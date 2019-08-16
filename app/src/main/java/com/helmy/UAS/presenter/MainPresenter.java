package com.helmy.UAS.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.helmy.UAS.preference.userPreference;
import com.helmy.UAS.view.MainView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class MainPresenter {

    private MainView view;
    private userPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new userPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
