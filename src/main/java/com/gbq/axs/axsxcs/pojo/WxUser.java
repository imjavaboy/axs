package com.gbq.axs.axsxcs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName WxUser
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/21 0:23
 */
@Data
@AllArgsConstructor
public class WxUser {
    private String code;
    private String nickName;
    private String city;
    private String avatarUrl;
    private Integer gender;
}
