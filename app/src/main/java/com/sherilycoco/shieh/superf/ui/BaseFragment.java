package com.sherilycoco.shieh.superf.ui;

import android.app.Fragment;
import android.os.Bundle;

import com.sherilycoco.shieh.superf.di.HasComponent;
import com.sherilycoco.shieh.superf.di.component.ApplicationComponent;


/**
 * Created by Administrator on 2016/8/5.
 */
public class BaseFragment extends android.support.v4.app.Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
    }

    protected void initializeInjector() {

    }

    @SuppressWarnings("unchecked")
    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((BaseActivity) getActivity()).getApplicationComponent();
    }
}
