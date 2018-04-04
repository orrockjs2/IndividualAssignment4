package com.example.scotty.indyassign4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        String word = getIntent().getStringExtra("WORD_SEARCH");

        DatabaseHelper helper = new DatabaseHelper(this);

        String ant = helper.searchWord(word);

        TextView textView = findViewById(R.id.textView);
        textView.setText(ant);
    }
}
