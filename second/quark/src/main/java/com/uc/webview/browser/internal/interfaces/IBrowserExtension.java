package com.uc.webview.browser.internal.interfaces;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import com.uc.webview.browser.interfaces.BrowserClient;
import com.uc.webview.browser.interfaces.BrowserExtension.SnapshotRequestResult;
import com.uc.webview.browser.interfaces.BrowserExtension.TextSelectionClient;
import com.uc.webview.browser.interfaces.BrowserExtension.TopControlsListener;
import com.uc.webview.browser.interfaces.BrowserSettings;
import com.uc.webview.browser.interfaces.HCAdAdapterClient;
import com.uc.webview.browser.interfaces.IWebBackForwardCustomData;
import com.uc.webview.browser.interfaces.ImageViewer;
import com.uc.webview.browser.interfaces.PictureViewer.Listener;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.IUCExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

@Interface
/* compiled from: ProGuard */
public interface IBrowserExtension extends IUCExtension {
    boolean addShortcutForWebapp(String str, ValueCallback<Bundle> valueCallback);

    boolean canGoPrereadPage();

    void cancelMultiTouchEventHandling();

    void clearXhtmlCache(String str);

    boolean closePictureViewer();

    void evaluateJavascriptInIsolateContext(String str, ValueCallback<String> valueCallback);

    void expandSelection();

    void forceUpdateTopControlsOffset(boolean z);

    Bitmap getCurrentPageFullSnapshot(Config config);

    void getEditorContent(ValueCallback<String> valueCallback);

    ImageViewer getImageViewer();

    String getSelection();

    BrowserSettings getUCSettings();

    IWebBackForwardCustomData getWebBackForwardCustomData();

    void getWebContent(ValueCallback<Bundle> valueCallback);

    int getWebViewType();

    boolean handleBackKeyPressed();

    boolean isMobileType();

    boolean isVisible();

    void loadAndShowPicture(String str);

    void loadNetErrInfoPage(String str);

    void loadRequest(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, byte[] bArr);

    void notifyBackForwardSlideEnd();

    void notifyBackForwardSlideStart(boolean z);

    void notifyContextMenuExpanded(boolean z);

    void notifyEnterMultiWindowMode();

    void notifyExitMultiWindowMode();

    void notifyForegroundChanged(boolean z);

    void notifySettingsChanged(String str);

    void notifyVisibleRectChanged();

    void notifyWindowCovered();

    void notifyWindowUncovered();

    boolean openPictureViewer();

    boolean pageDown(boolean z, boolean z2);

    boolean pageUp(boolean z, boolean z2);

    void paste(String str);

    void postDataWithForm(String str, String str2, Vector<String> vector, Vector<String> vector2);

    void requestAllIcons(ValueCallback<HashMap> valueCallback);

    SnapshotRequestResult requestSnapshot(int i, boolean z, boolean z2, Rect rect, Bitmap bitmap, ValueCallback<Bundle> valueCallback);

    void savePagePicture(String str, String str2, String str3, ValueCallback<Bundle> valueCallback);

    void savePageToDiskCache();

    void saveSessionCookie();

    void selectAll();

    boolean selectText();

    void selectionDone();

    void setClient(BrowserClient browserClient);

    boolean setEditorContent(double d);

    boolean setEditorContent(String str);

    void setEmbeddedTitleBar(View view);

    void setHCAdAdapterClient(HCAdAdapterClient hCAdAdapterClient);

    void setInputEnhanceControllerHeight(int i);

    void setPictureViewerListener(Listener listener);

    void setSmallTopControlsHeight(int i);

    void setSnapScreenPainting(boolean z);

    void setTextSelectionClient(TextSelectionClient textSelectionClient);

    void setToolbarHeight(int i);

    void setTopControlsHeight(int i);

    void setTopControlsListener(TopControlsListener topControlsListener);

    void setTopControlsStyle(int i);

    void setWebViewType(int i);

    boolean shouldCaptureTouchEvent();

    void updateVisitedLink(String str);
}
