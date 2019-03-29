package com.padc.simplehabit.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.simplehabit.R;
import com.padc.simplehabit.data.vos.ProgramsVO;
import com.padc.simplehabit.delegates.CategoriesProgramsItemDelegate;
import com.padc.simplehabit.views.holders.ProgramsViewHolder;

public class ProgramsAdapter extends BaseRecyclerAdapter<ProgramsViewHolder, ProgramsVO> {


    CategoriesProgramsItemDelegate mDelegate;
    public ProgramsAdapter(CategoriesProgramsItemDelegate delegate) {
        this.mDelegate = delegate;
    }

    @NonNull
    @Override
    public ProgramsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.viewholder_programs,viewGroup,false);

        return new ProgramsViewHolder(view,mDelegate);
    }



}
