package com.axis.app
import com.axis.model.Book
import com.axis.service.BookService
import java.util.*

fun main(){
    var bookservice=BookService()
    var sc=Scanner(System.`in`)
    println("=============================")
    println("Enter details of three books")
    //for(i in 1..3){
        println("Enter book: details:")
        println("Enter Book ID:")
        var bookId:String=sc.next()
        println("Enter Book Title:")
        var title:String=sc.next()
        println("Enter Book author:")
        var author:String=sc.next()
        println("Enter Book category:\ncategory should be in Science,Fiction,Technology,Others")
        var category:String=sc.next()
        println("Enter Book price:")
        var price:Float=sc.nextFloat()

        //object creation
        var book=Book(bookId,title,author,category,price)
        //function call to BookService
        bookservice.insertUserBook(book)

   // }
    println("1.Add Book\n2.Modify Book Details\n3.Delete Book details\n4.Display all the book details\n")
    println("5.Display specific book details\n6.search book by title\n7.Search book by author\n8.Exit")
    println("Enter Choice")
    var choice=sc.nextInt()
    while(choice<9){
        when(choice){
            1->{
                //Add book
                println("Enter Book ID:")
                var bookId:String=sc.next()
                println("Enter Book Title:")
                var title:String=sc.next()
                println("Enter Book author:")
                var author:String=sc.next()
                println("Enter Book category:\ncategory should be in Science,Fiction,Technology,Others")
                var category:String=sc.next()
                println("Enter Book price:")
                var price:Float=sc.nextFloat()

                var book=Book(bookId,title,author,category,price)
                bookservice.insertUserBook(book)

            }
            2->{
                //Modify Book details
                println("Enter book id to update book title")
                var bookIdToUpdate=sc.next()
                println("Enter updated product title")
                var bookTitleToUpdate=sc.next()
                bookservice.modifyBookDetails(bookTitleToUpdate,bookIdToUpdate)
            }
            3->{
                //Delete book details
                println("Enter book id to delete")
                var bookIdToDelete=sc.next()
                bookservice.deleteBookDetails(bookIdToDelete)
            }
            4->{
                //Display all the book details
                bookservice.displayAllBooks()
            }
            5->{
                //Display specific book details
                println("Enter book id to display:")
                var bookIdToDisplay=sc.next()
                bookservice.displaySpecificBook(bookIdToDisplay)
            }
            6->{
                //search book by title
                println("Enter title to search book")
                var bookIdTosearch=sc.next()
                bookservice.searchByTit(bookIdTosearch)
            }
            7->{
                //search book by author
                println("Enter author name to search book")
                var bookIdToSearch=sc.next()
                bookservice.searchByAuth(bookIdToSearch)
            }
            8->{
                //Exit
                println("Program end")
                System.exit(0)
            }
        }
        println("Enter choice to continue")
        println("1.Add Book\n2.Modify Book Details\n3.Delete Book details\n4.Display all the book details\n")
        println("5.Display specific book details\n6.search book by title\n7.Search book by author\n8.Exit")
        var ch = sc.nextInt()
        choice = ch
    }
}
