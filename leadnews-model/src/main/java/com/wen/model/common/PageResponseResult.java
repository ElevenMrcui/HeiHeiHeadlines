package com.wen.model.common;

import com.wen.model.dtos.ResponseResult;

public class PageResponseResult extends ResponseResult {
    private Long currentPage;
    private Long size;
    private Long total;

    public PageResponseResult(Long currentPage, Long size, Long total) {
        this.currentPage = currentPage;
        this.size = size;
        this.total = total;
    }
	 // set/get 代码省略
}