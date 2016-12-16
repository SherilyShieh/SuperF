package com.sherilycoco.shieh.superf.ui.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.ui.BaseFragment;
import com.sherilycoco.shieh.superf.ui.widget.footViewPager.FootViewFragment;
import com.sherilycoco.shieh.superf.ui.widget.footViewPager.FootViewPagerAdapter;
import com.sherilycoco.shieh.superf.ui.widget.footViewPager.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * Created by Administrator on 2016/8/5.
 */
public class MessageFragment extends BaseFragment {
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.pagenum)
    EditText pagenum;

    private FootViewPagerAdapter footViewPagerAdapter;
    private List<Person> name;
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
        name.add(new Person("张三",1.0f));
        name.add(new Person("薛子谦",2.8f));
        name.add(new Person("邓超",2.3f));
        name.add(new Person("李倩",3.6f));
        name.add(new Person("苏志燮",4.9f));
        name.add(new Person("彭于晏",5.0f));
        name.add(new Person("SB",0.0f));
        name.add(new Person("爱新觉罗",2.2f));
        name.add(new Person("四叔",3.7f));
        name.add(new Person("李四",4.5f));
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
        footViewPagerAdapter = new FootViewPagerAdapter(getFragmentManager());
        footViewPagerAdapter.setFragments(name);


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

    @OnTextChanged(R.id.pagenum)
    public void change(){
        if (!TextUtils.isEmpty(pagenum.getText())){
            viewPager.setCurrentItem(Integer.valueOf(pagenum.getText().toString()));
        }
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
