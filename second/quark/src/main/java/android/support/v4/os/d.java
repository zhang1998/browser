package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;

/* compiled from: ProGuard */
public final class d {
    public static <T> Creator<T> a(b<T> bVar) {
        return VERSION.SDK_INT >= 13 ? new a(bVar) : new j(bVar);
    }
}
