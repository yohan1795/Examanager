/*
 * Copyright (c) 2012-present, salesforce.com, inc.
 * All rights reserved.
 * Redistribution and use of this software in source and binary forms, with or
 * without modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of salesforce.com, inc. nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission of salesforce.com, inc.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.yohan.examanager.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.ui.SalesforceActivity;
import com.yohan.examanager.R;
import com.yohan.examanager.fragment.CompletedExamsFragment;
import com.yohan.examanager.fragment.MyExamsFragment;
import com.yohan.examanager.fragment.ProfileFragment;
import com.yohan.examanager.fragment.UpcomingExamsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Main activity
 */
public class MainActivity extends SalesforceActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RestClient client;
    private static final int TRANSACTION_SUCCESS = 0;
    private static final int TRANSACTION_FAIL = -1;
    @BindView(R.id.toolbar_main)
        Toolbar toolbar;
    @BindView(R.id.drawer_layout)
        DrawerLayout drawer;
    @BindView(R.id.nav_view)
        NavigationView navigationView;

    private ActionBarDrawerToggle toggle;
    private View navHeader;

    @Override
    public void onResume() {
        findViewById(R.id.clipboard).setVisibility(View.INVISIBLE);
        super.onResume();
    }

    public RestClient getClient() {
        return client;
    }

    public void setClient(RestClient client) {
        this.client = client;
    }

    @Override
    public void onResume(RestClient client) {
        setClient(client);
        findViewById(R.id.clipboard).setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup view
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navHeader = navigationView.getHeaderView(0);


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;
        String tag = null;

        int id = item.getItemId();

        switch (id) {
            case R.id.nav_my_exams :
                fragment = new MyExamsFragment();
                tag = getResources().getString(R.string.titlebar_my_exams);
                break;
            case R.id.nav_completed_exams :
                fragment = new CompletedExamsFragment();
                tag = getResources().getString(R.string.titlebar_completed_exams);
                break;
            case R.id.nav_upcoming_exams :
                fragment = new UpcomingExamsFragment();
                tag = getResources().getString(R.string.titlebar_upcoming_exams);
                break;
            case R.id.nav_profile :
                fragment = new ProfileFragment();
                tag = getResources().getString(R.string.titlebar_profile);
                break;
        }
        if(fragment!=null && tag!= null) {
            replaceFragment(fragment, tag);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return false;
        }
    }

    public void replaceFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.clipboard, fragment);
        transaction.commit();
        setTitle(tag);
    }

    public void addFragment(Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.clipboard, fragment);
        transaction.addToBackStack(tag);
        if(transaction.commit()==TRANSACTION_SUCCESS) setTitle(tag);
    }




}
