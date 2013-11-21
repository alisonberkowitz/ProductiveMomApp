package com.mobileproto.mommyapp;

import android.preference.PreferenceManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chloe Local on 11/19/13.
 */
public class JsonParser {
    String username = "";

    JsonParser(){
    };

    JsonParser(String userName){
        this.username = userName;
    };

    public ArrayList<Task> parseTaskList(){
        return null;
    }

    /*

     */
    public int getNumTasksCompleted(String responseString) {
        int taskCompleted = 0;
        try {
            JSONObject obj = new JSONObject(responseString);
            taskCompleted = obj.getInt("tasksCompleted");
        } catch (JSONException e){

        }
        return taskCompleted;
    }

    /*Mac-i please do this one
    Should return an ArrayList<String> w/ friends username
    */
    public ArrayList<String> getFriends(String responseString){
        ArrayList<String> friends = new ArrayList<String>();
        if (responseString != null && !responseString.isEmpty()) {
            if (!responseString.equals("")){
                JSONArray jArray = new JSONArray();
                JSONObject jsonObj = null;
                try{
                    jsonObj = new JSONObject(responseString);
                }catch (JSONException e){
                    Log.i("jsonParse", "error converting string to json object");
                }
                try {
                    jArray = jsonObj.getJSONArray("friends");
                } catch(JSONException e) {
                    e.printStackTrace();
                    Log.i("jsonParse", "error converting to json array");
                }
                for (int i=0; i < jArray.length(); i++)
                    try {
                        String friend = jArray.getString(i);
                        friends.add(friend);
                    } catch (JSONException e) {
                        Log.i("jsonParse", "error in iterating");
                    }
            }
        } else {Log.i("jsonParse", "result is null");}
        return friends;
    }

    public List<Task> getTasks(String responseString) {
        List<Task> taskList = new ArrayList<Task>();
        JSONArray jArray = new JSONArray();
        JSONObject jsonObj = null;
        try{
            jsonObj = new JSONObject(responseString);
        }catch (JSONException e){
            Log.i("jsonParse", "error converting string to json object");
        }
        try {
            jArray = jsonObj.getJSONArray("tasks");
        } catch(JSONException e) {
            Log.i("jsonParse", "error converting to json array");
        }
        for (int i=0; i < jArray.length(); i++) {
            try {
            JSONObject taskObject = jArray.getJSONObject(i);
            // Pulling items from the array
            String text = taskObject.getString("task");
            Boolean completed = taskObject.getBoolean("completed");
            String id = taskObject.getString("_id");
            Task task = new Task(text, true, completed, id);
            taskList.add(task);
            } catch (JSONException e) {
                Log.i("jsonParse", "error in iterating, adding tasks");
            }
        }
        return taskList;
    }

}

/*
    public List<List<String>> JSONParse(String responseString) throws JSONException {
        JSONObject obj = new JSONObject(responseString);
        List<List<String>> res = new ArrayList<List<String>>();
        JSONArray array;
        array = obj.getJSONArray("tweets");

        for (int j = 0; j<array.length(); j++){
            List<String> inner = new ArrayList<String>();
            inner.add(array.getJSONObject(j).getString("tweet"));
            inner.add(array.getJSONObject(j).getString("username"));
            inner.add(array.getJSONObject(j).getString("date"));
            inner.add(array.getJSONObject(j).getString("_id"));
            res.add(inner);
        }
        return res;

    }

    */