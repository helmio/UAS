package com.helmy.UAS.presenter;

import android.content.Context;
import android.widget.EditText;

import com.helmy.UAS.data.model.User;
import com.helmy.UAS.data.repo.UserRepository;
import com.helmy.UAS.view.daftarView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class daftarPresenter {

    private daftarView view;
    private UserRepository repo;

    public daftarPresenter(Context context, daftarView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Isi Box Kosong!");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password minimal 8 karekter!");
    }
}
