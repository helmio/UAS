package com.helmy.UAS.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.helmy.UAS.data.model.User;
import com.helmy.UAS.data.repo.UserRepository;
import com.helmy.UAS.preference.userPreference;
import com.helmy.UAS.view.loginView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class loginPresenter {

    private loginView view;
    private UserRepository repo;
    private userPreference prefs;

    public loginPresenter(Context context, loginView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new userPreference(context);
    }

    public void login(LifecycleOwner owner, final String username, final String pass) {
        repo.selectUser(username, pass).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    prefs.setIsLogin(username, pass);
                    view.loginSuccess();
                } else view.loginFail();
            }
        });
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Isi Box Kosong !");
    }

}
