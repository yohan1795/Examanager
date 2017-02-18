package com.yohan.examanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yohan.examanager.R;
import com.yohan.examanager.activity.MainActivity;
import com.yohan.examanager.model.ExamItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yohan on 03-02-17.
 */

public class DetailFragment extends Fragment {
    private ExamItem exam;
    private String source;
    private String buttonTag;
    @BindView(R.id.details_title)
    TextView  title;
    @BindView(R.id.details_date)
    TextView  date;
    @BindView(R.id.details_duration)
    TextView  duration;
    @BindView(R.id.details_time)
    TextView  time;
    @BindView(R.id.details_syllabus)
    TextView  syllabus;
    @BindView(R.id.details_eligibility)
    TextView  eligibility;
    @BindView(R.id.details_description)
    TextView  description;
    @BindView(R.id.details_contact)
    TextView  contact;
    @BindView(R.id.details_marks)
    TextView  marks;
    @BindView(R.id.details_submit)
    TextView  submit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exam_detail, container, false);
        ButterKnife.bind(this, view);
        Bundle bundle = getArguments();
        exam = (ExamItem) bundle.getSerializable("exam");
        source = bundle.getString("source");
        ((MainActivity) getContext()).setTitle(exam.getName());
        if(source.equalsIgnoreCase("Upcoming Exams")){
            buttonTag = "enroll";
        } else if(source.equalsIgnoreCase("My Exams")){
            buttonTag = "navigate";
        } else if(source.equalsIgnoreCase("Completed Exams")){
            buttonTag = "result";
        }
        submit.setText(buttonTag);
        showDetails();

        return view;
    }

    private void showDetails() {
        title.setText(exam.getName());
        date.setText(exam.getDatenTime());
        duration.setText(exam.getDuration());
        time .setText(exam.getDatenTime());
        syllabus.setText(exam.getSyllabus());
        marks.setText(exam.getMaxMarks());
        eligibility.setText(exam.getQualification());
        description.setText(exam.getDescription());
        contact.setText(exam.getContactNo());

    }


}
