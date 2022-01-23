package com.gbq.axs.axsxcs.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName ResPageBean
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/22 12:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResPageBean {
    //总条数
    private Integer total;
    //数据list
    private List<?> data;
}
