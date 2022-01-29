package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.Chatting;
import com.gbq.axs.axsxcs.pojo.ResBean;

/**
 * @ClassName ChattingService
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 12:01
 */
public interface ChattingService {
    ResBean insertMag(Chatting chatting);

    ResBean getChatList(Integer uid);

    ResBean getChatListToSomeone(Integer from, Integer to);
}
