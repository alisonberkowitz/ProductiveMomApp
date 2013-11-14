package com.mobileproto.mommyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by alison on 11/10/13.
 */
public class PersonDetailActivity extends Activity{

    TextView personName;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        Intent intent = getIntent();

        final String name = intent.getExtras().getString("MOM");

        personName = (TextView)findViewById(R.id.personName);
        personName.setText(name);
    }
}
