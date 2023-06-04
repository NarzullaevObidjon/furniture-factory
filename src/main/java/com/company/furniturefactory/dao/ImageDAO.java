package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
@RequiredArgsConstructor
public class ImageDAO {

    private String INSERT_SQL = "insert into main_user.image(original_file_name,generated_file_name,file_path,mime_type,extension,file_size,created_by) values(?,?,?,?,?,?,?)";
    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;
    private final DataSource dataSource;

    public Long save(Image image)  {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL,new String[]{"id"});
            preparedStatement.setString(1, image.getOriginalFileName());
            preparedStatement.setString(2, image.getGeneratedFileName());
            preparedStatement.setString(3, image.getFilePath());
            preparedStatement.setString(4, image.getMimeType());
            preparedStatement.setString(5, image.getExtension());
            preparedStatement.setLong(6, image.getSize());
            preparedStatement.setLong(7, sessionUser.getId());

            int res = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            Long generatedId =null;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);
            }
            return generatedId;
        }catch (SQLException ignored){
            return null;
        }
    }
}
