package com.gbq.axs.axsxcs.controller;

import com.gbq.axs.axsxcs.pojo.Buying;
import com.gbq.axs.axsxcs.pojo.Chatting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.service.BuyingService;
import com.gbq.axs.axsxcs.service.DealingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @ClassName BuyingController
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 11:35
 */
@Api(tags="购买模块")
@RestController
@RequestMapping("/buying")
public class BuyingController {
    @Autowired
    private BuyingService buyingService;
    @Autowired
    private DealingService dealingService;

    @ApiOperation("添加购买记录")
    @PostMapping("/insertBuying")
    public ResBean insertBuying(@RequestBody Buying buying){
//        System.out.println(buying+"hdshshahss");


        return buyingService.insertBuying(buying);
    }
    @ApiOperation("我购买的")
    @GetMapping("/myPurchase")
    public ResBean myPurchase(Integer uid){
        return buyingService.myPurchase(uid);
    }
    @ApiOperation("我的出售")
    @GetMapping("/mySell")
    public ResBean getMySell(Integer uid){
        return dealingService.getMySell(uid);
    }
    @ApiOperation("修改购买状态")
    @PutMapping("/editStatus")
    public ResBean editStatus(@RequestBody Buying buying){
        Integer bid = buying.getId();
        Integer status = buying.getStatus();
        Integer did = buying.getDealingId();
//        System.out.println(bid+";;;;;;;;"+status+";;;;;"+did);
        return dealingService.editStatus(bid,status,did);
    }
}
