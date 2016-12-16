package com.sherilycoco.shieh.superf.ui.widget.footViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.sherilycoco.shieh.superf.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14.
 */

public class FootViewPagerAdapter extends FragmentPagerAdapter {
    private List<FootViewFragment> fragments = new ArrayList<>();
    private List<Person> name = new ArrayList<>();

    public FootViewPagerAdapter(FragmentManager fm/*, List<FootViewFragment> fragments*//*,List<String> name*/) {
        super(fm);
    }

    public void setFragments(List<Person> name) {
//        fragments = new ArrayList<>();
        this.name = name;
        for (int i = 0; i < name.size(); i++){
            fragments.add(FootViewFragment.newInstance());
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
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
