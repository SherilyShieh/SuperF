package com.sherilycoco.shieh.superf.ui.widget.footViewPager;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.sherilycoco.shieh.superf.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/15.
 */

public class FootViewFrameLayout extends FrameLayout {

    @Bind(R.id.viewPager)
    ViewPager viewPager;

    public FootViewFrameLayout(Context context) {
        super(context);
    }

    public FootViewFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FootViewFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private FootViewPagerAdapter footViewPagerAdapter;

    private FragmentManager fragmentManager;

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.footview_framelayout, null);
        ButterKnife.bind(this,view);
        addView(view);
        footViewPagerAdapter = new FootViewPagerAdapter(fragmentManager);
        viewPager.setAdapter(footViewPagerAdapter);
        viewPager.setPageMargin(20);
    }
    public void setData(List<String> list){
        footViewPagerAdapter.setFragments(list);
    }


}
