package com.ivant.games.avalon.listener;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.player.Player;

/**
 * Created by anthony on 10/21/2017.
 */

public class PlayerEndGameOnClickListener implements AdapterView.OnItemClickListener {

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Player player = (Player) parent.getAdapter().getItem(position);
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.card_end_game_layout, null);
        ((ImageView) layout.findViewById(R.id.cardendgame)).setImageResource(player.getCard().getImageResource());

        AlertDialog.Builder playerDialog = new AlertDialog.Builder(view.getContext());
        playerDialog.setTitle(" ");
        playerDialog.setView(layout);
        playerDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        playerDialog.show();
    }
}
