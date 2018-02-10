package com.uc.webview.export.extension;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IWaStat;

/* compiled from: ProGuard */
final class g implements ValueCallback<Object[]> {
    g() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Object[] objArr = (Object[]) obj;
        switch (((Integer) objArr[0]).intValue()) {
            case 1:
                SDKFactory.invoke(10001, Long.valueOf(1024));
                return;
            case 2:
                SDKFactory.invoke(10001, Long.valueOf(2048));
                return;
            case 3:
                SDKFactory.invoke(10001, Long.valueOf(4096));
                return;
            case 4:
                SDKFactory.invoke(10001, Long.valueOf(16384));
                return;
            case 5:
                SDKFactory.invoke(10001, Long.valueOf(65536));
                return;
            case 6:
                SDKFactory.z.put(IWaStat.VIDEO_ERROR_CODE_UPDATE_CHECK_REQUEST, (Integer) objArr[1]);
                return;
            case 7:
                SDKFactory.z.put(IWaStat.VIDEO_ERROR_CODE_DOWNLOAD, (Integer) objArr[1]);
                return;
            case 8:
                SDKFactory.z.put(IWaStat.VIDEO_ERROR_CODE_VERIFY, (Integer) objArr[1]);
                return;
            case 9:
                SDKFactory.z.put(IWaStat.VIDEO_ERROR_CODE_UNZIP, (Integer) objArr[1]);
                return;
            default:
                return;
        }
    }
}
