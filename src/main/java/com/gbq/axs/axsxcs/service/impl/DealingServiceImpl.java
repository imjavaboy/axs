package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gbq.axs.axsxcs.mapper.BuyingMapper;
import com.gbq.axs.axsxcs.mapper.CartMapper;
import com.gbq.axs.axsxcs.mapper.CollectMapper;
import com.gbq.axs.axsxcs.mapper.DealingMapper;
import com.gbq.axs.axsxcs.pojo.*;

import com.gbq.axs.axsxcs.service.DealingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
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
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private BuyingMapper buyingMapper;
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

    @Override
    public ResBean insertDealing(Dealing dealing) {
        dealing.setTime(new Date());
        dealingMapper.insert(dealing);
        return ResBean.success("发布成功",dealing);
    }

    @Override
    public ResBean isCollect(Integer uid, Integer did) {
        List<Collecting> collectingList = collectMapper.selectList(new QueryWrapper<Collecting>()
                .eq("uid", uid)
                .eq("dealingId", did)
        );
        HashMap<Object, Object> map = new HashMap<>();

        if (collectingList.size() > 0){
            map.put("isCollect",true);
            return ResBean.success("查询成功",map);
        }
        map.put("isCollect",false);
        return ResBean.success("查询成功",map);
    }

    @Override
    public ResBean collect(Collecting collecting) {
        collectMapper.insert(collecting);
        return ResBean.success("收藏成功");
    }

    @Override
    public ResBean noCollect(Collecting collecting) {
        collectMapper.delete(new QueryWrapper<Collecting>()
                .eq("uid",collecting.getUid())
                .eq("dealingId",collecting.getDealingId()));
        return ResBean.success("取消成功");
    }

    @Override
    public ResPageBean allMyCollect(Integer page,Integer uid) {
        Page<Dealing> pageO = new Page<>(page,10);
        IPage<Dealing> dealings =  collectMapper.selectAllCollect(pageO,uid);
        ResPageBean resPageBean = new ResPageBean(dealings.getTotal(), dealings.getRecords());
        return resPageBean;
    }

    @Override
    public ResPageBean getShopList(Integer curPage,Integer uid) {
        Page<Dealing> pageO = new Page<>(curPage,10);
        IPage<Dealing> dealings = dealingMapper.getShopList(pageO,uid);
        ResPageBean resPageBean = new ResPageBean(dealings.getTotal(), dealings.getRecords());
        return resPageBean;
    }

    @Override
    public ResBean isInCart(Integer uid, Integer dealingId) {
        Cart cart = cartMapper.selectOne(new QueryWrapper<Cart>().eq("uid", uid).eq("dealingId", dealingId));
        HashMap<Object, Object> map = new HashMap<>();
        if (cart != null){
            map.put("isInCart",true);
            return ResBean.success("查询成功",map);
        }
        map.put("isInCart",false);
        return ResBean.success("查询成功",map);
    }

    @Override
    public ResBean joinCart(Cart cart) {
        cart.setTime(new Date());
        cartMapper.insert(cart);
        return ResBean.success("加入购物车成功");
    }

    @Override
    public ResBean outCart(Integer uid, Integer dealingId) {
        cartMapper.delete(new QueryWrapper<Cart>().eq("uid",uid).eq("dealingId",dealingId));
        return ResBean.success("移除购物车成功");
    }

    @Override
    public ResBean getMyCart(Integer uid) {
        List<Dealing> dealingList = dealingMapper.getMycart(uid);
        return ResBean.success("查寻成功,",dealingList);
    }

    @Override
    public ResBean getMySell(Integer uid) {
        List<Dealing> dealingList = dealingMapper.getMySell(uid);
        return ResBean.success("查询成功",dealingList);
    }

    @Override
    @Transactional
    public ResBean editStatus(Integer bid, Integer status,Integer did) {
        if (status == 2){
            dealingMapper.updateStus(did);
        }
        Integer o = buyingMapper.updateStatus(bid,status);
       if (o > 0){
           return ResBean.success("更新状态成功");
       }
       return ResBean.error("更新状态失败");
    }


}
