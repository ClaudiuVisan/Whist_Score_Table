package com.example.whistscoretable;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.ViewHolder>{
    private List<CurrentGame> games;
    private Context mContext;

    public GameAdapter(List<CurrentGame> games, Context context) {
        this.games = games;
        mContext=context;
    }

    @NonNull
    @Override
    public GameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameAdapter.ViewHolder holder, int position) {
        holder.gameName.setText(games.get(position).getName());
        holder.gameRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "clicked on " + games.get(position).getName() + "; round " + games.get(position).getRound() + ";id " + games.get(position).getId());
                for(int i=0; i<games.get(position).getNoPlayers();i++)
                {
                    Log.d("TAG", games.get(position).getPlayersList().get(i).getName() + games.get(position).getPlayersList().get(i).getScore());
                }
                Intent load=new Intent(mContext,ScoreTableActivity.class);
                Bundle passCurrentGame = new Bundle();
                passCurrentGame.putSerializable("currentGame",games.get(position));
                load.putExtras(passCurrentGame);
                mContext.startActivity(load);
            }
        });
    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;
        LinearLayout gameRow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.gameName);
            gameRow = itemView.findViewById(R.id.gameRow);
        }
    }
}
