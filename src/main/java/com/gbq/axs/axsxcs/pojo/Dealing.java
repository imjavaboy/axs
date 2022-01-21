package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("dealing")
public class Dealing {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String time;
    private String username;
    private String content;
    private String photo;
    private int type;
    private double price;
    private String exchange;
    private String category;
    private int status;
    private String itemname;
}
