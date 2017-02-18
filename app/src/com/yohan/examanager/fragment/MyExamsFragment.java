package com.yohan.examanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.yohan.examanager.R;
import com.yohan.examanager.activity.MainActivity;
import com.yohan.examanager.adapter.ExamListAdapter;
import com.yohan.examanager.model.ExamItem;
import com.yohan.examanager.rest.ApiInterface;
import com.yohan.examanager.rest.ExamanagerRetrofitClient;
import com.yohan.examanager.utils.CommonUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yohan on 03-02-17.
 */

public class MyExamsFragment extends Fragment {
    private static final String MY_EXAMS = "My Exams";
    private ExamListAdapter adapter;
    private ArrayList<ExamItem> examList;
    private LinearLayoutManager layoutManager;


    @BindView(R.id.exam_recycler)
        RecyclerView examRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exams, container, false);
        ButterKnife.bind(this, view);
        adapter = new ExamListAdapter(getContext(),new ArrayList<ExamItem>(), MY_EXAMS);
        examRecyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        examRecyclerView.setLayoutManager(layoutManager);
        callApi();
        return view;
    }

    private void callApi() {
        ApiInterface apiInterface = ExamanagerRetrofitClient.getInterface();
        String token = ((MainActivity) getActivity()).getClient().getAuthToken();
        String userId = ((MainActivity) getActivity()).getClient().getClientInfo().userId;

        Log.e("token", token);

        Call<String> myExamsCall = apiInterface.getCall("Bearer " + token, "myexams", userId);
        myExamsCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Gson gson = new Gson();
                ExamItem[] myArray = gson.fromJson(response.body(), ExamItem[].class);

                ArrayList<ExamItem> myExams = new ArrayList<ExamItem>();
                if(myArray != null && myArray.length>0) {
                    for (ExamItem e : myArray) {
                        myExams.add(e);
                    }
                } else {
                    CommonUtils.showErrorDialog(getContext(), "No Records to display");
                }

                adapter.setItem(myExams);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
