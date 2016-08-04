package com.sherilycoco.shieh.superf.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.sherilycoco.shieh.superf.SuperFApplication;
import com.sherilycoco.shieh.superf.di.component.ApplicationComponent;
import com.sherilycoco.shieh.superf.di.component.DaggerApplicationComponent;
import com.sherilycoco.shieh.superf.di.moudle.ApplicationMoudle;

/**
 * Created by Administrator on 2016/8/4.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
