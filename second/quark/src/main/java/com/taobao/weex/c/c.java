package com.taobao.weex.c;

import android.text.TextPaint;
import com.taobao.weex.utils.WXViewUtils;
import com.taobao.weex.utils.r;

/* compiled from: ProGuard */
public class c extends ae {
    private TextPaint l = new TextPaint();
    private int y = -1;

    public c() {
        this.l.setTextSize(WXViewUtils.a(32.0f, this.o));
        a(new b(this));
    }

    public final void a() {
        super.a();
        d();
    }

    protected final float b() {
        return (this.y == -1 || this.y <= 0) ? this.l.getFontMetrics(null) : (float) this.y;
    }

    protected float c() {
        return b();
    }

    protected void d() {
        if (g().size() > 0) {
            int a;
            int d;
            int c;
            String str = null;
            if (g().containsKey("fontSize")) {
                a = ao.a(g(), this.o);
            } else {
                a = -1;
            }
            if (g().containsKey("fontFamily")) {
                str = ao.e(g());
            } else if (r.a() != null) {
                str = "@default_font_family";
            }
            if (g().containsKey("fontStyle")) {
                d = ao.d(g());
            } else {
                d = -1;
            }
            if (g().containsKey("fontWeight")) {
                c = ao.c(g());
            } else {
                c = -1;
            }
            int b = ao.b(g(), this.o);
            if (b != -1) {
                this.y = b;
            }
            if (a != -1) {
                this.l.setTextSize((float) a);
            }
            if (str != null) {
                r.a(this.l, d, c, str);
            }
            h();
        }
    }
}
