package com.gbq.axs.axsxcs.controller;

import com.gbq.axs.axsxcs.pojo.Chatting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.service.ChattingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ChatingController
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 12:00
 */
@RestController
@Api(tags = "信息模块")
@RequestMapping("/chatting")
public class ChatingController {
    @Autowired
    private ChattingService chattingService;

    @ApiOperation("插入信息")
    @PostMapping("/insertMsg")
    public ResBean insertMsg(@RequestBody Chatting chatting){
       return chattingService.insertMag(chatting);
    }


    @ApiOperation("消息列表")
    @GetMapping("/chatList")
    public ResBean getChatList(Integer uid){
        return chattingService.getChatList(uid);
    }

    @ApiOperation("和某人的消息列表")
    @GetMapping("/chat/somebody")
    public ResBean getChatListToSomeone(Integer from,Integer to){
        return chattingService.getChatListToSomeone(from,to);
    }

}
