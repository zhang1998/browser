package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.cl;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

/* compiled from: ProGuard */
final class g extends s implements VisibilityListener {
    cl a;
    final /* synthetic */ v b;

    public g(v vVar, Context context, ActionProvider actionProvider) {
        this.b = vVar;
        super(vVar, context, actionProvider);
    }

    public final View a(MenuItem menuItem) {
        return this.c.onCreateActionView(menuItem);
    }

    public final boolean a() {
        return this.c.overridesItemVisibility();
    }

    public final boolean b() {
        return this.c.isVisible();
    }

    public final void a(cl clVar) {
        this.a = clVar;
        this.c.setVisibilityListener(this);
    }

    public final void onActionProviderVisibilityChanged(boolean z) {
        if (this.a != null) {
            this.a.a();
        }
    }
}
