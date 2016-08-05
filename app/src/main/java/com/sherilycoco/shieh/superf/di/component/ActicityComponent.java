package com.sherilycoco.shieh.superf.di.component;

import android.app.Activity;

import com.sherilycoco.shieh.superf.di.moudle.ActivityMoudle;
import com.sherilycoco.shieh.superf.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/5.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityMoudle.class)
public interface ActicityComponent {
    Activity activity();
}
