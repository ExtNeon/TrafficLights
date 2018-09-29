package com.example.trafficlights;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
            case R.id.redBtn:
                color = getResources().getColor(R.color.red);
                break;
            case R.id.yellowBtn:
                color = getResources().getColor(R.color.yellow);
                break;
            case R.id.greenBtn:
                color = getResources().getColor(R.color.green);
                break;
        }
        findViewById(R.id.layout).setBackgroundColor(color);
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
            findViewById(R.id.layout).setBackgroundColor(color);
        }
    }

}
