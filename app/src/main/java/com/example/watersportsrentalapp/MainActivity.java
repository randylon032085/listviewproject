package com.example.watersportsrentalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    String[] itemNames = {"glass kayak", "paddleboard", "shop's full website"};
    ListView listView;
    int[] imageList = {R.drawable.kayak, R.drawable.paddleboard};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        imageView = findViewById(R.id.imgView);
        listView = findViewById(R.id.list_View);

        CustomAdapter adapter = new CustomAdapter(this,itemNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0 :button.setVisibility(View.VISIBLE);
                            imageView.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.INVISIBLE);
                            imageView.setImageResource(imageList[position]);
                        break;
                    case 1 : button.setVisibility(View.VISIBLE);
                             imageView.setVisibility(View.VISIBLE);
                             listView.setVisibility(View.INVISIBLE);
                             imageView.setImageResource(imageList[position]);
                        break;
                    case 2 : startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://jopaddle.com")));
                        break;
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void ButtonBack (View view){
        listView.setVisibility(View.VISIBLE);
        button.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);
    }
}