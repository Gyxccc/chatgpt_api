package com.gyx.weixin.service;


import com.gyx.weixin.model.entity.UserBehaviorMessageEntity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 受理用户行为接口
 * @create 2023-08-05 17:04
 */
public interface IWeiXinBehaviorService {

    String acceptUserBehavior(UserBehaviorMessageEntity userBehaviorMessageEntity);

}
