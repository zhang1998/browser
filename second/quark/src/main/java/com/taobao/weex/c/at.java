package com.taobao.weex.c;

import android.graphics.Canvas;
import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.ForegroundColorSpan;
import com.taobao.weex.c.b.c;
import com.taobao.weex.c.b.j;
import com.taobao.weex.c.b.o;
import com.taobao.weex.i;
import com.taobao.weex.ui.component.bu;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.af;
import com.taobao.weex.utils.r;
import com.taobao.weex.utils.t;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ProGuard */
public class at extends ae {
    static final j l = new ar();
    private static final Canvas y = new Canvas();
    private boolean A = false;
    private int B;
    private int C = -1;
    private int D = -1;
    private int E = -1;
    private int F = -1;
    private int G = -1;
    private float H = Float.NaN;
    private String I = null;
    private String J = null;
    private TruncateAt K;
    private Alignment L;
    private int M = bu.b;
    private TextPaint N = new TextPaint();
    @Nullable
    private Spanned O;
    @Nullable
    private Layout P;
    private AtomicReference<Layout> Q = new AtomicReference();
    private boolean z = false;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return b();
    }

    public final /* synthetic */ ae v() {
        return b();
    }

    public at() {
        this.N.setFlags(1);
        a(l);
    }

    public final void a() {
        this.A = false;
        d();
        this.O = a(this.J);
        super.h();
        super.a();
    }

    public final void s() {
        if (!this.A) {
            d();
            c();
        } else if (!(this.P == null || o.a(t.a(this), this.H))) {
            c();
        }
        this.A = false;
        if (!(this.P == null || this.P.equals(this.Q.get()) || VERSION.SDK_INT < 19)) {
            a(this.P);
        }
        x();
        super.s();
    }

    public final void a(Map<String, Object> map) {
        x();
        super.a((Map) map);
        if (map.containsKey("value")) {
            this.J = v.a((Map) map);
        }
    }

    public final void b(Map<String, Object> map) {
        x();
        super.b((Map) map);
        c((Map) map);
    }

    private at b() {
        at atVar;
        Throwable e;
        try {
            atVar = new at();
            try {
                a((ae) atVar);
                atVar.A = this.A;
                atVar.Q = this.Q;
            } catch (Exception e2) {
                e = e2;
                if (i.c()) {
                    WXLogUtils.e("WXTextDomObject clone error: ", e);
                }
                if (atVar != null) {
                    atVar.O = this.O;
                }
                return atVar;
            }
        } catch (Exception e3) {
            e = e3;
            atVar = null;
            if (i.c()) {
                WXLogUtils.e("WXTextDomObject clone error: ", e);
            }
            if (atVar != null) {
                atVar.O = this.O;
            }
            return atVar;
        }
        if (atVar != null) {
            atVar.O = this.O;
        }
        return atVar;
    }

    private void c() {
        float a = t.a(this);
        if (a > 0.0f) {
            this.O = a(this.J);
            this.P = a(a, true, this.P);
            this.H = (float) this.P.getWidth();
        }
    }

    private void d() {
        c(g());
        this.J = v.a(i());
    }

    private void c(Map<String, Object> map) {
        if (map != null) {
            int h;
            if (map.containsKey("lines")) {
                h = ao.h(map);
                if (h > 0) {
                    this.E = h;
                }
            }
            if (map.containsKey("fontSize")) {
                this.F = ao.a((Map) map, this.o);
            }
            if (map.containsKey("fontWeight")) {
                this.D = ao.c(map);
            }
            if (map.containsKey("fontStyle")) {
                this.C = ao.d(map);
            }
            if (map.containsKey("color")) {
                this.B = af.a(ao.b(map));
                this.z = this.B != SectionHeader.SHT_LOUSER;
            }
            if (map.containsKey("textDecoration")) {
                this.M = ao.a((Map) map);
            }
            if (map.containsKey("fontFamily")) {
                this.I = ao.e(map);
            } else if (r.a() != null) {
                this.I = "@default_font_family";
            }
            this.L = ao.f(map);
            this.K = ao.g(map);
            h = ao.b(map, this.o);
            if (h != -1) {
                this.G = h;
            }
        }
    }

    @NonNull
    private Layout a(float f, boolean z, @Nullable Layout layout) {
        float a = a(this.N, f, z);
        if (!o.a(this.H, a) || layout == null) {
            layout = new StaticLayout(this.O, this.N, (int) Math.ceil((double) a), Alignment.ALIGN_NORMAL, IPictureView.DEFAULT_MIN_SCALE, 0.0f, false);
        }
        if (this.E != -1 && this.E > 0 && this.E < layout.getLineCount()) {
            int lineStart = layout.getLineStart(this.E - 1);
            int lineEnd = layout.getLineEnd(this.E - 1);
            if (lineStart < lineEnd) {
                this.O = a(this.J.subSequence(0, lineStart).toString() + a(this.J.substring(lineStart, lineEnd), this.N, layout.getWidth(), this.K));
                return new StaticLayout(this.O, this.N, (int) Math.ceil((double) a), Alignment.ALIGN_NORMAL, IPictureView.DEFAULT_MIN_SCALE, 0.0f, false);
            }
        }
        return layout;
    }

    @NonNull
    private String a(@Nullable String str, @NonNull TextPaint textPaint, int i, @Nullable TruncateAt truncateAt) {
        if (!TextUtils.isEmpty(str)) {
            for (int length = str.length(); length > 0; length--) {
                StringBuilder stringBuilder = new StringBuilder(length + 1);
                stringBuilder.append(str, 0, length);
                if (truncateAt != null) {
                    stringBuilder.append("…");
                }
                CharSequence a = a(stringBuilder.toString());
                if (new StaticLayout(a, textPaint, i, Alignment.ALIGN_NORMAL, IPictureView.DEFAULT_MIN_SCALE, 0.0f, true).getLineCount() <= 1) {
                    return a.toString();
                }
            }
        }
        return "";
    }

    final float a(TextPaint textPaint, float f, boolean z) {
        if (z) {
            return f;
        }
        float desiredWidth = Layout.getDesiredWidth(this.O, textPaint);
        if (c.a(f) || desiredWidth < f) {
            return desiredWidth;
        }
        return f;
    }

    @NonNull
    private Spanned a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        Spannable spannableString = new SpannableString(str);
        a(spannableString);
        return spannableString;
    }

    private void a(Spannable spannable) {
        int length = spannable.length();
        List<as> linkedList = new LinkedList();
        if (length >= 0) {
            if (this.M == bu.c || this.M == bu.d) {
                linkedList.add(new as(length, new u(this.M)));
            }
            if (this.z) {
                linkedList.add(new as(length, new ForegroundColorSpan(this.B)));
            }
            if (this.F != -1) {
                linkedList.add(new as(length, new AbsoluteSizeSpan(this.F)));
            }
            if (!(this.C == -1 && this.D == -1 && this.I == null)) {
                linkedList.add(new as(length, new y(this.C, this.D, this.I)));
            }
            linkedList.add(new as(length, new Standard(this.L)));
            if (this.G != -1) {
                linkedList.add(new as(length, new ak(this.G)));
            }
        }
        if (this.F == -1) {
            linkedList.add(new as(spannable.length(), new AbsoluteSizeSpan(32)));
        }
        Collections.reverse(linkedList);
        for (as a : linkedList) {
            a.a(spannable);
        }
    }

    private void x() {
        if (this.P != null) {
            this.Q.set(this.P);
            this.P = null;
            this.N = new TextPaint(this.N);
        }
    }

    private static boolean a(Layout layout) {
        try {
            layout.draw(y);
            return true;
        } catch (Throwable e) {
            WXLogUtils.eTag(m, e);
            return false;
        }
    }

    public final /* synthetic */ Object q() {
        return (Layout) this.Q.get();
    }
}
