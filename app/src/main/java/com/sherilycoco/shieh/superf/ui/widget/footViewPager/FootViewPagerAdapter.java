package com.sherilycoco.shieh.superf.ui.widget.footViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.sherilycoco.shieh.superf.ui.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class FootViewPagerAdapter extends FragmentPagerAdapter {
    private List<FootViewFragment> fragments;
    private List<String> name;

    public FootViewPagerAdapter(FragmentManager fm, List<FootViewFragment> fragments,List<String> name) {
        super(fm);
        this.fragments = fragments;
        this.name = name;

    }

    @Override
    public Fragment getItem(int position) {
        fragments.get(position).setData(name.get(position));
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
