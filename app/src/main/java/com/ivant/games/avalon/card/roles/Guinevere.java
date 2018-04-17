package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GuinevereView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Guinevere implements Card, GuinevereView {

    private String name = "Guinevere";
    private int imageResource = R.drawable.guinevere;
    private static Guinevere instance = new Guinevere();
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
