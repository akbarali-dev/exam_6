package ua.pdp.exam_6.service;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.pdp.exam_6.dto.BookDto;
import ua.pdp.exam_6.model.Book;
import ua.pdp.exam_6.payload.ApiResponse;
import ua.pdp.exam_6.repository.BookRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    BookRepo bookRepo;

    public HttpEntity getAllBook() {
        List<Book> books = bookRepo.findAll();
        ApiResponse response;
        try {
            response = new ApiResponse("success", true, books);
        } catch (Exception e) {
            response = new ApiResponse("error", false, null);
        }
        return ResponseEntity.ok(response);
    }

    public HttpEntity getById(UUID id) {
        Optional<Book> bookOption = bookRepo.findById(id);
        ApiResponse response;
        try {
            response = new ApiResponse("success", true, bookOption.get());
        } catch (Exception e) {
            response = new ApiResponse("error", false, null);
        }
        return ResponseEntity.ok(response);
    }

    public HttpEntity deleteById(UUID id) {
        ApiResponse response;
        try {
            bookRepo.deleteById(id);
            response = new ApiResponse("success", true, "delete");
        } catch (Exception e) {
            response = new ApiResponse("error", false, "error");
        }
        return ResponseEntity.ok(response);
    }

    @Transactional
    public HttpEntity saveAndUpdateBook(BookDto bookDto) {
        ApiResponse response;
        try {
            Book book = new Book();
            if (bookDto.getId() != null) {
                 book = bookRepo.findById(bookDto.getId()).get();
                if (bookDto.getDescription() != null) {
                    book.setDescription(bookDto.getDescription());
                }

                if (bookDto.getName() != null) {
                    book.setName(bookDto.getName());
                }

                if (bookDto.getTitle() != null) {
                    book.setName(bookDto.getTitle());
                }

                book = bookRepo.save(book);
            }else {
                book.setName(bookDto.getName());
                book.setTitle(bookDto.getTitle());
                book.setDescription(bookDto.getDescription());
                book = bookRepo.save(book);
            }

            response = new ApiResponse("success", true, book);
        } catch (Exception e) {
            response = new ApiResponse("error", false, "error");
        }
        return ResponseEntity.ok(response);
    }

}
