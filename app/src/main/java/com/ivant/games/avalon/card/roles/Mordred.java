package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MinionView;
import com.ivant.games.avalon.card.interfaces.MinionVisible;
import com.ivant.games.avalon.card.interfaces.UtherVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Mordred implements Card, MinionView, MinionVisible, UtherVisible {

    private String name = "Mordred";
    private int imageResource = R.drawable.mordred;
    private static Mordred instance = new Mordred();
    private boolean isLoyal = false;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }

    @Override
    public boolean getIsLoyal() {
        return isLoyal;
    }

    public static Card getInstance() {
        return instance;
    }
}
