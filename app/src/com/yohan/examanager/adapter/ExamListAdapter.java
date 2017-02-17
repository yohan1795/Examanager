package com.yohan.examanager.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yohan.examanager.R;
import com.yohan.examanager.activity.MainActivity;
import com.yohan.examanager.fragment.CompletedExamsFragment;
import com.yohan.examanager.fragment.MyExamsFragment;
import com.yohan.examanager.fragment.UpcomingExamsFragment;
import com.yohan.examanager.model.ExamItem;

import java.util.ArrayList;

/**
 * Created by Yohan on 03-02-17.
 */

public class ExamListAdapter extends RecyclerView.Adapter<ExamListAdapter.ExamViewHolder> {

    private static final String UPCOMING_EXAMS = "Upcoming Exams";
    private static final String MY_EXAMS = "My Exams";
    private static final String COMPLETED_EXAMS = "Completed Exams";
    private String tag;
    private Context context;

    private ArrayList<ExamItem> examList;

    public ExamListAdapter(Context context, ArrayList<ExamItem> examList, String tag) {
        this.context = context;
        this.examList = examList;
        this.tag = tag;
    }

    public void setItem(ArrayList<ExamItem> examList){
        this.examList = examList;
        notifyDataSetChanged();
    }

    @Override
    public ExamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exam_list_row, parent, false);
        return new ExamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExamViewHolder holder, final int position) {
        holder.title.setText(examList.get(position).getName());
        holder.date.setText(examList.get(position).getDatenTime().toString());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("exam", examList.get(position));
                bundle.putString("source", tag);
                Fragment fragment ;
                if(tag.equals(UPCOMING_EXAMS)){
                    fragment = new UpcomingExamsFragment();
                } else if(tag.equals(MY_EXAMS)){
                    fragment = new MyExamsFragment();
                } else if(tag.equals(COMPLETED_EXAMS)){
                    fragment = new CompletedExamsFragment();
                } else {
                    fragment = new Fragment();
                }
                fragment.setArguments(bundle);

                ((MainActivity)context).addFragment(fragment, tag);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(examList!=null)
            return examList.size();
        else
            return 0;
    }

    class ExamViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;

        public ExamViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.row_title);
            date = (TextView) view.findViewById(R.id.row_date);
        }
    }

}
