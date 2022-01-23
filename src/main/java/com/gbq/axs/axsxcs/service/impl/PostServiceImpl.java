package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.mapper.PostMapper;
import com.gbq.axs.axsxcs.pojo.Posting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;
import com.gbq.axs.axsxcs.service.PostService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public ResPageBean getAllPosting(Integer currentPage) {
        //开启分页
        Page<Posting> page = new Page<>(currentPage, 10);
        IPage<Posting> postingIPage = postMapper.getAllPosting(page);
        System.out.println("及技术计算机技术"+postingIPage);
        ResPageBean resPageBean = new ResPageBean(postingIPage.getTotal(), postingIPage.getRecords());
        return resPageBean;
    }

    /*获取帖子详情*/
    @Override
    public ResBean getPostingById(Integer id) {

        Posting ps = postMapper.getPostingById(id);
        return ResBean.success("查询成功",ps);
    }
}
