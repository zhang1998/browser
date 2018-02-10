package android.mini.support.v4.e;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
class i implements g {
    i() {
    }

    public float d(Object obj) {
        return 0.0f;
    }

    public final void a(Object obj, int i, int i2, int i3) {
        ((OverScroller) obj).startScroll(0, 0, i, i2, i3);
    }

    public final void a(Object obj, int i, int i2) {
        ((OverScroller) obj).fling(0, 0, i, i2, SectionHeader.SHT_LOUSER, Integer.MAX_VALUE, SectionHeader.SHT_LOUSER, Integer.MAX_VALUE);
    }

    public final Object a(Context context, Interpolator interpolator) {
        return interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    public final boolean a(Object obj) {
        return ((OverScroller) obj).isFinished();
    }

    public final int b(Object obj) {
        return ((OverScroller) obj).getCurrX();
    }

    public final int c(Object obj) {
        return ((OverScroller) obj).getCurrY();
    }

    public final boolean e(Object obj) {
        return ((OverScroller) obj).computeScrollOffset();
    }

    public final void f(Object obj) {
        ((OverScroller) obj).abortAnimation();
    }

    public final int g(Object obj) {
        return ((OverScroller) obj).getFinalX();
    }

    public final int h(Object obj) {
        return ((OverScroller) obj).getFinalY();
    }
}
