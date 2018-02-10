package com.uc.webview.export;

import android.webkit.WebHistoryItem;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class WebBackForwardList {
    public android.webkit.WebBackForwardList mList = null;

    public WebHistoryItem createItem(WebHistoryItem webHistoryItem) {
        return null;
    }

    public synchronized WebHistoryItem getCurrentItem() {
        WebHistoryItem webHistoryItem;
        WebHistoryItem currentItem = this.mList.getCurrentItem();
        if (currentItem == null) {
            webHistoryItem = null;
        } else {
            webHistoryItem = createItem(currentItem);
        }
        return webHistoryItem;
    }

    public synchronized int getCurrentIndex() {
        return this.mList.getCurrentIndex();
    }

    public synchronized WebHistoryItem getItemAtIndex(int i) {
        WebHistoryItem webHistoryItem;
        WebHistoryItem itemAtIndex = this.mList.getItemAtIndex(i);
        if (itemAtIndex == null) {
            webHistoryItem = null;
        } else {
            webHistoryItem = createItem(itemAtIndex);
        }
        return webHistoryItem;
    }

    public synchronized int getSize() {
        return this.mList.getSize();
    }

    protected synchronized WebBackForwardList clone() {
        return null;
    }
}
