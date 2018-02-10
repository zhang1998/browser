package com.uc.base.a.a.a.e;

import com.tencent.mm.sdk.constants.ConstantsAPI.Token;

/* compiled from: ProGuard */
public enum l {
    QQ("qq"),
    WECHAT(Token.WX_TOKEN_PLATFORMID_VALUE),
    WEIBO("weibo"),
    TAOBAO("taobao"),
    ZHIFUBAO("zhifubao");
    
    public String f;

    private l(String str) {
        this.f = str;
    }
}
