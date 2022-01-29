package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("chatting")
public class Chatting {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer buyUserId;
    private Integer havUserId;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date time;
    private Integer who;
    private Integer unread;
    @TableField(exist = false)
    private String buyHeadImg;
    @TableField(exist = false)
    private String buyUsername;
    @TableField(exist = false)
    private Account sendAccount;
    @TableField(exist = false)
    private Account toAccount;
}
