package com.wen.model.admin.pojo.dto;

import com.wen.model.common.Pagination;
import lombok.Data;

@Data
public class SensitiveDto extends Pagination {

    /**
     * 敏感词名称
     */
    private String name;
}

