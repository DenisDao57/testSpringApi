package player;

import nba.NbaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PlayerDAO implements IPlayerDAO {

    private ApplicationContext ctx;
    private NbaData data;

    @Autowired
    public PlayerDAO(ApplicationContext ctx){
        this.ctx=ctx;
        this.data = ctx.getBean(NbaData.class);
        this.data.init();
    }

    @Override
    public ArrayList<Player> findAll() {
        return this.data.players;
    }

    @Override
    public Player findBest3pts() {
        Player result = this.data.players.get(0);
        for (Player player : this.data.players){
            if (result.getFg3pts() < player.getFg3pts()) result = player;
        }

        return result;
    }

    @Override
    public ArrayList<Player> findByPost(String poste) {
        ArrayList<Player> result = new ArrayList<Player>();
        for (Player player : this.data.players){
            if (player.getPoste().equals(poste)){
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Player> findByName(String name) {
        ArrayList<Player> result = new ArrayList<Player>();
        for (Player player : this.data.players){
            if (player.getNom().equals(name)){
                result.add(player);
            }
        }
        return result;
    }

    @Override
    public void addPlayer(Player player) {
        player.setId(getMaxID());
        this.data.players.add(player);
    }

    @Override
    public Boolean deletePlayerByID(String id) {
        for (Player player : this.data.players){
            if (player.getId().equals(id)){
                this.data.players.remove(player);
                return true;
            }
        }

        return false;
    }

    @Override
    public Boolean updatePlayerByID(String id, Player play) {
        for (int i=0; i<this.data.players.size();i++){
            Player player = this.data.players.get(i);
            if (player.getId().equals(id)){
                play.setId(player.getId());
                this.data.players.set(i,play);
                return true;
            }
        }

        return false;
    }

    public String getMaxID(){
        int id = 0;
        for (int i = 0;i<this.data.players.size();i++){
            int player_id = Integer.parseInt(this.data.players.get(i).getId());
            if (player_id > id ){
                id = player_id + 1;
            }
        }
        return Integer.toString(id);
    }
}
