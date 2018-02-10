package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Deprecated
@Interface
/* compiled from: ProGuard */
public interface IMemoryManagerListener {
    void notifyLowMemory(int i);

    void requestMemoryReport();
}
