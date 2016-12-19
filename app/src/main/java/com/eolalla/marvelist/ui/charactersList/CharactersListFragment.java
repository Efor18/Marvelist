package com.eolalla.marvelist.ui.charactersList;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eolalla.marvelist.R;
import com.eolalla.marvelist.base.BaseFragment;
import com.eolalla.marvelist.data.model.Character;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ernesto Olalla on 2/11/16.
 */

public class CharactersListFragment extends BaseFragment implements CharactersListContract.View {

    public static final String FRAGMENT_TAG = CharactersListFragment.class.getName();

    private static final int NUM_ITEMS_BEFORE_PAGE_LOAD = 2;

    public static CharactersListFragment newInstance() {
        return new CharactersListFragment();
    }

    @BindView(R.id.fragment_character_recycler_view)
    RecyclerView recyclerView;

    private CharactersListContract.Presenter presenter;
    private CharactersListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    private void init() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setExitTransition(new Fade());
        }
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
    }

    @Override
    public void onResume() {
        super.onResume();
        setDisplayHomeAsUpEnabled(false);
        setActionBarTitle(getString(R.string.app_name));
        if (adapter == null) {
            adapter = new CharactersListAdapter();
            adapter.setOnItemClickListener(new CharactersListAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Character character, View sharedView) {
                    presenter.loadCharacterDetails(character, sharedView);
                }
            });
            presenter.start();
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(CharactersListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void populateCharacters(List<Character> characters, int total) {
        adapter.addCharacters(characters, total);
    }
}
