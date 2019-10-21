package com.govorip.random;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        TextView textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);

        Bundle arguments = getIntent().getExtras();
        if(arguments!= null) {
            int ran = arguments.getInt("randomNum");
            textView.setText(Integer.toString(ran));
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                Random random = new Random();
                int ranNum = random.nextInt(100);
                intent.putExtra("randomNum", ranNum);
                startActivity(intent);
                finish();
            }
        });
    }
}
