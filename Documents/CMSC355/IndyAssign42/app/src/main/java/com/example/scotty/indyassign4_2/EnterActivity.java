package com.example.scotty.indyassign4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText word = findViewById(R.id.wordText);
                EditText antonym = findViewById(R.id.antText);

                String wordStr = word.getText().toString();
                String antonymStr = antonym.getText().toString();

                Contact c = new Contact();
                c.setWord(wordStr);
                c.setAntonym(antonymStr);

                helper.insertWord(c);

                openDisplayActivity();
            }
        });
    }

    public void openDisplayActivity() {
        Intent intent = new Intent(this, displayActivity.class);
        startActivity(intent);
    }
}
