package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("comments")
public class Comments {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String username;
    private long posting;
    private String content;
    private String time;
}
