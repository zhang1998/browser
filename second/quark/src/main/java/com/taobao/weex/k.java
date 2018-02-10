package com.taobao.weex;

/* compiled from: ProGuard */
public enum k {
    SHARE_V8("sharev8"),
    BUILDIN_V8("buildinv8"),
    JSC("jsc"),
    UC_WEBVIEW("ucwebview"),
    WEBVIEW("webview"),
    UNKNOWN("unknown"),
    size("");
    
    private String h;

    private k(String str) {
        this.h = str;
    }

    public final String toString() {
        return this.h;
    }
}
