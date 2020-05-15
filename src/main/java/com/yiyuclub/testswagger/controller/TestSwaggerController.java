package com.yiyuclub.testswagger.controller;

import com.yiyuclub.testswagger.model.TestSwaggerModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * @Api 使用
 * @ApiResponses 使用
 * @ApiResponse 使用
 */
@Api(tags = "swagger api测试", value = "测试类")
@ApiResponses({
        @ApiResponse(code = 400, message = "业务逻辑异常", response = TestSwaggerController.class),
        @ApiResponse(code = 404, message = "找不到接口", response = TestSwaggerController.class),
        @ApiResponse(code = 500, message = "服务器内部错误", response = TestSwaggerController.class)
})
public class TestSwaggerController {

    /**
     * @ApiOperation使用
     */
    @GetMapping("test1")
    @ApiOperation(value = "测试1", tags = "测试1备注")
    public void test1() {
        System.out.println("测试1 ");
    }

    /**
     * @ApiOperation 使用
     * @ApiImplicitParam 使用
     */
    @GetMapping("test2")
    @ApiOperation(tags = "测试2", value = "测试2备注")
    @ApiImplicitParam(value = "param测试2", required = true, paramType = "path", dataType = "String", defaultValue = "yiyu")
    public void test2(@RequestParam(value = "name", defaultValue = "yiyu") String name) {
        System.out.println("测试2 " + name);
    }

    /**
     * @ApiOperation 使用
     * @ApiImplicitParams 使用
     * @ApiImplicitParam 使用
     */
    @GetMapping("test3")
    @ApiOperation(tags = "测试3", value = "测试3备注")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "param测试3", required = true, paramType = "path", dataType = "String", defaultValue = "yiyu"),
            @ApiImplicitParam(value = "param测试3", required = true, paramType = "path", dataType = "Integer", defaultValue = "18")
    })
    public void test3(@RequestParam(value = "name", defaultValue = "yiyu") String name,
                      @RequestParam(value = "name", defaultValue = "18") Integer age) {
        System.out.println("测试3,姓名：" + name + ",年龄：" + age);
    }


    /**
     * @ApiOperation使用
     */
    @GetMapping("test4")
    @ApiOperation(value = "测试4", tags = "测试4备注")
    public TestSwaggerModel test4() {
        System.out.println("测试4");

        TestSwaggerModel tsm = new TestSwaggerModel();
        tsm.setName("yiyu");
        tsm.setAge(18);
        return  tsm;
    }
}
