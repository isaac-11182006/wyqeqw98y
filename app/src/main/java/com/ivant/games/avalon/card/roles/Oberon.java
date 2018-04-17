package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Oberon implements Card, MerlinVisible {

    private String name = "Oberon";
    private int imageResource = R.drawable.oberon;
    private static Oberon instance = new Oberon();
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
