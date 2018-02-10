package com.ucpro.feature.navigation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.c.d;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public class u extends j {
    public TextView n;
    public ImageView o = new ImageView(getContext());
    public ImageView p;
    boolean q;
    private Drawable r;
    private String s;
    private int t;

    public u(Context context, al alVar, ax axVar) {
        super(context, alVar);
        setWidgetInfo(axVar);
        this.o.setBackgroundDrawable(a.a("nav_board.svg"));
        addView(this.o);
        this.n = new TextView(getContext());
        this.n.setVisibility(4);
        if (com.ucpro.b.a.a.a() && d.a()) {
            this.n.setSingleLine(false);
            this.n.setGravity(1);
        } else {
            this.n.setSingleLine();
        }
        this.n.setEllipsize(TruncateAt.END);
        this.n.setTextSize(0, (float) h);
        this.n.setPadding(i, 0, i, 0);
        addView(this.n);
        a();
    }

    public final void a(ax axVar) {
        super.a(axVar);
        c();
        this.n.setVisibility(0);
        this.o.animate().cancel();
        this.o.setTranslationY(0.0f);
        if (com.ucpro.feature.navigation.a.a.a(axVar)) {
            setCornerFlagDrawable("lightapp_corner_flag.svg");
        } else {
            setCornerFlagDrawable(null);
        }
    }

    public Drawable getIcon() {
        return this.r;
    }

    public final void i() {
        getIconView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }

    public final void j() {
        getTitleView().setAlpha(IPictureView.DEFAULT_MIN_SCALE);
    }

    protected View getIconView() {
        return this.o;
    }

    protected View getTitleView() {
        return this.n;
    }

    public void setIcon(Drawable drawable) {
        this.r = drawable;
        if (this.r != null) {
            a.a(this.r);
        }
        this.o.setImageDrawable(this.r);
        this.o.invalidate();
    }

    public void a() {
        if (a.a() && a.d()) {
            this.t = a.c("navigation_widget_title_color_dark");
        } else {
            this.t = a.c("navigation_widget_title_color");
        }
        c();
        if (this.r != null) {
            a.a(this.r);
            this.o.setImageDrawable(this.r);
            this.o.setBackgroundDrawable(a.a("nav_board.svg"));
            this.o.invalidate();
        }
        b();
    }

    private void b() {
        if (this.p == null) {
            return;
        }
        if (this.s == null) {
            this.p.setImageDrawable(null);
            return;
        }
        this.p.setImageDrawable(a.a(this.s));
        this.p.setVisibility(0);
        this.p.bringToFront();
    }

    private void c() {
        this.n.setTextColor(this.t);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.o.measure(MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(c, UCCore.VERIFY_POLICY_QUICK));
        this.n.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(0, 0));
        if (this.p != null) {
            this.p.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        canvas.save();
        canvas.clipRect(view.getLeft(), 0, view.getRight(), view.getBottom());
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    protected final boolean a(Rect rect) {
        rect.set(this.o.getLeft(), this.o.getTop(), this.o.getRight(), this.o.getBottom());
        return true;
    }

    public void setTitle(String str) {
        if (this.n.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        this.n.setText(str);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = (getWidth() - this.o.getMeasuredWidth()) / 2;
        int i5 = e;
        this.o.layout(width, i5, this.o.getMeasuredWidth() + width, this.o.getMeasuredHeight() + i5);
        width = (getWidth() - this.n.getMeasuredWidth()) / 2;
        i5 = this.o.getBottom() + f;
        this.n.layout(width, i5, this.n.getMeasuredWidth() + width, this.n.getMeasuredHeight() + i5);
        if (this.p != null) {
            width = this.o.getRight();
            i5 = this.o.getBottom();
            int measuredWidth = width - this.p.getMeasuredWidth();
            this.p.layout(measuredWidth, i5 - this.p.getMeasuredHeight(), width, i5);
        }
        if (this.q) {
            this.q = false;
            this.o.animate().cancel();
            this.o.setTranslationY((float) this.o.getHeight());
            this.o.animate().translationY(0.0f).setDuration(300).setInterpolator(new OvershootInterpolator()).start();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void setCornerFlagDrawable(String str) {
        if (this.p == null) {
            this.p = new ImageView(getContext());
            addView(this.p);
        }
        this.s = str;
        b();
    }
}
