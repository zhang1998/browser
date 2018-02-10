package com.ucpro.feature.l.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class i extends LinearLayout {
    private Drawable a;
    private TextView b;
    private View c;
    private ValueAnimator d = null;
    private AnimatorUpdateListener e = new b(this);

    public i(Context context) {
        super(context);
        setOrientation(1);
        setGravity(1);
        this.c = new View(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.dicover_page_lightapp_item_icon_width), a.c((int) R.dimen.dicover_page_lightapp_item_icon_width));
        layoutParams.bottomMargin = a.c((int) R.dimen.dicover_page_lightapp_item_icon_margin_bottom);
        addView(this.c, layoutParams);
        this.b = new TextView(getContext());
        this.b.setSingleLine();
        this.b.setEllipsize(TruncateAt.END);
        this.b.setTextSize(0, (float) a.c((int) R.dimen.dicover_page_lightapp_item_textsize));
        this.b.setGravity(17);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = a.c((int) R.dimen.dicover_page_lightapp_item_title_margin_bottom);
        addView(this.b, layoutParams);
        a();
    }

    public final void a() {
        this.b.setTextColor(a.c("default_maintext_gray"));
        if (this.a != null) {
            a.a(this.a);
            this.c.setBackgroundDrawable(this.a);
            this.c.invalidate();
        }
    }

    public final void setIcon(Drawable drawable) {
        this.a = drawable;
        if (this.a != null) {
            a.a(this.a);
        }
        this.c.setBackgroundDrawable(this.a);
        this.c.invalidate();
    }

    public final void setTitle(String str) {
        this.b.setText(str);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                a(true);
                break;
            case 1:
            case 3:
                a(false);
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a(boolean z) {
        if (this.d != null) {
            this.d.cancel();
        }
        if (z) {
            this.d = ValueAnimator.ofFloat(new float[]{getScaleX(), 0.9f});
        } else {
            this.d = ValueAnimator.ofFloat(new float[]{getScaleX(), IPictureView.DEFAULT_MIN_SCALE});
        }
        this.d.setDuration(200);
        this.d.addUpdateListener(this.e);
        this.d.start();
    }
}
