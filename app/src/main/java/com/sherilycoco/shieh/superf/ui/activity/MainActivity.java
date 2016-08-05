package com.sherilycoco.shieh.superf.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.HasComponent;
import com.sherilycoco.shieh.superf.di.component.DaggerMainComponent;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.di.moudle.ActivityMoudle;
import com.sherilycoco.shieh.superf.ui.BaseActivity;
import com.sherilycoco.shieh.superf.ui.BaseFragment;
import com.sherilycoco.shieh.superf.ui.fragement.HistoryFragment;
import com.sherilycoco.shieh.superf.ui.fragement.KeepAccountFragment;
import com.sherilycoco.shieh.superf.ui.fragement.MessageFragment;
import com.sherilycoco.shieh.superf.ui.fragement.PersonalCenterFrament;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements HasComponent<MainComponent> {

    @Bind(R.id.fragment_fl)
    FrameLayout fragmentFl;
    @Bind(R.id.jizhang_imageview)
    ImageView jizhangImageview;
    @Bind(R.id.jizhang_textview)
    TextView jizhangTextview;
    @Bind(R.id.jizhang)
    LinearLayout jizhang;
    @Bind(R.id.message_imageview)
    ImageView messageImageview;
    @Bind(R.id.message_textview)
    TextView messageTextview;
    @Bind(R.id.message)
    LinearLayout message;
    @Bind(R.id.history_imageview)
    ImageView historyImageview;
    @Bind(R.id.history_textview)
    TextView historyTextview;
    @Bind(R.id.history)
    LinearLayout history;
    @Bind(R.id.me_imageview)
    ImageView meImageview;
    @Bind(R.id.me_textview)
    TextView meTextview;
    @Bind(R.id.me)
    LinearLayout me;
    @Bind(R.id.bottom_toolbar)
    LinearLayout bottomToolbar;
    private MainComponent mainComponent;
    private KeepAccountFragment keepAccountFragment;
    private MessageFragment messageFragment;
    private HistoryFragment historyFragment;
    private PersonalCenterFrament personalCenterFrament;
    private int positions = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initSelected();
        setSelected(0);
//        keepAccountFragment = (KeepAccountFragment)getFragmentManager().findFragmentById(R.id.fragment_fl);
        keepAccountFragment = new KeepAccountFragment();
        messageFragment = new MessageFragment();
        historyFragment = new HistoryFragment();
        personalCenterFrament = new PersonalCenterFrament();

    }

    @OnClick({R.id.jizhang, R.id.message, R.id.history, R.id.me})
    public void choose(View view) {
        initSelected();
        switch (view.getId()) {
            case R.id.jizhang:
                setSelected(0);
                replaceFragment(keepAccountFragment);
                break;
            case R.id.message:
                setSelected(1);
                replaceFragment(messageFragment);
                break;
            case R.id.history:
                setSelected(2);
                replaceFragment(historyFragment);
                break;
            case R.id.me:
                setSelected(3);
                replaceFragment(personalCenterFrament);
                break;
        }
    }

    public void replaceFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_fl, fragment).commit();
    }

    private void setSelected(int position) {
        switch (position) {
            case 0:
                jizhangImageview.setSelected(true);
                jizhangTextview.setSelected(true);
                break;
            case 1:
                messageImageview.setSelected(true);
                messageTextview.setSelected(true);
                break;
            case 2:
                historyImageview.setSelected(true);
                messageTextview.setSelected(true);
                break;
            case 3:
                meImageview.setSelected(true);
                meTextview.setSelected(true);
                break;

        }
    }

    private void initSelected() {
        jizhangImageview.setSelected(false);
        jizhangTextview.setSelected(false);
        messageImageview.setSelected(false);
        messageTextview.setSelected(false);
        historyImageview.setSelected(false);
        messageTextview.setSelected(false);
        meImageview.setSelected(false);
        meTextview.setSelected(false);

    }

    @Override
    protected void initializeInjector() {
        super.initializeInjector();
        mainComponent = DaggerMainComponent.builder().activityMoudle(new ActivityMoudle(this)).build();
    }

    @Override
    public MainComponent getComponent() {
        return mainComponent;
    }
}
