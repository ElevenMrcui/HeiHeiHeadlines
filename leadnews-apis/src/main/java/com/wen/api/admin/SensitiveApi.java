package com.wen.api.admin;

import com.wen.model.admin.pojo.AdSensitive;
import com.wen.model.admin.pojo.dto.SensitiveDto;
import com.wen.model.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 敏感词接口
 */
@RequestMapping("/api/v1/sensitive")
@Api(value = "敏感词管理", tags = "敏感词管理", description = "敏感词管理API")
public interface SensitiveApi {

    @GetMapping("/list")
    @ApiOperation("敏感词列表查询")
    public ResponseResult list(SensitiveDto dto);

    @PostMapping("/saveOrUpdate")
    @ApiOperation("新增或修改敏感词")
    public ResponseResult saveOrUpdate(AdSensitive adSensitive);

    @ApiOperation("删除敏感词")
    public ResponseResult delete(Integer id);

}
