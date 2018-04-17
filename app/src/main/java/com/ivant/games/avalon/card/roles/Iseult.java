package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.IseultView;
import com.ivant.games.avalon.card.interfaces.TristanVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class Iseult implements Card, IseultView, TristanVisible {

    private String name = "Iseult";
    private int imageResource = R.drawable.iseult;
    private static Iseult instance = new Iseult();
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
