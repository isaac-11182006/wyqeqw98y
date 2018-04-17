package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.PuckView;

/**
 * Created by anthony on 11/8/2017.
 */

public class Puck implements Card, PuckView {

    private String name = "Puck";
    private int imageResource = R.drawable.puck;
    private static Puck instance = new Puck();
    private boolean isLoyal = true;

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
