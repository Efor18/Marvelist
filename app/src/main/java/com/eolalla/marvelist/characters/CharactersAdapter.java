package com.eolalla.marvelist.characters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eolalla.marvelist.R;
import com.eolalla.marvelist.network.model.Character;
import com.eolalla.marvelist.network.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ernesto Olalla on 3/11/16.
 */

public class CharactersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_CHARACTER = 0;
    private static final int VIEW_TYPE_LOADING = 1;

    private final List<Character> characters;
    private int total;

    public CharactersAdapter() {
        characters = new ArrayList<>();
        total = 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_CHARACTER) {
            View characterView = inflater.inflate(R.layout.view_character_row, parent, false);
            viewHolder = new CharacterViewHolder(characterView);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View loadingView = inflater.inflate(R.layout.view_loading_row, parent, false);
            viewHolder = new LoadingViewHolder(loadingView);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemTypeView = getItemViewType(position);
        if (itemTypeView == VIEW_TYPE_CHARACTER) {
            CharacterViewHolder characterViewHolder = (CharacterViewHolder) holder;
            Character character = characters.get(position);
            characterViewHolder.name.setText(character.getName());
            String path = character.getThumbnail().getPath() + Image.LANDSCAPE_INCREDIBLE;
            Picasso.with(characterViewHolder.image.getContext())
                    .load(path)
                    .error(R.drawable.side_nav_bar)
                    .into(characterViewHolder.image);
        }
    }

    @Override
    public int getItemCount() {
        if (characters.size() < total) {
            return characters.size() + 1;
        } else {
            return characters.size();
        }
    }

    public void addCharacters(List<Character> characters, int total) {
        this.total = total;
        this.characters.addAll(characters);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position < characters.size()) {
            return VIEW_TYPE_CHARACTER;
        } else {
            return VIEW_TYPE_LOADING;
        }
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_character_row_name)
        TextView name;
        @BindView(R.id.view_character_row_image)
        ImageView image;

        CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder {

        LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
