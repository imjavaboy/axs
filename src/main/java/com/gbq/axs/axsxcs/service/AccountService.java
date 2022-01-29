package com.gbq.axs.axsxcs.service;

import com.gbq.axs.axsxcs.pojo.Account;
import com.gbq.axs.axsxcs.pojo.ResBean;

public interface AccountService {
    Account selectByOpenId(String openid);

    Integer insertOne(Account account);

    ResBean getAccount(Integer id);

    ResBean loginByUser(Account wxUser);
}
