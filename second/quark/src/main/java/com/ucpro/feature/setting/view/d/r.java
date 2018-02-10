package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.business.d.e;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.feature.webwindow.e.c;
import com.ucpro.feature.webwindow.e.f;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.o.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class r extends ac {
    private f f;
    private String g;

    static /* synthetic */ void a(r rVar, String str, ValueCallback valueCallback) {
        Closeable open;
        Closeable closeable;
        e eVar;
        Throwable th;
        Object obj = null;
        if (!TextUtils.isEmpty(str)) {
            byte[] b;
            try {
                open = rVar.getContext().getAssets().open(str);
                if (open != null) {
                    try {
                        b = com.uc.encrypt.f.b(a.b((InputStream) open), com.uc.encrypt.a.a);
                    } catch (IOException e) {
                        closeable = open;
                        a.a(closeable);
                        b = null;
                        if (b != null) {
                            eVar = new e();
                            eVar.a(b);
                            obj = eVar.c();
                        }
                        valueCallback.onReceiveValue(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        a.a(open);
                        throw th;
                    }
                }
                b = null;
                a.a(open);
            } catch (IOException e2) {
                closeable = null;
                a.a(closeable);
                b = null;
                if (b != null) {
                    eVar = new e();
                    eVar.a(b);
                    obj = eVar.c();
                }
                valueCallback.onReceiveValue(obj);
            } catch (Throwable th3) {
                th = th3;
                open = null;
                a.a(open);
                throw th;
            }
            if (b != null) {
                eVar = new e();
                eVar.a(b);
                obj = eVar.c();
            }
        }
        valueCallback.onReceiveValue(obj);
    }

    public r(Context context, i iVar) {
        super(context, iVar);
        m.a(0, new f(this));
    }

    private void a(String str) {
        if (this.f != null && !TextUtils.isEmpty(str)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                this.f.a("ext:lp:useragreement", str, "text/html", "UTF-8", "ext:lp:useragreement");
                return;
            }
            m.a(2, new s(this, str));
        }
    }

    public final String getTitleText() {
        return com.ucpro.ui.c.a.d((int) R.string.user_agreement_setting_window_title);
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
            this.f.setLongClickListener(new ae(this));
            this.f.setWebViewCallback(new d(this, this.f));
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

    static /* synthetic */ void a(r rVar) {
        if (rVar.f != null) {
            rVar.f.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(1500).start();
        }
    }
}
