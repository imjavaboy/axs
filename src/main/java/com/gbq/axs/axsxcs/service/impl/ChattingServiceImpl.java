package com.gbq.axs.axsxcs.service.impl;

import com.gbq.axs.axsxcs.mapper.ChattingMapper;
import com.gbq.axs.axsxcs.pojo.Chatting;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.service.ChattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName ChattingServiceImpl
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 12:01
 */
@Service
public class ChattingServiceImpl implements ChattingService {
    @Autowired
    private ChattingMapper chattingMapper;
    @Override
    public ResBean insertMag(Chatting chatting) {
        chatting.setTime(new Date());
        chattingMapper.insert(chatting);
        return ResBean.success("发布消息成功");
    }

    @Override
    public ResBean getChatList(Integer uid) {
       List<Chatting> chattings = chattingMapper.getChatList(uid);

        return ResBean.success("查询成功",chattings);
    }

    @Override
    public ResBean getChatListToSomeone(Integer from, Integer to) {
        List<Chatting> chattingList = chattingMapper.getChatListToSomeone(from,to);
        return ResBean.success("查询成功",chattingList);
    }
}
