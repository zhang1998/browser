package com.uc.weex;

/* compiled from: ProGuard */
public enum h {
    WEEX_ERR_ENGINE_INIT_FAILED("UC-1100", "share engine init failed"),
    WEEX_ERR_BUNDLE_FROM_REMOTE_URL_EMPTY("UC-1201", "bundle from remote url is empty"),
    WEEX_ERR_BUNDLE_FROM_LOCAL_URL_EMPTY("UC-1202", "bundle from local url is empty"),
    WEEX_ERR_BUNDLE_FROM_BUNDLE_NAME_EMPTY("UC-1203", "bundle from bundle name is empty"),
    WEEX_RRR_BUNDLE_FROM_UNKNOW_EMPTY("UC-1204", "bundle from unknow is empty"),
    WEEX_ERROR_REMOTE_URL_ILLEGAL("UC-1301", "url is illegal");
    
    public String g;
    public String h;

    private h(String str, String str2) {
        this.g = str;
        this.h = str2;
    }
}
