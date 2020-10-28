package com.example.Romal_George_301107788;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class Exercise1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    public static int thickness = 10;
    RadioGroup radioGroup;
    RadioButton red, yellow, cyan;
    public static int color;

    ImageButton up, down, left, right;
    private ImageView reusableImageView;
    private TextView textView;

    private int startx = 10;
    private int starty = 10;
    private int endx = 300;
    private int endy = 300;

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(Color.RED);
        //paint.setStrokeMiter((float)0.5);
        paint.setStrokeWidth(10);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);

        //set the background for your drawings
        canvas.drawColor(Color.GRAY); //background

        reusableImageView = (ImageView) findViewById(R.id.ImageViewForDrawing);
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Exercise1.this,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        radioGroup = (RadioGroup) findViewById(R.id.colorGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                if (radioButton.getText().equals("Red"))
                    color = Color.RED;
                if (radioButton.getText().equals("Yellow"))
                    color = Color.YELLOW;
                if (radioButton.getText().equals("Cyan"))
                    color = Color.CYAN;


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                thickness = 10;
                break;
            case 1:
                thickness = 20;
                break;
            case 2:
                thickness = 30;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void drawLine()
    {
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(thickness);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    public void clearCanvas(View view)
    {
        canvas.drawColor(Color.CYAN);
        startx = 10;
        starty = 10;
        endx = 300;
        endy = 300;

    }

    public void drawLine(Canvas canvas)
    {
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy+100;
                drawLine( canvas);
                reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+100;
                drawLine( canvas);
                reusableImageView.invalidate();

                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endy=endy-100;
                drawLine( canvas);
                reusableImageView.invalidate();

                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx-100;
                drawLine( canvas);
                reusableImageView.invalidate();

                return true;
        }
        return false;
    }
}
