package com.example.finallogin2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class liftpersonlist extends AppCompatActivity {
FirebaseDatabase database;
    DatabaseReference databaselifttaker;
    ListView listViewlifttaker;
    List<Lifttaker> lifttakers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_liftpersonlist );

        listViewlifttaker=(ListView) findViewById(R.id.listView);
//        database =
//
//        lifttakers =new ArrayList<>( );
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaselifttaker.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lifttakers.clear();
//                for(DataSnapshot lifttakerSnapshot : DataSnapshot.getChildren()){

                for (DataSnapshot lifttakerSnapshot : dataSnapshot.getChildren()){
                    Lifttaker lifttaker=lifttakerSnapshot.getValue(Lifttaker.class);
                   lifttakers.add( lifttaker );
                }
                LifttakerList adapter =new LifttakerList(liftpersonlist.this ,lifttakers );
                listViewlifttaker.setAdapter( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );
    }
}
