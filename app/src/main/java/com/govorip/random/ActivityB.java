package com.govorip.random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        TextView textView2 = findViewById(R.id.textView2);
        Button button2 = findViewById(R.id.button2);

        Bundle arguments = getIntent().getExtras();
        if(arguments!= null) {
            int ran = arguments.getInt("randomNum");
            textView2.setText(Integer.toString(ran));
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityB.this, ActivityA.class);
                Random random = new Random();
                int ranNum = random.nextInt(100);
                Intent randomNum = intent.putExtra("randomNum", ranNum);
                startActivity(intent);
                finish();
            }
        });
    }
}
