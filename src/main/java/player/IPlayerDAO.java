package player;

import java.util.ArrayList;

public interface IPlayerDAO {
    public ArrayList<Player> findAll();
    public Player findBest3pts();
    public ArrayList<Player> findByPost(String poste);
    public ArrayList<Player> findByName(String name);
    public void addPlayer(Player player);
    public Boolean deletePlayerByName(String name);
    public Boolean updatePlayerByName(String name,Player play);
}
