package top.soft.brandlist.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ycshang
 * @description: 品牌实体类
 * @date 2024-10-12 下午3:24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    /**
     * 序号
     */
    private Integer id;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 品牌名
     */
    private String brandName;
    /**
     * 排序
     */
    private Integer ordered;

    /**
     * 描述
     */
    private String description;
}
