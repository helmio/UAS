package com.helmy.UAS.presenter;

import com.helmy.UAS.view.kontakView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class kontakPresenter {

    private kontakView view;

    public kontakPresenter(kontakView view) {
        this.view = view;
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

}
