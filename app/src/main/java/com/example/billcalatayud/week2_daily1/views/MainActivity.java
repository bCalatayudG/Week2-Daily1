package com.example.billcalatayud.week2_daily1.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.billcalatayud.week2_daily1.R;
import com.example.billcalatayud.week2_daily1.models.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "";
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;
    private EditText etMain,eTName,eTAge, eTGender;
    ArrayList <Person> persons= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.mImageView);
        etMain = findViewById(R.id.eText);

        eTName = findViewById(R.id.eTName);
        eTAge = findViewById(R.id.eTAge);
        eTGender = findViewById(R.id.eTGender);

    }


    public void onShare(View view) {
        String title = getResources().getString(R.string.chooser_title);
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, etMain.getText().toString());
        sendIntent.setType("text/plain");

        Intent chooser = Intent.createChooser(sendIntent, title);

        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }


    public void callTel(View view) {
        Intent callIntent = new Intent();
        callIntent.setAction(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:123456789"));
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }
/*
    public void callNumber(View view) {

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:5554"));
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
        }
    }
*/

    public void pickImage(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }

    public void onEMICalc(View view) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);

    }

    public void addPersons(View view) {
        String name = eTName.getText().toString();
        String age = eTAge.getText().toString();
        String gender = eTGender.getText().toString();
        Person person = new Person(name, age, gender);
        persons.add(person);

    }

    public void ViewPersons(View view) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        intent.putExtra("persons",persons);
        startActivity(intent);
    }
}
