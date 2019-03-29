package com.padc.simplehabit.views.holders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.simplehabit.R;
import com.padc.simplehabit.adapters.BaseRecyclerAdapter;
import com.padc.simplehabit.data.models.CategoriesAndProgramsModel;
import com.padc.simplehabit.data.models.CurrentProgramModel;
import com.padc.simplehabit.data.vos.ProgramsVO;
import com.padc.simplehabit.delegates.CategoriesProgramsItemDelegate;

public class ProgramsViewHolder extends BaseViewHolder<ProgramsVO> {

    private ProgramsVO mProgramsVO;
    public ProgramsViewHolder(@NonNull View itemView, final CategoriesProgramsItemDelegate delegate) {
        super(itemView);


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               delegate.onTapProgram(mProgramsVO);

            }
        });
    }

    @Override
    public void bindData(ProgramsVO data) {

        mProgramsVO = data;

        ImageView ivProgram;
        TextView tvTitle = itemView.findViewById(R.id.tv_title);
        TextView tvPeriod = itemView.findViewById(R.id.tv_peroid);

        tvTitle.setText(mProgramsVO.getTitle());
        tvPeriod.setText(mProgramsVO.getAverageLengths().get(0) + " mins");

    }
}
