package com.gyx.openai.model.aggregates;


import com.gyx.enums.ChatGLMModel;
import com.gyx.openai.model.entity.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: GYX
 * @program: chatgpt-data
 * @description:
 * @create: 2024-01-05 16:44
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatProcessAggregate {

    /** 验证信息 */
    private String token;
    /** 默认模型 */
    private String model = ChatGLMModel.CHATGLM_6B_SSE.getCode();
    /** 问题描述 */
    private List<MessageEntity> messages;

}
