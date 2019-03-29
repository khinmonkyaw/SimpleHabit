package com.padc.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.padc.simplehabit.R;
import com.padc.simplehabit.data.vos.SessionsVO;

public class SessionsViewHolder extends BaseViewHolder<SessionsVO> {

    private SessionsVO msessionsVO;

    public SessionsViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(SessionsVO data) {

        TextView tvNo, tvSessionName, tvAverageLength;
        msessionsVO = data;
        long totalseconds,minutes,seconds;

        tvNo = itemView.findViewById(R.id.tv_no);
        tvSessionName = itemView.findViewById(R.id.tv_session_name);
        tvAverageLength = itemView.findViewById(R.id.tv_average_length);



        totalseconds = msessionsVO.getLengthInSeconds();
        minutes = totalseconds / 60;
        seconds = totalseconds % 60;

        tvAverageLength.setText(minutes + ":" + seconds);

        tvSessionName.setText(msessionsVO.getTitle());





    }


}
