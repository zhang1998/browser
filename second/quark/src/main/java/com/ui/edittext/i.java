package com.ui.edittext;

import android.text.Layout;
import android.text.Spannable;
import android.view.MotionEvent;

/* compiled from: ProGuard */
public class i extends b implements h {
    protected boolean a(TextView textView, Spannable spannable) {
        return a(textView, 1);
    }

    protected boolean b(TextView textView, Spannable spannable) {
        return b(textView, 1);
    }

    protected boolean c(TextView textView, Spannable spannable) {
        return b.c(textView, 1);
    }

    protected boolean d(TextView textView, Spannable spannable) {
        return b.d(textView, 1);
    }

    protected final boolean g(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        if (b.a(textView) < 0) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(0));
        return true;
    }

    protected final boolean m(TextView textView, Spannable spannable) {
        return g(textView, spannable);
    }

    protected final boolean n(TextView textView, Spannable spannable) {
        return h(textView, spannable);
    }

    public boolean a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        return ax.a(textView, spannable, motionEvent);
    }

    public void a(TextView textView, Spannable spannable, int i) {
        Layout layout = textView.getLayout();
        if (!(layout == null || (i & 2) == 0)) {
            textView.scrollTo(textView.getScrollX(), layout.getLineTop(0));
        }
        if (layout != null && (i & 1) != 0) {
            int lineCount = layout.getLineCount() - 1;
            textView.scrollTo(textView.getScrollX(), layout.getLineTop(lineCount + 1) - (textView.getHeight() - (textView.getTotalPaddingTop() + textView.getTotalPaddingBottom())));
        }
    }

    protected final boolean e(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int lineForVertical = layout.getLineForVertical(textView.getScrollY() - b.d(textView));
        if (lineForVertical < 0) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(lineForVertical));
        return true;
    }

    protected final boolean f(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int d = b.d(textView);
        int lineForVertical = layout.getLineForVertical((textView.getScrollY() + d) + d);
        if (lineForVertical > layout.getLineCount() - 1) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(lineForVertical + 1) - d);
        return true;
    }

    protected final boolean h(TextView textView, Spannable spannable) {
        Layout layout = textView.getLayout();
        int lineCount = layout.getLineCount();
        if (b.b(textView) > lineCount - 1) {
            return false;
        }
        ax.a(textView, layout, textView.getScrollX(), layout.getLineTop(lineCount) - b.d(textView));
        return true;
    }

    protected final boolean i(TextView textView, Spannable spannable) {
        int e = b.e(textView);
        if (textView.getScrollX() <= e) {
            return false;
        }
        textView.scrollTo(e, textView.getScrollY());
        return true;
    }

    protected final boolean j(TextView textView, Spannable spannable) {
        int f = b.f(textView) - b.c(textView);
        if (textView.getScrollX() >= f) {
            return false;
        }
        textView.scrollTo(f, textView.getScrollY());
        return true;
    }
}
