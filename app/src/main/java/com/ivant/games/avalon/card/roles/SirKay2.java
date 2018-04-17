package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.SirKayView;
import com.ivant.games.avalon.card.interfaces.SirKayVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class SirKay2 implements Card, SirKayView, SirKayVisible, MerlinVisible {

    private String name = "Sir Kay";
    private int imageResource = R.drawable.sir_kay;
    private static SirKay2 instance = new SirKay2();
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
