package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@TableName("dealing")
public class Dealing {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Date time;
    private Integer uid;
    private String content;
    private String photo;
    private Integer type;
    private double price;
    private String exchange;
    private String category;
    private Integer status;
    private String itemName;
}
