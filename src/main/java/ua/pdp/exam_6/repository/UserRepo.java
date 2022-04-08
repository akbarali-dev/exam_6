package ua.pdp.exam_6.repository;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.pdp.exam_6.model.Book;
import ua.pdp.exam_6.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
