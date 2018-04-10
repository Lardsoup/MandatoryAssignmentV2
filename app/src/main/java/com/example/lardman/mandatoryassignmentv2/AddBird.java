package com.example.lardman.mandatoryassignmentv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

//TODO: hele den her klasse er FUCKED.. fix it
public class AddBird extends AppCompatActivity
{
    private Bird bird;
    private EditText nameDanishView, createdView, userIdView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_bird);

        Intent intent = getIntent();
        bird = (Bird) intent.getSerializableExtra("BIRD");

        TextView headingView = findViewById(R.id.specificBird_headerId_textview);
        //headingView.setText(R.string.app_specificBird_headerId + Integer.toString(bird.getId()));
        headingView.setText(Integer.toString(bird.getId()));

        nameDanishView = findViewById(R.id.specificBird_NameDanish_EditText);
        nameDanishView.setText(bird.getNameDanish());

        createdView = findViewById(R.id.specificBird_Created_EditText);
        createdView.setText(bird.getCreated());

        userIdView = findViewById(R.id.specificBird_UserId_EditText);
        userIdView.setText(bird.getUserId());
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
