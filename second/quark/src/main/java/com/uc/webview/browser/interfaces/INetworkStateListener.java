package com.uc.webview.browser.interfaces;

import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;

@Interface
/* compiled from: ProGuard */
public interface INetworkStateListener {
    public static final int PROXY_TRAFFIC = 1;
    public static final int WAP_TRAFFIC = 0;

    @Interface
    /* compiled from: ProGuard */
    public enum TrafficStat {
        WAP_TRAFFIC,
        PROXY_TRAFFIC,
        SAVED_TRAFFIC,
        CUR_TIME_TRAFFIC,
        CUR_DAY_TRAFFIC,
        CUR_MONTH_TRAFFIC,
        TOTAL_TRAFFIC,
        PROXY_CUR_TIME_TRAFFIC,
        PROXY_CUR_DAY_TRAFFIC,
        PROXY_CUR_MONTH_TRAFFIC,
        PROXY_TOTAL_TRAFFIC,
        SAVED_CUR_TIME_TRAFFIC,
        SAVED_CUR_DAY_TRAFFIC,
        SAVED_CUR_MONTH_TRAFFIC,
        SAVED_TOTAL_TRAFFIC
    }

    @Deprecated
    void onFoundTooManyRepeatedRequests(WebView webView, String str);

    @Deprecated
    void onReceiveDNSInformation(String str, String str2, int i);

    @Deprecated
    void onServerFailure(int i, String str);

    void onTrafficUpdate(TrafficStat trafficStat, long j, long j2);

    @Deprecated
    void onUCProxySecurity(boolean z);

    @Deprecated
    void onUrlScheme(String str);
}
