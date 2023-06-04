package com.company.furniturefactory.dao;

import com.company.furniturefactory.config.security.SessionUser;
import com.company.furniturefactory.domain.Product;
import com.company.furniturefactory.dto.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductDAO {

    private final String GET_ALL_SQL = """
            SELECT P.id,
                   P.name_uz,
                   P.name_ru,
                   P.category_id,
                   P.image_id,
                   I.file_path image_path,
                   C.name_uz category_name
            FROM Product P
                     LEFT JOIN Category C ON P.category_id = C.id
                     LEFT JOIN Image I ON P.image_id = I.id
            where P.deleted=0
            """;
    private final JdbcTemplate jdbcTemplate;
    private final SessionUser sessionUser;

    public List<ProductResponse> getAll() {
        return jdbcTemplate.query(
                GET_ALL_SQL, (rs, rowNum) -> {
                    ProductResponse productresponse = new ProductResponse();
                    productresponse.setId(rs.getLong("id"));
                    productresponse.setNameUz(rs.getString("name_uz"));
                    productresponse.setNameRu(rs.getString("name_ru"));
                    productresponse.setCategoryId(rs.getLong("category_id"));
                    productresponse.setImageId(rs.getLong("image_id"));
                    String imagePath = rs.getString("image_path");
                    if(imagePath!=null){
                        imagePath = "../" + imagePath.substring(imagePath.indexOf("resources")); //vaqtincha
                        imagePath = imagePath.replace("\\", "/");  //vaqtincha
                    }
                    productresponse.setImagePath(imagePath);
                    productresponse.setCategoryName(rs.getString("category_name"));
                    return productresponse;
                }
        );
    }

    public void save(Product product) {
        jdbcTemplate.update("insert into main_user.product(name_uz,name_ru,category_id,image_id, created_by) values(?,?,?,?,?)",
                product.getNameUz(),
                product.getNameRu(),
                product.getCategoryId(),
                product.getImageId(),
                sessionUser.getId()
        );
    }

    public Long getImageId(Long productId) {
        return jdbcTemplate.queryForObject("select image_id from main_user.product where id = ? and deleted = 0",Long.class,productId);
    }

    public void update(Product product) {
        String sql = "UPDATE main_user.product SET name_uz = ?, name_ru = ?, category_id = ?, image_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getNameUz(), product.getNameRu(), product.getCategoryId(), product.getImageId(), product.getId());
    }

    public void delete(Long id) {
        String sql = "UPDATE main_user.product SET deleted=1, deleted_by=?, deleted_at=? WHERE id=?";
        jdbcTemplate.update(sql, sessionUser.getId(), LocalDateTime.now(), id);
    }
}
