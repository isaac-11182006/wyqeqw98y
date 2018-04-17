package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.LoyalView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Loyal1 implements Card, LoyalView {

    private String name = "Loyal";
    private int imageResource = R.drawable.loyal1;
    private static Loyal1 instance = new Loyal1();
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
