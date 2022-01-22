package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.util.resources.LocaleData;

@Data
@AllArgsConstructor
@TableName("posting")
public class Posting {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private LocaleData time;
    private String uid;
    private String content;
    private String photo;
    private String tagId;
}
