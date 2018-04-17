package com.ivant.games.avalon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ivant.games.avalon.R;
import com.ivant.games.avalon.player.Player;

import java.util.List;

/**
 * Created by anthony on 10/21/2017.
 */

public class PlayerAdapter extends BaseAdapter {

    private Context context;
    private List<Player> players;
    private LayoutInflater layoutInflater;

    public PlayerAdapter(Context context, List<Player> players) {
        this.context = context;
        this.players = players;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Player getItem(int position) {
        return players.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlayerAdapter.ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new PlayerAdapter.ViewHolder();
            convertView = layoutInflater.inflate(R.layout.layout_player_end_game, parent, false);
            listViewHolder.playerTextView = (TextView) convertView.findViewById(R.id.player);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (PlayerAdapter.ViewHolder) convertView.getTag();
        }

        listViewHolder.playerTextView.setText(players.get(position).getName());

        return convertView;
    }

    static class ViewHolder{
        TextView playerTextView;
    }
}
