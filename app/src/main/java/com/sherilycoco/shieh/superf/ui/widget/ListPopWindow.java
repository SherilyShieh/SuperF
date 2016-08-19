package com.sherilycoco.shieh.superf.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.sherilycoco.shieh.superf.R;

import java.util.List;

import butterknife.Bind;

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
    private List<Object> datas;

    public ListPopWindow(Context context, int width) {
        super(width, WRAP_CONTENT);
        this.context = context;
        initView();
    }

    public interface getMyAllTeamDetialListener {
       void check();
    }
    private getMyAllTeamDetialListener listener;

    public void setListener(getMyAllTeamDetialListener listener) {
        this.listener = listener;
    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.popwindow, null);
        listview.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        listview.setLayoutManager(layoutManager);
        setContentView(rootView);
        checkMyteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.check();
            }
        });

    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        listview.setAdapter(adapter);
    }

}
