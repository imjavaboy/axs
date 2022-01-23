package com.gbq.axs.axsxcs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Tags
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/23 1:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="tags对象", description="")
@TableName("tags")
public class Tags {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String tagName;
}
