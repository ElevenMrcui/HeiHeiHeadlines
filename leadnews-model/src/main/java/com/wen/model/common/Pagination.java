package com.wen.model.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public  class Pagination {

    @ApiModelProperty(value = "当前页码",required = true)
    private Long pageNum;

    @ApiModelProperty(value = "当前页条数",required = true)
    private Long pageSize;

}
