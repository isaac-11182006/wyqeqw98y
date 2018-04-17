package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.UtherView;

/**
 * Created by anthony on 11/8/2017.
 */

public class Uther implements Card, UtherView {

    private String name = "Uther";
    private int imageResource = R.drawable.uther;
    private static Uther instance = new Uther();
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
