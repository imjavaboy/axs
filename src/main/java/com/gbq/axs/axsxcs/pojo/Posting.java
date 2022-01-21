package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("posting")
public class Posting {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String time;
    private String username;
    private String content;
    private String photo;
    private int likes;
    private int comments;
    private String tag;
}
