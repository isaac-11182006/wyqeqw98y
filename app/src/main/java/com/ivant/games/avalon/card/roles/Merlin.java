package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MerlinView;
import com.ivant.games.avalon.card.interfaces.PercivalVisible;
import com.ivant.games.avalon.card.interfaces.SirKayVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Merlin implements Card, MerlinView, PercivalVisible, SirKayVisible {

    private String name = "Merlin";
    private int imageResource = R.drawable.merlin;
    private static Merlin instance = new Merlin();
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
