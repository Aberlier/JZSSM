package com.jzssm.fhf.common;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.common
 * @ClassName: Params
 * @date ：Created in 2021/1/30 16:57
 * @description：
 * @modified By：
 * @version: $
 */

public class Params {

    private Integer pageSize = 10;
    private Integer pageNo = 1;


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}