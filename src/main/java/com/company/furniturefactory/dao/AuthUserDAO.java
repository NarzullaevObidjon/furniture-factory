package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.AuthUser;
import com.company.furniturefactory.dto.product.ProductResponse;
import com.company.furniturefactory.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthUserDAO {

    private final String GET_ALL_SQL = """
            SELECT U.id,
                   U.phone,
                   U.first_name,
                   U.last_name,
                   U.image_id image_id,
                   I.file_path image_path,
                   U.role role
            FROM AuthUser U
                     LEFT JOIN Image I ON U.image_id = I.id
            where U.deleted=0
            """;

    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public Optional<AuthUser> findByUsername(String username) {
        AuthUser authUser = jdbcTemplate.queryForObject("select * from main_user.authuser where username=? and deleted=0",
                new BeanPropertyRowMapper<>(AuthUser.class), username);
        return Optional.of(authUser);
    }

    public List<UserResponse> getAll() {
        return jdbcTemplate.query(
                GET_ALL_SQL, (rs, rowNum) -> {
                    UserResponse userResponse = new UserResponse();
                    userResponse.setId(rs.getLong("id"));
                    userResponse.setFirstName(rs.getString("first_name"));
                    userResponse.setLastName(rs.getString("last_name"));
                    userResponse.setPhone(rs.getString("phone"));
                    userResponse.setRole(rs.getString("role"));
                    userResponse.setImageId(rs.getLong("image_id"));
                    String imagePath = rs.getString("image_path");
                    if(imagePath!=null){
                        imagePath = "../" + imagePath.substring(imagePath.indexOf("resources")); //vaqtincha
                        imagePath = imagePath.replace("\\", "/");  //vaqtincha
                    }
                    userResponse.setImagePath(imagePath);
                    return userResponse;
                }
        );
    }

    public void save(AuthUser user) {
        jdbcTemplate.update("insert into main_user.authuser(first_name, last_name, phone, username, password, role, image_id, created_by) values(?,?,?,?,?,?,?,?)",
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getUsername(),
                user.getPassword(),
                user.getRole().toString(),
                user.getImageId(),
                sessionUser.getId()
        );
    }

    public Long getImageId(Long id) {
        return jdbcTemplate.queryForObject("select image_id from main_user.authuser where id = ? and deleted = 0",Long.class,id);
    }

    public void update(AuthUser user) {
        String sql = "UPDATE main_user.authuser SET first_name = ?, last_name = ?, phone = ?, role=?, image_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getPhone(), user.getRole().toString(),user.getImageId(), user.getId());

    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.authuser SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql, sessionUser.getId(), LocalDateTime.now(), id);
    }
}
