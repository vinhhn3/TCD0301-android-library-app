package com.example.tcd0301_book_library;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {

    EditText titleInput, authorInput, pagesInput;
    Button updateButton, deleteButton;

    String id, title, author, pages;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        titleInput = findViewById(R.id.title_input_update);
        authorInput = findViewById(R.id.author_input_update);
        pagesInput = findViewById(R.id.pages_input_update);
        updateButton = findViewById(R.id.button_update);
        deleteButton = findViewById(R.id.button_delete);
        builder =  new AlertDialog.Builder(this);
        getAndSetIntentData();

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                title = titleInput.getText().toString().trim();
                author = authorInput.getText().toString().trim();
                pages = pagesInput.getText().toString().trim();

                db.updateBook(id, title, author, pages);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBook();
            }
        });
    }

    void getAndSetIntentData() {
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

    void deleteBook(){
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure ???");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper databaseHelper = new DatabaseHelper(UpdateActivity.this);
                databaseHelper.deleteOneRow(id);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.create().show();
    }


}