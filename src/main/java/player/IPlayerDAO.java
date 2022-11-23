package player;

import java.util.ArrayList;

public interface IPlayerDAO {
    public ArrayList<Player> findAll();
    public Player findBest3pts();
    public ArrayList<Player> findByPost(String poste);
    public void addPlayer(Player player);
    public Boolean deletePlayerByName(String name);
}
