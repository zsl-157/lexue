package com.lexue.common.model;

import java.util.List;

/**
 * @author zsl
 * @date 2022-07-04
 */
@SuppressWarnings("unused")
public class Page<T> {
    private Integer currentPageNum;//当前页码
    private Integer pageSize;//每页数据条数
    private Integer totalPage;//总页数
    private Integer totalCount;//总数据条数
    private List<T> objectList;//用来存储查询出来的结果集
    private Integer start;//查询起始位置

    public Integer currentPageNum() {
        return currentPageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public Integer getStart() {
        return (currentPageNum-1)*pageSize;
    }

    public Integer getTotalPage() {
        return totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }

    public void currentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }
}

