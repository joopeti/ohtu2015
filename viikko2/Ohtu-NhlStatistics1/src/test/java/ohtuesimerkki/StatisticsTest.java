/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joopeti
 */
public class StatisticsTest {
    
    Statistics stats;
    List<Player> players;
    Reader readerStub = new Reader() {

        @Override
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchReturnsNullForNonexistentPlayer(){
        assertEquals(null, stats.search("Mirjami"));
    }
    @Test
    public void searchReturnsRightPlayer(){
        assertEquals(new Player("Semenko", "EDM", 4, 12), stats.search("Semenko"));
    }
    
    @Test
    public void teamReturnsRightAmountOfPlayers(){
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void teamReturnsListOfAllTeamsPlayers(){
        ArrayList<Player> tiimi = new ArrayList<Player>();
        tiimi.add(new Player("Semenko", "EDM", 4, 12));
        tiimi.add(new Player("Kurri",   "EDM", 37, 53));
        tiimi.add(new Player("Gretzky", "EDM", 35, 89));
        assertEquals(tiimi.get(0), stats.team("EDM").get(0));
        assertEquals(tiimi.get(1), stats.team("EDM").get(1));
        assertEquals(tiimi.get(2), stats.team("EDM").get(2));
    }
    
    @Test
    public void topscorersreturnrightamountofplayers(){
        System.out.println(stats.topScorers(3));
        assertEquals(4, stats.topScorers(3).size());
    }
    
    @Test
    public void topScorersReturnsCorrectPlayers(){
        List top = stats.topScorers(3);
        assertEquals(new Player("Gretzky", "EDM", 35, 89), top.get(0));
        assertEquals(new Player("Lemieux", "PIT", 45, 54), top.get(1));
        assertEquals(new Player("Yzerman", "DET", 42, 56), top.get(2));
        assertEquals(new Player("Kurri",   "EDM", 37, 53), top.get(3));
    }

}
