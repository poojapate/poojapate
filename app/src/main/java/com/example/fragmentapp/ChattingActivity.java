package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Locale;

public class ChattingActivity extends AppCompatActivity {
    ImageView backimg,share,pic;
    FloatingActionButton voice;
    EditText edit;
    ArrayList<String> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbaar);
        setSupportActionBar(toolbar);



        backimg=findViewById(R.id.backimg);
        share=findViewById(R.id.share);
        share=findViewById(R.id.share);
        voice=findViewById(R.id.voice);
        pic=findViewById(R.id.pic);
        edit=findViewById(R.id.edit);
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(ChattingActivity.this);
                bottomSheetDialog.setContentView(R.layout.bottomsheet);
                bottomSheetDialog.setCanceledOnTouchOutside(false);
                bottomSheetDialog.setDismissWithAnimation(true);
                bottomSheetDialog.show();
            }
        });

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speek now");
                startActivityForResult(intent,1);

            }


        });


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Check out this application");
                intent.putExtra(Intent.EXTRA_TEXT,"your application link here");
                startActivity(Intent.createChooser(intent,"share via"));

            }
          

        });

        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chatmenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.vidio:
                Toast.makeText(ChattingActivity.this, "vidio", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.phone:
                Toast.makeText(ChattingActivity.this, "phone", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Contect:
                Toast.makeText(ChattingActivity.this, "Contect", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Search:
                Toast.makeText(ChattingActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.more:
                Toast.makeText(ChattingActivity.this, "more", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 && resultCode==RESULT_OK && data!=null);
        arrayList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        Log.d("jbdsjh", "onActivityResult: "+arrayList);
        edit.setText(arrayList.get(0));
        Toast.makeText(this,arrayList.get(0),Toast.LENGTH_LONG);
    }
}
