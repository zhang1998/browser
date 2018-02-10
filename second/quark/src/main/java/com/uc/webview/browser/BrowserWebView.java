package com.uc.webview.browser;

import android.content.Context;
import android.util.AttributeSet;
import com.uc.webview.browser.interfaces.BrowserExtension;
import com.uc.webview.browser.internal.BrowserSDKFactory;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView.IHitTestResult;
import com.uc.webview.browser.internal.interfaces.IBrowserWebView.IHitTestResult.IExtension;
import com.uc.webview.export.DownloadListener;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Api;

@Api
/* compiled from: ProGuard */
public class BrowserWebView extends WebView {
    private BrowserExtension a;

    @Api
    /* compiled from: ProGuard */
    public class HitTestResult extends com.uc.webview.export.WebView.HitTestResult {
        public static final int DOWNLOAD_TEXT_TYPE = 24;
        public static final int PASSWORD_TYPE = 22;
        public static final int PHONE_TEXT_TYPE = 23;
        public static final int PLUGIN_TYPE = 21;
        final /* synthetic */ BrowserWebView a;
        private IHitTestResult c;
        private Extension d;

        @Api
        /* compiled from: ProGuard */
        public class Extension {
            final /* synthetic */ HitTestResult a;
            private IExtension b;

            private Extension(HitTestResult hitTestResult, IExtension iExtension) {
                this.a = hitTestResult;
                this.b = iExtension;
            }

            public void setType(int i) {
                this.b.setType(i);
            }

            public void setExtra(String str) {
                this.b.setExtra(str);
            }

            public String getLinkUrl() {
                return this.b.getLinkUrl();
            }

            public void setLinkUrl(String str) {
                this.b.setLinkUrl(str);
            }

            public String getImageUrl() {
                return this.b.getImageUrl();
            }

            public void setImageUrl(String str) {
                this.b.setImageUrl(str);
            }

            public boolean imageIsVisible() {
                return this.b.imageIsVisible();
            }

            public boolean disableScale() {
                return this.b.disableScale();
            }

            public boolean imageIsLoaded() {
                return this.b.imageIsLoaded();
            }

            public boolean hasImage() {
                return this.b.hasImage();
            }

            public boolean canEnterPictureMode() {
                return this.b.canEnterPictureMode();
            }

            public boolean nodeIsPlugin() {
                return this.b.nodeIsPlugin();
            }

            public boolean nodeIsEditText() {
                return this.b.nodeIsEditText();
            }

            public String getText() {
                return this.b.getText();
            }
        }

        private HitTestResult(BrowserWebView browserWebView, IHitTestResult iHitTestResult) {
            this.a = browserWebView;
            super(browserWebView);
            this.d = null;
            this.c = iHitTestResult;
            if (this.c.getExtension() != null) {
                this.d = new Extension(this.c.getExtension());
            }
        }

        public int getType() {
            return this.c.getType();
        }

        public String getExtra() {
            return this.c.getExtra();
        }

        public Extension getExtension() {
            return this.d;
        }
    }

    static {
        BrowserSDKFactory.f();
    }

    public BrowserWebView(Context context) {
        super(context, null);
        a();
    }

    public BrowserWebView(Context context, int i) {
        super(context, i);
        a();
    }

    public BrowserWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BrowserWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    @Deprecated
    public BrowserWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        a();
    }

    private void a() {
        if (getCurrentViewCoreType() != 2) {
            this.a = BrowserSDKFactory.a((IBrowserWebView) this.mWebView, getCurrentViewCoreType());
        }
    }

    public BrowserExtension getUCExtension() {
        return this.a;
    }

    public HitTestResult getHitTestResult() {
        if (super.getHitTestResult() != null) {
            return new HitTestResult((IHitTestResult) this.mWebView.getHitTestResultInner());
        }
        return null;
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mWebView.setDownloadListener(downloadListener);
    }

    public void setDownloadListener(com.uc.webview.browser.interfaces.DownloadListener downloadListener) {
        ((IBrowserWebView) this.mWebView).setDownloadListener(downloadListener);
    }

    public static int getTotalInstanceCount(int i) {
        return sInstanceCount[i];
    }
}
