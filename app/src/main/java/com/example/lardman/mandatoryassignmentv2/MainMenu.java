package com.example.lardman.mandatoryassignmentv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;


public class MainMenu extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView listView = findViewById(R.id.mainMenu_BirdList_listView);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.mainMenu_toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        //ReadTaskBirdList taskBirdList = new ReadTaskBirdList();
        //taskBirdList.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/birds");

        ReadTaskObservationList taskObservationList = new ReadTaskObservationList();
        taskObservationList.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/observations");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuMain_AddBird_Button:
                Intent intent = new Intent(this, AddBird.class);
                startActivity(intent);
                return true;
            case R.id.menuMain_Logout_Button:
                Toast.makeText(this, "Logout Button\nClicked", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void OwnObservationsButtonClicked(View view)
    {

    }

    public void OthersObservationsButtonClicked(View view)
    {

    }


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
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
                {

                    Intent intent = new Intent(getBaseContext(), specific_bird.class);
                    Observation obs = observations[(int) id];
                    intent.putExtra("OBSERVATION", obs);
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
