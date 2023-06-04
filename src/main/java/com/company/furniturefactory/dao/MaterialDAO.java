package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Material;
import com.company.furniturefactory.dto.material.MaterialResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MaterialDAO {
    private final String GET_ALL_SQL = """
            SELECT M.id,
                   M.code,
                   M.norma,
                   M.name_uz,
                   M.name_ru,
                   M.measurement_id,
                   M.image_id,
                   I.file_path image_path,
                   MS.name_uz measurement_name
            FROM Material M
                     LEFT JOIN Measurement MS ON M.measurement_id = MS.id
                     LEFT JOIN Image I ON M.image_id = I.id
            where M.deleted=0
            """;
    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<MaterialResponse> getAll() {
        return jdbcTemplate.query(
                GET_ALL_SQL, (rs, rowNum) -> {
                    MaterialResponse materialResponse = new MaterialResponse();
                    materialResponse.setId(rs.getLong("id"));
                    materialResponse.setCode(rs.getString("code"));
                    materialResponse.setNameUz(rs.getString("name_uz"));
                    materialResponse.setNameRu(rs.getString("name_ru"));
                    materialResponse.setNorma(rs.getInt("norma"));
                    materialResponse.setMeasurementId(rs.getLong("measurement_id"));
                    materialResponse.setImageId(rs.getLong("image_id"));
                    String imagePath = rs.getString("image_path");
                    if(imagePath!=null){
                        imagePath = "../" + imagePath.substring(imagePath.indexOf("resources")); //vaqtincha
                        imagePath = imagePath.replace("\\", "/");  //vaqtincha
                    }
                    materialResponse.setImagePath(imagePath);
                    materialResponse.setMeasurementName(rs.getString("measurement_name"));
                    return materialResponse;
                }
        );
    }

    public void save(Material material) {
        jdbcTemplate.update("insert into main_user.material(code,norma,name_uz,name_ru,measurement_id,image_id, created_by) values(?,?,?,?,?,?,?)",
                material.getCode(),
                material.getNorma(),
                material.getNameUz(),
                material.getNameRu(),
                material.getMeasurementId(),
                material.getImageId(),
                sessionUser.getId()
        );
    }

    public Long getImageId(Long materialId) {
       return jdbcTemplate.queryForObject("select image_id from main_user.material where id = ?",Long.class,materialId);
    }

    public void update(Material material) {
        String sql = "UPDATE main_user.material SET code = ?, norma = ?, name_uz = ?, name_ru = ?, measurement_id = ?, image_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, material.getCode(), material.getNorma(), material.getNameUz(), material.getNameRu(), material.getMeasurementId(), material.getImageId(), material.getId());
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.material SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql, sessionUser.getId(), LocalDateTime.now(), id);
    }
}
