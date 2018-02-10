package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.d.o;

/* compiled from: ProGuard */
final class dt extends o<Integer, PorterDuffColorFilter> {
    static int a(int i, Mode mode) {
        return ((i + 31) * 31) + mode.hashCode();
    }
}
