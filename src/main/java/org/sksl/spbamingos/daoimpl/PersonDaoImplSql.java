package org.sksl.spbamingos.daoimpl;

import org.sksl.spbamingos.dao.PersonDao;
import org.sksl.spbamingos.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository("Sql")
public class PersonDaoImplSql implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImplSql(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(String id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        String SsQl = "SELECT PID AS ID,PNAME AS NAME FROM PERSON_SPB";
        return (List<Person>) jdbcTemplate.query(SsQl, new PersonMapper());
    }

    @Override
    public Optional<Person> selectPersonById(String id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(String id) {
        return 0;
    }

    @Override
    public int updatePersonById(String id, Person person) {
        return 0;
    }


    private static final class PersonMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int i) throws SQLException {
            return new Person(rs.getString("ID"), rs.getString("NAME"));
        }
    }

}
