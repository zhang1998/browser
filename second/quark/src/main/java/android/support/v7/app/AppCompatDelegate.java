package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public abstract class AppCompatDelegate {
    private static boolean a = false;
    static int h = -1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface NightMode {
    }

    @Nullable
    public abstract View a(@IdRes int i);

    public abstract void a();

    public abstract void a(Configuration configuration);

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, LayoutParams layoutParams);

    public abstract void b(@LayoutRes int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, LayoutParams layoutParams);

    public abstract void b(@Nullable CharSequence charSequence);

    public abstract void c();

    public abstract boolean c(int i);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void h();

    public abstract boolean i();

    @Nullable
    public abstract ActionBar j();

    public abstract MenuInflater k();

    public static AppCompatDelegate a(Activity activity, ac acVar) {
        return a(activity, activity.getWindow(), acVar);
    }

    public static AppCompatDelegate a(Dialog dialog, ac acVar) {
        return a(dialog.getContext(), dialog.getWindow(), acVar);
    }

    private static AppCompatDelegate a(Context context, Window window, ac acVar) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new as(context, window, acVar);
        }
        if (i >= 14) {
            return new o(context, window, acVar);
        }
        if (i >= 11) {
            return new u(context, window, acVar);
        }
        return new AppCompatDelegateImplV7(context, window, acVar);
    }

    AppCompatDelegate() {
    }

    public static boolean l() {
        return a;
    }
}
