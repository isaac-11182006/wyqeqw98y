package com.ivant.games.avalon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.manager.PlayerManager;
import com.ivant.games.avalon.player.Player;

public class PlayersActivity extends AppCompatActivity {

    private static final String TAG = "PlayersActivity";

    private ViewGroup playerListContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        playerListContainer = (ViewGroup) findViewById(R.id.playerlistcontainer);

        for (Player player : PlayerManager.getPlayers()) {
//            Log.d(TAG, "onCreate: Player " + player.getName());
            addItem(player);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.add_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_item:
                newPlayerDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void newPlayerDialog() {
        final EditText playerNameET = new EditText(PlayersActivity.this);
        playerNameET.setHint("Enter new player name");
        AlertDialog.Builder newPlayerDialog = new AlertDialog.Builder(PlayersActivity.this);
        newPlayerDialog.setTitle("New Player");
        newPlayerDialog.setView(playerNameET);
        newPlayerDialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String playerName = playerNameET.getText().toString();
                if (PlayerManager.addPlayerByName(playerName)) {
                    addItem(PlayerManager.getPlayerByName(playerName));
                }
            }
        });
        newPlayerDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {dialog.dismiss();}
                });
        newPlayerDialog.show();
    }

    private void addItem(Player player) {
        final ViewGroup playerRowView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.player_list_item, playerListContainer, false);

        final String playerName = player.getName();

        ((TextView) playerRowView.findViewById(R.id.playerName)).setText(playerName);

        playerRowView.findViewById(R.id.deleteButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PlayerManager.removePlayerByName(playerName))
                    playerListContainer.removeView(playerRowView);
            }
        });

        playerListContainer.addView(playerRowView);
    }
}
