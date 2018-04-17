package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GawainView;

/**
 * Created by anthony on 10/21/2017.
 */

public class Gawain implements Card, GawainView {

    private String name = "GawainView";
    private int imageResource = R.drawable.gawain;
    private static Gawain instance = new Gawain();
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
