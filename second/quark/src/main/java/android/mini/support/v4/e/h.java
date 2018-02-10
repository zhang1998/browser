package android.mini.support.v4.e;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class h implements g {
    h() {
    }

    public final Object a(Context context, Interpolator interpolator) {
        return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
    }

    public final boolean a(Object obj) {
        return ((Scroller) obj).isFinished();
    }

    public final int b(Object obj) {
        return ((Scroller) obj).getCurrX();
    }

    public final int c(Object obj) {
        return ((Scroller) obj).getCurrY();
    }

    public final float d(Object obj) {
        return 0.0f;
    }

    public final boolean e(Object obj) {
        return ((Scroller) obj).computeScrollOffset();
    }

    public final void a(Object obj, int i, int i2, int i3) {
        ((Scroller) obj).startScroll(0, 0, i, i2, i3);
    }

    public final void a(Object obj, int i, int i2) {
        ((Scroller) obj).fling(0, 0, i, i2, SectionHeader.SHT_LOUSER, Integer.MAX_VALUE, SectionHeader.SHT_LOUSER, Integer.MAX_VALUE);
    }

    public final void f(Object obj) {
        ((Scroller) obj).abortAnimation();
    }

    public final int g(Object obj) {
        return ((Scroller) obj).getFinalX();
    }

    public final int h(Object obj) {
        return ((Scroller) obj).getFinalY();
    }
}
