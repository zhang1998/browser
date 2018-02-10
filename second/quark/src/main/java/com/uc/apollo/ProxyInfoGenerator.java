package com.uc.apollo;

import com.uc.apollo.annotation.KeepForRuntime;
import java.util.Map;

@KeepForRuntime
/* compiled from: ProGuard */
public interface ProxyInfoGenerator {

    @KeepForRuntime
    /* compiled from: ProGuard */
    public class ProxyInfo {
        public Map<String, String> httpHeaders;
        public String proxyServer;
    }

    ProxyInfo generateProxyInfo(String str);
}
