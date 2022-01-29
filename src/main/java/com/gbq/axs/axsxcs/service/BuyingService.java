package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.Buying;
import com.gbq.axs.axsxcs.pojo.ResBean;

/**
 * @ClassName BuyingService
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/26 11:38
 */
public interface BuyingService {
    ResBean insertBuying(Buying buying);

    ResBean myPurchase(Integer uid);
}
