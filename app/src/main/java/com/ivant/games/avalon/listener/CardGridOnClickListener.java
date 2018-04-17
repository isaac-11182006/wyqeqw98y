package com.ivant.games.avalon.listener;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.card.interfaces.LancelotView;
import com.ivant.games.avalon.manager.CardManager;

/**
 * Created by anthony on 10/21/2017.
 */

public class CardGridOnClickListener implements AdapterView.OnItemClickListener {

    private static final Float NOT_SELECTED = 0.25F;
    private static final Float SELECTED = 1.0F;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ImageView cardImageView = (ImageView) view.findViewById(R.id.card);
        Card card = (Card) parent.getAdapter().getItem(position);
        Float cardAlpha = cardImageView.getAlpha();

        if (NOT_SELECTED.equals(cardAlpha)) {
            if (CardManager.addCard(card)) {
                cardImageView.setAlpha(SELECTED);
                if (card instanceof LancelotView)
                    allegianceCountDialog(view);
            } else {
                Toast.makeText(view.getContext(), "Failed to ADD card to play.", Toast.LENGTH_SHORT).show();
            }
        } else if (SELECTED.equals(cardAlpha)) {
            if (CardManager.removeCard(card)) {
                cardImageView.setAlpha(NOT_SELECTED);
            } else {
                Toast.makeText(view.getContext(), "Failed to REMOVE card from play.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void allegianceCountDialog(View view) {

        final AlertDialog.Builder allegianceDialog = new AlertDialog.Builder(view.getContext());
        allegianceDialog.setTitle("Select allegiance card count");
        final LayoutInflater inflater = (LayoutInflater)
                view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final RadioGroup radioGroup = (RadioGroup) inflater.inflate(R.layout.allegiance_radio, null);
        if (CardManager.getAllegianceCards().size() == 5) {
            radioGroup.check(R.id.radio_5);
        } else {
            radioGroup.check(R.id.radio_7);
        }
        allegianceDialog.setView(radioGroup);
        allegianceDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        allegianceDialog.show();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_5) {
                    CardManager.setAllegianceCardCount(5);
                }
                if (checkedId == R.id.radio_7) {
                    CardManager.setAllegianceCardCount(7);
                }
            }
        });
    }
}
