package com.ai.demo.bean;

import fan.aiflow.client.open.anotation.AField;
import fan.aiflow.client.open.anotation.AServiceReqField;
import fan.aiflow.client.open.bean.entity.AEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Sky
 * @since 2025/05/24
 **/
@Data
public class SupplierParam implements AEntity {
    @AServiceReqField(doc = "供应商编码")
    private List<String> supplierCodeList;

}
