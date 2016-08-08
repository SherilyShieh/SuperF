package com.sherilycoco.shieh.superf.di.component;

import com.sherilycoco.shieh.superf.di.moudle.ActivityMoudle;
import com.sherilycoco.shieh.superf.di.scope.ActivityScope;
import com.sherilycoco.shieh.superf.ui.fragement.HistoryFragment;
import com.sherilycoco.shieh.superf.ui.fragement.KeepAccountFragment;
import com.sherilycoco.shieh.superf.ui.fragement.MessageFragment;
import com.sherilycoco.shieh.superf.ui.fragement.PersonalCenterFrament;

import java.util.logging.Handler;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/5.
 */
@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = {ActivityMoudle.class})
public interface MainComponent extends ActicityComponent {
    void inject(KeepAccountFragment keepAccountFragment);
    void inject(MessageFragment messageFragment);
    void inject(HistoryFragment historyFragment);
    void inject(PersonalCenterFrament personalCenterFrament);
}
