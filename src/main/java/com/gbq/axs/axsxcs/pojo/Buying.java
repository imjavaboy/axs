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
    private long id;
    private String ftime;
    private String time;
    private String username;
    private long dealing;
    private String status;
}
