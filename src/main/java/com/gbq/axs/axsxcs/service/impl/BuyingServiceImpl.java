package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gbq.axs.axsxcs.mapper.BuyingMapper;
import com.gbq.axs.axsxcs.mapper.CartMapper;
import com.gbq.axs.axsxcs.mapper.ChattingMapper;
import com.gbq.axs.axsxcs.mapper.DealingMapper;
import com.gbq.axs.axsxcs.pojo.*;
import com.gbq.axs.axsxcs.service.BuyingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BuyingServiceImpl
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 11:39
 */
@Service
public class BuyingServiceImpl implements BuyingService {
    @Autowired
    private BuyingMapper buyingMapper;
    @Autowired
    private DealingMapper dealingMapper;
    @Autowired
    private ChattingMapper chattingMapper;
    @Autowired
    private CartMapper cartMapper;
    @Override
    @Transactional
    public ResBean insertBuying(Buying buying) {
        buying.setTime(new Date());
        int insert = buyingMapper.insert(buying);
        dealingMapper.updateStatus(buying.getDealingId());

        cartMapper.delete(new QueryWrapper<Cart>().eq("dealingId",buying.getDealingId())
                .eq("uid",buying.getUid()));
        Chatting chatting = new Chatting();
        chatting.setTime(new Date());
        chatting.setHavUserId(0);
        chatting.setHavUserId(buying.getHavUserId());
        chatting.setBuyUserId(buying.getUid());
        chatting.setWho(0);
        chatting.setContent("您的商品("+buying.getItemName()+")被购买，请及时查看");
        chattingMapper.insert(chatting);
        if (insert > 0){
            return ResBean.success("购买成功");
        }
        return ResBean.error("购买失败");

    }

    @Override
    public ResBean myPurchase(Integer uid) {
      List<Dealing> dealingList = dealingMapper.getMyPurchase(uid);
        return ResBean.success("查询成功",dealingList);
    }
}
