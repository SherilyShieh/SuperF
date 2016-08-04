package com.sherilycoco.shieh.superf.di.component;

import android.widget.BaseAdapter;

import com.sherilycoco.shieh.superf.di.moudle.ApplicationMoudle;
import com.sherilycoco.shieh.superf.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/4.
 */
@Singleton
@Component(modules = ApplicationMoudle.class)
public interface ApplicationComponent {

    void inject(BaseActivity baseActivity);
}
