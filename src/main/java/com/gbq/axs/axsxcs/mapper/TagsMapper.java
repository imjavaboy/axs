package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Tags;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagsMapper extends BaseMapper<Tags> {
    List<Tags> selctAll();
}
