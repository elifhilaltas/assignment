package com.assignment.bsp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.assignment.bsp.domain.Login;
import com.assignment.bsp.domain.Users;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    DataSource datasource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void register(Users user) {
        String sql = "insert into users values(?,?,?,?,?,)";
        jdbcTemplate.update(sql, new Object[]{user.getUsername(), user.getPassword(), user.getName(),
                user.getSurname(), user.getPhone()});
    }

    public Users validateUser(Login login) {
        String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
                + "'";
        List<Users> users = jdbcTemplate.query(sql, new UserMapper());
        return users.size() > 0 ? users.get(0) : null;
    }

    class UserMapper implements RowMapper<Users> {
        public Users mapRow(ResultSet rs, int arg1) throws SQLException {
            Users user = new Users();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("firstname"));
            user.setSurname(rs.getString("lastname"));
            user.setPhone(rs.getString("phone"));
            return user;
        }

    }
    @Override
    public <S extends Users> S save(S s) {
        return null;
    }

    @Override
    public <S extends Users> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Users> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Users> findAll() {
        return null;
    }

    @Override
    public Iterable<Users> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Users users) {

    }

    @Override
    public void deleteAll(Iterable<? extends Users> iterable) {

    }

    @Override
    public void deleteAll() {

    }


}