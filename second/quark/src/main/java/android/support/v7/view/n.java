package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.u;
import android.support.v7.view.menu.z;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: ProGuard */
public final class n extends h implements z {
    private Context c;
    private ActionBarContextView d;
    private d e;
    private WeakReference<View> f;
    private boolean g;
    private boolean h;
    private u i;

    public n(Context context, ActionBarContextView actionBarContextView, d dVar, boolean z) {
        this.c = context;
        this.d = actionBarContextView;
        this.e = dVar;
        u uVar = new u(actionBarContextView.getContext());
        this.i = uVar;
        this.i.a((z) this);
        this.h = z;
    }

    public final void a(CharSequence charSequence) {
        this.d.setTitle(charSequence);
    }

    public final void b(CharSequence charSequence) {
        this.d.setSubtitle(charSequence);
    }

    public final void a(int i) {
        a(this.c.getString(i));
    }

    public final void b(int i) {
        b(this.c.getString(i));
    }

    public final void a(boolean z) {
        super.a(z);
        this.d.setTitleOptional(z);
    }

    public final boolean a() {
        return this.d.b;
    }

    public final void a(View view) {
        this.d.setCustomView(view);
        this.f = view != null ? new WeakReference(view) : null;
    }

    public final void b() {
        this.e.b(this, this.i);
    }

    public final void c() {
        if (!this.g) {
            this.g = true;
            this.d.sendAccessibilityEvent(32);
            this.e.a(this);
        }
    }

    public final Menu d() {
        return this.i;
    }

    public final CharSequence e() {
        return this.d.getTitle();
    }

    public final CharSequence f() {
        return this.d.getSubtitle();
    }

    public final View g() {
        return this.f != null ? (View) this.f.get() : null;
    }

    public final MenuInflater h() {
        return new i(this.d.getContext());
    }

    public final boolean a(u uVar, MenuItem menuItem) {
        return this.e.a((h) this, menuItem);
    }

    public final void a(u uVar) {
        b();
        this.d.b();
    }
}
