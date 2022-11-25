package nba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import player.Player;

import java.util.ArrayList;

@Component
@ComponentScan(basePackages = "player")
public class NbaData {

    public ArrayList<Player> players = new ArrayList<Player>();
    private ApplicationContext ctx;

    @Autowired
    public NbaData(ApplicationContext ctx){
        this.ctx=ctx;
    }

    public void init(){
        Player p1 = ctx.getBean(Player.class,"1","Stephen","Curry","Meneur",51);
        Player p2 = ctx.getBean(Player.class,"2","Klay","Thompson","Arriere",37);
        Player p3 = ctx.getBean(Player.class,"3","Russel","Westbrook","Meneur",31);
        Player p4 = ctx.getBean(Player.class,"4","Michael","Jordan","Arriere",33);
        Player p5 = ctx.getBean(Player.class,"5","Rudy","Gobert","Pivot",12);

        this.players.add(p1);this.players.add(p2);this.players.add(p3);this.players.add(p4);
        this.players.add(p5);
    }

}
