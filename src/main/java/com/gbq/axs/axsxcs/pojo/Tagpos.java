package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Tagpos
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/23 1:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="tags对象", description="")
@TableName("tagpos")
public class Tagpos {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer pid;
    private Integer tid;
}
