package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.MinionView;
import com.ivant.games.avalon.card.interfaces.MinionVisible;
import com.ivant.games.avalon.card.interfaces.PercivalVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Morgana implements Card, MinionView, MinionVisible, MerlinVisible, PercivalVisible {

    private String name = "Morgana";
    private int imageResource = R.drawable.morgana;
    private static Morgana instance = new Morgana();
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
