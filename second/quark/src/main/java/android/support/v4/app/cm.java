package android.support.v4.app;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import java.io.PrintWriter;

/* compiled from: ProGuard */
final class cm extends bm<FragmentActivity> {
    final /* synthetic */ FragmentActivity k;

    public cm(FragmentActivity fragmentActivity) {
        this.k = fragmentActivity;
        super(fragmentActivity);
    }

    public final void a(String str, PrintWriter printWriter, String[] strArr) {
        this.k.dump(str, null, printWriter, strArr);
    }

    public final boolean b() {
        return !this.k.isFinishing();
    }

    public final LayoutInflater c() {
        return this.k.getLayoutInflater().cloneInContext(this.k);
    }

    public final void d() {
        this.k.a();
    }

    public final boolean e() {
        return this.k.getWindow() != null;
    }

    public final int f() {
        Window window = this.k.getWindow();
        return window == null ? 0 : window.getAttributes().windowAnimations;
    }

    public final void g() {
        FragmentActivity.e();
    }

    @Nullable
    public final View a(int i) {
        return this.k.findViewById(i);
    }

    public final boolean a() {
        Window window = this.k.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }
}
