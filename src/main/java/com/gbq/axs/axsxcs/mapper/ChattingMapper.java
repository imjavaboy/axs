package com.gbq.axs.axsxcs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gbq.axs.axsxcs.pojo.Chatting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChattingMapper extends BaseMapper<Chatting> {

    List<Chatting> getChatList(Integer uid);

    List<Chatting> getChatListToSomeone(@Param("from") Integer from,@Param("to") Integer to);
}
