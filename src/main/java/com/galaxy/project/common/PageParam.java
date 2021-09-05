package com.galaxy.project.common;


import javax.persistence.Transient;

public class PageParam extends BaseParam{
    @Transient
    private Integer page=1;

    // 分页参数
    @Transient
    private Integer limit = 10 ;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
