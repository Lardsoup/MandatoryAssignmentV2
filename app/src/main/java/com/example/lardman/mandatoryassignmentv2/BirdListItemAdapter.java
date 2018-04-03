package com.example.lardman.mandatoryassignmentv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lardman on 31-03-2018.
 */

public class BirdListItemAdapter extends ArrayAdapter<Bird>
{
    private final int resource;

    public BirdListItemAdapter(Context context, int resource, List<Bird> objects)
    {
        super(context, resource, objects);
        this.resource = resource;
    }

    public BirdListItemAdapter(Context context, int resource, Bird[] objects)
    {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        Bird bird = getItem(position);
        String name = bird.getNameDanish(); //TODO: sat til nameDanish.. hør lige hvordan det skal sættes op hvis der er flere sprog
        String created = bird.getCreated();
        int id = bird.getId();
        String idString = Integer.toString(id);
        LinearLayout birdView;

        if (convertView == null)
        {
            birdView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, birdView, true);
        }
        else
        {
            birdView = (LinearLayout) convertView;
        }

        TextView nameView = birdView.findViewById(R.id.birdlist_item_name);
        TextView createdView = birdView.findViewById(R.id.birdlist_item_created);
        TextView idView = birdView.findViewById(R.id.birdlist_item_id);

        nameView.setText(name);
        createdView.setText(created);
        idView.setText(idString);

        return birdView;
    }
}