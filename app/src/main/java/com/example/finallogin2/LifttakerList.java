package com.example.finallogin2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LifttakerList extends ArrayAdapter<Lifttaker> {
    private Activity context;
    private List<Lifttaker> lifttakers;

    public LifttakerList(Activity context, List<Lifttaker> lifttakerList){
        super(context,R.layout.activity_liftpersonlist,lifttakerList);
        this.context=context;
        this.lifttakers=lifttakers;

    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.activity_liftpersonlist,null,true);
        TextView textViewName =(TextView) listViewItem.findViewById( R.id.textViewName );
        TextView textViewgenere = (TextView)listViewItem.findViewById( R.id.textViewgenere );

        Lifttaker lifttaker =lifttakers.get( position );
//        textViewName.setText( lifttaker.getOwnerDestination());
//        textViewgenere.setText( lifttaker.getownerStartingPoint() );
        return listViewItem;

    }
}
