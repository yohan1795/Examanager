package com.yohan.examanager.activity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.yohan.examanager.R;
import com.yohan.examanager.adapter.ExamListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExamActivity extends AppCompatActivity {
    @OnClick(R.id.exam_submit)
        void submit(){
        //submit via api
    }
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_exam);
        ButterKnife.bind(this);
    }
}
