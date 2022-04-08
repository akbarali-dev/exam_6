package ua.pdp.exam_6.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import ua.pdp.exam_6.dto.BookDto;
import ua.pdp.exam_6.service.BookService;

import java.util.UUID;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/all")
    HttpEntity getAll(){
        return bookService.getAllBook();
    }

    @GetMapping("/by-id/{id}")
    HttpEntity getById(@PathVariable UUID id){
        return bookService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    HttpEntity deleteById(@PathVariable UUID id){
        return bookService.deleteById(id);
    }

    @PostMapping("/add")
    HttpEntity save(@RequestBody BookDto bookDto){
        return bookService.saveAndUpdateBook(bookDto);
    }
}
