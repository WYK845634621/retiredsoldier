package com.yikai.retiredsoldier.Vo;

import java.io.Serializable;

public class ParamVo<P, C> implements Serializable {

    private static final long serialVersionUID = 1L;
    // 请求的页码信息
    private P pagger;
    // 请求查询条件
    private C condition;

    public P getPagger() {
        return pagger;
    }

    public void setPagger(P pagger) {
        this.pagger = pagger;
    }

    public C getCondition() {
        return condition;
    }

    public void setCondition(C condition) {
        this.condition = condition;
    }


}