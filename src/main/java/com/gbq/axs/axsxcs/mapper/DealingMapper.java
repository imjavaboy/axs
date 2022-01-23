package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Dealing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealingMapper extends BaseMapper<Dealing> {
    IPage<Dealing> getAllDealing(Page<Dealing> page);

    Dealing getDealingById(Integer id);

    List<Dealing> searchDealing(String keyword);
}
