package com.gyx.openai.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Gyx
 * @description: TODO
 * @date 2024/2/1 22:20
 */

@Getter
@AllArgsConstructor
public enum LogicCheckTypeVO {
    SUCCESS("0000", "校验通过"),
    REFUSE("0001","校验拒绝"),
            ;

    private final String code;
    private final String info;
}
