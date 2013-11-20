package com.mobileproto.mommyapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Chloe Local on 11/19/13.
 */
public class JsonParser {

    private String username;

    JsonParser(String username){
        this.username = username;
    };

    public ArrayList<Task> parseTaskList(){
        return null;
    }

    /*

     */
    public int getNumTasksCompleted(String responseString) throws JSONException{
        JSONObject obj = new JSONObject(responseString);
        return obj.getInt("tasksCompleted");
    }

    /*Mac-i please do this one
    Should return an ArrayList<String> w/ friends username
    */
    public ArrayList<String> getFriends(String responseString)throws JSONException{
       JSONObject obj = new JSONObject(responseString);
       JSONArray json =  obj.getJSONArray("friends");
        return null;
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