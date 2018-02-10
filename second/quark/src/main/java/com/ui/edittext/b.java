package com.ui.edittext;

import android.text.Layout;
import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class b implements h {
    public boolean a() {
        return false;
    }

    public void a(Spannable spannable) {
    }

    public final boolean a(TextView textView, Spannable spannable, int i, KeyEvent keyEvent) {
        boolean a = a(textView, spannable, i, a(spannable, keyEvent), keyEvent);
        if (a) {
            g.b(spannable);
            g.c(spannable);
        }
        return a;
    }

    public final boolean a(TextView textView, Spannable spannable, KeyEvent keyEvent) {
        int a = a(spannable, keyEvent);
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 0 || keyEvent.getAction() != 2) {
            return false;
        }
        int repeatCount = keyEvent.getRepeatCount();
        boolean z = false;
        for (int i = 0; i < repeatCount && a(textView, spannable, keyCode, a, keyEvent); i++) {
            z = true;
        }
        if (z) {
            g.b(spannable);
            g.c(spannable);
        }
        return z;
    }

    public void a(TextView textView, Spannable spannable, int i) {
    }

    public boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return false;
    }

    public final boolean a(TextView textView, MotionEvent motionEvent) {
        boolean z = false;
        if ((motionEvent.getSource() & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                float axisValue;
                float f;
                if ((motionEvent.getMetaState() & 1) != 0) {
                    axisValue = motionEvent.getAxisValue(9);
                    f = 0.0f;
                } else {
                    f = -motionEvent.getAxisValue(9);
                    axisValue = motionEvent.getAxisValue(10);
                }
                if (axisValue < 0.0f) {
                    z = a(textView, (int) Math.ceil((double) (-axisValue))) | 0;
                } else if (axisValue > 0.0f) {
                    z = b(textView, (int) Math.ceil((double) axisValue)) | 0;
                }
                if (f < 0.0f) {
                    return z | c(textView, (int) Math.ceil((double) (-f)));
                }
                if (f > 0.0f) {
                    return z | d(textView, (int) Math.ceil((double) f));
                }
                return z;
            default:
                return false;
        }
    }

    private static int a(Spannable spannable, KeyEvent keyEvent) {
        return KeyEvent.normalizeMetaState((keyEvent.getMetaState() | g.a((CharSequence) spannable)) & -1537) & -194;
    }

    protected boolean a(TextView textView, Spannable spannable, int i, int i2, KeyEvent keyEvent) {
        switch (i) {
            case 19:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return c(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return g(textView, spannable);
                }
                break;
            case 20:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return d(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return h(textView, spannable);
                }
                break;
            case 21:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return a(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)) {
                    return k(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return i(textView, spannable);
                }
                break;
            case 22:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return b(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)) {
                    return l(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return j(textView, spannable);
                }
                break;
            case 92:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return e(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return g(textView, spannable);
                }
                break;
            case 93:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return f(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, 2)) {
                    return h(textView, spannable);
                }
                break;
            case 122:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return m(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)) {
                    return g(textView, spannable);
                }
                break;
            case 123:
                if (KeyEvent.metaStateHasNoModifiers(i2)) {
                    return n(textView, spannable);
                }
                if (KeyEvent.metaStateHasModifiers(i2, SpdyProtocol.SLIGHTSSL_0_RTT_MODE)) {
                    return h(textView, spannable);
                }
                break;
        }
        return false;
    }

    protected boolean a(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean b(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean c(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean d(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean e(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean f(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean g(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean h(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean i(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean j(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean k(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean l(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean m(TextView textView, Spannable spannable) {
        return false;
    }

    protected boolean n(TextView textView, Spannable spannable) {
        return false;
    }

    static int a(TextView textView) {
        return textView.getLayout().getLineForVertical(textView.getScrollY());
    }

    static int b(TextView textView) {
        return textView.getLayout().getLineForVertical(textView.getScrollY() + d(textView));
    }

    static int c(TextView textView) {
        return (textView.getWidth() - textView.getTotalPaddingLeft()) - textView.getTotalPaddingRight();
    }

    static int d(TextView textView) {
        return (textView.getHeight() - textView.getTotalPaddingTop()) - textView.getTotalPaddingBottom();
    }

    private static int g(TextView textView) {
        return (int) Math.ceil((double) textView.getPaint().getFontSpacing());
    }

    static int e(TextView textView) {
        Layout layout = textView.getLayout();
        int a = a(textView);
        int b = b(textView);
        if (a > b) {
            return 0;
        }
        int i = Integer.MAX_VALUE;
        int i2 = a;
        while (i2 <= b) {
            a = (int) Math.floor((double) layout.getLineLeft(i2));
            if (a >= i) {
                a = i;
            }
            i2++;
            i = a;
        }
        return i;
    }

    static int f(TextView textView) {
        Layout layout = textView.getLayout();
        int a = a(textView);
        int b = b(textView);
        if (a > b) {
            return 0;
        }
        int i = SectionHeader.SHT_LOUSER;
        int i2 = a;
        while (i2 <= b) {
            a = (int) Math.ceil((double) layout.getLineRight(i2));
            if (a <= i) {
                a = i;
            }
            i2++;
            i = a;
        }
        return i;
    }

    protected final boolean a(TextView textView, int i) {
        int e = e(textView);
        int scrollX = textView.getScrollX();
        if (scrollX <= e) {
            return false;
        }
        textView.scrollTo(Math.max(scrollX - (g(textView) * i), e), textView.getScrollY());
        return true;
    }

    protected final boolean b(TextView textView, int i) {
        int f = f(textView) - c(textView);
        int scrollX = textView.getScrollX();
        if (scrollX >= f) {
            return false;
        }
        textView.scrollTo(Math.min(scrollX + (g(textView) * i), f), textView.getScrollY());
        return true;
    }

    protected static boolean c(TextView textView, int i) {
        Layout layout = textView.getLayout();
        int scrollY = textView.getScrollY();
        int lineForVertical = layout.getLineForVertical(scrollY);
        if (layout.getLineTop(lineForVertical) == scrollY) {
            lineForVertical--;
        }
        if (lineForVertical < 0) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(Math.max((lineForVertical - i) + 1, 0)));
        return true;
    }

    protected static boolean d(TextView textView, int i) {
        Layout layout = textView.getLayout();
        int d = d(textView);
        int scrollY = textView.getScrollY() + d;
        int lineForVertical = layout.getLineForVertical(scrollY);
        if (layout.getLineTop(lineForVertical + 1) < scrollY + 1) {
            lineForVertical++;
        }
        scrollY = layout.getLineCount() - 1;
        if (lineForVertical > scrollY) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(Math.min((lineForVertical + i) - 1, scrollY) + 1) - d);
        return true;
    }
}
