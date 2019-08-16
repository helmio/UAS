package com.helmy.UAS.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.helmy.UAS.data.model.User;
import com.helmy.UAS.data.repo.UserRepository;
import com.helmy.UAS.preference.userPreference;
import com.helmy.UAS.view.berandaView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class berandaPresenter {

    private berandaView view;
    private UserRepository repo;
    private userPreference prefs;

    public berandaPresenter(Context context, berandaView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new userPreference(context);
    }

    public void getUserData(LifecycleOwner owner) {
        String username = prefs.userLogin();
        String password = prefs.passwordLogin();

        repo.selectUser(username, password).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                view.showUser(user);
            }
        });
    }

    public void signOut() {
        prefs.setIsLogin(null, null);
        view.onSignOut();
    }
}
