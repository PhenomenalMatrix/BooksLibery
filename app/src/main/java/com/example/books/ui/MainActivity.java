package com.example.books.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.books.R;
import com.example.books.data.BookRepo;
import com.example.books.data.model.Books;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.ItemClickListener  {

    RecyclerView recyclerView;

    List<Books> books = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        books = BookRepo.getBooksList();
        initAdapter();
    }

    private void initAdapter() {
        BookAdapter adapter = new BookAdapter(books);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(this);
    }




    @Override
    public void onItemClick(int position) {
        books.get(position);
        Intent intent = new Intent(this, BookInfo.class);
        intent.putExtra(BookInfo.KEY, books.get(position));
        startActivity(intent);
    }
}
