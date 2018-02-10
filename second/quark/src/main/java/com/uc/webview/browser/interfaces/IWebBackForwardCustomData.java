package com.uc.webview.browser.interfaces;

import com.uc.webview.export.annotations.Interface;

@Deprecated
@Interface
/* compiled from: ProGuard */
public interface IWebBackForwardCustomData {
    Object getCurrentItem();

    Object getNextItem();

    Object getPreviousItem();

    void setCurrentItem(Object obj);

    void setNextItem(Object obj);

    void setPreviousItem(Object obj);
}
