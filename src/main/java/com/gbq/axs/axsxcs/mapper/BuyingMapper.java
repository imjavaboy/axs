package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Buying;
import org.springframework.stereotype.Repository;

/**
 * @ClassName BuyingMapper
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 11:39
 */
@Repository
public interface BuyingMapper extends BaseMapper<Buying> {
    Integer updateStatus(Integer bid, Integer status);
}
