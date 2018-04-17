package com.ivant.games.avalon.manager;

import com.ivant.games.avalon.card.NoSwitchAllegiance;
import com.ivant.games.avalon.card.SwitchAllegiance;
import com.ivant.games.avalon.card.interfaces.AllegianceCard;
import com.ivant.games.avalon.card.interfaces.LancelotView;
import com.ivant.games.avalon.card.roles.Assassin;
import com.ivant.games.avalon.card.roles.EvilLancelot;
import com.ivant.games.avalon.card.roles.Gawain;
import com.ivant.games.avalon.card.roles.GoodLancelot;
import com.ivant.games.avalon.card.roles.Guinevere;
import com.ivant.games.avalon.card.roles.LordMarke;
import com.ivant.games.avalon.card.roles.Loyal1;
import com.ivant.games.avalon.card.roles.Loyal2;
import com.ivant.games.avalon.card.roles.Loyal3;
import com.ivant.games.avalon.card.roles.Iseult;
import com.ivant.games.avalon.card.roles.Loyal4;
import com.ivant.games.avalon.card.roles.Loyal5;
import com.ivant.games.avalon.card.roles.Puck;
import com.ivant.games.avalon.card.roles.SirKay;
import com.ivant.games.avalon.card.roles.SirKay2;
import com.ivant.games.avalon.card.roles.SirKay3;
import com.ivant.games.avalon.card.roles.Tristan;
import com.ivant.games.avalon.card.roles.Merlin;
import com.ivant.games.avalon.card.roles.Minion1;
import com.ivant.games.avalon.card.roles.Minion2;
import com.ivant.games.avalon.card.roles.Minion3;
import com.ivant.games.avalon.card.roles.Mordred;
import com.ivant.games.avalon.card.roles.Morgana;
import com.ivant.games.avalon.card.roles.Oberon;
import com.ivant.games.avalon.card.roles.Percival;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.roles.Uther;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Aj on 10/14/2017.
 */

public class CardManager {

    private static List<Card> playCards = new ArrayList<>();
    private static List<Card> allCards = new ArrayList<>();

    private static List<AllegianceCard> allegianceCards = new ArrayList<>();

    static {
        playCards.add(Loyal1.getInstance());
        playCards.add(Loyal2.getInstance());
        playCards.add(Loyal3.getInstance());
        playCards.add(Loyal4.getInstance());
        playCards.add(Loyal5.getInstance());
        playCards.add(Minion1.getInstance());
        playCards.add(Minion2.getInstance());
        playCards.add(Minion3.getInstance());

        allCards.add(Loyal1.getInstance());
        allCards.add(Loyal2.getInstance());
        allCards.add(Loyal3.getInstance());
        allCards.add(Loyal4.getInstance());
        allCards.add(Loyal5.getInstance());
        allCards.add(Minion1.getInstance());
        allCards.add(Minion2.getInstance());
        allCards.add(Minion3.getInstance());
        allCards.add(Merlin.getInstance());
        allCards.add(Percival.getInstance());
        allCards.add(Assassin.getInstance());
        allCards.add(Morgana.getInstance());
        allCards.add(Mordred.getInstance());
        allCards.add(Oberon.getInstance());
        allCards.add(GoodLancelot.getInstance());
        allCards.add(EvilLancelot.getInstance());
        allCards.add(Iseult.getInstance());
        allCards.add(Tristan.getInstance());
        allCards.add(LordMarke.getInstance());
        allCards.add(Gawain.getInstance());
        allCards.add(SirKay.getInstance());
        allCards.add(SirKay2.getInstance());
        allCards.add(SirKay3.getInstance());
        allCards.add(Guinevere.getInstance());
        allCards.add(Uther.getInstance());
        allCards.add(Puck.getInstance());

        allegianceCards.add(NoSwitchAllegiance.getInstance());
        allegianceCards.add(NoSwitchAllegiance.getInstance());
        allegianceCards.add(NoSwitchAllegiance.getInstance());
        allegianceCards.add(SwitchAllegiance.getInstance());
        allegianceCards.add(SwitchAllegiance.getInstance());
    }

    public static List<Card> getCards() {
        return playCards;
    }

    public static int getCardsSize() {
        return playCards.size();
    }

    public static boolean addCard(Card card) {
        if (!playCards.contains(card))
            return playCards.add(card);
        return false;
    }

    public static boolean removeCard(Card card) {
        if (playCards.contains(card))
            return playCards.remove(card);
        return false;
    }

    public static boolean isSelected(Card card) {
        return playCards.contains(card);
    }

    public static void shuffleCards() {
        long seed = System.nanoTime() + 13;
        Collections.shuffle(playCards, new Random(seed));

        //restore lancelot cards allegiance
        for (Card card : playCards) {
            if (card instanceof LancelotView)
                ((LancelotView) card).restoreOriginalAllegiance();
        }
        if (allegianceCards.size() > 0) {
            seed = System.nanoTime();
            Collections.shuffle(allegianceCards, new Random(seed));
        }
    }

    public static List<Card> getAllCards() {
        return allCards;
    }

    public static void setAllegianceCardCount(int count) {
        if (count == 5) {
            allegianceCards = new ArrayList<>();
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(SwitchAllegiance.getInstance());
            allegianceCards.add(SwitchAllegiance.getInstance());
        } else if (count == 7) {
            allegianceCards = new ArrayList<>();
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(SwitchAllegiance.getInstance());
            allegianceCards.add(SwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());
            allegianceCards.add(NoSwitchAllegiance.getInstance());

        }
    }

    public static List<AllegianceCard> getAllegianceCards() {
        return allegianceCards;
    }
}
