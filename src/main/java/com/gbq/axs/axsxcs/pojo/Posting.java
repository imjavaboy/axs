package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import sun.util.resources.LocaleData;

import java.util.List;

@Data
@AllArgsConstructor
@TableName("posting")
public class Posting {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private LocaleData time;
    private Integer uid;
    private String content;
    private String photo;

    private List<Likes> likes;

    private List<StringBuffer> tags;
    private Integer likesNum;
}
