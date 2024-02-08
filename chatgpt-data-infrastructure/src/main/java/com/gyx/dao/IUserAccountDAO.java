package com.gyx.dao;

import com.gyx.po.UserAccountPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Gyx
 * @description: TODO
 * @date 2024/2/4 21:47
 */
@Mapper
public interface IUserAccountDAO {

    UserAccountPO queryUserAccount(String openid);
    int subAccountQuota(String openid);

}
