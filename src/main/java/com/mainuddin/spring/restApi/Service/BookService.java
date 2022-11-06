package com.mainuddin.spring.restApi.Service;

import com.mainuddin.spring.restApi.Dao.BookRepository;
import com.mainuddin.spring.restApi.Entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    //get all book
    public List<Book> getAllBook(){
        List<Book> list = (List<Book>)bookRepository.findAll();
        return list;
    }

    //get book by id
    public Book getBookById(int id){
        Book book = null;
        try {
            book = bookRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b){
        Book result = bookRepository.save(b);
        return result;
    }

    // deleting the book
    public void deleteBook(int bid){
        bookRepository.deleteById(bid);
    }

    // updating book
    public void updateBook(Book book, int bid){
        book.setId(bid);
        bookRepository.save(book);
    }


    //------------------Simple fake service----------------//
//    private static List<Book> list = new ArrayList<>();
//
//    static{
//        list.add(new Book(1,"shaanti ek prateek","aman"));
//        list.add(new Book(2,"dark knight rises","mainu"));
//        list.add(new Book(3,"two face","maaz alam"));
//    }
//
//    //get all book
//    public List<Book> getAllBook(){
//        return list;
//    }
//
//    //get book by id
//    public Book getBookById(int id){
//        Book book = null;
//        try {
//            book = list.stream().filter(b -> b.getId() == id).findFirst().get();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return book;
//    }
//
//    //adding the book
//    public Book addBook(Book b){
//        list.add(b);
//        return b;
//    }
//
//    // deleting the book
//    public void deleteBook(int bid){
//        list = list.stream().filter(book -> book.getId()!=bid).collect(Collectors.toList());
//    }
//
//    // updating book
//    public Book updateBook(Book book, int bid){
//        list = list.stream().map(b->{
//            if(b.getId()==bid){
//                    b.setTitle(book.getTitle());
//                    b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
//        return book;
//    }

}
