package com.ui.edittext;

import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
abstract class aj implements av {
    protected PopupWindow b;
    protected ViewGroup c;
    int d;
    int e;
    final /* synthetic */ TextView f;

    protected abstract int a(int i);

    protected abstract void a();

    protected abstract int b(int i);

    protected abstract void b();

    protected abstract int c();

    public aj(TextView textView) {
        this.f = textView;
        a();
        this.b.setWidth(-2);
        this.b.setHeight(-2);
        b();
        this.c.setLayoutParams(new LayoutParams(-2, -2));
        this.b.setContentView(this.c);
    }

    public void d() {
        this.f.getPositionListener().a(this, false);
        h();
        ak m = this.f.getPositionListener();
        a(m.a, m.b);
    }

    protected void e() {
        DisplayMetrics displayMetrics = this.f.mContext.getResources().getDisplayMetrics();
        this.c.measure(MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, SectionHeader.SHT_LOUSER));
    }

    private void h() {
        e();
        int measuredWidth = this.c.getMeasuredWidth();
        int c = c();
        this.d = (int) (this.f.h.getPrimaryHorizontal(c) - (((float) measuredWidth) / 2.0f));
        this.d += this.f.z();
        this.e = a(this.f.h.getLineForOffset(c));
        this.e += this.f.A();
    }

    private void a(int i, int i2) {
        int i3 = this.d + i;
        int b = b(this.e + i2);
        DisplayMetrics displayMetrics = this.f.mContext.getResources().getDisplayMetrics();
        i3 = Math.max(0, Math.min(displayMetrics.widthPixels - this.c.getMeasuredWidth(), i3));
        if (this.b.isShowing()) {
            this.b.update(i3, b, -1, -1);
        } else {
            this.b.showAtLocation(this.f, 0, i3, b);
        }
    }

    public void f() {
        this.b.dismiss();
        this.f.getPositionListener().a(this);
    }

    public final boolean g() {
        return this.b.isShowing();
    }

    public final void a(int i, int i2, boolean z, boolean z2) {
        if (this.b.isShowing() && this.f.e(((int) this.f.h.getPrimaryHorizontal(c())) + this.f.z(), this.f.h.getLineBottom(this.f.h.getLineForOffset(c())) + this.f.A())) {
            if (z2) {
                h();
            }
            a(i, i2);
            return;
        }
        f();
    }
}
