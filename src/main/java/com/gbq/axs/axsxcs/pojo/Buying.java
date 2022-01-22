package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("buying")
public class Buying {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String time;
    private Integer uid;
    private long dealingId;
    private String status;
}
