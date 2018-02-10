package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.c.k;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* compiled from: ProGuard */
public class ax extends Dialog implements ac {
    private AppCompatDelegate a;

    protected void onCreate(Bundle bundle) {
        a().h();
        super.onCreate(bundle);
        a().a(bundle);
    }

    public void setContentView(@LayoutRes int i) {
        a().b(i);
    }

    public void setContentView(View view) {
        a().a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Nullable
    public View findViewById(@IdRes int i) {
        return a().a(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().b(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        a().b(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        a().c();
    }

    public void invalidateOptionsMenu() {
        a().f();
    }

    public final AppCompatDelegate a() {
        if (this.a == null) {
            this.a = AppCompatDelegate.a((Dialog) this, (ac) this);
        }
        return this.a;
    }

    public ax(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(k.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        a().a(null);
        a().i();
    }
}
