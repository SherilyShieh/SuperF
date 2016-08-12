package com.sherilycoco.shieh.superf.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/8/12.
 */
public class FullExpanListView extends ListView {
    public FullExpanListView(Context context) {
        super(context);
    }

    public FullExpanListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullExpanListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        setFullHeight();
    }

    public void setFullHeight() {
        int totalHeight = 0;
        for (int i = 0, len = getAdapter().getCount(); i < len; i++) { //listAdapter.getCount()返回数据项的数目
            View listItem = getAdapter().getView(i, null, this);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = getLayoutParams();
        params.height = totalHeight + (getDividerHeight() * (getCount() - 1));
        setLayoutParams(params);
    }
}
