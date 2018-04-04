package com.example.scotty.indyassign4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class displayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Button entVal = findViewById(R.id.enterVal);
        Button findAnt = findViewById(R.id.findAnt);

        entVal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEnterActivity();
            }
        });

        findAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText word = findViewById(R.id.searchText);

                String wordStr = word.getText().toString();

                openResultsActivity(wordStr);
            }
        });
    }

    private void openResultsActivity(String word) {
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("WORD_SEARCH", word);
        startActivity(intent);
    }

    public void openEnterActivity(){
        Intent intent = new Intent(this, EnterActivity.class);
        startActivity(intent);
    }
}
