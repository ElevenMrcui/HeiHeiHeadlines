package com.wen.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wen.admin.mapper.ChannelMapper;
import com.wen.admin.service.ChannelService;
import com.wen.model.admin.pojo.AdChannel;
import com.wen.model.admin.pojo.dto.ChannelDto;
import com.wen.model.common.PageResponseResult;
import com.wen.model.dtos.ResponseResult;
import com.wen.model.enums.AppHttpCodeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, AdChannel> implements ChannelService {

    /**
     * 频道查询
     * @param channel
     * @return
     */
    @Override
    public ResponseResult pageQueryChannel(ChannelDto channel) {
        IPage<AdChannel> page = query()
                .like(StringUtils.isNotBlank(channel.getName()), "name", channel.getName())
                .eq(channel.getStatus() != null,"status",channel.getStatus())
                .page(new Page<>(channel.getPageNum(), channel.getPageSize()));
        ResponseResult result = new PageResponseResult(page.getCurrent(), page.getSize(), page.getTotal());
        result.setData(page.getRecords());
        return result;
    }

    /**
     * 频道添加或修改
     * @param channel
     * @return
     */
    @Override
    public ResponseResult saveOrUpdateChannel(AdChannel channel) {
        if(channel == null){
            return  ResponseResult.errorResult(AppHttpCodeEnum.PARAM_REQUIRE,"参数不能为空");
        }
        channel.setCreatedTime(new Date());
        try {
            saveOrUpdate(channel);
        } catch (Exception e) {
            return  ResponseResult.errorResult(AppHttpCodeEnum.ERROR_SAVEORUPDATE,"添加或修改失败");
        }
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 删除频道
     * @param id
     * @return
     */
    @Override
    public ResponseResult delete(Integer id) {
        if(id == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        AdChannel channel = getById(id);
        if(channel==null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }
        if (channel.getStatus()) {
            return ResponseResult.errorResult(AppHttpCodeEnum.ADMIN_CHANNEL_ISSTATUS_ERROR);
        }
        removeById(id);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }
}
