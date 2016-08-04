package com.sherilycoco.shieh.superf.di.moudle;

import android.content.Context;

import com.sherilycoco.shieh.superf.SuperFApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/4.
 */
@Module
public class ApplicationMoudle {
    private final SuperFApplication superFApplication;

    public ApplicationMoudle(SuperFApplication superFApplication) {
        this.superFApplication = superFApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return superFApplication;
    }
}
