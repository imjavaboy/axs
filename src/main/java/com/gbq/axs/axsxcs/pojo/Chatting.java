package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@TableName("chatting")
public class Chatting {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer buyUserId;
    private Integer havUserId;
    private String content;
    private LocalDate time;
    private String who;
    private Integer unread;
}
