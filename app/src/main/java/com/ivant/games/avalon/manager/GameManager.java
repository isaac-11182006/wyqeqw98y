package com.ivant.games.avalon.manager;

import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GuinevereVisible;
import com.ivant.games.avalon.card.interfaces.IseultVisible;
import com.ivant.games.avalon.card.interfaces.LancelotView;
import com.ivant.games.avalon.card.interfaces.MerlinVisible;
import com.ivant.games.avalon.card.interfaces.MinionVisible;
import com.ivant.games.avalon.card.interfaces.PercivalVisible;
import com.ivant.games.avalon.card.interfaces.SirKayView;
import com.ivant.games.avalon.card.interfaces.SirKayVisible;
import com.ivant.games.avalon.card.interfaces.TristanVisible;
import com.ivant.games.avalon.card.interfaces.UtherVisible;
import com.ivant.games.avalon.card.roles.Iseult;
import com.ivant.games.avalon.card.roles.LordMarke;
import com.ivant.games.avalon.card.roles.Merlin;
import com.ivant.games.avalon.card.roles.SirKay;
import com.ivant.games.avalon.card.roles.Tristan;
import com.ivant.games.avalon.card.roles.Uther;
import com.ivant.games.avalon.constants.RoleMessage;
import com.ivant.games.avalon.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 10/21/2017.
 */

public class GameManager {

    private static List<Card> cards;
    private static List<Player> players;
    private static String lastKnownError = "";

    private static final String NO_ERROR = "No error";
    private static final String ERROR_INVALID = "Players and cards count does not match. Players (%s) Cards (%s).";

    private static int currentIndex = 0;

    private static List<Player> visibleToMinion;
    private static List<Player> visibleToMerlin;
    private static List<Player> visibleToPercival;
    private static List<Player> visibleToTristan;
    private static List<Player> visibleToIseult;
    private static List<Player> visibleToSirKay;
    private static List<Player> sirKayPlayers;
    private static List<Player> visibleToGuinevere;
    private static List<Player> visibleToUther;
    private static List<Player> lancelotPlayers;
    private static boolean sirKayInGame;
    private static boolean lordMarkeInGame;

    private static boolean merlinInGame;
    private static boolean loversInGame;
    private static boolean utherInGame;

    public static boolean start() {
        lastKnownError = NO_ERROR;
        currentIndex = 0;

        if (PlayerManager.getPlayersSize() != CardManager.getCardsSize()) {
            lastKnownError = String.format(ERROR_INVALID, PlayerManager.getPlayersSize(), CardManager.getCardsSize());
            return false;
        }

        CardManager.shuffleCards();
        cards = CardManager.getCards();
        PlayerManager.shufflePlayers();
        players = PlayerManager.getPlayers();

        visibleToMinion = new ArrayList<>();
        visibleToMerlin = new ArrayList<>();
        visibleToPercival = new ArrayList<>();
        visibleToIseult = new ArrayList<>();
        visibleToTristan = new ArrayList<>();
        visibleToSirKay = new ArrayList<>();
        sirKayPlayers = new ArrayList<>();
        visibleToGuinevere = new ArrayList<>();
        visibleToUther = new ArrayList<>();
        lancelotPlayers = new ArrayList<>();
        sirKayInGame = false;
        lordMarkeInGame = false;
        merlinInGame = false;
        loversInGame = false;
        utherInGame = false;

        for (int i = 0; i < players.size(); i++) {
            players.get(i).setCard(cards.get(i));
            if (cards.get(i) instanceof MinionVisible) {
                visibleToMinion.add(players.get(i));
            }
            if (cards.get(i) instanceof MerlinVisible) {
                visibleToMerlin.add(players.get(i));
            }
            if (cards.get(i) instanceof PercivalVisible) {
                visibleToPercival.add(players.get(i));
            }
            if (cards.get(i) instanceof IseultVisible) {
                visibleToIseult.add(players.get(i));
            }
            if (cards.get(i) instanceof TristanVisible) {
                visibleToTristan.add(players.get(i));
            }
            if (cards.get(i) instanceof SirKayVisible && !(cards.get(i) instanceof SirKayView)) {
                visibleToSirKay.add(players.get(i));
            }
            if (cards.get(i) instanceof SirKayView) {
                sirKayPlayers.add(players.get(i));
            }
            if (cards.get(i) instanceof GuinevereVisible) {
                visibleToGuinevere.add(players.get(i));
            }
            if (cards.get(i) instanceof UtherVisible) {
                visibleToUther.add(players.get(i));
            }
            if (cards.get(i) instanceof LancelotView) {
                lancelotPlayers.add(players.get(i));
            }

            if (cards.get(i) instanceof LordMarke) {
                lordMarkeInGame = true;
            } else if (cards.get(i) instanceof SirKay) {
                sirKayInGame = true;
            } else if (cards.get(i) instanceof Merlin) {
                merlinInGame = true;
            } else if (cards.get(i) instanceof Tristan || cards.get(i) instanceof Iseult) {
                loversInGame = true;
            } else if (cards.get(i) instanceof Uther) {
                utherInGame = true;
            }
        }

        return true;
    }

    public static boolean hasNext() {
        if (currentIndex + 1 < players.size())
            return true;
        return false;
    }

    public static boolean next() {
        currentIndex++;
        if (currentIndex < players.size()) {
            return true;
        }
        return false;
    }

    public static Player getCurrentPlayer() {
        return players.get(currentIndex);
    }

    public static Card getCurrentCard() {
        return cards.get(currentIndex);
    }

    public static String getLastKnownError() {
        return lastKnownError;
    }

    public static String getMessageToMinion(Player excludePlayer) {
        StringBuilder sb = new StringBuilder();
        if (visibleToMinion.size() > 1) {
            if (SettingsManager.isRoleBlindMinion()) {
                if (visibleToMinion.size() > 2)
                    sb.append(RoleMessage.MINIONS_BLIND);
                else
                    sb.append(RoleMessage.MINION_BLIND);
                sb.append("\n\n");
            }
            for (Player player : visibleToMinion) {
                if (!player.equals(excludePlayer)) {
                    if (!SettingsManager.isRoleBlindMinion())
                        sb.append(player.getCard().getName().toUpperCase()).append(" - ");
                    sb.append(player.getName()).append("\n");
                }
            }
        } else {
            sb.append(RoleMessage.MINION_LONE);
        }
        return sb.toString();
    }

    public static String getMessageToMerlin() {
        StringBuilder sb = new StringBuilder();
        if (SettingsManager.isMinionBlindMerlin()) {
            sb.append(RoleMessage.MERLIN_NONE);
        } else if (visibleToMerlin.size() > 0) {
            if (sirKayInGame)
                sb.append(RoleMessage.MERLIN_W_SIR_KAY);
            else
                sb.append(RoleMessage.MERLIN);
            sb.append("\n\n");
            for (Player player : visibleToMerlin) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.MERLIN_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToPercival() {
        StringBuilder sb = new StringBuilder();
        if (visibleToPercival.size() > 0) {
            sb.append(RoleMessage.PERCIVAL).append("\n\n");
            for (Player player : visibleToPercival) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.PERCIVAL_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToIseult() {
        StringBuilder sb = new StringBuilder();
        if (visibleToIseult.size() > 0) {
            if (lordMarkeInGame)
                sb.append(RoleMessage.ISEULT_W_MARKE);
            else
                sb.append(RoleMessage.ISEULT);
            sb.append("\n\n");
            for (Player player : visibleToIseult) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.ISEULT_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToTristan() {
        StringBuilder sb = new StringBuilder();
        if (visibleToTristan.size() > 0) {
            if (lordMarkeInGame)
                sb.append(RoleMessage.TRISTAN_W_MARKE);
            else
                sb.append(RoleMessage.TRISTAN);
            sb.append("\n\n");
            for (Player player : visibleToTristan) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.TRISTAN_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToSirKay(Player excludePlayer) {
        StringBuilder sb = new StringBuilder();
        if (sirKayPlayers.size() > 1) {
            if (sirKayPlayers.size() > 2)
                sb.append(RoleMessage.SIR_KAY_OTHERS);
            else
                sb.append(RoleMessage.SIR_KAY_OTHER);
            sb.append("\n\n");
            for (Player player : sirKayPlayers) {
                if (!player.equals(excludePlayer)) {
                    sb.append(player.getName()).append("\n");
                }
            }
            sb.append("\n\n");
        }
        if (visibleToSirKay.size() > 0) {
            sb.append(RoleMessage.SIR_KAY_MERLIN).append("\n\n");
            for (Player player : visibleToSirKay) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.SIR_KAY_MERLIN_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToGuinevere() {
        StringBuilder sb = new StringBuilder();
        if (visibleToGuinevere.size() > 0) {
            sb.append(RoleMessage.GUINEVERE).append("\n\n");
            for (Player player : visibleToGuinevere) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.GUINEVERE_NONE);
        }
        return sb.toString();
    }

    public static String getMessageToUther() {
        StringBuilder sb = new StringBuilder();
        if (visibleToUther.size() > 0) {
            sb.append(RoleMessage.UTHER).append("\n\n");
            for (Player player : visibleToUther) {
                sb.append(player.getName()).append("\n");
            }
        } else {
            sb.append(RoleMessage.UTHER_NONE);
        }
        return sb.toString();
    }

    public static boolean isLancelotInGame() {
        return lancelotPlayers.size() > 0;
    }

    public static void changeAllLancelotAllegiance() {
        for (Player player : lancelotPlayers) {
            ((LancelotView) player.getCard()).switchAllegiance();
        }
    }

    public static boolean isMerlinInGame() {
        return merlinInGame;
    }

    public static boolean isLoversInGame() {
        return loversInGame;
    }

    public static boolean isUtherInGame() {
        return utherInGame;
    }
}
