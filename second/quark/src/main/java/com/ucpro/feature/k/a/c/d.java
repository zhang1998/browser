package com.ucpro.feature.k.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class d extends LinearLayout implements OnClickListener {
    a a;
    Bitmap b;
    int c;
    private FrameLayout d;
    private View e;
    private View f;
    private View g;
    private e h;
    private boolean i = true;

    public d(Context context) {
        super(context);
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(R.layout.wallpaper_preview, this, true);
        this.d = (FrameLayout) findViewById(R.id.wallpaper_preview_content);
        this.e = findViewById(R.id.wallpaper_preview_logo_btn);
        this.f = findViewById(R.id.wallpaper_preview_logo_select);
        this.g = findViewById(R.id.wallpaper_preview_confim_btn);
        this.a = new a(getContext());
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.d.addView(this.a, layoutParams);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(this);
        setBackgroundColor(a.c("default_background_dark"));
        this.f.setBackgroundDrawable(a.a("wallpaper_select_box_on.svg"));
        this.g.setBackgroundDrawable(a.a("quark_lab_item_btn_bg.xml"));
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view == this.e) {
            if (this.i) {
                this.f.setBackgroundDrawable(a.a("wallpaper_select_box_off.svg"));
                this.a.setLogoVisibility(8);
            } else {
                this.f.setBackgroundDrawable(a.a("wallpaper_select_box_on.svg"));
                this.a.setLogoVisibility(0);
            }
            if (!this.i) {
                z = true;
            }
            this.i = z;
        } else if (view == this.g) {
            this.h.a(this.i, this.b, this.c);
        }
    }

    public final void setPresenter(e eVar) {
        this.h = eVar;
    }

    public final a getPreviewHomePage() {
        return this.a;
    }
}
