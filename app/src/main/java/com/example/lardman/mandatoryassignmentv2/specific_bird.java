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

import org.w3c.dom.Text;

import java.text.DateFormat;

//TODO: hele den her klasse er FUCKED.. fix it
public class specific_bird extends AppCompatActivity
{
    private String TAG = "SPECIFIC_BIRD";
    private int id;
    private Observation[] observations;
    private Observation singleObservation;
    private TextView headingView, nameDanishView, createdView, userIdView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bird);


        //TODO: prøver og sende en liste over istedet for det individuelle object.. se om du kan få det til at virke så man kan swipe rigtigt
        Intent intent = getIntent();
        Bundle obs = getIntent().getBundleExtra("OBSERVATIONS");
        id = (int) intent.getSerializableExtra("ID");
        observations = (Observation[]) obs.getSerializable("observations");
        singleObservation = observations[id];

        headingView = findViewById(R.id.specificBird_headerId_TextView);
        headingView.setText(Integer.toString(singleObservation.getId()));

        nameDanishView = findViewById(R.id.specificBird_headerBirdName_TextView);
        nameDanishView.setText(singleObservation.getNameDanish());

        createdView = findViewById(R.id.specficBird_headerUserId_TextView);
        createdView.setText(singleObservation.getUserId());

        userIdView = findViewById(R.id.specificBird_headerCreated_TextView);
        userIdView.setText(singleObservation.getCreated());
/*
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener()
        {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
            {
                Log.d(TAG, "onFling " + e1.toString() + "::::" + e2.toString());

                boolean leftSwipe = e1.getX() > e2.getX();
                boolean rightSwipe = e1.getX() < e2.getX();

                if (leftSwipe)
                {

                }
                return true;
            }
        });

*/
    }


//TODO: fix onCreate
/*
    public void deleteBook(View view)
    {
        DeleteTask task = new DeleteTask();
        task.execute("http://anbo-restserviceproviderbooks.azurewebsites.net/Service1.svc/books/" + book.getId());
        finish();
    }

    public void updateBook(View view)
    {
        // code missing: Left as an exercise
    }
*/
/*
    public void back(View view) {
        finish();
    }

    private class DeleteTask extends AsyncTask<String, Void, CharSequence>
    {
        @Override
        protected CharSequence doInBackground(String... urls)
        {
            String urlString = urls[0];
            try
            {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                int responseCode = connection.getResponseCode();
                if (responseCode % 100 != 2)
                {
                    throw new IOException("Response code: " + responseCode);
                }
                return "Nothing";
            } catch (MalformedURLException e)
            {
                return e.getMessage() + " " + urlString;
            } catch (IOException e)
            {
                return e.getMessage();
            }
        }

        @Override
        protected void onCancelled(CharSequence charSequence)
        {
            super.onCancelled(charSequence);
            TextView messageView = findViewById(R.id.book_message_textview);
            messageView.setText(charSequence);
        }
    }
*/
}
