package com.example.fragmentapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class NewFragment extends Fragment {

    RecyclerView chat;
    FloatingActionButton btn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new, container, false);

        chat=view.findViewById(R.id.chat);
        btn=view.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ContectActivity.class);
                startActivity(intent);


            }

        });



        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        chat.setLayoutManager(linearLayoutManager);

       ChatAdapter chatAdapter =new ChatAdapter(getContext());
        chat.setAdapter(chatAdapter);


        return view;
    }
}