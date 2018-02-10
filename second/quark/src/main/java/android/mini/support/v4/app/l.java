package android.mini.support.v4.app;

import android.mini.support.annotation.Nullable;
import android.view.View;

/* compiled from: ProGuard */
final class l extends r {
    final /* synthetic */ Fragment a;

    l(Fragment fragment) {
        this.a = fragment;
    }

    @Nullable
    public final View a(int i) {
        if (this.a.S != null) {
            return this.a.S.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public final boolean a() {
        return this.a.S != null;
    }
}
