package com.sherilycoco.shieh.superf.ui.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherilycoco.shieh.superf.R;
import com.sherilycoco.shieh.superf.mvp.model.TeamSummary;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/8/19.
 */
public class PopuWindowAdapter extends RecyclerView.Adapter<PopuWindowAdapter.PopuViewHolder> {



    private List<TeamSummary> list;
    private Context context;
    private LayoutInflater inflater;

    public PopuWindowAdapter(List<TeamSummary> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    public void setData(List<TeamSummary> teamSummaryList) {
        list.clear();
        list.addAll(teamSummaryList);
        notifyDataSetChanged();

    }

    @Override
    public PopuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PopuViewHolder(inflater.inflate(R.layout.team_list_item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(final PopuViewHolder holder, int position) {
        TeamSummary teamSummary = list.get(holder.getAdapterPosition());
         holder.teamIcon.setBackgroundResource(teamSummary.getImage());
         holder.teamName.setText(teamSummary.getName());
         holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeTeamListener.change(list.get(holder.getAdapterPosition()));
            }
        });
    }

    public interface OnChangeTeamListener {
        void change(TeamSummary teamSummary);
    }

    private OnChangeTeamListener onChangeTeamListener;

    public void setOnChangeTeamListener(OnChangeTeamListener onChangeTeamListener) {
        this.onChangeTeamListener = onChangeTeamListener;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PopuViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.team_icon)
        ImageView teamIcon;
        @Bind(R.id.team_name)
        TextView teamName;
        public PopuViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
