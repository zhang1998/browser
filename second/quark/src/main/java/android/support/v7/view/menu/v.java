package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.e.a.b;
import android.view.ActionProvider;

@TargetApi(16)
/* compiled from: ProGuard */
final class v extends ab {
    v(Context context, b bVar) {
        super(context, bVar);
    }

    final s a(ActionProvider actionProvider) {
        return new g(this, this.b, actionProvider);
    }
}
