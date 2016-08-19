package com.sherilycoco.shieh.superf.ui.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class PopuWindowAdapter extends RecyclerView.Adapter<PopuWindowAdapter.PopuViewHolder> {

    private List<Object> list;

    @Override
    public PopuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PopuViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PopuViewHolder extends RecyclerView.ViewHolder {
        public PopuViewHolder(View itemView) {
            super(itemView);
        }
    }
}
