package com.example.finallogin2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class car extends AppCompatActivity {
    private TextView destination;
    private TextView startingpoint;
    private TextView time;
    private Button submit;
    private Button liftneederperson;
    private ImageButton back1;

    List<car> carowner;
    DatabaseReference databasecar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_car );
        destination=(TextView)findViewById( R.id.editText );
        startingpoint=(TextView)findViewById( R.id.editText2 );
        time=(TextView)findViewById( R.id.editText3 );
        submit=(Button)findViewById( R.id.button );
        back1=(ImageButton)findViewById( R.id.imageButton3 ) ;
        liftneederperson=(Button)findViewById( R.id.button2 );
        carowner = new ArrayList<>();







        databasecar = FirebaseDatabase.getInstance().getReference("carowner");
        //adding an onclicklistener to button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addcarowner();
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),NextActivity.class);
                startActivity(i);
            }
        });

        liftneederperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                //below lines calls the next activity
                Intent i = new Intent(getApplicationContext(),retrieve.class);
                startActivity(i);
            }
        });

    }

    private void addcarowner() {
        //getting the values to save
        String dest = destination.getText().toString().trim();
        String start = startingpoint.getText().toString().trim();
        String tim = time.getText().toString().trim();


        //checking if the value is provided
        if (!TextUtils.isEmpty(dest)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databasecar.push().getKey();

            //creating an Artist Object

           Owner owner = new Owner(id, dest,start,tim);

            //Saving the Artist
            databasecar.child(id).setValue(owner);

            //setting edittext to blank again
//            editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Data added successfully!", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a valid name", Toast.LENGTH_LONG).show();
        }
    }
}
