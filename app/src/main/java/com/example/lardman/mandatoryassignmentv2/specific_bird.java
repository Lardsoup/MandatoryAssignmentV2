package com.example.lardman.mandatoryassignmentv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

//TODO: hele den her klasse er FUCKED.. fix it
public class specific_bird extends AppCompatActivity
{
    private Observation observation;
    private TextView headingView, nameDanishView, createdView, userIdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bird);

        Intent intent = getIntent();
        observation = (Observation) intent.getSerializableExtra("OBSERVATION");

        headingView = findViewById(R.id.specificBird_headerId_TextView);
        headingView.setText(Integer.toString(observation.getId()));

        nameDanishView = findViewById(R.id.specificBird_headerBirdName_TextView);
        nameDanishView.setText(observation.getNameDanish());

        createdView = findViewById(R.id.specficBird_headerUserId_TextView);
        createdView.setText(observation.getUserId());

        userIdView = findViewById(R.id.specificBird_headerCreated_TextView);
        userIdView.setText(observation.getCreated());
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
