package com.uc.webview.browser.internal.interfaces;

import android.util.SparseBooleanArray;
import com.uc.webview.browser.interfaces.DownloadListener;
import com.uc.webview.browser.interfaces.IWebBackForwardCustomData;
import com.uc.webview.browser.interfaces.ImageViewer;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.IWebView;

@Interface
/* compiled from: ProGuard */
public interface IBrowserWebView extends IWebBackForwardCustomData, ImageViewer, IBrowserExtension, IWebView {

    @Interface
    /* compiled from: ProGuard */
    public interface IHitTestResult extends com.uc.webview.export.internal.interfaces.IWebView.IHitTestResult {
        public static final int PLUGIN_TYPE = 21;

        @Interface
        /* compiled from: ProGuard */
        public interface IExtension {
            boolean canEnterPictureMode();

            boolean disableScale();

            String getImageUrl();

            String getLinkUrl();

            String getText();

            boolean hasImage();

            boolean imageIsLoaded();

            boolean imageIsVisible();

            boolean nodeIsEditText();

            boolean nodeIsPlugin();

            void setExtra(String str);

            void setImageUrl(String str);

            void setLinkUrl(String str);

            void setType(int i);
        }

        IExtension getExtension();
    }

    IHitTestResult getHitTestResultInner();

    IBrowserExtension getUCExtension();

    void onListBoxCancel();

    void onMultiListBoxSelected(int i, SparseBooleanArray sparseBooleanArray);

    void onSingleListBoxSelected(int i);

    void setDownloadListener(DownloadListener downloadListener);
}
