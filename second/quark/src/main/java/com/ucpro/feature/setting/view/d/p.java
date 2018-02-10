package com.ucpro.feature.setting.view.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout.LayoutParams;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.setting.view.item.h;
import com.ucpro.feature.webwindow.e.c;
import com.ucpro.feature.webwindow.e.f;
import com.ucpro.ui.b.e;
import com.ucweb.common.util.h.m;
import com.ucweb.common.util.o.a;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: ProGuard */
public final class p extends ac {
    private f f;
    private String g;
    private String h;
    private boolean i = false;

    public p(Context context, i iVar, String str, String str2, boolean z) {
        super(context, iVar);
        this.g = str;
        this.h = str2;
        this.i = z;
        getTitleBar().a(this.h);
    }

    public final String getTitleText() {
        return this.h;
    }

    public final void a(h hVar, int i, Object obj) {
    }

    protected final void a(byte b) {
        super.a(b);
        if ((byte) 1 == b) {
            if (this.f == null) {
                this.f = c.a(getContext(), false);
                getContentLayer().addView(this.f, new LayoutParams(-1, -1));
            }
            this.f.setAlpha(0.0f);
            this.f.setBackgroundColor(0);
            this.f.getBackground().setAlpha(0);
            this.f.setLongClickListener(new h(this));
            this.f.setWebViewCallback(new x(this, this.f));
            if (this.f.getWebViewSetting() != null) {
                this.f.getWebViewSetting().a();
            }
            if (this.i) {
                m.a(0, new af(this, this.g));
            } else {
                this.f.a(this.g);
            }
            e.a().a((int) R.string.doodle_promtion_page_loading_tip, 1);
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

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 1 || this.f == null || !this.f.c()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.f.d();
        return true;
    }

    static /* synthetic */ void a(p pVar) {
        if (pVar.f != null) {
            pVar.f.animate().alpha(IPictureView.DEFAULT_MIN_SCALE).setDuration(500).start();
        }
    }

    static /* synthetic */ void a(p pVar, String str) {
        Closeable open;
        Throwable th;
        Closeable closeable = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                String c;
                open = pVar.getContext().getAssets().open(str);
                if (open != null) {
                    try {
                        c = a.c(open);
                    } catch (IOException e) {
                        a.a(open);
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        closeable = open;
                        th = th3;
                        a.a(closeable);
                        throw th;
                    }
                }
                m.a(2, new z(pVar, c));
                a.a(open);
            } catch (IOException e2) {
                open = null;
                a.a(open);
            } catch (Throwable th4) {
                th = th4;
                a.a(closeable);
                throw th;
            }
        }
    }
}
