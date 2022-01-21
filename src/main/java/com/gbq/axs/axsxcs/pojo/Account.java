package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("account")
@ApiModel(value="Account对象", description="")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "昵称")
    private String username;
    @ApiModelProperty(value = "性别")
    private int sex;
    @ApiModelProperty(value = "出生日期")
    private String birthday;
    @ApiModelProperty(value = "头像")
    private String headimg;
    @ApiModelProperty(value = "学院专业")
    private String department;
    @ApiModelProperty(value = "住址")
    private String address;
    @ApiModelProperty(value = "openID")
    private String openId;
    @ApiModelProperty(value = "sessionKey")
    private String sessionKey;
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "创建时间")
    private LocalDate creteTime;

}
