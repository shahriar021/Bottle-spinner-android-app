package com.example.bottlespinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView button;
    int currentPosition;
    int nextPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAnimation();
            }
        });
    }

    private void playAnimation() {
        nextPosition = new Random().nextInt(5000);
        int px = button.getWidth()/2;
        int py = button.getHeight()/2;

        Animation rotate = new RotateAnimation(currentPosition,nextPosition,px,py);
        rotate.setDuration(3000);
        rotate.setFillAfter(true);

        currentPosition  = nextPosition;
        button.startAnimation(rotate);


    }
}