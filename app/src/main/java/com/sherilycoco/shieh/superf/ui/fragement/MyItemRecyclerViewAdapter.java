package com.sherilycoco.shieh.superf.ui.fragement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sherilycoco.shieh.superf.R;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private List<MockData> datas;

    public MyItemRecyclerViewAdapter() {
        datas = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            datas.add(new MockData("NO."+1,"这是第"+i+"名"));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        MockData mockdata = datas.get(holder.getAdapterPosition());
        holder.mIdView.setText(mockdata.getName());
        holder.mContentView.setText(mockdata.getContent());

//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);


    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.id)
        TextView mIdView;
        @Bind(R.id.content)
        TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }
}
