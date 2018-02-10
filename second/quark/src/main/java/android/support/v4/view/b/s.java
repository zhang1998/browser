package android.support.v4.view.b;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class s {
    public static final t a;
    public final Object b;

    static {
        if (VERSION.SDK_INT >= 22) {
            a = new i();
        } else if (VERSION.SDK_INT >= 21) {
            a = new z();
        } else if (VERSION.SDK_INT >= 19) {
            a = new m();
        } else if (VERSION.SDK_INT >= 18) {
            a = new ag();
        } else if (VERSION.SDK_INT >= 17) {
            a = new ae();
        } else if (VERSION.SDK_INT >= 16) {
            a = new u();
        } else if (VERSION.SDK_INT >= 14) {
            a = new o();
        } else {
            a = new aa();
        }
    }

    public s(Object obj) {
        this.b = obj;
    }

    public static s a(s sVar) {
        Object a = a.a(sVar.b);
        if (a != null) {
            return new s(a);
        }
        return null;
    }

    public final void a(View view) {
        a.c(this.b, view);
    }

    public final void b(View view) {
        a.a(this.b, view);
    }

    public final int a() {
        return a.b(this.b);
    }

    public final void a(int i) {
        a.a(this.b, i);
    }

    public final boolean a(h hVar) {
        return a.c(this.b, hVar.w);
    }

    public final void c(View view) {
        a.b(this.b, view);
    }

    public final void a(Rect rect) {
        a.a(this.b, rect);
    }

    public final void b(Rect rect) {
        a.c(this.b, rect);
    }

    public final void c(Rect rect) {
        a.b(this.b, rect);
    }

    public final void d(Rect rect) {
        a.d(this.b, rect);
    }

    public final boolean b() {
        return a.k(this.b);
    }

    public final void a(boolean z) {
        a.c(this.b, z);
    }

    public final boolean c() {
        return a.l(this.b);
    }

    public final void b(boolean z) {
        a.d(this.b, z);
    }

    public final boolean d() {
        return a.s(this.b);
    }

    public final void c(boolean z) {
        a.h(this.b, z);
    }

    public final boolean e() {
        return a.t(this.b);
    }

    public final void d(boolean z) {
        a.i(this.b, z);
    }

    public final boolean f() {
        return a.p(this.b);
    }

    public final void e(boolean z) {
        a.g(this.b, z);
    }

    public final boolean g() {
        return a.i(this.b);
    }

    public final void f(boolean z) {
        a.a(this.b, z);
    }

    public final boolean h() {
        return a.m(this.b);
    }

    public final void g(boolean z) {
        a.e(this.b, z);
    }

    public final boolean i() {
        return a.j(this.b);
    }

    public final void h(boolean z) {
        a.b(this.b, z);
    }

    public final void i(boolean z) {
        a.f(this.b, z);
    }

    public final CharSequence j() {
        return a.e(this.b);
    }

    public final void a(CharSequence charSequence) {
        a.c(this.b, charSequence);
    }

    public final CharSequence k() {
        return a.c(this.b);
    }

    public final void b(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public final CharSequence l() {
        return a.d(this.b);
    }

    public final void c(CharSequence charSequence) {
        a.b(this.b, charSequence);
    }

    public final void m() {
        a.q(this.b);
    }

    public final void a(Object obj) {
        a.b(this.b, ((l) obj).a);
    }

    public final int hashCode() {
        return this.b == null ? 0 : this.b.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.b == null) {
            if (sVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(sVar.b)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a(rect);
        stringBuilder.append("; boundsInParent: " + rect);
        c(rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(j());
        stringBuilder.append("; className: ").append(k());
        stringBuilder.append("; text: ").append(a.f(this.b));
        stringBuilder.append("; contentDescription: ").append(l());
        stringBuilder.append("; viewId: ").append(a.u(this.b));
        stringBuilder.append("; checkable: ").append(a.g(this.b));
        stringBuilder.append("; checked: ").append(a.h(this.b));
        stringBuilder.append("; focusable: ").append(b());
        stringBuilder.append("; focused: ").append(c());
        stringBuilder.append("; selected: ").append(f());
        stringBuilder.append("; clickable: ").append(g());
        stringBuilder.append("; longClickable: ").append(h());
        stringBuilder.append("; enabled: ").append(i());
        stringBuilder.append("; password: ").append(a.n(this.b));
        stringBuilder.append("; scrollable: " + a.o(this.b));
        stringBuilder.append("; [");
        int a = a();
        while (a != 0) {
            String str;
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(a);
            int i = (numberOfTrailingZeros ^ -1) & a;
            switch (numberOfTrailingZeros) {
                case 1:
                    str = "ACTION_FOCUS";
                    break;
                case 2:
                    str = "ACTION_CLEAR_FOCUS";
                    break;
                case 4:
                    str = "ACTION_SELECT";
                    break;
                case 8:
                    str = "ACTION_CLEAR_SELECTION";
                    break;
                case 16:
                    str = "ACTION_CLICK";
                    break;
                case 32:
                    str = "ACTION_LONG_CLICK";
                    break;
                case 64:
                    str = "ACTION_ACCESSIBILITY_FOCUS";
                    break;
                case 128:
                    str = "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    break;
                case LogType.UNEXP /*256*/:
                    str = "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    break;
                case 512:
                    str = "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    break;
                case 1024:
                    str = "ACTION_NEXT_HTML_ELEMENT";
                    break;
                case 2048:
                    str = "ACTION_PREVIOUS_HTML_ELEMENT";
                    break;
                case SpdyProtocol.SLIGHTSSL_0_RTT_MODE /*4096*/:
                    str = "ACTION_SCROLL_FORWARD";
                    break;
                case SpdyProtocol.SLIGHTSSL_1_RTT_MODE /*8192*/:
                    str = "ACTION_SCROLL_BACKWARD";
                    break;
                case 16384:
                    str = "ACTION_COPY";
                    break;
                case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                    str = "ACTION_PASTE";
                    break;
                case 65536:
                    str = "ACTION_CUT";
                    break;
                case 131072:
                    str = "ACTION_SET_SELECTION";
                    break;
                default:
                    str = "ACTION_UNKNOWN";
                    break;
            }
            stringBuilder.append(str);
            if (i != 0) {
                stringBuilder.append(", ");
            }
            a = i;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
