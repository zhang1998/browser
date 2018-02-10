package com.uc.weex.component.richtext;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import com.taobao.weex.c.ae;
import com.taobao.weex.c.ao;
import com.taobao.weex.c.v;
import com.taobao.weex.i;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class aa extends ae {
    private static String A = "displayCount";
    private static String B = "customEllipsis";
    private static Map<Integer, LightingColorFilter> C;
    private int D;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private int H = -1;
    private int I = -1;
    private boolean J;
    private String K = null;
    private ColorFilter L;
    private List<x> M = new ArrayList();
    private String N;
    private a O = new a();
    Spanned l;
    Layout y;
    w z;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return c();
    }

    public final /* synthetic */ ae v() {
        return c();
    }

    public aa() {
        a(new y());
    }

    public final void a() {
        String a;
        if (i() != null) {
            a = v.a(i());
        } else {
            a = null;
        }
        ao g = g();
        if (g != null) {
            if (g.containsKey("filterColor")) {
                b((String) g.get("filterColor"));
            } else if (g.containsKey("filtercolor")) {
                b((String) g.get("filtercolor"));
            }
        }
        if (i().containsKey(A)) {
            try {
                this.I = Integer.parseInt(i().get(A));
            } catch (Throwable e) {
                if (i.c()) {
                    WXLogUtils.e("WXTextDomObject updateAttr error: ", e);
                }
            }
        }
        a(a);
        super.h();
    }

    public final Object q() {
        return this.y;
    }

    public final void a(Map<String, Object> map) {
        super.a((Map) map);
        if (map.containsKey(A)) {
            try {
                int parseInt = Integer.parseInt(map.get(A));
                if (this.I != parseInt) {
                    this.J = true;
                    this.I = parseInt;
                } else {
                    this.J = false;
                }
            } catch (Throwable e) {
                if (i.c()) {
                    WXLogUtils.e("WXTextDomObject updateAttr error: ", e);
                }
            }
        }
        if (map.containsKey("value")) {
            a(v.a((Map) map));
        } else {
            a(v.a(i()));
        }
    }

    private aa c() {
        aa aaVar;
        Throwable e;
        try {
            aaVar = new aa();
            try {
                a((ae) aaVar);
                aaVar.l = this.l;
                aaVar.y = this.y;
                aaVar.L = this.L;
                aaVar.M = this.M;
            } catch (Exception e2) {
                e = e2;
                if (i.c()) {
                    WXLogUtils.e("WXTextDomObject clone error: ", e);
                }
                return aaVar;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            aaVar = null;
            e = th;
            if (i.c()) {
                WXLogUtils.e("WXTextDomObject clone error: ", e);
            }
            return aaVar;
        }
        return aaVar;
    }

    final TextPaint b() {
        Resources resources = i.e().getResources();
        Paint textPaint = new TextPaint(1);
        textPaint.density = resources.getDisplayMetrics().density;
        textPaint.setTextSize((float) ao.a(g(), this.o));
        String b = ao.b(g());
        if (b.length() > 0) {
            textPaint.setColor(af.a(b));
        }
        r.a(textPaint, this.G, this.H, this.K);
        return textPaint;
    }

    private void a(String str) {
        int i = 0;
        if (str == null || str.trim().length() == 0) {
            this.l = null;
            this.D = 0;
            return;
        }
        int c;
        int hashCode = str.hashCode();
        if (this.D != hashCode) {
            this.D = hashCode;
            i = 1;
        }
        if (this.J) {
            i = 1;
        }
        String a = i().a(B);
        if (!(a == null || a.equals(this.N))) {
            this.N = a;
            i = 1;
        }
        hashCode = ao.a(g(), this.o);
        if (this.E != hashCode) {
            this.E = hashCode;
            i = 1;
        }
        hashCode = ao.b(g(), this.o);
        if (this.F != hashCode) {
            this.F = hashCode;
            i = 1;
        }
        if (g().containsKey("fontWeight")) {
            c = ao.c(g());
            if (this.H != c) {
                this.H = c;
                i = 1;
            }
        }
        if (g().containsKey("fontStyle")) {
            c = ao.d(g());
            if (this.G != c) {
                this.G = c;
                i = 1;
            }
        }
        String replaceAll;
        if (g().containsKey("fontFamily")) {
            String e = ao.e(g());
            if (!(e == null || e.equals(this.K))) {
                this.K = e;
            }
            if (i == 0) {
                replaceAll = str.replaceAll("[\n|\t]", "");
                if (!replaceAll.startsWith("<html>")) {
                    replaceAll = "<html>" + replaceAll;
                }
                if (!replaceAll.endsWith("</html>")) {
                    replaceAll = replaceAll + "</html>";
                }
                try {
                    this.l = e.a(this.O.a(replaceAll, b().getFontMetrics()), new z(), hashCode, this.I, this.N);
                } catch (Exception e2) {
                    this.l = new SpannableStringBuilder();
                    replaceAll = e2.getMessage();
                    if (this.z != null && this.z.a() != null) {
                        this.z.a().a(this.z.getInstance(), "rich_text_paser_error", replaceAll);
                        return;
                    }
                    return;
                }
            }
        }
        if (!(r.a() == null || "@default_font_family".equals(this.K))) {
            this.K = "@default_font_family";
        }
        if (i == 0) {
            replaceAll = str.replaceAll("[\n|\t]", "");
            if (replaceAll.startsWith("<html>")) {
                replaceAll = "<html>" + replaceAll;
            }
            if (replaceAll.endsWith("</html>")) {
                replaceAll = replaceAll + "</html>";
            }
            this.l = e.a(this.O.a(replaceAll, b().getFontMetrics()), new z(), hashCode, this.I, this.N);
        }
        i = 1;
        if (i == 0) {
            replaceAll = str.replaceAll("[\n|\t]", "");
            if (replaceAll.startsWith("<html>")) {
                replaceAll = "<html>" + replaceAll;
            }
            if (replaceAll.endsWith("</html>")) {
                replaceAll = replaceAll + "</html>";
            }
            this.l = e.a(this.O.a(replaceAll, b().getFontMetrics()), new z(), hashCode, this.I, this.N);
        }
    }

    private void d() {
        if (this.M != null && !this.M.isEmpty()) {
            for (x a : this.M) {
                a.a(this.L);
            }
        }
    }

    private void b(String str) {
        ColorFilter colorFilter;
        if (str == null || str.trim().length() == 0 || "none".equalsIgnoreCase(str)) {
            colorFilter = null;
        } else {
            if (C == null) {
                C = new HashMap();
            }
            int a = af.a(str);
            LightingColorFilter lightingColorFilter = (LightingColorFilter) C.get(Integer.valueOf(a));
            if (lightingColorFilter == null) {
                colorFilter = new LightingColorFilter(a, 0);
                C.put(Integer.valueOf(a), colorFilter);
            }
        }
        if (colorFilter != this.L) {
            this.L = colorFilter;
            d();
        }
    }
}
