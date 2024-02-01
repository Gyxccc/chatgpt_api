package com.gyx.openai.service;

import com.gyx.openai.model.aggregates.ChatProcessAggregate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

/**
 * @author: GYX
 * @program: chatgpt-data
 * @description:
 * @create: 2024-01-05 16:44
 **/

public interface IChatService {

    ResponseBodyEmitter completions(ResponseBodyEmitter emitter, ChatProcessAggregate processAggregate);

}
