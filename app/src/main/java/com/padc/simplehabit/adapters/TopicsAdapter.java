package com.padc.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.simplehabit.R;
import com.padc.simplehabit.data.models.TopicsModel;
import com.padc.simplehabit.data.vos.TopicsVO;
import com.padc.simplehabit.views.holders.TopicsViewHolder;

public class TopicsAdapter extends BaseRecyclerAdapter<TopicsViewHolder, TopicsVO> {



    @NonNull
    @Override
    public TopicsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.viewholder_topics,viewGroup,false);
        return new TopicsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicsViewHolder holder, int position) {

        TextView tvTopic, tvDesc;
        ImageView icon, background;

        tvTopic = holder.itemView.findViewById(R.id.tv_topic_name);
        tvDesc = holder.itemView.findViewById(R.id.tv_desc);

        tvTopic.setText(getItems().get(position).getTopicName());
        tvDesc.setText(getItems().get(position).getTopicDesc());
    }


}
