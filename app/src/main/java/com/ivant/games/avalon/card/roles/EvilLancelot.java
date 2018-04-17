package com.ivant.games.avalon.card.roles;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GuinevereVisible;
import com.ivant.games.avalon.card.interfaces.LancelotView;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.MinionVisible;

/**
 * Created by anthony on 10/21/2017.
 */

public class EvilLancelot implements Card, LancelotView, MinionVisible, MerlinVisible, GuinevereVisible {

    private String name = "Evil LancelotView";
    private int imageResource = R.drawable.lancelot_minion;
    private static EvilLancelot instance = new EvilLancelot();
    private boolean isLoyal = false;

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
        isLoyal = false;
        imageResource = R.drawable.lancelot_minion;
    }

    @Override
    public boolean getIsLoyal() {
        return isLoyal;
    }
}
