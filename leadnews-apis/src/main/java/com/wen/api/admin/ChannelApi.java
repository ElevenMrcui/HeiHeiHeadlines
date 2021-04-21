package com.wen.api.admin;

import com.wen.model.admin.pojo.AdChannel;
import com.wen.model.admin.pojo.dto.ChannelDto;
import com.wen.model.dtos.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/channel")
@Api(value = "频道管理", tags = "频道管理", description = "频道管理API")
public interface ChannelApi {


    @PostMapping("/list")
    @ApiOperation("频道分页列表查询")
    public ResponseResult pageQueryChannel(@RequestBody  ChannelDto channel);

    @PostMapping("/saveOrUpdate")
    @ApiOperation("添加或修改频道")
    public ResponseResult saveOrUpdateChannel(@RequestBody @Validated AdChannel channel);

    @GetMapping("/delete/{id}")
    @ApiOperation("删除频道")
    public  ResponseResult deleteChannel( @PathVariable Integer id);
}
