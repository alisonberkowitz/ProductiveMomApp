package com.mobileproto.mommyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.view.ContextThemeWrapper;
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
    String name;
    String userName;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);
        Intent intent = getIntent();
        userName = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("userName", "");
        Log.d("dauser", userName);
        final Button newTask = (Button)findViewById(R.id.button);

        //set the name
        name = intent.getExtras().getString("name");
        Log.d("daname",name);
        personName = (TextView)findViewById(R.id.personName);
        personName.setText(name);

        //only let them add new tasks if they are on their own tasklist
        if (name.equals(userName)){
            Log.d("daif", "same");
            newTask.setVisibility(View.VISIBLE);
            personName.setText("Me");
        }
        else{
            Log.d("username: ", userName);
            Log.d("daelse","dif");
            newTask.setVisibility(View.GONE);
        }

        taskList = (ListView) findViewById(R.id.taskList);
        refreshListView();

        newTask.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PersonDetailActivity.this);
                /*builder.setTitle("New Task");

                // Specify the type of input expected;
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);*/

                //set the view
                View box = inflateDialog(R.layout.new_task_dialog);
                builder.setView(box);
                box.setBackgroundColor(R.color.purple);

                final EditText input = (EditText) box.findViewById(R.id.input);

                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String taskString = input.getText().toString();
                        AddTaskRequest updateHttpRequest = new
                                AddTaskRequest(PersonDetailActivity.this);
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

    private View inflateDialog(int layoutId){
        return getLayoutInflater().inflate(layoutId, null);
    }

    //Refresh Group List View
    public void refreshListView() {

        this.taskListAdapter = new TaskListAdapter(this, this.tasks, userName.equals(name));
        this.taskList.setAdapter(this.taskListAdapter);
        Log.e("Buffer Error", name);
        new getTaskListServerRequest(taskListAdapter).execute("http://mommytask.herokuapp.com/" +
                name + "/getTasks");
    }

}