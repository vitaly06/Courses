package ru.oksei.Courses.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.oksei.Courses.Models.Person;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonDAO() {
        this.jdbcTemplate = null;
    }

    public Person Login(Person person){
        return jdbcTemplate.query("SELECT * FROM \"USERS\" WHERE email = ? AND password = ?",
                        new Object[]{person.getEmail(), person.getPassword()}, new PersonMapper())
                .stream().findAny().orElse(null);
    }
}
