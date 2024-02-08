package com.gyx.http;

import cn.bugstack.chatglm.model.ChatCompletionRequest;
import cn.bugstack.chatglm.model.Model;
import cn.bugstack.chatglm.model.Role;
import cn.bugstack.chatglm.session.Configuration;
import cn.bugstack.chatglm.session.OpenAiSession;
import cn.bugstack.chatglm.session.OpenAiSessionFactory;
import cn.bugstack.chatglm.session.defaults.DefaultOpenAiSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author: GYX
 * @program: chatgpt-data
 * @description:
 * @create: 2024-01-08 11:15
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    private final OpenAiSession openAiSession;


    public TestController() {
        // 1. 配置文件；智谱Ai申请你的 ApiSecretKey 教程；https://bugstack.cn/md/project/chatgpt/sdk/chatglm-sdk-java.html
        Configuration configuration = new Configuration();
        configuration.setApiHost("https://open.bigmodel.cn/");
        configuration.setApiSecretKey("0dc1c9beb3241e6326358bc8078f6e97.Kc7WotuYSEaoUqV8");
        // 2. 会话工厂
        OpenAiSessionFactory factory = new DefaultOpenAiSessionFactory(configuration);
        // 3. 开启会话
        this.openAiSession = factory.openSession();
        logger.info("开始 openAiSession");
    }
    @RequestMapping("/chat")
    public String chat(){
        doChatGPTTask("你好");
        return "success";
    }

    public void doChatGPTTask(String content) {
        // 入参；模型、请求信息；记得更新最新版 ChatGLM-SDK-Java
        ChatCompletionRequest request = new ChatCompletionRequest();
        request.setModel(Model.CHATGLM_LITE); // chatGLM_6b_SSE、chatglm_lite、chatglm_lite_32k、chatglm_std、chatglm_pro
        request.setPrompt(new ArrayList<ChatCompletionRequest.Prompt>() {
            private static final long serialVersionUID = -7988151926241837899L;
            {
                add(ChatCompletionRequest.Prompt.builder()
                        .role(Role.user.getCode())
                        .content(content)
                        .build());
            }
        });
        // 同步获取结果
        try {
            CompletableFuture<String> future = openAiSession.completions(request);
            System.out.println(future);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
