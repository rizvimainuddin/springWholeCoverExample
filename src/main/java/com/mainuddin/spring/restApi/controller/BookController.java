package com.mainuddin.spring.restApi.controller;

import com.mainuddin.spring.restApi.Entities.Book;
import com.mainuddin.spring.restApi.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//use in MVC structure so use RestController for RESTful
//@Controller

@RestController // @Controller + @ResponseBody
public class BookController {

    @Autowired
    BookService bookService;

//    @RequestMapping(value = "/books",method = RequestMethod.GET)
//    @ResponseBody


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){

        ////first step to create json object here jackson help to return object
//        Book book = new Book();
//        book.setAuthor("mainuddin");
//        book.setId(1);
//        book.setTitle("Batman Begins");
//        return book;

        List<Book> list = bookService.getAllBook();
        if (list.size() <=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if (book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b =null;
        try{
            b = bookService.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(b));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book ,@PathVariable("id") int id) {
        try {
            this.bookService.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
