package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.View;

/* compiled from: ProGuard */
final class bg extends cp {
    final /* synthetic */ Fragment a;

    bg(Fragment fragment) {
        this.a = fragment;
    }

    @Nullable
    public final View a(int i) {
        if (this.a.M != null) {
            return this.a.M.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }

    public final boolean a() {
        return this.a.M != null;
    }
}
