package com.example.Romal_George_301107788;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        final Button startButton = (Button) findViewById(R.id.ButtonAll);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.revolve);
            }
        });


        final Button stopButton = (Button) findViewById(R.id.buttonStop);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }
    private void performAnimation(int animationResourceID)
    {

        ImageView imageView = (ImageView)findViewById(R.id.ImageViewMoon);

        Animation an =  AnimationUtils.loadAnimation(this, animationResourceID);

        an.setAnimationListener(new Exercise3.MyAnimationListener());

        imageView.startAnimation(an);

    }

    private void toggleButtons(boolean clickableState)
    {

        final Button allButton = (Button) findViewById(R.id.ButtonAll);
        allButton.setClickable(clickableState);

    }

    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {

            ImageView imageView = (ImageView)findViewById(R.id.ImageViewMoon);
            imageView.setVisibility(View.INVISIBLE);


            toggleButtons(true);

        }

    public void onAnimationRepeat(Animation animation) {

        }



        public void onAnimationStart(Animation animation) {

        }




    }
    private void stopAnimation()
    {
        ImageView imageView = (ImageView)findViewById(R.id.ImageViewMoon);
        imageView.clearAnimation();

    }
}
