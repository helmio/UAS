package com.helmy.UAS.view;

import android.widget.EditText;

import com.helmy.UAS.data.model.Friends;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public interface modifikasiTemanView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
