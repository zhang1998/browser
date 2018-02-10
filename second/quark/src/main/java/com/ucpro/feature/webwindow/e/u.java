package com.ucpro.feature.webwindow.e;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import com.quark.browser.R;
import com.uc.apollo.android.GuideDialog;
import com.uc.media.interfaces.IProxyHandler;
import com.uc.webview.browser.interfaces.BrowserClient;
import com.uc.webview.browser.interfaces.BrowserClient.CustomViewCallbackEx;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.UCClient.MoveCursorToTextInputResult;
import com.ucpro.base.a.e;
import com.ucpro.base.a.g;
import com.ucpro.base.c.a.c;
import com.ucpro.base.c.b.m;
import com.ucpro.feature.u.a;
import com.ucpro.feature.video.av;
import com.ucpro.feature.webwindow.at;
import com.ucpro.feature.webwindow.ba;
import com.ucpro.feature.webwindow.bb;
import com.ucpro.feature.webwindow.bo;
import com.ucpro.feature.webwindow.l;
import com.ucpro.feature.webwindow.r;
import com.ucweb.common.util.i.f;
import java.util.HashMap;
import java.util.List;

/* compiled from: ProGuard */
public final class u extends BrowserClient {
    private final bo a;
    private at b;
    private Context c;
    private c d;
    private m e;

    public u(Context context, at atVar, bo boVar, m mVar, c cVar) {
        this.b = atVar;
        this.a = boVar;
        this.c = context;
        this.d = cVar;
        this.e = mVar;
        a.a("BrowserClientImpl", this);
    }

    public final String onJsCommand(String str, String str2, String[] strArr) {
        new StringBuilder("onJsCommand\nfunction : ").append(str).append("\nurl : ").append(str2).append("\nargs length : ").append(strArr.length);
        return this.a.getJsApiManager().a(str, str2, strArr);
    }

    public final void onFirstLayoutFinished(boolean z, String str) {
        super.onFirstLayoutFinished(z, str);
        bo boVar = this.a;
        List<String> a = com.ucpro.feature.webwindow.f.c.a().a(f.c(str), "T1");
        if (boVar != null && a != null && !a.isEmpty()) {
            for (String str2 : a) {
                if (!TextUtils.isEmpty(str2)) {
                    boVar.b("javascript: " + str2);
                }
            }
        }
    }

    public final void onSaveFormDataPrompt(int i, ValueCallback<Boolean> valueCallback) {
        ba c;
        bo boVar;
        com.ucpro.ui.g.m mVar;
        switch (i) {
            case 0:
                c = this.b.c();
                boVar = this.a;
                mVar = new com.ucpro.ui.g.m(c.a);
                mVar.a(3);
                mVar.a(com.ucpro.ui.c.a.d((int) R.string.browser_form_save_tips));
                mVar.a(com.ucpro.ui.c.a.d((int) R.string.browser_form_save), com.ucpro.ui.c.a.d((int) R.string.browser_form_not_save));
                mVar.a(new l(c, boVar, valueCallback));
                mVar.show();
                return;
            case 1:
                c = this.b.c();
                boVar = this.a;
                mVar = new com.ucpro.ui.g.m(c.a);
                mVar.a(com.ucpro.ui.c.a.d((int) R.string.browser_form_save_tips));
                mVar.a(com.ucpro.ui.c.a.d((int) R.string.browser_form_save), com.ucpro.ui.c.a.d((int) R.string.browser_form_not_save));
                mVar.a(new r(c, boVar, valueCallback));
                mVar.show();
                return;
            default:
                return;
        }
    }

    public final void onWebViewEvent(WebView webView, int i, Object obj) {
        super.onWebViewEvent(webView, i, obj);
        this.a.a(i, obj);
    }

    public final void onMoveCursorToTextInput(MoveCursorToTextInputResult moveCursorToTextInputResult) {
        g.a().a(e.ae, (Object) moveCursorToTextInputResult);
    }

    public final void onVideoDataSource(Uri uri, String str, String str2) {
        if (uri != null) {
            Object bundle = new Bundle();
            bundle.putString(IProxyHandler.KEY_PAGE_URL, str2);
            bundle.putString(IProxyHandler.KEY_VIDEO_URL, uri.toString());
            bundle.putString(GuideDialog.TITLE, str);
            g.a().b(e.bt, bundle);
        }
    }

    public final Object createVideoView(int i) {
        Object obj = new Object[3];
        obj[0] = Integer.valueOf(this.a.getID());
        obj[1] = Integer.valueOf(i);
        g.a().b(e.bn, obj);
        return ((av) obj[2]).a.e();
    }

    public final void onEnterVideoFullScreen(boolean z, int i) {
        if (this.a instanceof bb) {
            this.a.d(z);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str, int i) {
        e a = e.a();
        CharSequence url = webView.getUrl();
        if (!(TextUtils.isEmpty(url) || TextUtils.isEmpty(str))) {
            a.a.put(url, str);
        }
        return false;
    }

    public final void onShowCustomView(View view, int i, CustomViewCallbackEx customViewCallbackEx) {
        this.a.a(view, i, customViewCallbackEx);
    }

    public final void requestLittleWinPermission(ValueCallback<Boolean> valueCallback) {
        g.a().b(e.br, 0, 0, valueCallback);
    }

    public final void enquireInterruptStart(ValueCallback<Boolean> valueCallback) {
        new Handler().post(new n(this, valueCallback));
    }

    public final void onReceivedDispatchResponse(HashMap<String, String> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            this.a.setReceivedDispatchResponse(hashMap);
        }
    }

    public final void didOverscroll(int i, int i2) {
        this.a.c(i2);
    }
}
