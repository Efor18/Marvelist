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

    private static final int NUM_ITEMS_BEFORE_PAGE_LOAD = 2;

    public static CharactersFragment newInstance() {
        return new CharactersFragment();
    }

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
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int lastVisible = layoutManager.findLastVisibleItemPosition();
                if (lastVisible > adapter.getItemCount() - NUM_ITEMS_BEFORE_PAGE_LOAD) {
                    presenter.loadCharacters();
                }
            }
        });
        adapter = new CharactersAdapter();
        recyclerView.setAdapter(adapter);
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
    public void populateCharacters(List<Character> characters, int total) {
        adapter.addCharacters(characters, total);
    }
}
