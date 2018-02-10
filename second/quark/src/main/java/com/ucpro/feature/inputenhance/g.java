package com.ucpro.feature.inputenhance;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.quark.browser.R;
import com.uc.webview.browser.BrowserWebView;
import com.ucpro.base.system.b;
import com.ucpro.model.a;
import com.ucpro.ui.edittext.CustomEditText;
import com.ucweb.common.util.c;
import com.ucweb.common.util.h.m;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class g extends Dialog implements v {
    protected boolean a;
    int b = -1;
    boolean c = false;
    public am d;
    s e = null;
    private Context f;
    private View g;
    private boolean h = false;

    static /* synthetic */ boolean a(g gVar) {
        View a = gVar.a();
        if (a != null) {
            BrowserWebView browserWebView = null;
            if (a.getParent() != null && (a.getParent() instanceof BrowserWebView)) {
                browserWebView = (BrowserWebView) a.getParent();
            }
            if (browserWebView != null) {
                gVar.e.a(gVar.e.b, -1);
                return true;
            } else if (((a instanceof EditText) || (a instanceof CustomEditText)) && a.getTag() != null) {
                if (a.getTag().equals(Integer.valueOf(1))) {
                    int i;
                    if (a instanceof EditText) {
                        if (((EditText) a).getText().length() <= 0) {
                            i = 0;
                        } else {
                            i = 1;
                        }
                    } else if (!(a instanceof CustomEditText)) {
                        i = -1;
                    } else if (((CustomEditText) a).getText().length() <= 0) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    gVar.e.a(gVar.e.a, i);
                    return true;
                } else if (a.getTag().equals(Integer.valueOf(2))) {
                    gVar.e.a(gVar.e.c, -1);
                } else {
                    gVar.e.a(gVar.e.b, -1);
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ void d(g gVar) {
        if (gVar.g == null) {
            return;
        }
        if (gVar.g instanceof EditText) {
            ((EditText) gVar.g).addTextChangedListener(new ae(gVar));
        } else if (gVar.g instanceof CustomEditText) {
            ((CustomEditText) gVar.g).a(new ae(gVar));
        }
    }

    public g(Context context, am amVar) {
        super(context, R.style.contextmenu);
        this.f = context;
        this.d = amVar;
        LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= 8;
        attributes.flags |= 131072;
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        getWindow().setAttributes(attributes);
        getWindow().setWindowAnimations(R.style.contextmenu_anim);
        this.e = new s(this.f);
        this.e.setCallback(this);
        setContentView(this.e, new FrameLayout.LayoutParams(b.a.c(), -2));
    }

    final void a(boolean z) {
        this.a = true;
        if (z) {
            if (a.a("flag_addon_clipboard_enabled")) {
                this.e.getClipboardButton().setVisibility(0);
            } else {
                this.e.getClipboardButton().setVisibility(8);
            }
            new o(this).execute(new Object[0]);
            return;
        }
        this.h = true;
        s sVar = this.e;
        if (!(sVar.h == null || sVar.h.isEmpty())) {
            Iterator it = sVar.h.iterator();
            while (it.hasNext()) {
                ValueAnimator valueAnimator = (ValueAnimator) it.next();
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    valueAnimator.cancel();
                }
            }
            sVar.h.clear();
        }
        this.e.b();
        if (this.g instanceof CustomEditText) {
            CustomEditText customEditText = (CustomEditText) this.g;
            customEditText.n();
            customEditText.k();
        }
        this.g = null;
        this.a = false;
        this.c = false;
        this.h = false;
        this.e.a(this.e.b, -1);
        dismiss();
    }

    public final View a() {
        if (m.c()) {
            return k();
        }
        Object aVar = new com.ucpro.b.c.a(new ak(this));
        ((Activity) this.f).runOnUiThread(aVar);
        synchronized (aVar) {
            while (!aVar.a) {
                try {
                    aVar.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return this.g;
    }

    private View k() {
        try {
            if (!(((Activity) this.f).getWindow() == null || ((Activity) this.f).getWindow().getCurrentFocus() == null || !((Activity) this.f).getWindow().getCurrentFocus().hasWindowFocus())) {
                return ((Activity) this.f).getCurrentFocus();
            }
        } catch (Exception e) {
        }
        return null;
    }

    public final void a(int[] iArr) {
        if (this.e != null) {
            this.e.getLocationOnScreen(iArr);
        }
    }

    public final void b() {
        int i = 0;
        Layout layout;
        if (this.g instanceof CustomEditText) {
            CustomEditText customEditText = (CustomEditText) this.g;
            layout = customEditText.getLayout();
            if (layout != null) {
                while (i < 4) {
                    m.a(2, new ac(this, i, layout.getPrimaryHorizontal(customEditText.getSelectionStart()) + ((float) customEditText.getScrollX())), (long) (i * 1));
                    i++;
                }
            }
        } else if (this.g instanceof EditText) {
            EditText editText = (EditText) this.g;
            layout = editText.getLayout();
            if (layout != null) {
                while (i < 4) {
                    m.a(2, new x(this, i, layout.getPrimaryHorizontal(editText.getSelectionStart()) + ((float) editText.getScrollX())), (long) (i * 1));
                    i++;
                }
            }
        }
    }

    public final void c() {
        this.d.d();
    }

    public final void d() {
        this.d.e();
    }

    public final void e() {
        this.d.i();
    }

    public final void f() {
        this.d.j();
    }

    public final void a(String str) {
        this.d.a(str);
    }

    public final void g() {
        Object a = a();
        if (a != null) {
            this.d.a((View) a);
        }
        c.a(a);
    }

    public final void a(int i) {
        this.d.a(i);
    }

    public final void b(int i) {
        this.d.b(i);
    }

    public final void h() {
        this.d.k();
    }

    public final void c(int i) {
        this.d.c(i);
    }

    public final void d(int i) {
        this.d.d(i);
    }

    public final void i() {
    }

    public final void j() {
    }

    public final void a(com.ucpro.feature.z.g.b.a aVar) {
    }
}
