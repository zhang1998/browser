package com.uc.weex.g;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.o;
import java.util.Map;

/* compiled from: ProGuard */
public abstract class a extends o {
    @JSMethod
    @Deprecated
    public abstract void commit(String str, String str2, String str3, Map<String, String> map);

    @JSMethod
    @Deprecated
    public abstract void commitEvent(String str, int i, String str2, String str3, String str4, Map<String, String> map);

    @JSMethod
    public abstract void commitut(String str, int i, String str2, String str3, String str4, String str5, String str6, Map<String, String> map);

    @JSMethod
    public abstract void customAdvance(String str, int i, String str2, String str3, String str4, Map<String, String> map);

    @JSMethod
    public abstract void pageAppear();

    @JSMethod
    public abstract void pageDisAppear();

    @JSMethod
    public abstract void skipPage();

    @JSMethod
    public abstract void updateNextPageUtparam(String str);

    @JSMethod
    public abstract void updatePageUtparam(String str);
}
