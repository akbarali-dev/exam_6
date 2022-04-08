package ua.pdp.exam_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pdp.exam_6.model.Book;

import java.util.UUID;

public interface BookRepo extends JpaRepository<Book, UUID> {
}
