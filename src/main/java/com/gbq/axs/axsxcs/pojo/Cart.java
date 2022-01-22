package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@TableName("cart")
public class Cart {
    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private LocalDate time;
    private String uid;
    private long dealingId;
}
