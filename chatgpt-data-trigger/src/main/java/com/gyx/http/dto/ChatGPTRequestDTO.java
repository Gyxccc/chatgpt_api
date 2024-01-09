package com.gyx.http.dto;

import com.gyx.enums.ChatGLMModel;
import com.gyx.openai.model.entity.MessageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description
 * @create 2023-07-22 21:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatGPTRequestDTO {

    /** 默认模型 */
    private String model = ChatGLMModel.CHATGLM_6B_SSE.getCode();

    /** 问题描述 */
    private List<MessageEntity> messages;

}
