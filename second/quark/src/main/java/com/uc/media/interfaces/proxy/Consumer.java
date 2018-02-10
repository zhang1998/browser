package com.uc.media.interfaces.proxy;

import com.uc.webview.export.annotations.Reflection;

@Reflection
/* compiled from: ProGuard */
public interface Consumer {
    String brief();

    void onDataReady();

    void onSourceFragmentError(int i, boolean z);
}
