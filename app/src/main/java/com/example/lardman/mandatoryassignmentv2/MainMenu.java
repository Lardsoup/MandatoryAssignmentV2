package com.example.lardman.mandatoryassignmentv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainMenu extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ListView listView = findViewById(R.id.mainMenu_BirdList_listView);

    }

    //TODO: fix denne metode
    //TODO: skal have liste fra birdListItemAdapter.. se bookstore main
    @Override
    protected void onStart()
    {
        super.onStart();

        //ReadTaskBirdList taskBirdList = new ReadTaskBirdList();
        //taskBirdList.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/birds");

        ReadTaskObservationList taskObservationList = new ReadTaskObservationList();
        taskObservationList.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/observations");
    }

    public void OwnObservationsButtonClicked(View view)
    {

    }

    public void OthersObservationsButtonClicked(View view)
    {

    }
/*
    private class ReadTaskBirdList extends ReadHttpTask
    {
        @Override
        protected void onPostExecute(CharSequence jsonString)
        {
            Gson gson = new GsonBuilder().create();
            final Bird[] birds = gson.fromJson(jsonString.toString(), Bird[].class);

            ListView listView = findViewById(R.id.mainMenu_BirdList_listView);
            BirdListItemAdapter adapter = new BirdListItemAdapter(getBaseContext(), R.layout.birdlist_item, birds);
            //ArrayAdapter<Bird> adapter = new ArrayAdapter<>(getBaseContext(), R.layout.birdlist_item, birds);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> aædapterView, View view, int position, long id)
                {
                    Intent intent = new Intent(getBaseContext(), specific_bird.class);
                    Bird bird = birds[(int) id];
                    intent.putExtra("BIRD", bird);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onCancelled(CharSequence message)
        {
            TextView messageTextView = findViewById(R.id.mainMenu_Message_TextView);
            messageTextView.setText(message);
            Log.e("BIRDS", message.toString());
        }
    }
*/

    private class ReadTaskObservationList extends ReadHttpTask
    {
        @Override
        protected void onPostExecute(CharSequence jsonString)
        {
            Gson gson = new GsonBuilder().create();
            final Observation[] observations = gson.fromJson(jsonString.toString(), Observation[].class);

            ListView listView = findViewById(R.id.mainMenu_BirdList_listView);
            ObservationListItemAdapter adapter = new ObservationListItemAdapter(getBaseContext(),
                    R.layout.activity_observation_list_item_adapter, observations);
            //ArrayAdapter<Bird> adapter = new ArrayAdapter<>(getBaseContext(), R.layout.birdlist_item, birds);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> aædapterView, View view, int position, long id)
                {
                    Intent intent = new Intent(getBaseContext(), specific_bird.class);
                    Observation observation = observations[(int) id];
                    intent.putExtra("OBSERVATION", observation);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onCancelled(CharSequence message)
        {
            TextView messageTextView = findViewById(R.id.mainMenu_Message_TextView);
            messageTextView.setText(message);
            Log.e("BIRDS", message.toString());
        }
    }

/*
    private class ReadTask extends ReadHttpTask
    {
        @Override
        protected void onPostExecute(CharSequence jsonString) {
            TextView messageTextView = findViewById(R.id.main_message_textview);

            Gson gson = new GsonBuilder().create();
            final Book[] books = gson.fromJson(jsonString.toString(), Book[].class);

            ListView listView = findViewById(R.id.main_books_listview);
            //ArrayAdapter<Book> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, books);
            BookListItemAdapter adapter = new BookListItemAdapter(getBaseContext(), R.layout.booklist_item, books);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getBaseContext(), BookActivity.class);
                    //Book book = books.get((int) id);
                    Book book = books[(int) id];
                    intent.putExtra("BOOK", book);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onCancelled(CharSequence message) {
            TextView messageTextView = findViewById(R.id.main_message_textview);
            messageTextView.setText(message);
            Log.e("BOOKS", message.toString());
        }
    }
*/
/*
    //TODO: skulle gerne være iorden.. kig her hvis der er problemer
    private class ReadTask extends ReadHttpTask
    {

        @Override
        protected void onPostExecute(CharSequence jsonString)
        {
            Gson gson = new GsonBuilder().create();
            final Bird[] birds = gson.fromJson(jsonString.toString(), Bird[].class);

            ListView listView = getActivity().findViewById(R.id.fragmentBirdObservationListView);
            BirdListItemAdapter adapter = new BirdListItemAdapter(getActivity(), R.layout.birdlist_item, birds);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(getActivity(), SpecificBirdActivity.class);
                    Bird bird = birds[(int) id];
                    intent.putExtra("BIRD", bird);
                    startActivity(intent);
                }
            });
        }


        @Override
        protected void onCancelled(CharSequence message)
        {
            TextView messageTextView = getActivity().findViewById(R.id.fragmentBird_Message_TextView);
            messageTextView.setText(message);
            Log.e("BIRDS", message.toString());
        }
    }
*/
}
