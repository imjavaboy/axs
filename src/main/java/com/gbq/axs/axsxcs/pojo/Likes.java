package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.util.resources.LocaleData;

@Data
@AllArgsConstructor
@TableName("likes")
public class Likes {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String uid;
    private int postingId;
    private LocaleData time;
}
