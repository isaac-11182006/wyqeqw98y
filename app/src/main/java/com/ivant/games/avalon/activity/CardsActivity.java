package com.ivant.games.avalon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.adapter.CardAdapter;
import com.ivant.games.avalon.listener.CardGridOnClickListener;
import com.ivant.games.avalon.manager.CardManager;

public class CardsActivity extends AppCompatActivity {

    private GridView cardsGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        cardsGridView = (GridView) findViewById(R.id.cards_gridview);
        CardAdapter cardAdapter = new CardAdapter(this, CardManager.getAllCards());
        cardsGridView.setAdapter(cardAdapter);

        cardsGridView.setOnItemClickListener(new CardGridOnClickListener());
    }
}
