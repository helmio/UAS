package com.helmy.UAS.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.helmy.UAS.R;
import com.helmy.UAS.data.model.Friends;
import com.helmy.UAS.data.model.FriendsData;
import com.helmy.UAS.data.repo.FriendsRepository;
import com.helmy.UAS.preference.userPreference;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class splashActivity extends AppCompatActivity {

    FriendsRepository repo;
    userPreference prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        repo = new FriendsRepository(this);
        prefs = new userPreference(this);

        Boolean isFirstRun = prefs.isFirstRun();
        if (isFirstRun) {
            Friends friends;
            for (String[] aData : FriendsData.initFriendsData) {
                friends = new Friends(aData[0], aData[1], aData[2], aData[3], aData[4], aData[5]);
                repo.insertFriend(friends);
            }

            prefs.setFirstRun(false);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splashActivity.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}
