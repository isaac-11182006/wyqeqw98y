package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.IseultVisible;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.MinionView;
import com.ivant.games.avalon.card.interfaces.MinionVisible;
import com.ivant.games.avalon.card.interfaces.TristanVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class LordMarke implements Card, MinionView, MinionVisible, MerlinVisible, TristanVisible, IseultVisible {

    private String name = "Lord Marke";
    private int imageResource = R.drawable.lord_marke;
    private static LordMarke instance = new LordMarke();
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
