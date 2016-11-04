package com.eolalla.marvelist.characters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eolalla.marvelist.R;
import com.eolalla.marvelist.network.model.Character;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ernesto Olalla on 3/11/16.
 */

public class CharactersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Character> characters;

    public CharactersAdapter(List<Character> characterList) {
        characters = characterList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View characterView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_character_row, parent, false);
        return new CharacterViewHolder(characterView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CharacterViewHolder characterViewHolder = (CharacterViewHolder) holder;
        Character character = characters.get(position);
        characterViewHolder.name.setText(character.getName());
        characterViewHolder.description.setText(character.getDescription());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_character_row_name)
        TextView name;
        @BindView(R.id.view_character_row_description)
        TextView description;

        CharacterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
