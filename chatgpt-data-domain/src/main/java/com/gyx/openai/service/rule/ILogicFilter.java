package com.gyx.openai.service.rule;

import com.gyx.openai.model.aggregates.ChatProcessAggregate;
import com.gyx.openai.model.entity.RuleLogicEntity;

/**
 * @author Gyx
 * @description: TODO
 * @date 2024/2/1 22:10
 */
public interface ILogicFilter<T> {
    RuleLogicEntity<ChatProcessAggregate> filter(ChatProcessAggregate chatProcess, T data) throws Exception;
}
