package ua.pdp.exam_6.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.pdp.exam_6.model.Book;
import ua.pdp.exam_6.model.Role;
import ua.pdp.exam_6.model.User;
import ua.pdp.exam_6.repository.BookRepo;
import ua.pdp.exam_6.repository.RoleRepo;
import ua.pdp.exam_6.repository.UserRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.sql.init.mode}")
    String initMode;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initMode.equals("always")) {


            Role roleSuperAdmin = roleRepo.save(new Role("ROLE_SUPER_ADMIN"));
            userRepo.save(new User("akbarali", passwordEncoder.encode("1"), Collections.singleton(roleSuperAdmin)));

            Role roleAdmin = roleRepo.save(new Role("ROLE_ADMIN"));
            userRepo.save(new User("zaxriddin", passwordEncoder.encode("1"), Collections.singleton(roleAdmin)));

            Role roleUser = roleRepo.save(new Role("ROLE_USER"));
            userRepo.save(new User("umid", passwordEncoder.encode("1"), Collections.singleton(roleUser)));


            bookRepo.save(new Book("1", "1", "1"));
            bookRepo.save(new Book("2", "2", "2"));
            bookRepo.save(new Book("3", "3", "3"));


        }
    }
}
