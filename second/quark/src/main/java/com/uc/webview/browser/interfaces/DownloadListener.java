package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;
import java.util.ArrayList;

@Interface
/* compiled from: ProGuard */
public abstract class DownloadListener implements com.uc.webview.export.DownloadListener {
    public static final int DOWNLOADVIDEO = 0;

    public abstract void onDownloadStartEx(String str, String str2, String str3, String str4, String str5, long j, boolean z, boolean z2, String str6, ArrayList<String> arrayList);

    public abstract void onVideoDownloadStart(String str, String str2, String str3, String str4, String str5, long j, boolean z, String str6, int i, Object obj);

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        throw new RuntimeException("browser should override onDownloadStartEx instead");
    }

    public void onDownloadStartEx(String str, String str2, String str3, String str4, String str5, long j, boolean z, boolean z2, String str6, String str7, ArrayList<String> arrayList) {
    }
}
