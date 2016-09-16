package com.sherilycoco.shieh.superf.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.mvp.model.TeamSummary;
import com.sherilycoco.shieh.superf.ui.Adapter.PopuWindowAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

/**
 * Created by Administrator on 2016/8/19.
 */
public class ListPopWindow extends PopupWindow {
    @Bind(R.id.listview)
    RecyclerView listview;
    @Bind(R.id.check_myteam)
    Button checkMyteam;
    private Context context;
    private View rootView;
    private PopuWindowAdapter adapter;

    public ListPopWindow(Context context, int width) {
        super(width, WRAP_CONTENT);
        this.context = context;
    }

    public interface getMyAllTeamDetialListener {
       void check();
    }
    private getMyAllTeamDetialListener listener;

    public void setListener(getMyAllTeamDetialListener listener) {
        this.listener = listener;
    }

    public interface OnAccountClickListener{
        void acount(TeamSummary teamSummary);
    }
    private OnAccountClickListener onAccountClickListener;

    public void setOnAccountClickListener(OnAccountClickListener onAccountClickListener) {
        this.onAccountClickListener = onAccountClickListener;
    }

    public void initView(List<TeamSummary> list) {
        LayoutInflater inflater = LayoutInflater.from(context);
        rootView = inflater.inflate(R.layout.popwindow, null);
        ButterKnife.bind(this, rootView);
        listview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        adapter = new PopuWindowAdapter(list,context);
        listview.setAdapter(adapter);
        listview.setLayoutManager(layoutManager);
        setContentView(rootView);
        if (listener != null){
            checkMyteam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.check();
                }
            });
        }
        if (onAccountClickListener != null){
            adapter.setOnChangeTeamListener(new PopuWindowAdapter.OnChangeTeamListener() {
                @Override
                public void change(TeamSummary teamSummary) {
                    onAccountClickListener.acount(teamSummary);
                }
            });
        }


    }

    public void setData(List<TeamSummary> list){
        adapter.setData(list);
    }


}
