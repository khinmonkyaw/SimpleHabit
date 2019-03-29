package com.padc.simplehabit.activities;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.padc.simplehabit.R;
import com.padc.simplehabit.adapters.SessionsAdapter;
import com.padc.simplehabit.data.models.CategoriesAndProgramsModelImpl;
import com.padc.simplehabit.data.vos.ProgramsVO;

public class ProgramDetailActivity extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView ivBackground,ivLecturer;
    private TextView tvDescription, tvReadMore,tvLecturerName;
    private  boolean expandable = true;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the toolbar

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for back arrow
        getSupportActionBar().setDisplayShowHomeEnabled(true); // for back arrow



        collapsingToolbarLayout = findViewById(R.id.ctbl);
        tvDescription = findViewById(R.id.tv_description);

       // collapsingToolbarLayout.setTitle("Unlock Your Full Potential");
        /*collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));*/

       // collapsingToolbarLayout.setCollapsedTitleTextAppearance(getResources().getDimensionPixelOffset(R.dimen.text_regular));

        String id = getIntent().getStringExtra("id");
        ProgramsVO programsVO = CategoriesAndProgramsModelImpl.getObjInstance().getProgramById(id);


        collapsingToolbarLayout.setTitle(programsVO.getTitle());
        tvDescription.setText(programsVO.getDescription());


        recyclerView = findViewById(R.id.rv_sessions);
        SessionsAdapter sessionsAdapter = new SessionsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(sessionsAdapter);
        sessionsAdapter.setNewData(programsVO.getSessionsList());

        tvDescription = findViewById(R.id.tv_description);
        tvReadMore = findViewById(R.id.tv_read_more);

        tvDescription.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(expandable)
                {
                    expandable= false;
                    if(tvDescription.getLineCount() > 3)
                    {
                        tvReadMore.setVisibility(View.VISIBLE);
                        ObjectAnimator animator = ObjectAnimator.ofInt(tvDescription,"maxLines",3);
                        animator.setDuration(0).start();

                    }

                }
            }
        });

        tvReadMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /*if (!expand) {
                    expand = true;
                    ObjectAnimator animation = ObjectAnimator.ofInt(tvDescription, "maxLines", 40);
                    animation.setDuration(100).start();
                    tvReadMore.setVisibility(View.INVISIBLE);

                }*/

                /*else {
                    expand = false;
                    ObjectAnimator animation = ObjectAnimator.ofInt(tvDescription, "maxLines", 3);
                    animation.setDuration(100).start();

                }*/

                ObjectAnimator animation = ObjectAnimator.ofInt(tvDescription, "maxLines", 40);
                animation.setDuration(100).start();
                tvReadMore.setVisibility(View.INVISIBLE);



            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
