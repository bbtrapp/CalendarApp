package com.example.bradley.calendarapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CalendarActivity extends AppCompatActivity implements
    CalendarFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, CalendarFragment.newInstance(null, null))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
