package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.mapper.DealingMapper;
import com.gbq.axs.axsxcs.pojo.Dealing;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;
import com.gbq.axs.axsxcs.service.DealingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DealingServideImpl
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/23 3:16
 */
@Service
public class DealingServiceImpl implements DealingService {
    @Autowired
    private DealingMapper dealingMapper;
    @Override
    public ResPageBean getAllDealingByPage(Integer currentPage) {
        //开启分页
        Page<Dealing> page = new Page<>(currentPage, 10);
        IPage<Dealing> postingIPage = dealingMapper.getAllDealing(page);
        ResPageBean resPageBean = new ResPageBean(postingIPage.getTotal(), postingIPage.getRecords());
        return resPageBean;
    }

    @Override
    public ResBean getDealingById(Integer id) {
        Dealing dealing = dealingMapper.getDealingById(id);
        return ResBean.success("查询成功",dealing);
    }

    @Override
    public ResBean searchDealing(String keyword) {
        List<Dealing> itemName = dealingMapper.selectList(new QueryWrapper<Dealing>().like("itemName",keyword));

        return ResBean.success("查询成功",itemName);
    }
}
