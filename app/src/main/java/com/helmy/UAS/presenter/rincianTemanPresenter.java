package com.helmy.UAS.presenter;

import android.content.Context;

import com.helmy.UAS.data.model.Friends;
import com.helmy.UAS.data.repo.FriendsRepository;
import com.helmy.UAS.view.rincianTemanView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class rincianTemanPresenter {

    private rincianTemanView view;
    private FriendsRepository repo;

    public rincianTemanPresenter(Context context, rincianTemanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void getFriendsDetail(Friends fr) {
        view.showDetail(fr);
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void removeFriend(Friends friend) {
        repo.deleteFriend(friend);
        view.onFriendDeleted();
    }
}
