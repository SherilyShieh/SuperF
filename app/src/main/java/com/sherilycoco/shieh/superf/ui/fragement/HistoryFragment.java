package com.sherilycoco.shieh.superf.ui.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.ui.Adapter.MyViewPagerAdapter;
import com.sherilycoco.shieh.superf.ui.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/5.
 */
public class HistoryFragment extends BaseFragment {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.history_fragment, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getFragmentManager());
        viewPagerAdapter.addFragment(TestFragment.newInstance(), "TabOne");//添加Fragment
        viewPagerAdapter.addFragment(TestFragment.newInstance(), "TabTwo");
        viewPagerAdapter.addFragment(TestFragment.newInstance(), "TabThree");
        viewpager.setAdapter(viewPagerAdapter);//设置适配器
        mTabLayout.addTab(mTabLayout.newTab().setText("TabOne"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("TabTwo"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TabThree"));
        mTabLayout.setupWithViewPager(viewpager);//给TabLayout设置关联ViewPager，如果设置了ViewPager，那么ViewPagerAdapter中的getPageTitle()方法返回的就是Tab上的标题
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
