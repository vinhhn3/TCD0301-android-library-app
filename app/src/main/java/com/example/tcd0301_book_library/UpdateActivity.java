package com.example.tcd0301_book_library;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText titleInput, authorInput, pagesInput;
    Button updateButton;

    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titleInput = findViewById(R.id.title_input_update);
        authorInput = findViewById(R.id.author_input_update);
        pagesInput = findViewById(R.id.pages_input_update);
        updateButton = findViewById(R.id.button_update);

        getandSetIntentData();
    }

    void getandSetIntentData() {
        if (getIntent().hasExtra("id")
                && getIntent().hasExtra("title")
                && getIntent().hasExtra("author")
                && getIntent().hasExtra("pages")) {

            // Get the data from intent passing from the CustomAdapter
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            // Display the data to UpdateActivity
            titleInput.setText(title);
            authorInput.setText(author);
            pagesInput.setText(pages);
        }
        else {
            Toast.makeText(this,"NO DATA", Toast.LENGTH_SHORT).show();
        }
    }
}