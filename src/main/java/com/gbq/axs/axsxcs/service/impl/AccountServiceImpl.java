package com.gbq.axs.axsxcs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gbq.axs.axsxcs.mapper.AccountMapper;
import com.gbq.axs.axsxcs.pojo.Account;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/20 20:43
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /*查找是否有openid的用户*/
    @Override
    public Account selectByOpenId(String openid) {
       return accountMapper.selectOne(new QueryWrapper<Account>().eq("openId", openid));


    }

    /*插入用户*/
    @Override
    public Integer insertOne(Account account) {
        return accountMapper.insert(account);
    }

    @Override
    public ResBean getAccount(Integer id) {
        Account account = accountMapper.selectOne(new QueryWrapper<Account>().eq("id", id));
        return ResBean.success("查询成功",account);
    }

    /*修改用户*/
    @Override
    public ResBean editAccount(Account account) {
        accountMapper.editAccount(account);
        Account editAccount = accountMapper.getEditAccount(account.getId());
        return ResBean.success("修改成功",editAccount);
    }
}
