package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.bean.enums.ValuePathType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jixiaoliang
 * @since 2025/05/27
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImgInfo {

    @AField(name = "mainImg",valuePath = ValuePathType.URL_NAME,doc = "图片名")
    private String name;

    @AField(name = "mainImg",valuePath = ValuePathType.URL_PATH,doc = "图片地址")
    private String url;
}
