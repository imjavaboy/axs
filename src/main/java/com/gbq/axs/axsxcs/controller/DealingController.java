package com.gbq.axs.axsxcs.controller;

import com.gbq.axs.axsxcs.pojo.Dealing;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;
import com.gbq.axs.axsxcs.service.DealingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DealingController
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/23 3:13
 */
@Api(tags = "货物模块")
@RestController
@RequestMapping("/dealing")
public class DealingController {
    @Autowired
    private DealingService dealingService;

    @ApiOperation("分页获取所有货物")
    @GetMapping("/getAllDealing")
    public ResPageBean getAllDealing(@RequestParam(defaultValue = "1") Integer currentPage){
        return dealingService.getAllDealingByPage(currentPage);
    }
    @ApiOperation("/获取货物详情")
    @GetMapping("/getDealingById")
    public ResBean getDealingById(@RequestParam("id") Integer id){
        return dealingService.getDealingById(id);
    }
    @ApiOperation("/根据关键词搜索货物")
    @GetMapping("/searchDealing")
    public ResBean searchDealing(String keyword){
        return dealingService.searchDealing(keyword);
    }
}
