package com.mobileproto.mommyapp;

/**
 * Created by mingram on 11/20/13.
 */
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class getTaskListServerRequest extends AsyncTask<String, Integer, List<Task>> {
    //save taskListAdapter as a property of server request
    public TaskListAdapter taskListAdapter;


    public getTaskListServerRequest(TaskListAdapter taskListAdapter){
        //assigning the inputs to stuff in here
        this.taskListAdapter = taskListAdapter;
    }

    @Override
    protected List<Task> doInBackground(String... uri){
        //url to make request
        String url = uri[0];

        //geting JSON string from URL
        String responseString = getJSONFromUrl(url);

        //parse tasks and return result
        List<Task> Data = new JsonParser().getTasks(responseString);
        return Data;
    }

    public String getJSONFromUrl(String url) {
        InputStream is = null;
        JSONObject jObj = null;
        String json = "";

        Log.d("Req URL:", url);
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
        return json;

    }

    //replace items in task listview
    protected void onPostExecute(List<Task> result){
        this.taskListAdapter.replaceAll(result);
    }
}
