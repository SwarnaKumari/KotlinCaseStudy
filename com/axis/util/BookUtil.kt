package com.axis.util

import app.DbConnection
import com.axis.model.Book
import modal.Product
import java.util.*

class BookUtil{
    var dbConnection= DbConnection()
    var connection=dbConnection.connect()

    fun insertUserInput(book:Book):Int {

            val prepareStmt = connection.prepareStatement("insert into Book values(?,?,?,?,?)")
            prepareStmt.setString(1, book.bookId)
            prepareStmt.setString(2, book.title)
            prepareStmt.setString(3, book.author)
            prepareStmt.setString(4, book.category)
            prepareStmt.setFloat(5, book.price)
            val rows = prepareStmt.executeUpdate()
           return rows
    }
    fun addBook(book:Book):Int{
        val prepareStmt = connection.prepareStatement("insert into Book values(?,?,?,?,?)")
        prepareStmt.setString(1, book.bookId)
        prepareStmt.setString(2, book.title)
        prepareStmt.setString(3, book.author)
        prepareStmt.setString(4, book.category)
        prepareStmt.setFloat(5, book.price)
        val rows = prepareStmt.executeUpdate()
        return rows
    }
    fun modifyBook(title:String,bookId:String):Int{
        var prepareStmt = connection.prepareStatement("update Book set title=? where bookId=?")
        prepareStmt.setString(1,title)
        prepareStmt.setString(2,bookId)
        var rows=prepareStmt.executeUpdate()

        return rows

    }
    fun deleteBook(bookId:String):Int{
        var prepareStmt = connection.prepareStatement("delete from Book where bookId=?")
        prepareStmt.setString(1,bookId)
        var rows=prepareStmt.executeUpdate()

        return rows
    }
    fun searchByTitle(title:String){
        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book where title=?")
        query.setString(1,title)
        val result = query.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val title= result.getString("title")
            val author= result.getString("author")
            val category= result.getString("category")
            val price= result.getFloat("price")

            books.add(Book(bookId,title,author,category,price))
        }
        for(book in books) {
            println(book)
        }

    }
    fun searchByAuthor(author:String){
        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book where author=?")
        query.setString(1,author)
        val result = query.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val title= result.getString("title")
            val author= result.getString("author")
            val category= result.getString("category")
            val price= result.getFloat("price")

            books.add(Book(bookId,title,author,category,price))
        }
        for(book in books) {
            println(book)
        }



    }
    fun displayAll(){
        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book")
        val result = query.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val title= result.getString("title")
            val author= result.getString("author")
            val category= result.getString("category")
            val price= result.getFloat("price")

            books.add(Book(bookId,title,author,category,price))
        }
        for(book in books) {
            println(book)
        }

    }
    fun specificBookDetails(bookId:String){

        var books= mutableListOf<Book>()
        val query = connection.prepareStatement("select * from Book where bookId=?")
        query.setString(1,bookId)
        val result = query.executeQuery()
        while(result.next()){
            val bookId = result.getString("bookId")
            val title= result.getString("title")
            val author= result.getString("author")
            val category= result.getString("category")
            val price= result.getFloat("price")

            books.add(Book(bookId,title,author,category,price))
        }
        for(book in books) {
            println(book)
        }
    }


}