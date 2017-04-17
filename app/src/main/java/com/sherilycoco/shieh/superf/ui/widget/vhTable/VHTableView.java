package com.sherilycoco.shieh.superf.ui.widget.vhTable;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/4/12.
 */

public class VHTableView extends LinearLayout implements HListViewScrollView.ScrollChangedListener{

    private Context context;

    private LayoutInflater inflater;
    //是否显示标题行
    private boolean showTitle;
    //第一列是否可移动
    private boolean firstColumnIsMove;


    //用于显示表格正文内容
    private ListView listView;


    //存放标题行中的每一列的宽度，所有的行里的每一列都是基于标题行的每一列的宽度，都跟标题行的每一列的宽度相等
    private HashMap<String ,Integer> widthMap=new HashMap<>();

    //存放所有的HScrollView
    protected List<HListViewScrollView> mHScrollViews =new ArrayList<HListViewScrollView>();
    public VHTableView(Context context) {
        this(context,null);
    }

    public VHTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }
    private void init() {
        this.inflater = LayoutInflater.from(context);
        //默认显示标题行
        showTitle=true;
        //默认第一列不可滑动
        firstColumnIsMove=false;
    }
    //设置是否显示标题
    public void setShowTitle(boolean showTitle) {
        this.showTitle = showTitle;
    }

    //设置第一列是否可以滑动
    public void setFirstColumnIsMove(boolean firstColumnIsMove) {
        this.firstColumnIsMove = firstColumnIsMove;
    }

    @Override
    public void setCurrentTounchView(HListViewScrollView currentTounchView) {

    }

    @Override
    public HListViewScrollView getCurrentView() {
        return null;
    }

    @Override
    public void onUIScrollChanged(int l, int t, int oldl, int oldt) {

    }
}
