package com.helmy.UAS.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.helmy.UAS.data.model.Friends;
import com.helmy.UAS.data.repo.FriendsRepository;
import com.helmy.UAS.view.temanView;

import java.util.List;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class temanPresenter {

    private FriendsRepository repo;
    private temanView view;
    private LiveData<List<Friends>> allFriends;

    public temanPresenter(Context context, temanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
        allFriends = repo.getAllFriends();
    }

    public void setFriendsList(LifecycleOwner owner) {
        allFriends.observe(owner, new Observer<List<Friends>>() {
            @Override
            public void onChanged(@Nullable List<Friends> friends) {
                view.showFriendsList(friends);
            }
        });
    }
}
