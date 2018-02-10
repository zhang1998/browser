package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.g;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ProGuard */
public final class a extends u implements SubMenu {
    public u a;
    private i m;

    public a(Context context, u uVar, i iVar) {
        super(context);
        this.a = uVar;
        this.m = iVar;
    }

    public final void setQwertyMode(boolean z) {
        this.a.setQwertyMode(z);
    }

    public final boolean a() {
        return this.a.a();
    }

    public final boolean b() {
        return this.a.b();
    }

    public final MenuItem getItem() {
        return this.m;
    }

    public final void a(z zVar) {
        this.a.a(zVar);
    }

    public final u c() {
        return this.a;
    }

    final boolean a(u uVar, MenuItem menuItem) {
        return super.a(uVar, menuItem) || this.a.a(uVar, menuItem);
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.m.setIcon(drawable);
        return this;
    }

    public final SubMenu setIcon(int i) {
        this.m.setIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        super.a(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        super.a(null, null, view);
        return this;
    }

    public final boolean a(i iVar) {
        return this.a.a(iVar);
    }

    public final boolean b(i iVar) {
        return this.a.b(iVar);
    }

    public final String d() {
        int itemId = this.m != null ? this.m.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.d() + ":" + itemId;
    }

    public final SubMenu setHeaderIcon(int i) {
        super.a(g.a(this.b, i));
        return this;
    }

    public final SubMenu setHeaderTitle(int i) {
        super.a(this.b.getResources().getString(i));
        return this;
    }
}
