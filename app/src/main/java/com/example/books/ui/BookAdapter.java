package com.example.books.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.books.R;
import com.example.books.data.model.Books;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BooksAdapterVh> {

    private List<Books> booksList;

    private Context context;

    public  ItemClickListener listener;


    public BookAdapter(List<Books> booksList) {
        this.booksList = booksList;
    }

    @NonNull
    @Override
    public BookAdapter.BooksAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book_recycler, parent, false);
        return new BooksAdapterVh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BooksAdapterVh holder, int position) {
        holder.onBind(booksList.get(position));
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }



    public class BooksAdapterVh extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView bookName;

        TextView bookAuthor;
        public BooksAdapterVh(@NonNull View itemView) {
            super(itemView);

            bookName = itemView.findViewById(R.id.book_name_tv);
            bookAuthor = itemView.findViewById(R.id.book_author_tv);
            itemView.setOnClickListener(this);

        }



        public void onBind(Books books) {
            bookName.setText(books.getName());
            bookAuthor.setText(books.getAuthor());
        }

        @Override
        public void onClick(View view) {
            if (listener != null) listener.onItemClick(getAdapterPosition());
        }

    }
    public void setOnClickListener(ItemClickListener mListener) {
        this.listener = mListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }

}
