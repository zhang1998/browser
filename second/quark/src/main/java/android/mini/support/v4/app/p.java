package android.mini.support.v4.app;

import android.app.Activity;
import android.mini.support.annotation.Nullable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.PrintWriter;

/* compiled from: ProGuard */
final class p extends t<FragmentActivity> {
    final /* synthetic */ FragmentActivity a;

    public p(FragmentActivity fragmentActivity) {
        this.a = fragmentActivity;
        super(fragmentActivity);
    }

    public final void a(String str, PrintWriter printWriter, String[] strArr) {
        this.a.dump(str, null, printWriter, strArr);
    }

    public final boolean b() {
        return !this.a.isFinishing();
    }

    public final LayoutInflater c() {
        return this.a.getLayoutInflater().cloneInContext(this.a);
    }

    public final void d() {
        Activity activity = this.a;
        if (VERSION.SDK_INT >= 11) {
            activity.invalidateOptionsMenu();
        } else {
            activity.j = true;
        }
    }

    public final boolean e() {
        return this.a.getWindow() != null;
    }

    public final int f() {
        Window window = this.a.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }

    public final void g() {
        FragmentActivity.c();
    }

    @Nullable
    public final View a(int i) {
        return this.a.findViewById(i);
    }

    public final boolean a() {
        Window window = this.a.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
