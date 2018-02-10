package com.uc.media.interfaces;

import com.uc.media.interfaces.proxy.SourceInfo;
import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface IProxyHandler {
    public static final String KEY_PAGE_URL = "pageUrl";
    public static final String KEY_SOURCEINFO_LISTENER = "sourceInfoListener";
    public static final String KEY_USER_AGENT = "userAgent";
    public static final String KEY_VIDEO_URL = "videoUrl";
    public static final int MSG_PROXY_ADD_TASK = 0;
    public static final int MSG_PROXY_GET_CACHE_ENABLE_SYNC = 5;
    public static final int MSG_PROXY_GET_PROXY_ENABLE_SYNC = 4;
    public static final int MSG_PROXY_GET_PROXY_URL_SYNC = 3;
    public static final int MSG_PROXY_QUERY_SOURCEINFO = 2;
    public static final int MSG_PROXY_REMOVE_TASK = 1;

    @Reflection
    /* compiled from: ProGuard */
    public class ProxyFactory {
        private static IProxyHandler mProxyHandler;

        public static void setProxyHandler(IProxyHandler iProxyHandler) {
            mProxyHandler = iProxyHandler;
        }

        public static IProxyHandler getProxyHandler() {
            return mProxyHandler;
        }
    }

    @Reflection
    /* compiled from: ProGuard */
    public interface SourceInfoListenerWrapper {
        boolean onSourceParseFailure(String str, int i);

        boolean onSourceReady(SourceInfo sourceInfo);
    }

    void sendMessage(int i, Object obj);

    Object sendMessageSync(int i, Object obj);
}
