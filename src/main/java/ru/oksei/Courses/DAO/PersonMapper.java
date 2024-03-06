package ru.oksei.Courses.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.oksei.Courses.Models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        try {
            person.setEmail(resultSet.getString("email"));
            person.setPassword(resultSet.getString("password"));
        }
        catch (Exception e){
            return new Person(null, null);
        }
        return person;
    }
}
