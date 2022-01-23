package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.util.resources.LocaleData;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@TableName("likes")
public class Likes {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer postingId;
    private Date time;

    @ApiModelProperty("点赞人")
    @TableField(exist = false)
    private List<Account> account;
}
