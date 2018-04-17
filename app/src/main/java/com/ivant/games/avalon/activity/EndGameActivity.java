package com.ivant.games.avalon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.adapter.PlayerAdapter;
import com.ivant.games.avalon.listener.PlayerEndGameOnClickListener;
import com.ivant.games.avalon.manager.PlayerManager;

import java.util.List;

public class EndGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        ListView playerListView = (ListView) findViewById(R.id.playerlist);
        PlayerAdapter adapter = new PlayerAdapter(this, PlayerManager.getPlayers());
        playerListView.setAdapter(adapter);

        playerListView.setOnItemClickListener(new PlayerEndGameOnClickListener());

        findViewById(R.id.endgame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String msg = getIntent().getStringExtra(AssassinationActivity.MSG_KEY);
        if (AssassinationActivity.MSG_END.equals(msg))
            finish();
        else
            ((TextView) findViewById(R.id.selectTextRole)).setText(msg);
    }
}
