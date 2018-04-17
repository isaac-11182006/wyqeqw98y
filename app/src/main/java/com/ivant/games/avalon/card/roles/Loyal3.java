package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.LoyalView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Loyal3 implements Card, LoyalView {

    private String name = "Loyal";
    private int imageResource = R.drawable.loyal3;
    private static Loyal3 instance = new Loyal3();
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
