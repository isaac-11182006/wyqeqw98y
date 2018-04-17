package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.MinionView;
import com.ivant.games.avalon.card.interfaces.MinionVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Minion1 implements Card, MinionView, MinionVisible, MerlinVisible {

    private String name = "Minion";
    private int imageResource = R.drawable.minion1;
    private static Minion1 instance = new Minion1();
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
