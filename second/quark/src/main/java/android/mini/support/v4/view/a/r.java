package android.mini.support.v4.view.a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.uc.crashsdk.export.LogType;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class r {
    public static final j a;
    public final Object b;

    static {
        if (VERSION.SDK_INT >= 24) {
            a = new h();
        } else if (VERSION.SDK_INT >= 22) {
            a = new g();
        } else if (VERSION.SDK_INT >= 21) {
            a = new f();
        } else if (VERSION.SDK_INT >= 19) {
            a = new n();
        } else if (VERSION.SDK_INT >= 18) {
            a = new m();
        } else if (VERSION.SDK_INT >= 17) {
            a = new l();
        } else if (VERSION.SDK_INT >= 16) {
            a = new k();
        } else if (VERSION.SDK_INT >= 14) {
            a = new i();
        } else {
            a = new o();
        }
    }

    public r(Object obj) {
        this.b = obj;
    }

    public final void a(int i) {
        a.a(this.b, i);
    }

    public final void a(boolean z) {
        a.a(this.b, z);
    }

    public final void a(CharSequence charSequence) {
        a.a(this.b, charSequence);
    }

    public final void a(Object obj) {
        a.b(this.b, ((q) obj).a);
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
        r rVar = (r) obj;
        if (this.b == null) {
            if (rVar.b != null) {
                return false;
            }
            return true;
        } else if (this.b.equals(rVar.b)) {
            return true;
        } else {
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        Rect rect = new Rect();
        a.a(this.b, rect);
        stringBuilder.append("; boundsInParent: " + rect);
        a.b(this.b, rect);
        stringBuilder.append("; boundsInScreen: " + rect);
        stringBuilder.append("; packageName: ").append(a.d(this.b));
        stringBuilder.append("; className: ").append(a.b(this.b));
        stringBuilder.append("; text: ").append(a.e(this.b));
        stringBuilder.append("; contentDescription: ").append(a.c(this.b));
        stringBuilder.append("; viewId: ").append(a.p(this.b));
        stringBuilder.append("; checkable: ").append(a.f(this.b));
        stringBuilder.append("; checked: ").append(a.g(this.b));
        stringBuilder.append("; focusable: ").append(a.j(this.b));
        stringBuilder.append("; focused: ").append(a.k(this.b));
        stringBuilder.append("; selected: ").append(a.o(this.b));
        stringBuilder.append("; clickable: ").append(a.h(this.b));
        stringBuilder.append("; longClickable: ").append(a.l(this.b));
        stringBuilder.append("; enabled: ").append(a.i(this.b));
        stringBuilder.append("; password: ").append(a.m(this.b));
        stringBuilder.append("; scrollable: " + a.n(this.b));
        stringBuilder.append("; [");
        int a = a.a(this.b);
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
