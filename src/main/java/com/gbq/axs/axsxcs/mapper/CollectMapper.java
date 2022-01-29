package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Collecting;
import com.gbq.axs.axsxcs.pojo.Dealing;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CollectMapper
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 12:36
 */
@Repository
public interface CollectMapper extends BaseMapper<Collecting> {

    IPage<Dealing> selectAllCollect(Page<Dealing> pageO, Integer uid);


}
