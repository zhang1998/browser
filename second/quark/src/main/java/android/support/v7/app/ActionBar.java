package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.v7.c.h;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.ViewGroup.MarginLayoutParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: ProGuard */
public abstract class ActionBar {

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface DisplayOptions {
    }

    /* compiled from: ProGuard */
    public class LayoutParams extends MarginLayoutParams {
        public int a;

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ActionBarLayout);
            this.a = obtainStyledAttributes.getInt(h.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-2, -2);
            this.a = 0;
            this.a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
            this.a = layoutParams.a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: ProGuard */
    public @interface NavigationMode {
    }

    public abstract int a();

    public abstract boolean b();

    public Context c() {
        return null;
    }

    public void a(boolean z) {
    }

    public void b(boolean z) {
    }

    public void a(Configuration configuration) {
    }

    public void c(boolean z) {
    }

    public android.support.v7.view.h a(d dVar) {
        return null;
    }

    public boolean d() {
        return false;
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean e() {
        return false;
    }

    public void a(CharSequence charSequence) {
    }

    boolean f() {
        return false;
    }

    void g() {
    }
}
