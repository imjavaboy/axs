package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@TableName("comments")
public class Comments {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String uid;
    private long postingId;
    private String content;
    private LocalDate time;
}
