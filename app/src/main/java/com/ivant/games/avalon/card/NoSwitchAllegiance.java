package com.ivant.games.avalon.card;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.AllegianceCard;

/**
 * Created by anthony on 10/26/2017.
 */

public class NoSwitchAllegiance implements AllegianceCard {

    private int imageResource = R.drawable.noswitchallegiance;
    private static NoSwitchAllegiance instance = new NoSwitchAllegiance();

    @Override
    public int getImageResource() {
        return imageResource;
    }

    public static AllegianceCard getInstance() {
        return instance;
    }
}
