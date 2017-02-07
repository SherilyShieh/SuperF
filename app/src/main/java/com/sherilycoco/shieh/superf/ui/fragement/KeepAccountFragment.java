package com.sherilycoco.shieh.superf.ui.fragement;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.di.component.MainComponent;
import com.sherilycoco.shieh.superf.mvp.model.TeamSummary;
import com.sherilycoco.shieh.superf.ui.Adapter.PopuWindowAdapter;
import com.sherilycoco.shieh.superf.ui.BaseFragment;
import com.sherilycoco.shieh.superf.ui.activity.DiaologDemoActivity;
import com.sherilycoco.shieh.superf.ui.widget.ListPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @Bind(R.id.current_team)
    TextView currentTeam;

    private ListPopWindow listPopWindow;
    private List<TeamSummary> list;

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
    @OnClick(R.id.month)
    public void show(){
        Intent intent = new Intent(getActivity(), DiaologDemoActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.change_zhangben)
    public void changeZhangben() {

        if (listPopWindow != null && listPopWindow.isShowing()) {
            listPopWindow.dismiss();
            upDown.setSelected(false);
            return;
        }

        list = new ArrayList<>();
//        PopuWindowAdapter adapter = new PopuWindowAdapter(list, getActivity());
//        listPopWindow.initView(list);
//        adapter.setOnChangeTeamListener(new PopuWindowAdapter.OnChangeTeamListener() {
//            @Override
//            public void change(TeamSummary teamSummary) {
//
//            }
//        });
        listPopWindow = new ListPopWindow(getActivity(), changeZhangben.getWidth());
        listPopWindow.initView(list);
        listPopWindow.setListener(new ListPopWindow.getMyAllTeamDetialListener() {
            @Override
            public void check() {
               //跳转到我的团队页面，查看所有团队的缩略信息，并可以在团队页面操作每个团队
            }
        });
        listPopWindow.setOnAccountClickListener(new ListPopWindow.OnAccountClickListener() {
            @Override
            public void acount(TeamSummary teamSummary) {
                //改变标题，并获取账本ID,刷新本页
            }
        });

        listPopWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        listPopWindow.showAsDropDown(changeZhangben);
        listPopWindow.setTouchable(true);
        listPopWindow.setFocusable(true);
        listPopWindow.setOutsideTouchable(true);
        listPopWindow.showAtLocation(changeZhangben, Gravity.NO_GRAVITY, 0, 0);
        listPopWindow.update();
        listPopWindow.setData(render());


    }

    public List<TeamSummary> render() {
        list = new ArrayList<>();
        list.add(new TeamSummary("Sherily", R.mipmap.ic_launcher));
        list.add(new TeamSummary("Coconut", R.mipmap.ic_launcher));
        list.add(new TeamSummary("Sherily-Coco", R.mipmap.ic_launcher));
        list.add(new TeamSummary("Coco-Sherily", R.mipmap.ic_launcher));

        return list;
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
