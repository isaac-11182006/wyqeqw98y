package com.ivant.games.avalon.player;

import com.ivant.games.avalon.card.interfaces.Card;

/**
 * Created by anthony on 10/12/2017.
 */

public class Player {

    private String name;
    private Card card;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
