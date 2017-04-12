package com.sherilycoco.shieh.superf.ui.widget.vhTable;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/4/12.
 */

public class VHTableView extends LinearLayout implements HListViewScrollView.ScrollChangedListener{
    public VHTableView(Context context) {
        super(context);
    }

    public VHTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VHTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
