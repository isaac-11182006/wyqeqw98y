package com.ivant.games.avalon.activity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.SwitchAllegiance;
import com.ivant.games.avalon.manager.CardManager;
import com.ivant.games.avalon.manager.GameManager;

public class LancelotAllegianceActivity extends AppCompatActivity {

    private AnimatorSet frontRotateDownAnim;
    private AnimatorSet backRotateDownAnim;

    private ImageView allegianceBack1;
    private ImageView allegianceBack2;
    private ImageView allegianceBack3;
    private ImageView allegianceBack4;
    private ImageView allegianceBack5;
    private ImageView allegianceBack6;
    private ImageView allegianceBack7;
    private ImageView allegianceFront1;
    private ImageView allegianceFront2;
    private ImageView allegianceFront3;
    private ImageView allegianceFront4;
    private ImageView allegianceFront5;
    private ImageView allegianceFront6;
    private ImageView allegianceFront7;
    private boolean[] shown = {false, false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancelot_allegiance);

        allegianceBack1 = (ImageView) findViewById(R.id.allegiance_back_1);
        allegianceBack2 = (ImageView) findViewById(R.id.allegiance_back_2);
        allegianceBack3 = (ImageView) findViewById(R.id.allegiance_back_3);
        allegianceBack4 = (ImageView) findViewById(R.id.allegiance_back_4);
        allegianceBack5 = (ImageView) findViewById(R.id.allegiance_back_5);
        allegianceBack6 = (ImageView) findViewById(R.id.allegiance_back_6);
        allegianceBack7 = (ImageView) findViewById(R.id.allegiance_back_7);
        allegianceFront1 = (ImageView) findViewById(R.id.allegiance_front_1);
        allegianceFront2 = (ImageView) findViewById(R.id.allegiance_front_2);
        allegianceFront3 = (ImageView) findViewById(R.id.allegiance_front_3);
        allegianceFront4 = (ImageView) findViewById(R.id.allegiance_front_4);
        allegianceFront5 = (ImageView) findViewById(R.id.allegiance_front_5);
        allegianceFront6 = (ImageView) findViewById(R.id.allegiance_front_6);
        allegianceFront7 = (ImageView) findViewById(R.id.allegiance_front_7);

        loadAnimations();

        attachShowOnClickListener(0, allegianceBack1, allegianceFront1);
        attachShowOnClickListener(1, allegianceBack2, allegianceFront2);
        attachShowOnClickListener(2, allegianceBack3, allegianceFront3);
        attachShowOnClickListener(3, allegianceBack4, allegianceFront4);
        attachShowOnClickListener(4, allegianceBack5, allegianceFront5);
        attachShowOnClickListener(5, allegianceBack6, allegianceFront6);
        attachShowOnClickListener(6, allegianceBack7, allegianceFront7);

        if (CardManager.getAllegianceCards().size() == 5) {
            findViewById(R.id.allegiance_grp_6).setVisibility(View.GONE);
            findViewById(R.id.allegiance_grp_7).setVisibility(View.GONE);
        }

        initAllegianceCards();

        findViewById(R.id.proceed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LancelotAllegianceActivity.this, EndGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initAllegianceCards() {
        if (CardManager.getAllegianceCards().size() > 0) {
            allegianceFront1.setImageResource(CardManager.getAllegianceCards().get(0).getImageResource());
            allegianceFront2.setImageResource(CardManager.getAllegianceCards().get(1).getImageResource());
            allegianceFront3.setImageResource(CardManager.getAllegianceCards().get(2).getImageResource());
            allegianceFront4.setImageResource(CardManager.getAllegianceCards().get(3).getImageResource());
            allegianceFront5.setImageResource(CardManager.getAllegianceCards().get(4).getImageResource());
            if (CardManager.getAllegianceCards().size() > 5) {
                allegianceFront6.setImageResource(CardManager.getAllegianceCards().get(5).getImageResource());
                allegianceFront7.setImageResource(CardManager.getAllegianceCards().get(6).getImageResource());
            }
        }
    }

    private void attachShowOnClickListener(final int index, View back, final View front) {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View back) {
                showCard(index, back, front);
            }
        });
    }

    private void showCard(int index, View back, View front) {
        if (!shown[index]) {
            frontRotateDownAnim.setTarget(back);
            backRotateDownAnim.setTarget(front);
            frontRotateDownAnim.start();
            backRotateDownAnim.start();
            shown[index] = true;
            if (CardManager.getAllegianceCards().get(index) instanceof SwitchAllegiance) {
                GameManager.changeAllLancelotAllegiance();
            }
        }
    }

    private void loadAnimations() {
        int distance = 4000;
        float scale = getResources().getDisplayMetrics().density * distance;
        allegianceBack1.setCameraDistance(scale);
        allegianceBack2.setCameraDistance(scale);
        allegianceBack3.setCameraDistance(scale);
        allegianceBack4.setCameraDistance(scale);
        allegianceBack5.setCameraDistance(scale);
        allegianceBack6.setCameraDistance(scale);
        allegianceBack7.setCameraDistance(scale);
        allegianceFront1.setCameraDistance(scale);
        allegianceFront2.setCameraDistance(scale);
        allegianceFront3.setCameraDistance(scale);
        allegianceFront4.setCameraDistance(scale);
        allegianceFront5.setCameraDistance(scale);
        allegianceFront6.setCameraDistance(scale);
        allegianceFront7.setCameraDistance(scale);
        frontRotateDownAnim = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.front_rotate_down_anim);
        backRotateDownAnim = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.back_rotate_down_anim);
    }
}
