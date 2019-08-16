package com.helmy.UAS.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.helmy.UAS.R;
import com.helmy.UAS.data.model.User;
import com.helmy.UAS.presenter.daftarPresenter;
import com.helmy.UAS.view.daftarView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class daftarActivity extends AppCompatActivity implements daftarView {

    daftarPresenter presenter;
    EditText etUsername, etName, etPassword;
    TextView tvFailed;
    Button btnSignUp;

    @Override
    public void signUpSuccess() {
        Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void signUpFailed() {
        tvFailed.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        initView();

        presenter = new daftarPresenter(this, this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void initView() {
        etUsername = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvFailed = findViewById(R.id.tvFailed);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    private void signUp() {
        String username = etUsername.getText().toString();
        String name = etName.getText().toString();
        String pass = etPassword.getText().toString();

        User user = new User(username, name, pass);

        if (!username.isEmpty()) {
            if (!name.isEmpty()) {
                if (pass.length() >= 8) {

                    presenter.signUp(user);

                } else presenter.setPassError(etPassword);
            } else presenter.setError(etName);
        } else presenter.setError(etUsername);
    }
}
