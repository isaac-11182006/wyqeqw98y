package com.ivant.games.avalon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.card.interfaces.Card;
import com.ivant.games.avalon.manager.CardManager;

import java.util.List;

/**
 * Created by anthony on 10/21/2017.
 */

public class CardAdapter extends BaseAdapter {

    private Context context;
    private List<Card> cards;
    private LayoutInflater layoutInflater;

    private static final Float NOT_SELECTED = 0.25F;
    private static final Float SELECTED = 1.0F;

    public CardAdapter(Context context, List<Card> cards) {
        this.context = context;
        this.cards = cards;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Card getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        CardAdapter.ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new CardAdapter.ViewHolder();
            convertView = layoutInflater.inflate(R.layout.layout_card, parent, false);
            listViewHolder.cardImageView = (ImageView) convertView.findViewById(R.id.card);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (CardAdapter.ViewHolder) convertView.getTag();
        }

        Card thisCard = cards.get(position);
        listViewHolder.cardImageView.setImageResource(thisCard.getImageResource());
        if (CardManager.isSelected(thisCard)) {
            listViewHolder.cardImageView.setAlpha(SELECTED);
        } else {
            listViewHolder.cardImageView.setAlpha(NOT_SELECTED);
        }

        return convertView;
    }

    static class ViewHolder{
        ImageView cardImageView;
    }
}
