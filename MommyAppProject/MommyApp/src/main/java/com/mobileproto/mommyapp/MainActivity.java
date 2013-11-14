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

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the moms
        final Mom mom1 = getMom(1);
        final Mom mom2 = getMom(2);
        final Mom mom3 = getMom(3);
        final Mom mom4 = getMom(4);

        //pull wine buttons
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
                i.putExtras(b);
                startActivity(i);
            }
        });

        p2.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),PersonDetailActivity.class);
                i.putExtra("MOM", "Annie");
                startActivity(i);
            }
        });

        p3.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),PersonDetailActivity.class);
                i.putExtra("MOM", "Annie");
                startActivity(i);
            }
        });

        p4.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),PersonDetailActivity.class);
                i.putExtra("MOM", "Annie");
                startActivity(i);
            }
        });
    }

    public Mom getMom(int num){
        return null;
    }
      
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

    public void incr_bottle(int current_image, ImageView v){
        switch (current_image){
            case R.drawable.bottle_0:
                v.setImageResource(R.drawable.bottle_1);
            case R.drawable.bottle_1:
                v.setImageResource(R.drawable.bottle_2);
            case R.drawable.bottle_2:
                v.setImageResource(R.drawable.bottle_3);
            case R.drawable.bottle_3:
                v.setImageResource(R.drawable.bottle_4);
            case R.drawable.bottle_4:
                v.setImageResource(R.drawable.bottle_5);
            case R.drawable.bottle_5:
                v.setImageResource(R.drawable.bottle_6);
            case R.drawable.bottle_6:
                v.setImageResource(R.drawable.bottle_7);
            case R.drawable.bottle_7:
                v.setImageResource(R.drawable.bottle_8);
            case R.drawable.bottle_8:
                v.setImageResource(R.drawable.bottle_9);
            case R.drawable.bottle_9:
                v.setImageResource(R.drawable.bottle_10);
            case R.drawable.bottle_10:
                v.setImageResource(R.drawable.bottle_11);
            case R.drawable.bottle_11:
                v.setImageResource(R.drawable.bottle_11);
            case R.drawable.bottle_12:
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
