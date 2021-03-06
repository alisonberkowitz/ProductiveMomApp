package com.mobileproto.mommyapp;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mac-I on 11/16/13.
 */
//custom task list adapter
public class TaskListAdapter extends ArrayAdapter {
    Context context;
    List<Task> tasks;
    Boolean mainUser;

    //create custom constructor
    public TaskListAdapter(Context context, List<Task> tasks,Boolean mainUser){
        super(context, R.layout.task_item, tasks);
        this.context = context;
        this.tasks = sortByCompletion(tasks);
        this.mainUser = mainUser;
    }

    //add method to easily replace all tasks in list.
    public void replaceAll(List<Task> tasks) {
        this.tasks.clear();
        addAll(sortByCompletion(tasks));
        notifyDataSetChanged();
    }

    //create task holder
    private class TaskHolder{
        TextView taskText;
        CheckBox completedBox;
    }

    //setView of each task item
    public View getView(final int position, View convertView, ViewGroup parent){
        TaskHolder holder;
        if(true){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_item, parent, false);
            holder = new TaskHolder();

            holder.taskText = (TextView) convertView.findViewById(R.id.taskText);
            holder.completedBox = (CheckBox) convertView.findViewById(R.id.completedBox);
            convertView.setTag(holder);
            holder.completedBox.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    cb.setEnabled(false);
                    CompleteTaskRequest updateHttpRequest = new
                            CompleteTaskRequest();
                    tasks.get(position).setStatus(true);
                    String url = "http://mommytask.herokuapp.com/" +
                            tasks.get(position).getId() + "/completed";
                    ArrayList urlParams = new ArrayList<String> ();
                    urlParams.add(url);
                    updateHttpRequest.execute(urlParams);
                }
            });
        } else holder = (TaskHolder) convertView.getTag();
        Task task = this.tasks.get(position);
        holder.taskText.setText(task.text);
        //check or uncheck box depending on completion status of task

        if (task.done) {
            holder.completedBox.setChecked(true);
            holder.completedBox.setEnabled(false);
        } else {
            holder.completedBox.setChecked(false);
            holder.completedBox.setEnabled(true);
        }
        if (!mainUser) {
            holder.completedBox.setEnabled(false);
        }
        return convertView;
    }

    //sort task list so uncompleted task are at the top if the list
    public List<Task> sortByCompletion(List<Task> tasks) {
        if (tasks.size()>0) {
            List<Task> sortedTasks = new ArrayList<Task>();
            for(int i=0;i<tasks.size();i++) {
                if (tasks.get(i).getStatus()) {
                    sortedTasks.add(tasks.get(i));
                } else {
                    sortedTasks.add(0,tasks.get(i));
                }
            }
            return sortedTasks;
        } else {
            return tasks;
        }
    }
}
