package com.ucpro.feature.p;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class c extends ViewGroup {
    private final b a;
    private ImageView b;
    private ImageView c;
    private TextView d;
    private Drawable e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private boolean m = true;
    private LottieAnimationView n;

    public c(Context context, b bVar) {
        super(context);
        this.a = bVar;
        setTag(R.id.ui_auto, this.a.h);
        this.k = a.c((int) R.dimen.mainmenu_item_text_margin_top);
        this.g = a.c((int) R.dimen.mainmenu_item_icon_size);
        this.h = a.c((int) R.dimen.mainmenu_left_image_width);
        this.i = a.c((int) R.dimen.mainmenu_item_icon_tips_size);
        this.j = a.c((int) R.dimen.mainmenu_item_text_size);
        this.b = new ImageView(getContext());
        addView(this.b);
        this.d = new TextView(getContext());
        this.d.setTextSize(0, (float) this.j);
        if (c()) {
            this.d.setText(this.a.a());
        }
        this.d.setGravity(1);
        addView(this.d);
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(this.i);
        shapeDrawable.setIntrinsicWidth(this.i);
        shapeDrawable.getPaint().setColor(a.c("main_menu_icon_tips_color"));
        this.c = new ImageView(getContext());
        this.c.setBackgroundDrawable(shapeDrawable);
        this.c.setVisibility(this.a.g ? 0 : 8);
        addView(this.c);
        this.d.setSingleLine();
        if (this.a.f) {
            setEnabled(true);
            setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        } else {
            setEnabled(false);
            setAlpha(0.2f);
        }
        if (this.a.i) {
            this.n = new LottieAnimationView(getContext());
            this.n.setVisibility(8);
            this.n.setAnimation(this.a.j);
            if (a.b() && !TextUtils.isEmpty(this.a.l)) {
                this.n.setImageAssetsFolder(this.a.l);
            } else if (!TextUtils.isEmpty(this.a.k)) {
                this.n.setImageAssetsFolder(this.a.k);
            }
            this.n.setProgress(0.0f);
            this.n.a(false);
            addView(this.n);
        }
        a();
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.g;
        if (!c()) {
            i3 = this.h;
        }
        this.b.measure(MeasureSpec.makeMeasureSpec(i3, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(i3, UCCore.VERIFY_POLICY_QUICK));
        this.c.measure(MeasureSpec.makeMeasureSpec(this.i, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.i, UCCore.VERIFY_POLICY_QUICK));
        b();
        if (this.n != null) {
            i3 = this.g;
            if (!c()) {
                i3 = this.h;
            }
            this.n.measure(MeasureSpec.makeMeasureSpec(i3, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(i3, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    private void b() {
        this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), SectionHeader.SHT_LOUSER), MeasureSpec.makeMeasureSpec(0, c() ? 0 : UCCore.VERIFY_POLICY_QUICK));
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.m) {
            this.m = false;
            this.f = (((getHeight() - this.d.getMeasuredHeight()) - this.b.getMeasuredHeight()) - this.k) / 2;
            this.d.setSingleLine(false);
            b();
        }
        int width = (getWidth() - this.b.getMeasuredWidth()) / 2;
        int measuredWidth = this.b.getMeasuredWidth() + width;
        int i5 = this.f;
        this.b.layout(width, i5, measuredWidth, this.b.getMeasuredHeight() + i5);
        this.c.layout(measuredWidth - (this.c.getMeasuredWidth() / 2), i5 - (this.c.getMeasuredWidth() / 2), measuredWidth + (this.c.getMeasuredWidth() / 2), i5 + (this.c.getMeasuredWidth() / 2));
        width = (getWidth() - this.d.getMeasuredWidth()) / 2;
        i5 = this.b.getBottom() + this.k;
        this.d.layout(width, i5, this.d.getMeasuredWidth() + width, this.d.getMeasuredHeight() + i5);
        if (!(this.e == null || this.b == null)) {
            this.e.setBounds(this.b.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
        }
        if (this.n != null && this.n.getVisibility() == 0) {
            width = (getWidth() - this.n.getMeasuredWidth()) / 2;
            measuredWidth = this.n.getMeasuredWidth() + width;
            i5 = this.f;
            this.n.layout(width, i5, measuredWidth, this.n.getMeasuredHeight() + i5);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        switch (action) {
            case 0:
                this.l = true;
                invalidate();
                break;
            case 1:
            case 3:
            case 4:
                this.l = false;
                invalidate();
                break;
        }
        return onTouchEvent;
    }

    public final void a() {
        this.b.setImageDrawable(a.a(this.a.e));
        this.d.setTextColor(a.c("default_maintext_gray"));
        this.e = a.a("menu_item_pressed_bg.svg");
    }

    public final b getData() {
        return this.a;
    }

    private boolean c() {
        if (this.a == null || this.a.b == -1) {
            return false;
        }
        return true;
    }

    protected final void dispatchDraw(Canvas canvas) {
        if (this.l && this.e != null) {
            this.e.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }
}
