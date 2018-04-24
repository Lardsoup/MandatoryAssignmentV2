package com.example.lardman.mandatoryassignmentv2;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.GestureDetector;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;

public class specific_bird extends AppCompatActivity implements GestureDetector.OnGestureListener
{
    private String TAG = "SBIRD";
    private long id;
    private Observation[] observations;
    private Observation singleObservation;
    private TextView headingView, nameDanishView, createdView, userIdView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bird);

        Intent intent = getIntent();
        singleObservation = (Observation) intent.getSerializableExtra("OBSERVATION");

        headingView = findViewById(R.id.specificBird_headerId_TextView);
        headingView.setText(Integer.toString(singleObservation.getId()));

        nameDanishView = findViewById(R.id.specificBird_headerBirdName_TextView);
        nameDanishView.setText(singleObservation.getNameDanish());

        createdView = findViewById(R.id.specficBird_headerUserId_TextView);
        createdView.setText(singleObservation.getUserId());

        userIdView = findViewById(R.id.specificBird_headerCreated_TextView);
        userIdView.setText(singleObservation.getCreated());


        gestureDetector = new GestureDetector(this, this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent)
    {
        Log.d(TAG, "onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        Log.d(TAG, "onFling " + e1.toString() + "::::" + e2.toString());

        boolean leftSwipe = e1.getX() > e2.getX();
        boolean rightSwipe = e1.getX() < e2.getX();

        Log.d(TAG, "onFling left: " + leftSwipe);
        if (leftSwipe)
        {
            Toast.makeText(this, "Swipe Left", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "SwipeLeft");
        }
        else if (rightSwipe)
        {
            Toast.makeText(this, "Swipe Right", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
