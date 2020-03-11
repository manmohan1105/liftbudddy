package com.example.finallogin2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class retrieve extends AppCompatActivity {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Lifttaker lifttaker;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_retrieve );
        lifttaker=new Lifttaker(  );
        listView=(ListView)findViewById( R.id.listView );
        back=(ImageView)findViewById( R.id.imageView) ;

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("lifttaker");
        list =new ArrayList<>(  );
        adapter= new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list  );
        ref.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();

                for (DataSnapshot ds:dataSnapshot.getChildren()){
                    lifttaker=ds.getValue(Lifttaker.class);
                    list.add("Owner Id: "+lifttaker.getOwnerId().toString()+"\nDestination :"+ lifttaker.getOwnerDestination().toString() +"\nStartingPoint :"+lifttaker.getOwnerStartingPoint().toString()+"\nTime of leaving:"+lifttaker.getTime().toString());
//                    +""+lifttaker.getownerStartingPoint().toString() +""+lifttaker.getownerid().toString(
                }
                listView.setAdapter( adapter );
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        } );

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),lift.class);
                startActivity(i);
            }
        });
    }
}
