package com.ucpro.feature.video.player.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.alibaba.wireless.security.SecExceptionCode;
import com.quark.browser.R;
import com.uc.apollo.media.MediaDefines;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.base.system.b;
import com.ucpro.feature.video.player.a.g;

/* compiled from: ProGuard */
public final class a extends ViewGroup {
    private int A = 0;
    protected g a;
    BaseHintView b = null;
    BaseHintView c = null;
    Drawable d = null;
    Drawable e = null;
    Drawable f = null;
    Drawable g = null;
    private View h = null;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private float m;
    private float n;
    private float o;
    private float p;
    private float q;
    private int r = 0;
    private int s = 0;
    private e t = null;
    private l u = null;
    private x v = null;
    private ac w = null;
    private w x = null;
    private q y = null;
    private int z = 0;

    public a(Context context, g gVar) {
        super(context);
        this.a = gVar;
        this.q = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        a();
        this.x = new w(this);
        this.u = new l(this);
        this.v = new x(this);
        this.w = new ac(this);
        this.t = this.x;
        this.i = com.ucpro.ui.c.a.c((int) R.dimen.player_center_hint_width_large);
        this.j = com.ucpro.ui.c.a.c((int) R.dimen.player_center_hint_height);
        this.k = com.ucpro.ui.c.a.c((int) R.dimen.player_center_hint_forward_backward_width);
        this.l = com.ucpro.ui.c.a.c((int) R.dimen.player_center_hint_height);
        this.d = com.ucpro.ui.c.a.a("new_video_light.svg");
        this.e = com.ucpro.ui.c.a.a("new_video_volume.svg");
        this.f = com.ucpro.ui.c.a.a("new_video_time_forward.svg");
        this.g = com.ucpro.ui.c.a.a("new_video_time_back.svg");
        this.h = new View(getContext());
        this.h.setBackgroundColor(-1);
        this.h.setVisibility(8);
        addView(this.h);
        this.b = new BaseHintView(getContext());
        this.b.setVisibility(8);
        addView(this.b);
        this.c = new BaseHintView(getContext());
        this.c.setVisibility(8);
        addView(this.c);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h != null) {
            this.h.measure(MeasureSpec.makeMeasureSpec(SecExceptionCode.SEC_ERROR_STA_ENC, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(200, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.m = x;
                this.n = y;
                this.o = -1.0f;
                this.p = -1.0f;
                this.t = this.x;
                break;
            case 1:
            case 3:
                this.t.b();
                this.t = this.x;
                break;
            case 2:
                if (this.t == this.x) {
                    if (Math.abs(x - this.m) > this.q) {
                        this.t = this.w;
                    } else if (Math.abs(y - this.n) > this.q) {
                        if (this.m < ((float) this.r) / 2.0f) {
                            this.t = this.u;
                        } else {
                            this.t = this.v;
                        }
                    }
                    this.t.a();
                }
                this.t.a(this.m, this.n, x, y);
                break;
        }
        super.onTouchEvent(motionEvent);
        this.o = x;
        this.p = y;
        return true;
    }

    public final void setLightAreaInfo(int i) {
        this.b.setText(String.valueOf(i) + "%");
    }

    public final void setVolumeAreaInfo(int i) {
        this.b.setText(String.valueOf(i) + "%");
    }

    public final void setGestureListener(q qVar) {
        this.y = qVar;
    }

    public final void a() {
        if (b.a.a((Activity) getContext())) {
            this.r = b.a.f();
            this.s = b.a.g();
        } else {
            this.r = Math.max(b.a.g(), b.a.f());
            this.s = Math.min(b.a.g(), b.a.f());
        }
        this.z = this.s / 100;
        this.A = this.r / MediaDefines.MSG_ENABLE_VR_MODE;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.h != null && this.h.getVisibility() == 0) {
            int measuredWidth = (getMeasuredWidth() - this.h.getMeasuredWidth()) / 2;
            int measuredHeight = (getMeasuredHeight() - this.h.getMeasuredHeight()) / 2;
            this.h.layout(measuredWidth, measuredHeight, this.h.getMeasuredWidth() + measuredWidth, this.h.getMeasuredHeight() + measuredHeight);
        }
        if (this.b != null && this.b.getVisibility() == 0) {
            measuredWidth = (getMeasuredWidth() - this.b.getMeasuredWidth()) / 2;
            measuredHeight = (getMeasuredHeight() - this.b.getMeasuredHeight()) / 2;
            this.b.layout(measuredWidth, measuredHeight, this.b.getMeasuredWidth() + measuredWidth, this.b.getMeasuredHeight() + measuredHeight);
        }
        if (this.c != null && this.c.getVisibility() == 0) {
            measuredWidth = (getMeasuredWidth() - this.c.getMeasuredWidth()) / 2;
            measuredHeight = (getMeasuredHeight() - this.c.getMeasuredHeight()) / 2;
            this.c.layout(measuredWidth, measuredHeight, this.c.getMeasuredWidth() + measuredWidth, this.c.getMeasuredHeight() + measuredHeight);
        }
    }
}
