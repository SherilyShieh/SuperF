package com.sherilycoco.shieh.superf.ui.widget.footViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.ui.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/14.
 */

public class FootViewFragment extends BaseFragment {


    @Bind(R.id.head_portrait)
    ImageView headPortrait;
    @Bind(R.id.m_name)
    TextView mName;
    @Bind(R.id.merchant_name)
    LinearLayout merchantName;
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.gender_age)
    TextView genderAge;
    @Bind(R.id.worker_name)
    RelativeLayout workerName;
    @Bind(R.id.rating_bar)
    RatingBar ratingBar;
//    @Bind(R.id.scope)
//    TextView scope;
    @Bind(R.id.activity_jian)
    ImageView activityJian;
    @Bind(R.id.activity_fan)
    ImageView activityFan;
    @Bind(R.id.merchant_address)
    TextView merchantAddress;
    @Bind(R.id.address)
    TextView address;
    @Bind(R.id.worker_address)
    LinearLayout workerAddress;
    @Bind(R.id.service_type)
    TextView serviceType;
    @Bind(R.id.take_order)
    FrameLayout takeOrder;
    @Bind(R.id.call_phone)
    FrameLayout callPhone;

    private TextView scope;
    private Person workersName;
    public static FootViewFragment newInstance(){
        FootViewFragment fragment  = new FootViewFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_page_service_item_layout, container, false);
        ButterKnife.bind(this, view);
        scope = (TextView) view.findViewById(R.id.scope);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name.setText(workersName.getName());
        ratingBar.setRating(workersName.getScope());
    }

    public void setData(Person nameString) {
        workersName = nameString;
//        if (!TextUtils.isEmpty(nameString))
//            Toast.makeText(getActivity(), nameString, Toast.LENGTH_SHORT).show();

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
