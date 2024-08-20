package de.ait.users.app.repository;

import de.ait.users.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepositoryJDBCImpl implements UserRepositoryInt{
    private final DataSource dataSource; // our data in resources
    private final JdbcTemplate jdbcTemplate; //
    private static RowMapper<User> userRowMapper = (row, rowNumber)->{
        Long id = row.getLong("id");
        String name = row.getString("name");
        String email = row.getString("email");
        String password = row.getString("password");
        return new User(id,name,email, password);
    };
    @Autowired
    public UserRepositoryJDBCImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, userRowMapper);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
           return create(user);
        }else {
           return update(user);
        }
    }
    private User create(User user) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource)
                .usingGeneratedKeyColumns("id")
                .withTableName("t_user");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",user.getName());
        parameters.put("email",user.getEmail());
        parameters.put("password", user.getPassword());

        Long generatedId = jdbcInsert.executeAndReturnKey(parameters).longValue();
        user.setId(generatedId);

        return user;
    }
    private User update(User user) {
        String queryStr = "UPDATE t_user SET name = ?, email = ?, password = ? WHERE id=?";
        int affectedRows = jdbcTemplate.update(queryStr, user.getName(), user.getEmail(), user.getPassword(), user.getId());
        return affectedRows==1 ? user:null;
    }
}
