package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.e.a.c;
import android.support.v7.view.menu.ac;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
/* compiled from: ProGuard */
public final class b extends ActionMode {
    final Context a;
    final h b;

    public b(Context context, h hVar) {
        this.a = context;
        this.b = hVar;
    }

    public final Object getTag() {
        return this.b.a;
    }

    public final void setTag(Object obj) {
        this.b.a = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    public final void invalidate() {
        this.b.b();
    }

    public final void finish() {
        this.b.c();
    }

    public final Menu getMenu() {
        return ac.a(this.a, (c) this.b.d());
    }

    public final CharSequence getTitle() {
        return this.b.e();
    }

    public final void setTitle(int i) {
        this.b.a(i);
    }

    public final CharSequence getSubtitle() {
        return this.b.f();
    }

    public final void setSubtitle(int i) {
        this.b.b(i);
    }

    public final View getCustomView() {
        return this.b.g();
    }

    public final void setCustomView(View view) {
        this.b.a(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.b.h();
    }

    public final boolean getTitleOptionalHint() {
        return this.b.b;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }

    public final boolean isTitleOptional() {
        return this.b.a();
    }
}
