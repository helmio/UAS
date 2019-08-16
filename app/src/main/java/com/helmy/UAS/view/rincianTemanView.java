package com.helmy.UAS.view;

import com.helmy.UAS.data.model.Friends;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public interface rincianTemanView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
