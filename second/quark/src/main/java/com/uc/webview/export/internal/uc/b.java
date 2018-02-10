package com.uc.webview.export.internal.uc;

import com.UCMobile.Apollo.Global;
import com.uc.apollo.impl.SettingsConst;
import com.uc.webview.export.internal.interfaces.INetworkDelegate;
import com.uc.webview.export.internal.interfaces.IRequestData;
import com.uc.webview.export.internal.interfaces.IResponseData;
import com.uc.webview.export.internal.interfaces.InvokeObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class b implements InvokeObject {
    private INetworkDelegate a;

    /* compiled from: ProGuard */
    final class a implements IResponseData {
        private Map<String, Object> a = new HashMap();

        public a(Map<String, Object> map) {
            this.a = map;
        }

        public final String getUrl() {
            return (String) this.a.get(SettingsConst.TRUE);
        }

        public final void setUrl(String str) {
            this.a.put(SettingsConst.TRUE, str);
        }

        public final int getStatus() {
            return ((Integer) this.a.get("4")).intValue();
        }

        public final void setStatus(int i) {
            this.a.put("4", new Integer(i));
        }

        public final Map<String, String> getHeaders() {
            return (Map) this.a.get("3");
        }

        public final void setHeaders(Map<String, String> map) {
            this.a.put("3", map);
        }

        public final Map<String, List<String>> getHeadersV2() {
            return (Map) this.a.get("3");
        }

        public final void setHeadersV2(Map<String, List<String>> map) {
            this.a.put("3", map);
        }
    }

    /* compiled from: ProGuard */
    final class b implements IRequestData {
        private Map<String, Object> a = new HashMap();

        public b(Map<String, Object> map) {
            this.a = map;
        }

        public final String getUrl() {
            return (String) this.a.get(SettingsConst.TRUE);
        }

        public final void setUrl(String str) {
            this.a.put(SettingsConst.TRUE, str);
        }

        public final String getMethod() {
            return (String) this.a.get(Global.APOLLO_SERIES);
        }

        public final void setMethod(String str) {
            this.a.put(Global.APOLLO_SERIES, str);
        }

        public final Map<String, String> getHeaders() {
            return (Map) this.a.get("3");
        }

        public final void setHeaders(Map<String, String> map) {
            this.a.put("3", map);
        }
    }

    public b(INetworkDelegate iNetworkDelegate) {
        this.a = iNetworkDelegate;
    }

    public final Object invoke(int i, Object[] objArr) {
        switch (i) {
            case 1:
                return ((b) this.a.onSendRequest(new b((Map) objArr[0]))).a;
            case 2:
            case 3:
                return ((a) this.a.onReceiveResponse(new a((Map) objArr[0]))).a;
            default:
                return null;
        }
    }
}
