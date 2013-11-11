package com.mobileproto.mommyapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the moms
        Mom mom1 = getMom(1);
        Mom mom2 = getMom(2);
        Mom mom3 = getMom(3);
        Mom mom4 = getMom(4);

        //pull wine buttons
        final ImageButton p1 = (ImageButton)findViewById(R.id.wine1);
        final ImageButton p2 = (ImageButton)findViewById(R.id.wine2);
        final ImageButton p3 = (ImageButton)findViewById(R.id.wine3);
        final ImageButton p4 = (ImageButton)findViewById(R.id.wine4);

        //set wine buttons to correct image
        setMomImage(mom1, p1);
        setMomImage(mom2, p2);
        setMomImage(mom3, p3);
        setMomImage(mom4, p4);

        //Set on click listeners for all wine buttons
        p1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PersonDetailActivity.class);
                i.putExtra("MOM", "Annie");
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
                b.setBackgroundResource(R.drawable.wine_glass);
            case 10:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 20:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 30:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 40:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 50:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 60:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 70:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 80:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 90:
                b.setBackgroundResource(R.drawable.wine_glass);
            case 100:
                b.setBackgroundResource(R.drawable.wine_glass);
        }
    }

    public void incr_bottle(int current_image){
        switch (current_image){
            case R.drawable.wine_bottle:
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
    
}
