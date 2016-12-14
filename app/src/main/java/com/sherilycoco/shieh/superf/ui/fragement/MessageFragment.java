package com.sherilycoco.shieh.superf.ui.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.ui.BaseFragment;
import com.sherilycoco.shieh.superf.ui.widget.footViewPager.FootViewFragment;
import com.sherilycoco.shieh.superf.ui.widget.footViewPager.FootViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/5.
 */
public class MessageFragment extends BaseFragment {
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private FootViewPagerAdapter footViewPagerAdapter;
    private List<String> name;
    private FootViewFragment first;
    private FootViewFragment sencond;
    private FootViewFragment third;
    private FootViewFragment fourth;
    private FootViewFragment fivth;
    private List<FootViewFragment> fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = new ArrayList<>();
        name.add("张三");
        name.add("李四");
        name.add("王五");
        name.add("小明");
        name.add("小红");
        fragments = new ArrayList<>();
        first = new FootViewFragment();
        sencond = new FootViewFragment();
        third = new FootViewFragment();
        fourth = new FootViewFragment();
        fivth = new FootViewFragment();
        fragments.add(first);
        fragments.add(sencond);
        fragments.add(third);
        fragments.add(fourth);
        fragments.add(fivth);
        footViewPagerAdapter = new FootViewPagerAdapter(getFragmentManager(),fragments,name);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.message_fragment, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(footViewPagerAdapter);
        viewPager.setPageMargin(20);
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
