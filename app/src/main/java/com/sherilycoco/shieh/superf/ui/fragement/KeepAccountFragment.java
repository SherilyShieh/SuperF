package com.sherilycoco.shieh.superf.ui.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.ui.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/5.
 */
public class KeepAccountFragment extends BaseFragment {
    @Bind(R.id.check_myzhangben)
    ImageView checkMyzhangben;
    @Bind(R.id.up_down)
    ImageView upDown;
    @Bind(R.id.change_zhangben)
    LinearLayout changeZhangben;
    @Bind(R.id.add_zhangben)
    ImageView addZhangben;
    @Bind(R.id.zhangben_top_toolbar)
    RelativeLayout zhangbenTopToolbar;
    @Bind(R.id.month_text)
    TextView monthText;
    @Bind(R.id.month)
    LinearLayout month;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.keep_account_fragment, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initializeInjector() {
        super.initializeInjector();
        getComponent(MainComponent.class).inject(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
