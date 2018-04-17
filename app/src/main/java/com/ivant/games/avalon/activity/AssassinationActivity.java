package com.ivant.games.avalon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.adapter.PlayerAdapter;
import com.ivant.games.avalon.manager.GameManager;
import com.ivant.games.avalon.manager.PlayerManager;

import org.w3c.dom.Text;

public class AssassinationActivity extends AppCompatActivity {

    public static final String MSG_KEY = "msg";
    public static final String MSG_END = "end";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assassination);

        Button merlinButton = (Button) findViewById(R.id.merlinButton);
        Button loversButton = (Button) findViewById(R.id.loversButton);
        Button utherButton = (Button) findViewById(R.id.utherButton);
        Button loyalWinsButton = (Button) findViewById(R.id.loyalWins);
        Button minionWinsButton = (Button) findViewById(R.id.minionWins);
        TextView selectLabel = (TextView) findViewById(R.id.selectText);

        assignButtonOnclick(merlinButton);
        assignButtonOnclick(loversButton);
        assignButtonOnclick(utherButton);
        assignEndGameButtonOnclick(loyalWinsButton);
        assignEndGameButtonOnclick(minionWinsButton);

        if (!GameManager.isMerlinInGame())
            merlinButton.setVisibility(View.GONE);
        if (!GameManager.isLoversInGame())
            loversButton.setVisibility(View.GONE);
        if (!GameManager.isUtherInGame())
            utherButton.setVisibility(View.GONE);
        if (GameManager.isMerlinInGame() || GameManager.isLoversInGame() || GameManager.isUtherInGame())
            loyalWinsButton.setVisibility(View.GONE);
        else
            selectLabel.setText("Select");

        ListView playerOrderListView = (ListView) findViewById(R.id.playerorderlist);
        PlayerAdapter adapter = new PlayerAdapter(this, PlayerManager.getPlayers());
        playerOrderListView.setAdapter(adapter);
    }

    private void assignButtonOnclick(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssassinationActivity.this, EndGameActivity.class);
                String role = (((Button) v).getText()).toString();
                intent.putExtra(MSG_KEY, role);
                startActivity(intent);
                finish();
            }
        });
    }

    private void assignEndGameButtonOnclick(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AssassinationActivity.this, EndGameActivity.class);
                intent.putExtra(MSG_KEY, MSG_END);
                startActivity(intent);
                finish();
            }
        });
    }
}
