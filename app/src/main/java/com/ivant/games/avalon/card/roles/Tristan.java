package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.IseultVisible;
import com.ivant.games.avalon.card.interfaces.TristanView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Tristan implements Card, TristanView, IseultVisible {

    private String name = "Tristan";
    private int imageResource = R.drawable.tristan;
    private static Tristan instance = new Tristan();
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
