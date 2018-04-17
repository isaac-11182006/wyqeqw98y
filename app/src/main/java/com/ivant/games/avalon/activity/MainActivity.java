package com.ivant.games.avalon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.manager.GameManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playersButton = (Button) findViewById(R.id.players);
        playersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayersActivity.class);
                startActivity(intent);
            }
        });

        Button cardsButton = (Button) findViewById(R.id.cards);
        cardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardsActivity.class);
                startActivity(intent);
            }
        });

        Button settingsButton = (Button) findViewById(R.id.settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        Button startButton = (Button) findViewById(R.id.start);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GameManager.start()) {
                    Intent intent = new Intent(MainActivity.this, StartGameActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, GameManager.getLastKnownError(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
