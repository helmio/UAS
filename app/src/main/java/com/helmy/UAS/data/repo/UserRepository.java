package com.helmy.UAS.data.repo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.helmy.UAS.data.db.AppDatabase;
import com.helmy.UAS.data.db.UserDao;
import com.helmy.UAS.data.model.User;

/**
 15 Agustus 2019
 10116298
 M Helmy H
 */

public class UserRepository {

    private UserDao userDao;

    public UserRepository(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        userDao = db.userDao();
    }

    public LiveData<User> selectUser(String username, String password) {
        return userDao.login(username, password);
    }

    public void insertUser(User user) {
        new insertAsync(userDao).execute(user);
    }

    private static class insertAsync extends AsyncTask<User, Void, Void> {
        private UserDao userDao;

        insertAsync(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... user) {
            userDao.addUser(user);
            return null;
        }
    }
}
