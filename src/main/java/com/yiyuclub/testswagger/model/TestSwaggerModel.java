package com.yiyuclub.testswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ApiModel 使用
 * @ApiModelProperty 使用
 */
@Data
@ApiModel
public class TestSwaggerModel {

    @ApiModelProperty(value = "姓名",hidden = false)
    private String name;

    @ApiModelProperty(value = "年龄",hidden = false)
    private Integer age;
}
