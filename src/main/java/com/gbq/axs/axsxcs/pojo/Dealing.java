package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("dealing")
public class Dealing {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date time;
    private Integer uid;
    private String content;
    private String photo;
    private Integer type;
    private double price;
    private String exchange;
    private String category;
    private Integer status;
    private String itemName;

    @ApiModelProperty("拥有者")
    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String headimg;
    @TableField(exist = false)
    private Integer buyingStatus;
    @TableField(exist = false)
    private Integer bid;
}
