package com.ivant.games.avalon.card;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.AllegianceCard;

/**
 * Created by anthony on 10/26/2017.
 */

public class SwitchAllegiance implements AllegianceCard {

    private int imageResource = R.drawable.switchallegiance;
    private static SwitchAllegiance instance = new SwitchAllegiance();

    @Override
    public int getImageResource() {
        return imageResource;
    }

    public static AllegianceCard getInstance() {
        return instance;
    }
}
