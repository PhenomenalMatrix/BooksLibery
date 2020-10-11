package com.example.books.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.books.R;
import com.example.books.data.model.Books;

import java.util.List;

public class BookInfo extends AppCompatActivity {

    public static final String KEY = "BOOK_INFO_ACTIVITY";
    private List<BookInfo> bookInfoList;
    private TextView book_name;
    private TextView book_desc;
    private Button closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        book_name = findViewById(R.id.bookAct_title_tv);
        book_desc = findViewById(R.id.bookAct_desc_tv);
        closeBtn = findViewById(R.id.bookACT_close_btn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent() != null) {
            Books book = (Books) getIntent().getSerializableExtra(BookInfo.KEY);
            book_name.setText(book.getName());
            book_desc.setText(book.getDesc());
        }
    }

}