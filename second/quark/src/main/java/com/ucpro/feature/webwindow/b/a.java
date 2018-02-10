package com.ucpro.feature.webwindow.b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
public final class a extends LinearLayout implements OnClickListener {
    private FrameLayout a = new FrameLayout(getContext());
    private ImageView b;
    private FrameLayout c;
    private ImageView d;
    private FrameLayout e;
    private ImageView f;
    private z g;

    public a(Context context) {
        super(context);
        setOrientation(0);
        this.a.setOnClickListener(this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.b = new ImageView(getContext());
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.a.addView(this.b, layoutParams2);
        addView(this.a, layoutParams);
        this.c = new FrameLayout(getContext());
        this.c.setOnClickListener(this);
        layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.d = new ImageView(getContext());
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.c.addView(this.d, layoutParams2);
        addView(this.c, layoutParams);
        this.e = new FrameLayout(getContext());
        this.e.setOnClickListener(this);
        layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        this.f = new ImageView(getContext());
        layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.e.addView(this.f, layoutParams2);
        addView(this.e, layoutParams);
        a();
    }

    public final void a() {
        setBackgroundColor(-16777216);
        getBackground().setAlpha(229);
        this.b.setImageDrawable(com.ucpro.ui.c.a.a("pic_close.svg"));
        com.ucpro.ui.c.a.a(this.b);
        this.d.setImageDrawable(com.ucpro.ui.c.a.a("download_pic.svg"));
        com.ucpro.ui.c.a.a(this.d);
        this.f.setImageDrawable(com.ucpro.ui.c.a.a("download_pic_all.svg"));
        com.ucpro.ui.c.a.a(this.f);
    }

    public final void onClick(View view) {
        if (view != null && this.g != null) {
            if (view == this.a) {
                this.g.a();
            } else if (view == this.c) {
                this.g.b();
            } else if (view == this.e) {
                this.g.c();
            }
        }
    }

    public final void setPicViewerToolbarCallback(z zVar) {
        this.g = zVar;
    }
}
