package com.example.lardman.mandatoryassignmentv2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lardman on 31-03-2018.
 */
//TODO: observations vises nu istedet for birds, birds skal bruges til valg af fugl når man skal oprette en fugl
//TODO: vis de rigtige ting fra observations istedet for Id, birdname og created
//TODO: fix created timestamp så det vises rigtigt
public class ObservationListItemAdapter extends ArrayAdapter<Observation>
{
    private final int resource;

    public ObservationListItemAdapter(Context context, int resource, List<Observation> objects)
    {
        super(context, resource, objects);
        this.resource = resource;
    }

    public ObservationListItemAdapter(Context context, int resource, Observation[] objects)
    {
        super(context, resource, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        Observation observation = getItem(position);
        String name = observation.getNameDanish(); //TODO: sat til nameDanish.. hør lige hvordan det skal sættes op hvis der er flere sprog
        String created = observation.getCreated();
        int id = observation.getId();
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

        TextView nameView = birdView.findViewById(R.id.observationList_item_name);
        TextView createdView = birdView.findViewById(R.id.observationList_item_created);
        TextView idView = birdView.findViewById(R.id.observationList_item_id);

        nameView.setText(name);
        createdView.setText(created);
        idView.setText(idString);

        return birdView;
    }
}