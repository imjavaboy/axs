package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Tagpos;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsPosMapper extends BaseMapper<Tagpos> {
   Integer deleteByIds(Integer pid);
}
