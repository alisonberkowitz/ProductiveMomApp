package com.mobileproto.mommyapp;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mac-I on 11/16/13.
 */

public class TaskListAdapter extends ArrayAdapter {
    Context context;
    List<Task> tasks;


    public TaskListAdapter(Context context, List<Task> groups){
        super(context, R.layout.task_item, groups);
        this.context = context;
        this.tasks = groups;
        Random rand = new Random();
    }
    private class TaskHolder{
        TextView taskText;
        CheckBox completedBox;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        TaskHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_item, parent, false);
            holder = new TaskHolder();

            holder.taskText = (TextView) convertView.findViewById(R.id.taskText);
            holder.completedBox = (CheckBox) convertView.findViewById(R.id.completedBox);

            convertView.setTag(holder);
        } else holder = (TaskHolder) convertView.getTag();

        Task task = this.tasks.get(position);
        holder.taskText.setText(task.text);
        //check or uncheck box depending on completion status of task
        if (task.done) {
            holder.completedBox.setChecked(true);
        } else {
            holder.completedBox.setChecked(false);
        }
        return convertView;
    }
}
