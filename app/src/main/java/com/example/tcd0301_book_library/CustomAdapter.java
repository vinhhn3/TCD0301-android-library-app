package com.example.tcd0301_book_library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList bookId, bookTitle, bookAuthor, bookPages;

    public CustomAdapter(Context context,
                         ArrayList bookId,
                         ArrayList bookTitle,
                         ArrayList bookAuthor,
                         ArrayList bookPages) {
        this.context = context;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
    }


    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.book_id_text.setText(String.valueOf(bookId.get(position)));
        holder.book_title_text.setText(String.valueOf(bookTitle.get(position)));
        holder.book_author_text.setText(String.valueOf(bookAuthor.get(position)));
        holder.book_pages_text.setText(String.valueOf(bookPages.get(position)));
    }

    @Override
    public int getItemCount() {
        return bookId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView book_id_text, book_author_text, book_pages_text, book_title_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_text = itemView.findViewById(R.id.book_id_text);
            book_author_text = itemView.findViewById(R.id.book_author_text);
            book_pages_text = itemView.findViewById(R.id.book_pages_text);
            book_title_text = itemView.findViewById(R.id.book_title_text);
        }
    }
}
