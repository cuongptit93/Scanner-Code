package com.example.cuongpp.scannerapp.Activity;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.cuongpp.scannerapp.R;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar;
    AtomicBoolean isrunning = new AtomicBoolean(false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bar = (ProgressBar) findViewById(R.id.probar);
        bar.setVisibility(View.INVISIBLE);
        doStart();
    }
    public void doStart() {
        bar.setProgress(0);
        isrunning.set(false);

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 60 && isrunning.get(); i++) {
                    SystemClock.sleep(60);
                }
                Intent i = new Intent(MainActivity.this, MainMenu.class);
                startActivity(i);
            }
        });
        isrunning.set(true);
        th.start();

    }

}
