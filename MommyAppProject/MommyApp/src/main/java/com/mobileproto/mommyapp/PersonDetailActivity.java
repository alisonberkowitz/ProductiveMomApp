package com.mobileproto.mommyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by alison on 11/10/13.
 */
public class PersonDetailActivity extends Activity{

    TextView personName;

    TaskListAdapter taskListAdapter;
    ListView taskList;
    ArrayList<Task> tasks = new ArrayList<Task>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        Intent intent = getIntent();

        final String name = intent.getExtras().getString("name");

        personName = (TextView)findViewById(R.id.personName);
        personName.setText(name);

        taskList = (ListView) findViewById(R.id.taskList);
        refreshListView();
    }

    //Refresh Group List View
    public void refreshListView(){
        this.taskListAdapter = new TaskListAdapter(this, this.tasks);
        this.taskList.setAdapter(this.taskListAdapter);
        this.taskListAdapter.notifyDataSetChanged();
    }
}
