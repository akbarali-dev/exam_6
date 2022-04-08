package ua.pdp.exam_6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "books")
public class Book {
    @Id
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String title;
    private String description;
    private String name;

    public Book(String title, String description, String name) {
        this.title = title;
        this.description = description;
        this.name = name;
    }
}
