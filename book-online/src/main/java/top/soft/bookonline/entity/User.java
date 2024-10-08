package top.soft.bookonline.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author ycshang
 * @description: 用户实体类
 * @date 2024-09-19 上午9:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;

    private String account;

    private String password;

    private String nickname;

    private String avatar;

    private String address;

    private LocalDateTime createTime;
}