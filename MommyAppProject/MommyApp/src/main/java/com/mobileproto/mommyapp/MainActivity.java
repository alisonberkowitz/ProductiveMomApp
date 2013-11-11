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

        final ImageButton p1 = (ImageButton)findViewById(R.id.wine1);
        final ImageButton p2 = (ImageButton)findViewById(R.id.wine2);
        final ImageButton p3 = (ImageButton)findViewById(R.id.wine3);
        final ImageButton p4 = (ImageButton)findViewById(R.id.wine4);

        p1.setOnClickListener( new Button.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(getApplicationContext(),PersonDetailActivity.class);
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

    public void incr_glass(int current_image){
        switch (current_image){
            case R.drawable.wine_glass:
                break;
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
