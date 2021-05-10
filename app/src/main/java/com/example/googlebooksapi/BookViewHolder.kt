package com.example.googlebooksapi

import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooksapi.databinding.ListItemBinding

class BookViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentBook: Book

    fun bindBook(book: Book) {
        currentBook = book
        binding.bookTitle.text = currentBook.title

        if(currentBook.subtitle == ""){
            binding.bookSubtitle.text = currentBook.author
            binding.bookAuthor.text = ""
        }

        else{
            binding.bookSubtitle.text = currentBook.subtitle
            binding.bookAuthor.text = currentBook.author
        }
    }
}