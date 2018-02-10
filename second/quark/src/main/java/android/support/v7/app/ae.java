package android.support.v7.app;

import android.content.Context;
import android.view.ContextThemeWrapper;

/* compiled from: ProGuard */
public final class ae {
    public final b a;
    public int b;

    public ae(Context context) {
        this(context, ap.a(context, 0));
    }

    private ae(Context context, int i) {
        this.a = new b(new ContextThemeWrapper(context, ap.a(context, i)));
        this.b = i;
    }
}
