package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("collecting")
public class Collecting {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer uid;
    private Integer dealingId;
}
