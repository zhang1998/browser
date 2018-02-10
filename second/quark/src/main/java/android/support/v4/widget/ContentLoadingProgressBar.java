package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* compiled from: ProGuard */
public class ContentLoadingProgressBar extends ProgressBar {
    private long a = -1;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private final Runnable e = new bm(this);
    private final Runnable f = new bb(this);

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    private void a() {
        removeCallbacks(this.e);
        removeCallbacks(this.f);
    }
}
