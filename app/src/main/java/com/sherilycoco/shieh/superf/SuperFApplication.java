package com.sherilycoco.shieh.superf;

import android.app.Application;

import com.sherilycoco.shieh.superf.di.component.ApplicationComponent;
import com.sherilycoco.shieh.superf.di.component.DaggerApplicationComponent;
import com.sherilycoco.shieh.superf.di.moudle.ApplicationMoudle;

/**
 * Created by Administrator on 2016/8/4.
 */
public class SuperFApplication extends Application{

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void initializeInjector(){
        applicationComponent = DaggerApplicationComponent.builder().applicationMoudle(new ApplicationMoudle(this)).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }
}
