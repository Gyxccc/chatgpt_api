package com.gyx.repository;

import com.gyx.dao.IUserAccountDAO;
import com.gyx.openai.model.entity.UserAccountEntity;
import com.gyx.openai.model.valobj.UserAccountStatusVO;
import com.gyx.openai.repository.IOpenAiRepository;
import com.gyx.po.UserAccountPO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;


/**
 * @author Gyx
 * @description: TODO
 * @date 2024/2/4 22:10
 */
@Repository
public class OpenAiRepository implements IOpenAiRepository {

    @Resource
    private IUserAccountDAO userAccountDAO;
    @Override
    public UserAccountEntity queryUserAccount(String openid) {
        UserAccountPO userAccountPO = userAccountDAO.queryUserAccount(openid);
        if(null == userAccountPO) return null;
        UserAccountEntity userAccountEntity = new UserAccountEntity();
        userAccountEntity.setOpenid(userAccountPO.getOpenid());
        userAccountEntity.setTotalQuota(userAccountPO.getTotalQuota());
        userAccountEntity.setSurplusQuota(userAccountPO.getSurplusQuota());
        userAccountEntity.setUserAccountStatusVO(UserAccountStatusVO.get(userAccountPO.getStatus()));
        userAccountEntity.genModelTypes(userAccountPO.getModelTypes());
        return userAccountEntity;
    }

    @Override
    public int subAccountQuota(String openid) {
        return userAccountDAO.subAccountQuota(openid);
    }

}
