package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.annotation.StyleRes;
import android.support.v7.c.b;
import android.view.LayoutInflater;

/* compiled from: ProGuard */
public final class a extends ContextWrapper {
    public int a;
    private Theme b;
    private LayoutInflater c;

    public a(Context context, @StyleRes int i) {
        super(context);
        this.a = i;
    }

    public final void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            a();
        }
    }

    public final Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = b.Theme_AppCompat_Light;
        }
        a();
        return this.b;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    private void a() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }
}
