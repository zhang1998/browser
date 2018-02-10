package com.taobao.weex.common;

import com.uc.apollo.impl.SettingsConst;

/* compiled from: ProGuard */
public enum g {
    WX_ERR_LOAD_SO("-2001", "load so error"),
    WX_ERR_LOAD_JSLIB("-2002", "unzip JSLib error!"),
    WX_ERR_BAD_SO("-2003", "so size error, to reload apk so"),
    WX_ERR_COPY_FROM_APK("-2007", "system load so error，copy from APK also error!"),
    WX_ERR_JSFUNC_PARAM("-2009", "JS params error!"),
    WX_ERR_JSON_OBJECT("-2008", "transform JSON->OBJ  error!"),
    WX_ERR_INVOKE_NATIVE("-2012", "Native-> Call ->JS  error!"),
    WX_ERR_JS_EXECUTE("-2013", "JavaScript execute error!"),
    WX_SUCCESS(SettingsConst.FALSE, "successful"),
    WX_ERR_DOM_CREATEBODY("-2100", "createBody error"),
    WX_ERR_DOM_UPDATEATTRS("-2101", "updateAttrs error"),
    WX_ERR_DOM_UPDATESTYLE("-2102", "updateStyle error"),
    WX_ERR_DOM_ADDELEMENT("-2103", "addElement error"),
    WX_ERR_DOM_REMOVEELEMENT("-2104", "removeElement error"),
    WX_ERR_DOM_MOVEELEMENT("-2105", "moveElement error"),
    WX_ERR_DOM_ADDEVENT("-2106", "addEvent error"),
    WX_ERR_DOM_REMOVEEVENT("-2107", "removeEvent error"),
    WX_ERROR_DOM_CREATEFINISH("-2108", "createFinish error"),
    WX_ERROR_DOM_REFRESHFINISH("-2109", "refreshFinish error"),
    WX_ERR_DOM_SCROLLTO("-2110", "scrollToElement"),
    WX_ERR_JSDOWNLOAD_START("-2201", "js bundle download start"),
    WX_ERR_JSBUNDLE_DOWNLOAD("-2299", "js bundle download err"),
    WX_ERR_JSBUNDLE_EMPTY("-2203", "js bundle empty"),
    WX_ERR_JSDOWNLOAD_END("-2299", "js bundle download end"),
    WX_ERR_JS_FRAMEWORK("-1002", "js framework error");
    
    public String A;
    private String B;
    private String C;
    public String z;

    private g(String str, String str2) {
        this.C = "";
        this.z = str;
        this.B = str2;
    }

    public final String a() {
        StringBuilder stringBuilder = new StringBuilder(this.B);
        stringBuilder.append(this.C);
        return stringBuilder.toString();
    }
}
