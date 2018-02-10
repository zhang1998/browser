package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.e.a.b;
import android.support.v4.view.ba;
import android.support.v4.view.bl;
import android.support.v7.widget.fb;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

/* compiled from: ProGuard */
public final class i implements b {
    static String f;
    static String g;
    static String h;
    static String i;
    final int a;
    u b;
    int c = 0;
    public bl d;
    ContextMenuInfo e;
    private final int j;
    private final int k;
    private final int l;
    private CharSequence m;
    private CharSequence n;
    private Intent o;
    private char p;
    private char q;
    private Drawable r;
    private int s = 0;
    private a t;
    private Runnable u;
    private OnMenuItemClickListener v;
    private int w = 16;
    private View x;
    private ba y;
    private boolean z = false;

    public final /* synthetic */ MenuItem setActionView(View view) {
        return a(view);
    }

    i(u uVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.b = uVar;
        this.j = i2;
        this.k = i;
        this.l = i3;
        this.a = i4;
        this.m = charSequence;
        this.c = i5;
    }

    public final boolean b() {
        if ((this.v != null && this.v.onMenuItemClick(this)) || this.b.a(this.b.c(), (MenuItem) this)) {
            return true;
        }
        if (this.u != null) {
            this.u.run();
            return true;
        }
        if (this.o != null) {
            try {
                this.b.b.startActivity(this.o);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.d == null || !this.d.d()) {
            return false;
        }
        return true;
    }

    public final boolean isEnabled() {
        return (this.w & 16) != 0;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.w |= 16;
        } else {
            this.w &= -17;
        }
        this.b.b(false);
        return this;
    }

    public final int getGroupId() {
        return this.k;
    }

    @CapturedViewProperty
    public final int getItemId() {
        return this.j;
    }

    public final int getOrder() {
        return this.l;
    }

    public final Intent getIntent() {
        return this.o;
    }

    public final MenuItem setIntent(Intent intent) {
        this.o = intent;
        return this;
    }

    public final char getAlphabeticShortcut() {
        return this.q;
    }

    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.q != c) {
            this.q = Character.toLowerCase(c);
            this.b.b(false);
        }
        return this;
    }

    public final char getNumericShortcut() {
        return this.p;
    }

    public final MenuItem setNumericShortcut(char c) {
        if (this.p != c) {
            this.p = c;
            this.b.b(false);
        }
        return this;
    }

    public final MenuItem setShortcut(char c, char c2) {
        this.p = c;
        this.q = Character.toLowerCase(c2);
        this.b.b(false);
        return this;
    }

    final char c() {
        return this.b.a() ? this.q : this.p;
    }

    final boolean d() {
        return this.b.b() && c() != '\u0000';
    }

    public final SubMenu getSubMenu() {
        return this.t;
    }

    public final boolean hasSubMenu() {
        return this.t != null;
    }

    public final void a(a aVar) {
        this.t = aVar;
        aVar.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public final CharSequence getTitle() {
        return this.m;
    }

    final CharSequence a(k kVar) {
        return (kVar == null || !kVar.a()) ? getTitle() : getTitleCondensed();
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.m = charSequence;
        this.b.b(false);
        if (this.t != null) {
            this.t.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitle(int i) {
        return setTitle(this.b.b.getString(i));
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.n != null ? this.n : this.m;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.n = charSequence;
        this.b.b(false);
        return this;
    }

    public final Drawable getIcon() {
        if (this.r != null) {
            return this.r;
        }
        if (this.s == 0) {
            return null;
        }
        Drawable a = fb.a().a(this.b.b, this.s, false);
        this.s = 0;
        this.r = a;
        return a;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.s = 0;
        this.r = drawable;
        this.b.b(false);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.r = null;
        this.s = i;
        this.b.b(false);
        return this;
    }

    public final boolean isCheckable() {
        return (this.w & 1) == 1;
    }

    public final MenuItem setCheckable(boolean z) {
        int i = this.w;
        this.w = (z ? 1 : 0) | (this.w & -2);
        if (i != this.w) {
            this.b.b(false);
        }
        return this;
    }

    public final void a(boolean z) {
        this.w = (z ? 4 : 0) | (this.w & -5);
    }

    public final boolean e() {
        return (this.w & 4) != 0;
    }

    public final boolean isChecked() {
        return (this.w & 2) == 2;
    }

    public final MenuItem setChecked(boolean z) {
        if ((this.w & 4) != 0) {
            u uVar = this.b;
            int groupId = getGroupId();
            int size = uVar.d.size();
            for (int i = 0; i < size; i++) {
                i iVar = (i) uVar.d.get(i);
                if (iVar.getGroupId() == groupId && iVar.e() && iVar.isCheckable()) {
                    iVar.e(iVar == this);
                }
            }
        } else {
            e(z);
        }
        return this;
    }

    private void e(boolean z) {
        int i;
        int i2 = this.w;
        int i3 = this.w & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.w = i | i3;
        if (i2 != this.w) {
            this.b.b(false);
        }
    }

    public final boolean isVisible() {
        if (this.d == null || !this.d.a()) {
            if ((this.w & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.w & 8) == 0 && this.d.b()) {
            return true;
        } else {
            return false;
        }
    }

    final boolean b(boolean z) {
        int i = this.w;
        this.w = (z ? 0 : 8) | (this.w & -9);
        if (i != this.w) {
            return true;
        }
        return false;
    }

    public final MenuItem setVisible(boolean z) {
        if (b(z)) {
            this.b.g();
        }
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.v = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        return this.m != null ? this.m.toString() : null;
    }

    public final ContextMenuInfo getMenuInfo() {
        return this.e;
    }

    public final boolean f() {
        return (this.w & 32) == 32;
    }

    public final boolean g() {
        return (this.c & 1) == 1;
    }

    public final boolean h() {
        return (this.c & 2) == 2;
    }

    public final void c(boolean z) {
        if (z) {
            this.w |= 32;
        } else {
            this.w &= -33;
        }
    }

    public final void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.c = i;
                this.b.h();
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    private b a(View view) {
        this.x = view;
        this.d = null;
        if (view != null && view.getId() == -1 && this.j > 0) {
            view.setId(this.j);
        }
        this.b.h();
        return this;
    }

    public final View getActionView() {
        if (this.x != null) {
            return this.x;
        }
        if (this.d == null) {
            return null;
        }
        this.x = this.d.a((MenuItem) this);
        return this.x;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final bl a() {
        return this.d;
    }

    public final b a(bl blVar) {
        if (this.d != null) {
            bl blVar2 = this.d;
            blVar2.f = null;
            blVar2.e = null;
        }
        this.x = null;
        this.d = blVar;
        this.b.b(true);
        if (this.d != null) {
            this.d.a(new p(this));
        }
        return this;
    }

    public final boolean expandActionView() {
        if (!i()) {
            return false;
        }
        if (this.y == null || this.y.a(this)) {
            return this.b.a(this);
        }
        return false;
    }

    public final boolean collapseActionView() {
        if ((this.c & 8) == 0) {
            return false;
        }
        if (this.x == null) {
            return true;
        }
        if (this.y == null || this.y.b(this)) {
            return this.b.b(this);
        }
        return false;
    }

    public final b a(ba baVar) {
        this.y = baVar;
        return this;
    }

    public final boolean i() {
        if ((this.c & 8) == 0) {
            return false;
        }
        if (this.x == null && this.d != null) {
            this.x = this.d.a((MenuItem) this);
        }
        if (this.x != null) {
            return true;
        }
        return false;
    }

    public final void d(boolean z) {
        this.z = z;
        this.b.b(false);
    }

    public final boolean isActionViewExpanded() {
        return this.z;
    }

    public final MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public final /* synthetic */ MenuItem setActionView(int i) {
        Context context = this.b.b;
        a(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    public final /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }
}
