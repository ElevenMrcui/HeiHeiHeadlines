package com.wen.admin.controller;

import com.wen.admin.service.SensitiveService;
import com.wen.api.admin.SensitiveApi;
import com.wen.model.admin.pojo.AdSensitive;
import com.wen.model.admin.pojo.dto.SensitiveDto;
import com.wen.model.dtos.ResponseResult;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

@Slf4j
@RestController
public class SensitiveController implements SensitiveApi {

    @Autowired
    private SensitiveService sensitiveService;

    /**
     * 查询敏感词列表
     * @param dto
     * @return
     */
    @Override
    public ResponseResult list(SensitiveDto dto) {
        return null;
    }

    /**
     * 新增或修改敏感词
     * @param adSensitive
     * @return
     */
    @Override
    public ResponseResult saveOrUpdate(AdSensitive adSensitive) {
        return null;
    }

    /**
     * 删除敏感词
     * @param id
     * @return
     */
    @Override
    public ResponseResult delete(Integer id) {
        return null;
    }
}
