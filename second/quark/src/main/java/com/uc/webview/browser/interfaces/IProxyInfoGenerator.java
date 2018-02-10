package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;
import java.util.Map;

@Interface
/* compiled from: ProGuard */
public interface IProxyInfoGenerator {

    @Interface
    /* compiled from: ProGuard */
    public class ProxyInfo {
        public Map<String, String> httpHeaders;
        public String proxyServer;
    }

    ProxyInfo generateProxyInfo(String str);
}
