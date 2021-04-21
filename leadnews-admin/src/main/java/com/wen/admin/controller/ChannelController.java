package com.wen.admin.controller;

import com.wen.admin.service.ChannelService;
import com.wen.api.admin.ChannelApi;
import com.wen.model.admin.pojo.AdChannel;
import com.wen.model.admin.pojo.dto.ChannelDto;
import com.wen.model.dtos.ResponseResult;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ChannelController implements ChannelApi {

    @Autowired
    private ChannelService channelService;

    /**
     * 频道查询
     * @param channel
     * @return
     */
    @Override
    public ResponseResult pageQueryChannel( ChannelDto channel) {
        return channelService.pageQueryChannel(channel);
    }

    /**
     * 频道添加或修改
     * @param channel
     * @return
     */
    @Override
    public ResponseResult saveOrUpdateChannel( AdChannel channel) {
        return channelService.saveOrUpdateChannel(channel);
    }

    /**
     * 删除频道
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteChannel( Integer id) {
        return channelService.delete(id);
    }
}
