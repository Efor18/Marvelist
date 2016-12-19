package com.eolalla.marvelist.ui.characterDetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eolalla.marvelist.R;
import com.eolalla.marvelist.base.BaseFragment;
import com.eolalla.marvelist.data.model.Character;
import com.eolalla.marvelist.data.model.Image;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ernesto Olalla on 19/12/16.
 */

public class CharacterDetailsFragment extends BaseFragment implements CharacterDetailsContract.View {

    public static final String FRAGMENT_TAG = CharacterDetailsFragment.class.getName();

    public static CharacterDetailsFragment newInstance() {
        return new CharacterDetailsFragment();
    }

    @BindView(R.id.fragment_character_details_image)
    ImageView image;
    @BindView(R.id.fragment_character_details_name)
    TextView name;
    @BindView(R.id.fragment_character_details_description)
    TextView description;
    @BindView(R.id.fragment_character_details_container)
    LinearLayout container;
    private CharacterDetailsContract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_character_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setPresenter(CharacterDetailsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        setDisplayHomeAsUpEnabled(true);
        setActionBarTitle(getString(R.string.details));
        presenter.start();
    }

    @Override
    public void populateCharacter(Character character) {
        name.setText(character.getName());
        description.setText(character.getDescription());
        String path = character.getThumbnail().getPath() + Image.LANDSCAPE_INCREDIBLE;
        Glide.with(getActivity())
                .load(path)
                .error(R.drawable.side_nav_bar)
                .error(R.drawable.side_nav_bar)
                .into(image);
    }
}
