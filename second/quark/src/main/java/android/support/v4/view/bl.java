package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ProGuard */
public abstract class bl {
    private final Context a;
    public ce e;
    public cl f;

    public abstract View c();

    public bl(Context context) {
        this.a = context;
    }

    public View a(MenuItem menuItem) {
        return c();
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void a(SubMenu subMenu) {
    }

    public final void a(boolean z) {
        if (this.e != null) {
            this.e.b(z);
        }
    }

    public void a(cl clVar) {
        if (this.f != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f = clVar;
    }
}
