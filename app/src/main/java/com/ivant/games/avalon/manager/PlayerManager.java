package com.ivant.games.avalon.manager;

import com.ivant.games.avalon.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Aj on 10/14/2017.
 */

public class PlayerManager {

    private static List<Player> players = new ArrayList<>();

    static {
        players.add(new Player("Aldrin"));
        players.add(new Player("Anthony"));
        players.add(new Player("Billy"));
        players.add(new Player("Greg"));
        players.add(new Player("Isaac"));
        players.add(new Player("Jayvie"));
        players.add(new Player("Kim"));
        players.add(new Player("Migs"));
        players.add(new Player("Ras"));
    }

    public static int getPlayersSize() {
        return players.size();
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static Player getPlayerByName(String name) {
        for (Player player : players) {
            if (name.equalsIgnoreCase(player.getName())) {
                return player;
            }
        }
        return null;
    }

    public static boolean removePlayerByName(String name) {
        if (name != null && !name.equals(""))
            return getPlayerByName(name) != null && removePlayer(getPlayerByName(name));
        return false;
    }

    public static boolean removePlayer(Player player) {
        return players.remove(player);
    }

    public static boolean addPlayerByName(String name) {
        if (name != null && !name.equals(""))
            return getPlayerByName(name) == null && addPlayer(new Player(name));
        return false;
    }

    public static boolean addPlayer(Player player) {
        return players.add(player);
    }

    public static void shufflePlayers() {
        long seed = System.nanoTime();
        Collections.shuffle(players, new Random(seed));
    }
}
