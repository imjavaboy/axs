package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("posting")
public class Posting implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date time;
    private Integer uid;
    @ApiModelProperty("帖子内容")
    private String content;
    @ApiModelProperty("帖子照片")
    private String photo;

    @ApiModelProperty("发帖人")
    private String username;
    @ApiModelProperty("发帖人头像")
    private String headimg;

    @ApiModelProperty("点赞数")
    private Integer likesNum;

    @ApiModelProperty("评论数")
    private Integer commentNum;

    @ApiModelProperty("所有的标签")
    @TableField(exist = false)
    private List<Tags> tags;

    @ApiModelProperty("所有的评论")
    @TableField(exist = false)
    private List<Comments> comments;

    @ApiModelProperty("所有点赞人")
    @TableField(exist = false)
    private List<Account> likeAccounts;

    @TableField(exist = false)
    private Integer tagsId;

}
