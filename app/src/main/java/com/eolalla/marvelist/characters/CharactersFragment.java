package com.eolalla.marvelist.characters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eolalla.marvelist.R;
import com.eolalla.marvelist.base.BaseFragment;
import com.eolalla.marvelist.network.model.Character;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class CharactersFragment extends BaseFragment implements CharactersContract.View {

    public static final String FRAGMENT_TAG = CharactersFragment.class.getName();

    public static CharactersFragment newInstance() {
        return new CharactersFragment();
    }

    @BindView(R.id.fragment_character_loading_container)
    View loadingContainer;
    @BindView(R.id.fragment_character_recycler_view_container)
    View listContainer;
    @BindView(R.id.fragment_character_recycler_view)
    RecyclerView recyclerView;

    private CharactersContract.Presenter presenter;
    private CharactersAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public void setPresenter(CharactersContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void showLoading(boolean showLoading) {
        if (showLoading) {
            listContainer.setVisibility(View.GONE);
            loadingContainer.setVisibility(View.VISIBLE);
        } else {
            listContainer.setVisibility(View.VISIBLE);
            loadingContainer.setVisibility(View.GONE);
        }
    }

    @Override
    public void populateCharacters(List<Character> characters) {
        adapter = new CharactersAdapter(characters);
        recyclerView.setAdapter(adapter);
    }
}
