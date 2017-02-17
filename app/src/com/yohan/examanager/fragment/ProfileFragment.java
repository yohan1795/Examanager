package com.yohan.examanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.yohan.examanager.R;
import com.yohan.examanager.activity.MainActivity;
import com.yohan.examanager.model.Profile;
import com.yohan.examanager.rest.ApiInterface;
import com.yohan.examanager.rest.ExamanagerRetrofitClient;
import com.yohan.examanager.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Yohan on 03-02-17.
 */

public class ProfileFragment extends Fragment {

    @BindView(R.id.profile_aadhar_no_box)
    EditText aadharNo;
    @BindView(R.id.profile_contact_no_box)
    EditText contactNo;
    @BindView(R.id.profile_name_box)
    EditText name;
    @BindView(R.id.profile_id_box)
    EditText id;
    @BindView(R.id.profile_gender_box)
    EditText gender;
    @BindView(R.id.profile_dob_box)
    EditText dob;
    @BindView(R.id.profile_email_box)
    EditText email;
    @BindView(R.id.profile_edit)
    Button edit;
    @BindView(R.id.profile_save)
    Button save;


    @OnClick(R.id.profile_edit
    )
    public void doEdit(){
        edit.setVisibility(View.GONE);
        save.setVisibility(View.VISIBLE);

        id.setEnabled(true);
        aadharNo.setEnabled(true);
        name.setEnabled(true);
        contactNo.setEnabled(true);
        email.setEnabled(true);
        gender.setEnabled(true);
        dob.setEnabled(true);//set edittexts editable
    }

    @OnClick(R.id.profile_save)
    public void doSave(){
        save.setVisibility(View.GONE);
        edit.setVisibility(View.VISIBLE);

        id.setEnabled(false);
        aadharNo.setEnabled(false);
        name.setEnabled(false);
        contactNo.setEnabled(false);
        email.setEnabled(false);
        gender.setEnabled(false);
        dob.setEnabled(false);//set edittexts editable
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        getProfile();
        return view;
    }

    private void getProfile(){
        String token = ((MainActivity) getActivity()).getClient().getAuthToken();
        String userId = ((MainActivity) getActivity()).getClient().getClientInfo().userId;
        Toast.makeText(getContext(), "user Id: "+ userId, Toast.LENGTH_SHORT).show();
        ApiInterface apiInterface = ExamanagerRetrofitClient.getInterface();

        Call<String> profileCall = apiInterface.getProfileCall("Bearer "+token, userId);

        profileCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Gson gson = new Gson();
                Profile profile = gson.fromJson(response.body(), Profile.class);
                id.setText(profile.getId());
                aadharNo.setText(String.valueOf(profile.getAadharNo()));
                name.setText(profile.getName());
                contactNo.setText(profile.getContact().replaceAll("[()]","").replaceAll("-","").replaceAll(" ",""));
                email.setText(profile.getEmailAddress());
                gender.setText(profile.getGender());
                dob.setText(profile.getDob());

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                CommonUtils.showErrorDialog(getContext(), "Cannot get profile");
                t.printStackTrace();
            }
        });

    }

    private void setProfile(){

    }

}
