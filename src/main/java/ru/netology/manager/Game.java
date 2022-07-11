package ru.netology.manager;

import ru.netology.domain.Player;
import ru.netology.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players = new HashMap<>();

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) {
        int result = 0;
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("The player " + playerName1 + " is not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("The player " + playerName2 + " is not registered");
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            result = 2;
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            result = 1;
        }
        if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
            result = 0;
        }
        return result;
    }

    public Player findByName(String name) {
        for (String key : players.keySet()) {
            Player player = players.get(key);
            if (key == name) {
                return player;
            }
        }
        return null;
    }
}
