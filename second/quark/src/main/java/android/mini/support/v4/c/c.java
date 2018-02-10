package android.mini.support.v4.c;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public final class c {
    public static <T> Creator<T> a(d<T> dVar) {
        return VERSION.SDK_INT >= 13 ? new e(dVar) : new b(dVar);
    }
}
