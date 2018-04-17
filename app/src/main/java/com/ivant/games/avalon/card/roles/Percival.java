package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.PercivalView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Percival implements Card, PercivalView {

    private String name = "Percival";
    private int imageResource = R.drawable.percival;
    private static Percival instance = new Percival();
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
