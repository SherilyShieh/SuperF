package com.sherilycoco.shieh.superf.di.moudle;

import android.app.Activity;

import com.sherilycoco.shieh.superf.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/5.
 */
@Module
public class ActivityMoudle {

    private final Activity activity;

    public ActivityMoudle(Activity activity) {
        this.activity = activity;
    }

    @Provides @ActivityScope
    Activity activity(){
        return activity;
    }
}
