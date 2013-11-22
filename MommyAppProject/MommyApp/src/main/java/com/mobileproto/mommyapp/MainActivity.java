package com.mobileproto.mommyapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting the username
        getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .edit()
                .putString("userName", "Trish")
                .commit();
        final ImageButton p1 = (ImageButton)findViewById(R.id.wine1);
        final ImageButton p2 = (ImageButton)findViewById(R.id.wine2);
        final ImageButton p3 = (ImageButton)findViewById(R.id.wine3);
        final ImageButton p4 = (ImageButton)findViewById(R.id.wine4);
        final ImageView bottle = (ImageView) findViewById(R.id.imageView);
        updateFriends();

        //Set on click listeners for all wine buttons
        p1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                i.putExtra("name", me);
                startActivity(i);
            }
        });

        p2.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                i.putExtra("name", friend1);
                startActivity(i);
            }
        });

        p3.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                i.putExtra("name", friend2);
                startActivity(i);
            }
        });

        p4.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                i.putExtra("name", friend3);
                startActivity(i);
            }
        });
    }
    ArrayList<String> friendList;
    String me;
    String friend1;
    String friend2;
    String friend3;
    int myNumCompleted=0;
    int friend1NumCompleted=0;
    int friend2NumCompleted=0;
    int friend3NumCompleted=0;


    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        updateFriends();
        //Refresh your stuff here
    }
      
    public void setMomImage(int numDone, ImageButton b){
        if (numDone >= 10 ){
            b.setBackgroundResource(R.drawable.glass_5);
        }
        else {
        switch (numDone){
            case 0:
                b.setBackgroundResource(R.drawable.glass_0);
                break;
            case 1:
                b.setBackgroundResource(R.drawable.glass_1);
                break;
            case 2:
                b.setBackgroundResource(R.drawable.glass_1);
                break;
            case 3:
                b.setBackgroundResource(R.drawable.glass_2);
                break;
            case 4:
                b.setBackgroundResource(R.drawable.glass_2);
                break;
            case 5:
                b.setBackgroundResource(R.drawable.glass_3);
                break;
            case 6:
                b.setBackgroundResource(R.drawable.glass_3);
                break;
            case 7:
                b.setBackgroundResource(R.drawable.glass_3);
                break;
            case 8:
                b.setBackgroundResource(R.drawable.glass_4);
                break;
            case 9:
                b.setBackgroundResource(R.drawable.glass_4);
                break;
        }
        }
    }

    //for now, let's assume it takes 20 tasks to fill the bottle
    //The 13 comes from the fact that we are on a 0-12 scale
    public int setBottleLevel(){
        int totalTasks = myNumCompleted + friend3NumCompleted + friend1NumCompleted + friend2NumCompleted;
        return (int) ((((totalTasks)/20.0))*13) ;
    }

    //Set the level of the wine bottle based on the completeness
    //of the mom's tasks
    public void setBottleImage(ImageView v){
        int level = setBottleLevel();
        switch (level){
            case 0:
                v.setImageResource(R.drawable.bottle_1);
                break;
            case 1:
                v.setImageResource(R.drawable.bottle_2);
                break;
            case 2:
                v.setImageResource(R.drawable.bottle_3);
                break;
            case 3:
                v.setImageResource(R.drawable.bottle_4);
                break;
            case 4:
                v.setImageResource(R.drawable.bottle_5);
                break;
            case 5:
                v.setImageResource(R.drawable.bottle_6);
                break;
            case 6:
                v.setImageResource(R.drawable.bottle_7);
                break;
            case 7:
                v.setImageResource(R.drawable.bottle_8);
                break;
            case 8:
                v.setImageResource(R.drawable.bottle_9);
                break;
            case 9:
                v.setImageResource(R.drawable.bottle_10);
                break;
            case 10:
                v.setImageResource(R.drawable.bottle_11);
                break;
            case 11:
                v.setImageResource(R.drawable.bottle_11);
                break;
            case 12:
                v.setImageResource(R.drawable.bottle_13);
                break;
        }
    }

    public void set_name(String name, TextView t){

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //this method calls the async task to get the mom tasks completed
    public void updateTasksCompleted(String momName) {
        new GetNumberTasksCompletedRequest(this, momName).execute("http://mommytask.herokuapp.com/" +
                momName + "/getTasksCompleted");
    }

    public void setMomsTaskCompleted(String momName, int taskCompleted) {
        //this is called when the async task in updateTasksCompleted is done
        //do something with the
        if (momName.equals(me)) {
            myNumCompleted = taskCompleted;
            setMomImage(myNumCompleted, (ImageButton)findViewById(R.id.wine1));
        }
        if (momName.equals(friend1)) {
            friend1NumCompleted = taskCompleted;
            setMomImage(friend1NumCompleted, (ImageButton)findViewById(R.id.wine2));
        }
        if (momName.equals(friend2)) {
            friend2NumCompleted = taskCompleted;
            setMomImage(friend2NumCompleted, (ImageButton)findViewById(R.id.wine3));
        }
        if (momName.equals(friend3)) {
            friend3NumCompleted = taskCompleted;
            setMomImage(friend3NumCompleted, (ImageButton)findViewById(R.id.wine4));
        }
        setBottleImage((ImageView) findViewById(R.id.imageView));

    }

    public void updateFriends() {
        String userName = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("userName", "");
        new GetFriendsRequest(this).execute("http://mommytask.herokuapp.com/" +
                userName + "/friends");
    }

    public void setFriends(ArrayList<String> friends) {
        friendList = friends;
        me = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getString("userName", "");
        friend1 = friendList.get(0);
        friend2 = friendList.get(1);
        friend3 = friendList.get(2);

        updateTasksCompleted(me);
        updateTasksCompleted(friend1);
        updateTasksCompleted(friend2);
        updateTasksCompleted(friend3);

        final TextView personName1 = (TextView)findViewById(R.id.textView);
        personName1.setText("Me");
        final TextView personName2 = (TextView)findViewById(R.id.textView2);
        personName2.setText(friend1);
        final TextView personName3 = (TextView)findViewById(R.id.textView3);
        personName3.setText(friend2);
        final TextView personName4 = (TextView)findViewById(R.id.textView4);
        personName4.setText(friend3);
        //this is called when the async task in updateFriends is done
        //what to do with friends
    }
}
