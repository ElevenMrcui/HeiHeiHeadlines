package com.wen.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wen.model.admin.pojo.AdChannel;
import com.wen.model.admin.pojo.dto.ChannelDto;
import com.wen.model.dtos.ResponseResult;

public interface ChannelService extends IService<AdChannel> {

    /**
     * 频道查询
     * @param channel
     * @return
     */
    ResponseResult pageQueryChannel(ChannelDto channel);

    /**
     * 频道添加或修改
     * @param channel
     * @return
     */
    ResponseResult saveOrUpdateChannel(AdChannel channel);

    /**
     * 删除频道
     * @param id
     * @return
     */
    ResponseResult delete(Integer id);
}
