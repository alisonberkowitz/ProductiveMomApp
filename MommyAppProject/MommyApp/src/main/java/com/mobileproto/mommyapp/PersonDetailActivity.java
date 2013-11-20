package com.mobileproto.mommyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    String name = "";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        Intent intent = getIntent();
        final Button newTask = (Button)findViewById(R.id.button);

        //set the name
        name = intent.getExtras().getString("name");
        personName = (TextView)findViewById(R.id.personName);
        personName.setText(name);

        taskList = (ListView) findViewById(R.id.taskList);
        refreshListView();
        tasks.add(new Task("hello1",true,false));

        newTask.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PersonDetailActivity.this);
                builder.setTitle("New Task");

                final EditText input = new EditText(PersonDetailActivity.this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String taskString = input.getText().toString();
                        AddTaskRequest updateHttpRequest = new
                                AddTaskRequest("task");
                        String url = "http://mommytask.herokuapp.com/" +
                                name + "/createTask";
                        ArrayList urlParams = new ArrayList<String> ();
                        urlParams.add(url);
                        urlParams.add("task");
                        urlParams.add(taskString);
                        updateHttpRequest.execute(urlParams);
                    }
                });
                builder.show();
            }
    });
    }
    //Refresh Group List View
    public void refreshListView() {
        this.taskListAdapter = new TaskListAdapter(this, this.tasks);
        this.taskList.setAdapter(this.taskListAdapter);
        this.taskListAdapter.notifyDataSetChanged();
    }


}