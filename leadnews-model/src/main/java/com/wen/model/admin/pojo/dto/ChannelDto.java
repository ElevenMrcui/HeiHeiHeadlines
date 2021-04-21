package com.wen.model.admin.pojo.dto;

import com.wen.model.common.Pagination;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChannelDto extends Pagination {


    @ApiModelProperty("频道名称")
    private String name;


    @ApiModelProperty("账号状态")
    private Boolean status;
}
