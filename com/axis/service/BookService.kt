package com.axis.service

import com.axis.model.Book
import com.axis.util.BookUtil

class BookService{
    var bookutil=BookUtil()
    fun insertUserBook(book:Book){
        var records=bookutil.insertUserInput(book)
        if (records>0) println(" books inserted successfully")
        else println("record not found")

    }
    fun addBookToTable(book:Book){
        var records=bookutil.addBook(book)
        if (records>0) println("$records book added successfully")
        else println("record not found")
    }
    fun modifyBookDetails(title:String,bookId:String){
        var records=bookutil.modifyBook(title,bookId)
        if (records>0) println("$records book modified successfully")
        else println("book not modified")

    }
    fun deleteBookDetails(bookId:String){
        var records=bookutil.deleteBook(bookId)
        if (records>0) println("$records book deleted successfully")
        else println("book not deleted")
    }
    fun searchByTit(title:String){
        bookutil.searchByTitle(title)

    }
    fun searchByAuth(author:String){
        bookutil.searchByAuthor(author)

    }
    fun displayAllBooks(){
        var booksres=bookutil.displayAll()
    }
    fun displaySpecificBook(bookId:String){
        bookutil.specificBookDetails(bookId)

    }

}