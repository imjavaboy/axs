package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.ResPageBean;

public interface DealingService {
    ResPageBean getAllDealingByPage(Integer currentPage);

    ResBean getDealingById(Integer id);

    ResBean searchDealing(String keyword);
}
