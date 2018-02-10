package android.support.v7.view;

import android.content.Context;
import android.support.v7.c.i;

/* compiled from: ProGuard */
public final class g {
    public Context a;

    public static g a(Context context) {
        return new g(context);
    }

    private g(Context context) {
        this.a = context;
    }

    public final boolean a() {
        if (this.a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.a.getResources().getBoolean(i.abc_action_bar_embed_tabs);
        }
        return this.a.getResources().getBoolean(i.abc_action_bar_embed_tabs_pre_jb);
    }
}
