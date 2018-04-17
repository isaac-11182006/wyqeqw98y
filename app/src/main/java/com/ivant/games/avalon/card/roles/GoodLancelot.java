package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GuinevereVisible;
import com.ivant.games.avalon.card.interfaces.LancelotView;

/**
 * Created by anthony on 10/21/2017.
 */

public class GoodLancelot implements Card, LancelotView, GuinevereVisible {

    private String name = "Good LancelotView";
    private int imageResource = R.drawable.lancelot_loyal;
    private static GoodLancelot instance = new GoodLancelot();
    private boolean isLoyal = true;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getImageResource() {
        return imageResource;
    }

    public static Card getInstance() {
        return instance;
    }

    @Override
    public void switchAllegiance() {
        if (isLoyal) {
            isLoyal = false;
            imageResource = R.drawable.lancelot_minion;
        } else {
            isLoyal = true;
            imageResource = R.drawable.lancelot_loyal;
        }
    }

    @Override
    public void restoreOriginalAllegiance() {
        isLoyal = true;
        imageResource = R.drawable.lancelot_loyal;
    }

    @Override
    public boolean getIsLoyal() {
        return isLoyal;
    }
}
