package com.jzssm.fhf.common;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.common
 * @ClassName: AthoCommon
 * @date ：Created in 2021/1/31 9:28
 * @description：
 * @modified By：
 * @version: $
 */
public class AthoCommon {
    int loginId;
    String token;
    T params;

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
