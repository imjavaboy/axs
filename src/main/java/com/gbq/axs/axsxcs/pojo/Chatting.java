package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("chatting")
public class Chatting {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String user1;
    private String user2;
    private String content;
    private String time;
    private String who;
    private int unread;
}
