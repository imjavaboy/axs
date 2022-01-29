package com.gbq.axs.axsxcs.controller;

import com.gbq.axs.axsxcs.pojo.*;
import com.gbq.axs.axsxcs.service.DealingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("/发布二手物品")
    @PostMapping("/insertDealing")
    public ResBean insertDealing(@RequestBody Dealing dealing){
        return dealingService.insertDealing(dealing);
    }
    @ApiOperation("查看收藏状态")
    @GetMapping("/isCollect")
    public ResBean isCollect(Integer uid,Integer did){
        return dealingService.isCollect(uid,did);
    }
    @ApiOperation("收藏")
    @PutMapping("/collect")
    public ResBean collect(@RequestBody Collecting collecting){
//        System.out.println("收藏。。"+collecting);
        return dealingService.collect(collecting);
    }
    @ApiOperation("收藏")
    @DeleteMapping("/collect")
    public ResBean noCollect(@RequestBody Collecting collecting){
//        System.out.println("收藏。。"+collecting);
        return dealingService.noCollect(collecting);

    }
    @ApiOperation("我的收藏列表")
    @GetMapping("/collect")
    public ResPageBean allMyCollect(Integer page,Integer uid){
//        System.out.println("收藏。。"+collecting);
        return dealingService.allMyCollect(page,uid);

    }

    @ApiOperation("店铺货物列表")
    @GetMapping("/shopList")
    public ResPageBean getShopList(Integer curPage,Integer uid){
//        System.out.println("收藏。。"+collecting);
        return dealingService.getShopList(curPage,uid);
    }
    @ApiOperation("是否在购物车")
    @GetMapping("/isInCart")
    public ResBean isInCart(Integer uid,Integer dealingId){
        return dealingService.isInCart(uid,dealingId);
    }
    @ApiOperation("加入购物车")
    @PostMapping("/joinCart")
    public ResBean joinCart(@RequestBody Cart cart){
//        System.out.println(cart);
        return dealingService.joinCart(cart);
//        return null;
    }
    @ApiOperation("移除购物车")
    @DeleteMapping("/outCart/{uid}/{dealingId}")
    public ResBean joinCart(@PathVariable("uid") Integer uid,@PathVariable("dealingId") Integer dealingId){
        return dealingService.outCart(uid,dealingId);
    }
    @ApiOperation("我的购物车")
    @GetMapping("/myCart")
    public ResBean getMyCart( Integer uid){
        return dealingService.getMyCart(uid);
    }


}
