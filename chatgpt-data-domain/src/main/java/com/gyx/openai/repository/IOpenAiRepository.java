package com.gyx.openai.repository;

import com.gyx.openai.model.entity.UserAccountEntity;

/**
 * @author Gyx
 * @description: TODO
 * @date 2024/2/4 22:05
 */

public interface IOpenAiRepository {
    UserAccountEntity queryUserAccount(String openid);

    int subAccountQuota(String openid);
}
