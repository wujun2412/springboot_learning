package com.wujun.boot.requests;

import java.io.Serializable;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class PageRequest implements Serializable{
    private static final long serialVersionUID = -8835828530872280844L;

    /**
     * 每页最大记录数限制
     */
    private static final Integer MAX_PAGE_SIZE = Integer.MAX_VALUE;

    /**
     * 当前第几页
     */
    private Integer currentPage = 1;

    /**
     * 每页多少条
     */
    private Integer pageSize = 20;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage != null && currentPage > 0){
            this.currentPage = currentPage;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null || pageSize <= 0) {
            return;
        }
        if (pageSize > MAX_PAGE_SIZE) {
            pageSize = MAX_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }


}
