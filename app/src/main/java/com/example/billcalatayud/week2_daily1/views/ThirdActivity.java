package com.example.billcalatayud.week2_daily1.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.billcalatayud.week2_daily1.R;
import com.example.billcalatayud.week2_daily1.models.Person;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ArrayList<Person> person = (ArrayList<Person>) getIntent().getExtras().get("persons");

        ListView personList = findViewById(R.id.listview);

        ArrayAdapter<Person> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, person);

        // Set The Adapter
        personList.setAdapter(arrayAdapter);

    }


}
