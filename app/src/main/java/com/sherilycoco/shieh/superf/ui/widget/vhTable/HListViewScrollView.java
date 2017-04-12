package com.sherilycoco.shieh.superf.ui.widget.vhTable;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

/**
 * Created by Administrator on 2017/4/12.
 */

public class HListViewScrollView extends HorizontalScrollView {

    private ScrollChangedListener scrollChangedListener;

    public void setScrollChangedListener(ScrollChangedListener scrollChangedListener) {
        this.scrollChangedListener = scrollChangedListener;
    }

    public HListViewScrollView(Context context) {
        super(context);
    }

    public HListViewScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HListViewScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (null != this.scrollChangedListener){
            scrollChangedListener.setCurrentTounchView(this);
        }
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        if (null != this.scrollChangedListener && null != scrollChangedListener.getCurrentView() && scrollChangedListener.getCurrentView() == this) {
            scrollChangedListener.onUIScrollChanged(l,t,oldl,oldt);
        } else {
            super.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public interface ScrollChangedListener {
        void  setCurrentTounchView(HListViewScrollView currentTounchView);
        HListViewScrollView getCurrentView();
        void  onUIScrollChanged(int l, int t, int oldl, int oldt);
    }
}
