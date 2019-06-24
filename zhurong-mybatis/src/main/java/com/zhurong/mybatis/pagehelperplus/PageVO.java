/**
 * @Title: PageVO.java
 * @Package: com.zhurong.mybatis.page
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.mybatis.pagehelperplus;

import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @description:
 * @author LZG
 * @date 2019/6/21
 */
public class PageVO<T> {

    //PageHelper自带
    private PageInfo<T> pageInfo;

    //模糊查询条件
    private List<SearchCondition> searchInfo;

    //排序条件
    private List<SortCondition> sortInfo;

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<SearchCondition> getSearchInfo() {
        return searchInfo;
    }

    public void setSearchInfo(List<SearchCondition> searchInfo) {
        this.searchInfo = searchInfo;
    }

    public List<SortCondition> getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(List<SortCondition> sortInfo) {
        this.sortInfo = sortInfo;
    }

}