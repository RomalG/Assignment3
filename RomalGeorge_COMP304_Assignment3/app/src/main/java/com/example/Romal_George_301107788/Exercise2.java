package com.example.Romal_George_301107788;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise2 extends AppCompatActivity {

    AnimationDrawable mframeAnimation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        final Button onButton = (Button) findViewById(R.id.buttonStart);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });


        final Button offButton = (Button) findViewById(R.id.buttonStop);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });

    }
    private void startAnimation()
    {

        ImageView img = (ImageView)findViewById(R.id.ImageView_Evolution);

        BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim1);
        BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim2);
        BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim3);
        BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim4);
        BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim5);
        BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.anim6);

        // Get the background, which has been compiled to an AnimationDrawable object.
        int duration = 250;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);	// loop continuously
        mframeAnimation.addFrame(frame1, duration);
        mframeAnimation.addFrame(frame2, duration);
        mframeAnimation.addFrame(frame3, duration);
        mframeAnimation.addFrame(frame4, duration);
        mframeAnimation.addFrame(frame5, duration);
        mframeAnimation.addFrame(frame6, duration);
        mframeAnimation.addFrame(frame6, duration);
        mframeAnimation.addFrame(frame6, duration);

        img.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true,true);
        mframeAnimation.start();
    }
    private void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }

}
