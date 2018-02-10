package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.feature.webwindow.e.c;
import com.ucpro.feature.webwindow.e.f;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.o.a;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: ProGuard */
public final class t extends ac {
    private f f;
    private String g;

    static /* synthetic */ void a(t tVar, String str, ValueCallback valueCallback) {
        Closeable open;
        Object c;
        Throwable th;
        Closeable closeable = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                open = tVar.getContext().getAssets().open(str);
                if (open != null) {
                    try {
                        c = a.c(open);
                    } catch (IOException e) {
                        a.a(open);
                        valueCallback.onReceiveValue(c);
                    } catch (Throwable th2) {
                        th = th2;
                        a.a(open);
                        throw th;
                    }
                }
                a.a(open);
            } catch (IOException e2) {
                open = closeable;
                a.a(open);
                valueCallback.onReceiveValue(c);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                open = closeable;
                th = th4;
                a.a(open);
                throw th;
            }
        }
        valueCallback.onReceiveValue(c);
    }

    public t(Context context, i iVar) {
        super(context, iVar);
        m.a(0, new c(this));
    }

    private void a(String str) {
        if (this.f != null && !TextUtils.isEmpty(str)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.f.a("ext:lp:privacyagreement", str, "text/html", "UTF-8", "ext:lp:privacyagreement");
                return;
            }
            m.a(2, new u(this, str));
        }
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.about_setting_view_privacy_agreement);
    }

    public final void a(h hVar, int i, Object obj) {
    }

    protected final void a(byte b) {
        super.a(b);
        new StringBuilder("stateFlag:   ").append(String.valueOf(b));
        if ((byte) 1 == b) {
            if (this.f == null) {
                this.f = c.a(getContext(), false);
            }
            this.f.setAlpha(0.0f);
            this.f.setBackgroundColor(0);
            this.f.getBackground().setAlpha(0);
            this.f.setLongClickListener(new l(this));
            this.f.setWebViewCallback(new o(this, this.f));
            if (this.f.getWebViewSetting() != null) {
                this.f.getWebViewSetting().a();
            }
            a(this.g);
            getContentLayer().addView(this.f, new LayoutParams(-1, -1));
        } else if ((byte) 13 == b && this.f != null) {
            if (this.f.getParent() != null) {
                getContentLayer().removeView(this.f);
            }
            this.f.g();
            this.f = null;
        }
    }

    public final void l() {
        super.l();
        if (this.f != null) {
            this.f.setBackgroundColor(0);
            if (this.f.getBackground() != null) {
                this.f.getBackground().setAlpha(0);
            }
            this.f.h();
        }
    }

    static /* synthetic */ void a(t tVar) {
        if (tVar.f != null) {
            tVar.f.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(1500).start();
        }
    }
}
