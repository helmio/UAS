package com.helmy.UAS.presenter;

import android.content.Context;
import android.widget.EditText;

import com.helmy.UAS.data.model.Friends;
import com.helmy.UAS.data.repo.FriendsRepository;
import com.helmy.UAS.view.modifikasiTemanView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class modifikasiTemanPresenter {

    private FriendsRepository repo;
    private modifikasiTemanView view;

    public modifikasiTemanPresenter(Context context, modifikasiTemanView view) {
        this.view = view;
        repo = new FriendsRepository(context);
    }

    public void isEdit(int type) {
        if (type == 1) {
            view.showData();
        }
    }

    public void addFriend(Friends friend) {
        try {
            repo.insertFriend(friend);
            view.onFriendAdded();
        } catch (Exception ex) {
            view.showFailed("Failed to add friend, NIM "+friend.getNim()+" already used");
        }
    }

    public void updateFriend(Friends friend) {
        try {
            repo.updateFriend(friend);
            view.onFriendUpdated(friend);
        } catch (Exception ex) {
            view.showFailed("Gagal diupdate!, NIM "+friend.getNim()+" sudah ada!");
        }
    }

    public void setError(EditText et) {
        view.showError(et);
    }
}
