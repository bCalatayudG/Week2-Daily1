package com.example.billcalatayud.week2_daily1.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.billcalatayud.week2_daily1.R;
import com.example.billcalatayud.week2_daily1.models.Person;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    ArrayList<String> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ArrayList<Person> person = (ArrayList<Person>) getIntent().getExtras().get("persons");

        movies = new ArrayList<String>();
        getMovies();

        ListView moviesList=(ListView)findViewById(R.id.listview);
/*
        // Create The Adapter with passing ArrayList as 3rd parameter
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, movies);
        */

        ArrayAdapter<Person> arrayAdapter =
                new ArrayAdapter<Person>(this,android.R.layout.simple_list_item_1, person);
        // Set The Adapter
        moviesList.setAdapter(arrayAdapter);

        // register onClickListener to handle click events on each item
        moviesList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v,int position, long arg3)
            {
                String selectedmovie=movies.get(position);
                Toast.makeText(getApplicationContext(), "Movie Selected : "+selectedmovie,   Toast.LENGTH_LONG).show();
            }
        });
    }

    void getMovies()
    {
        movies.add("X-Men");
        movies.add("IRONMAN");
        movies.add("SPIDY");
        movies.add("NARNIA");
        movies.add("LIONKING");
        movies.add("AVENGERS");
    }


}
