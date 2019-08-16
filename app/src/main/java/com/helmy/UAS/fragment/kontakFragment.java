package com.helmy.UAS.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.helmy.UAS.R;
import com.helmy.UAS.presenter.kontakPresenter;
import com.helmy.UAS.view.kontakView;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class kontakFragment extends Fragment implements kontakView, View.OnClickListener {

    RelativeLayout lytPhone, lytEmail, lytIG;
    kontakPresenter presenter;

    public kontakFragment() {
        // Required empty public constructor
    }

    public static kontakFragment newInstance() {
        return new kontakFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kontak, container, false);

        lytPhone = view.findViewById(R.id.lytPhone);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);

        lytPhone.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);

        presenter = new kontakPresenter(this);

        return view;
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","+6285721218965", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:helmy.hudiya@gmail.com"));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/mohammed_helmyg/"));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
        }
    }
}
