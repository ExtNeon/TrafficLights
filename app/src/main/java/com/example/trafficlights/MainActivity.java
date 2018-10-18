package com.example.trafficlights;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int color = 0x111111;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.red_button:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.yellow_button:
                color = getResources().getColor(R.color.yellow);
                break;
            case R.id.green_button:
                color = getResources().getColor(R.color.green);
                break;
        }
        findViewById(R.id.main_layout).setBackgroundColor(color);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bgcolor", color);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("bgcolor")) {
            color = savedInstanceState.getInt("bgcolor");
            findViewById(R.id.main_layout).setBackgroundColor(color);
        }
    }

}
