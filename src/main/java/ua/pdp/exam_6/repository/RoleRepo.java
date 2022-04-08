package ua.pdp.exam_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.pdp.exam_6.model.Book;
import ua.pdp.exam_6.model.Role;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
}
