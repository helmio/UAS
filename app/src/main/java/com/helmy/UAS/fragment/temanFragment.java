package com.helmy.UAS.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.helmy.UAS.R;
import com.helmy.UAS.activity.modifikasiTemanActivity;
import com.helmy.UAS.adapter.temanAdapter;
import com.helmy.UAS.data.model.Friends;
import com.helmy.UAS.presenter.temanPresenter;
import com.helmy.UAS.view.temanView;

import java.util.ArrayList;
import java.util.List;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class temanFragment extends Fragment implements temanView, View.OnClickListener {

    temanAdapter adapter;
    ArrayList<Friends> friends;
    static temanPresenter presenter;
    RecyclerView rvFriends;
    FloatingActionButton fab;

    public temanFragment() {
        // Required empty public constructor
    }

    @Override
    public void showFriendsList(List<Friends> friends) {
        this.friends.clear();
        this.friends.addAll(friends);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teman, container, false);
        rvFriends = view.findViewById(R.id.rvFriends);
        fab = view.findViewById(R.id.fabAddFriends);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        friends = new ArrayList<>();
        adapter = new temanAdapter(friends, getActivity());
        rvFriends.setHasFixedSize(true);
        rvFriends.setLayoutManager(new LinearLayoutManager(getContext()));
        rvFriends.setAdapter(adapter);

        presenter = new temanPresenter(getContext(),this);
        presenter.setFriendsList(this);

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fabAddFriends) {
            Intent i = new Intent(getContext(), modifikasiTemanActivity.class);
            i.putExtra("type", 0);
            startActivity(i);
        }
    }
}
