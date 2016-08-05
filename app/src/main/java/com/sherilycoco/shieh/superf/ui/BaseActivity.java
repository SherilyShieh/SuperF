package com.sherilycoco.shieh.superf.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.sherilycoco.shieh.superf.SuperFApplication;
import com.sherilycoco.shieh.superf.di.component.ApplicationComponent;


/**
 * Created by Administrator on 2016/8/4.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initializeInjector();
    }

    public ApplicationComponent getApplicationComponent(){
        return ((SuperFApplication)getApplication()).getApplicationComponent();
    }
    protected void initializeInjector(){
        getApplicationComponent().inject(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
