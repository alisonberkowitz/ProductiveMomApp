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

        /*pull moms from the database-- takes the identity (Mac-i you said that was trivial right?

         */

        //This needs to be replaced by a lookup to get the
        //correct local moms and her friends
        /*

        * */
        //get the moms
        final Mom mom1 = new Mom("Trish");//getMom(1);
        final Mom mom2 = new Mom("Ella");//getMom(2);
        final Mom mom3 = new Mom("Suzie");//getMom(3);
        final Mom mom4 = new Mom("Leslie");//getMom(4);


        //pull wine buttons
        //Need to set it to appropriate value based on mom's
        //progress
        final ImageButton p1 = (ImageButton)findViewById(R.id.wine1);
        final ImageButton p2 = (ImageButton)findViewById(R.id.wine2);
        final ImageButton p3 = (ImageButton)findViewById(R.id.wine3);
        final ImageButton p4 = (ImageButton)findViewById(R.id.wine4);
        final ImageView bottle = (ImageView) findViewById(R.id.imageView);

        //set wine buttons to correct image
        setMomImage(mom1, p1);
        setMomImage(mom2, p2);
        setMomImage(mom3, p3);
        setMomImage(mom4, p4);

        ArrayList<Mom> moms = new ArrayList<Mom>();
        moms.add(mom1); moms.add(mom2); moms.add(mom3); moms.add(mom4);

        setBottleImage(setBottleLevel(moms), bottle);

        //Set on click listeners for all wine buttons
        p1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("name", mom1.getName());
                b.putInt("status", mom1.getPercent_full());
                //b.putParcelableArrayList("tasks", mom1.getTasks());
                //it looks like it will be a challenge to pass an ArrayList between
                //we might do better just to pull tasks from a db/ the server
                i.putExtra("name", "Sarah");
                startActivity(i);
            }
        });

        p2.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("name", mom1.getName());
                b.putInt("status", mom1.getPercent_full());
                //b.putParcelableArrayList("tasks", mom1.getTasks());
                //it looks like it will be a challenge to pass an ArrayList between
                //we might do better just to pull tasks from a db/ the server
                i.putExtras(b);
                startActivity(i);
            }
        });

        p3.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("name", mom1.getName());
                b.putInt("status", mom1.getPercent_full());
                //b.putParcelableArrayList("tasks", mom1.getTasks());
                //it looks like it will be a challenge to pass an ArrayList between
                //we might do better just to pull tasks from a db/ the server
                i.putExtras(b);
                startActivity(i);
            }
        });

        p4.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("name", mom1.getName());
                b.putInt("status", mom1.getPercent_full());
                //b.putParcelableArrayList("tasks", mom1.getTasks());
                //it looks like it will be a challenge to pass an ArrayList between
                //we might do better just to pull tasks from a db/ the server
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    /*
    public Mom getMom(int num){
        return null;
    }
    */
      
    public void setMomImage(Mom m, ImageButton b){
        switch (m.getPercent_full()){
            case 0:
                b.setBackgroundResource(R.drawable.glass_0);
            case 1:
                b.setBackgroundResource(R.drawable.glass_1);
            case 2:
                b.setBackgroundResource(R.drawable.glass_2);
            case 3:
                b.setBackgroundResource(R.drawable.glass_3);
            case 4:
                b.setBackgroundResource(R.drawable.glass_4);
            case 5:
                b.setBackgroundResource(R.drawable.glass_5);
        }
    }

    //for now, let's assume it takes 20 tasks to fill the bottle
    //The 13 comes from the fact that we are on a 0-12 scale
    public int setBottleLevel(ArrayList<Mom> moms){
        int totalTasks = 0;
        for (Mom mom:moms){
            totalTasks += mom.getPercent_full();
        }
        return (int) Math.floor(((double)totalTasks)/20.0)*13 ;
    }

    //Set the level of the wine bottle based on the completeness
    //of the mom's taks
    public void setBottleImage(int numCompleted, ImageView v){
        switch (numCompleted){
            case 0:
                v.setImageResource(R.drawable.bottle_1);
            case 1:
                v.setImageResource(R.drawable.bottle_2);
            case 2:
                v.setImageResource(R.drawable.bottle_3);
            case 3:
                v.setImageResource(R.drawable.bottle_4);
            case 4:
                v.setImageResource(R.drawable.bottle_5);
            case 5:
                v.setImageResource(R.drawable.bottle_6);
            case 6:
                v.setImageResource(R.drawable.bottle_7);
            case 7:
                v.setImageResource(R.drawable.bottle_8);
            case 8:
                v.setImageResource(R.drawable.bottle_9);
            case 9:
                v.setImageResource(R.drawable.bottle_10);
            case 10:
                v.setImageResource(R.drawable.bottle_11);
            case 11:
                v.setImageResource(R.drawable.bottle_11);
            case 12:
                v.setImageResource(R.drawable.bottle_13);
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
    
}
