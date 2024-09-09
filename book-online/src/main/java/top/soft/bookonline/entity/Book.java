package top.soft.bookonline.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ycshang
 * @description: 图书实体类
 * @date 2024-09-04 下午2:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
}