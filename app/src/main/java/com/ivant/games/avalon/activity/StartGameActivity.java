package com.ivant.games.avalon.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.GawainView;
import com.ivant.games.avalon.card.interfaces.GuinevereView;
import com.ivant.games.avalon.card.interfaces.IseultView;
import com.ivant.games.avalon.card.interfaces.MerlinView;
import com.ivant.games.avalon.card.interfaces.MinionView;
import com.ivant.games.avalon.card.interfaces.PercivalView;
import com.ivant.games.avalon.card.interfaces.PuckView;
import com.ivant.games.avalon.card.interfaces.SirKayView;
import com.ivant.games.avalon.card.interfaces.TristanView;
import com.ivant.games.avalon.card.interfaces.UtherView;
import com.ivant.games.avalon.constants.RoleMessage;
import com.ivant.games.avalon.manager.GameManager;

public class StartGameActivity extends AppCompatActivity {

    private AnimatorSet frontClockwiseAnim;
    private AnimatorSet backClockwiseAnim;

    private ImageView backOfCard;
    private ImageView playerCard;
    private boolean cardShown = false;
    private boolean cardSeen = false;
    private boolean updateCardAfterHide = false;

    private TextView playername;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        backOfCard = (ImageView) findViewById(R.id.backofcard);
        backOfCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });
        playerCard = (ImageView) findViewById(R.id.playercard);
        playerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });

        loadAnimations();

        playerCard.setImageResource(GameManager.getCurrentCard().getImageResource());

        playername = (TextView) findViewById(R.id.playername);
        playername.setText(GameManager.getCurrentPlayer().getName() + "'s turn (click to show)");

        done = (Button) findViewById(R.id.done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cardSeen) {
                    if (GameManager.hasNext()) {
                        nextPlayer();
                    } else {
                        if (GameManager.isLancelotInGame()) {
                            Intent intent = new Intent(StartGameActivity.this, LancelotAllegianceActivity.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(StartGameActivity.this, AssassinationActivity.class);
                            startActivity(intent);
                        }
                        finish();
                    }
                } else {
                    cardUnseen();
                }
            }
        });
        done.setVisibility(View.INVISIBLE);
    }

    private void nextPlayer() {
        GameManager.next();
        if (!cardShown) {
            updatePlayerContent();
        } else {
            hideCard();
            updateCardAfterHide = true;
        }
        cardSeen = false;
        done.setVisibility(View.INVISIBLE);
    }

    private void updatePlayerContent() {
        playerCard.setImageResource(GameManager.getCurrentCard().getImageResource());
        playername.setText(GameManager.getCurrentPlayer().getName() + "'s turn (click to show)");
    }

    private void toggle() {
        if (cardShown) {
            hideCard();
        } else {
            showCard();
        }
    }

    private void showCard() {
        if (!cardShown) {
            frontClockwiseAnim.setTarget(backOfCard);
            backClockwiseAnim.setTarget(playerCard);
            frontClockwiseAnim.start();
            backClockwiseAnim.start();
            cardShown = true;
            cardSeen = true;
        }
    }

    private void hideCard() {
        if (cardShown) {
            frontClockwiseAnim.setTarget(playerCard);
            backClockwiseAnim.setTarget(backOfCard);
            frontClockwiseAnim.start();
            backClockwiseAnim.start();
            cardShown = false;
            done.setVisibility(View.VISIBLE);
        }
    }

    private void playerDialog() {

        boolean hasMessageToPlayer = false;
        String messageToPlayer = "";
        Card currentCard = GameManager.getCurrentCard();
        if (currentCard instanceof MinionView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToMinion(GameManager.getCurrentPlayer());
        } else if (currentCard instanceof MerlinView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToMerlin();
        } else if (currentCard instanceof PercivalView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToPercival();
        } else if (currentCard instanceof IseultView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToIseult();
        } else if (currentCard instanceof TristanView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToTristan();
        } else if (currentCard instanceof GawainView) {
            hasMessageToPlayer = true;
            messageToPlayer = RoleMessage.GAWAIN;
        } else if (currentCard instanceof SirKayView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToSirKay(GameManager.getCurrentPlayer());
        } else if (currentCard instanceof GuinevereView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToGuinevere();
        } else if (currentCard instanceof UtherView) {
            hasMessageToPlayer = true;
            messageToPlayer = GameManager.getMessageToUther();
        } else if (currentCard instanceof PuckView) {
            hasMessageToPlayer = true;
            messageToPlayer = RoleMessage.PUCK;
        }

        if (hasMessageToPlayer) {
            AlertDialog.Builder playerDialog = new AlertDialog.Builder(StartGameActivity.this);
            playerDialog.setMessage(messageToPlayer);
            playerDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            playerDialog.show();
        }
    }

    private void cardUnseen() {
        AlertDialog.Builder playerDialog = new AlertDialog.Builder(StartGameActivity.this);
        playerDialog.setMessage("You must see your card first.");
        playerDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        playerDialog.show();
    }

    private void loadAnimations() {
        int distance = 4000;
        float scale = getResources().getDisplayMetrics().density * distance;
        backOfCard.setCameraDistance(scale);
        playerCard.setCameraDistance(scale);
        frontClockwiseAnim = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front_cw_anim);
        backClockwiseAnim = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back_cw_anim);

        frontClockwiseAnim.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationEnd(Animator animation) {
                if (updateCardAfterHide) {
                    updatePlayerContent();
                    updateCardAfterHide = false;
                }
            }

            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }
        });

        backClockwiseAnim.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationEnd(Animator animation) {
                if (cardShown)
                    playerDialog();
            }

            @Override
            public void onAnimationStart(Animator animation) { }

            @Override
            public void onAnimationCancel(Animator animation) { }

            @Override
            public void onAnimationRepeat(Animator animation) { }
        });
    }
}
