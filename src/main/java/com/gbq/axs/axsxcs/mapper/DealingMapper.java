package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.pojo.Dealing;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealingMapper extends BaseMapper<Dealing> {
    IPage<Dealing> getAllDealing(Page<Dealing> page);

    Dealing getDealingById(Integer id);

    Integer updateStatus(Integer did);

    IPage<Dealing> getShopList(Page<Dealing> pageO, Integer uid);

    List<Dealing> getMycart(Integer uid);

    List<Dealing> getMyPurchase(Integer uid);

    List<Dealing> getMySell(Integer uid);

    Integer updateStus(Integer bid);
}
