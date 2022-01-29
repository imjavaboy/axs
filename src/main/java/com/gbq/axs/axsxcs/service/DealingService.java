package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.*;

public interface DealingService {
    ResPageBean getAllDealingByPage(Integer currentPage);

    ResBean getDealingById(Integer id);

    ResBean searchDealing(String keyword);

    ResBean insertDealing(Dealing dealing);

    ResBean isCollect(Integer uid, Integer did);

    ResBean collect(Collecting collecting);

    ResBean noCollect(Collecting collecting);

    ResPageBean allMyCollect(Integer page,Integer uid);

    ResPageBean getShopList(Integer curPage,Integer uid);

    ResBean isInCart(Integer uid, Integer dealingId);

    ResBean joinCart(Cart cart);

    ResBean outCart(Integer uid, Integer dealingId);

    ResBean getMyCart(Integer uid);

    ResBean getMySell(Integer uid);


    ResBean editStatus(Integer bid, Integer status,Integer did);
}
