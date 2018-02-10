package com.ucpro.feature.setting.d;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.RoundRectView;
import com.ucpro.ui.widget.i;

/* compiled from: ProGuard */
final class l extends FrameLayout {
    RoundRectView a = ((RoundRectView) findViewById(R.id.lab_item_image));
    TextView b = ((TextView) findViewById(R.id.lab_item_title));
    TextView c = ((TextView) findViewById(R.id.lab_item_subtitle));
    final /* synthetic */ j d;
    private View e = findViewById(R.id.lab_item_footer);
    private View f = findViewById(R.id.lab_item_btn_bg);
    private TextView g = ((TextView) findViewById(R.id.lab_item_btn_text));
    private LinearLayout h = ((LinearLayout) findViewById(R.id.lab_item_container));
    private i i;

    public l(j jVar, Context context) {
        this.d = jVar;
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.quark_lab_item, this, true);
        int c = a.c((int) R.dimen.multi_window_cardview2_corner_radius);
        this.i = new i(new float[]{0.0f, 0.0f, 0.0f, 0.0f, (float) c, (float) c, (float) c, (float) c}, a.c("default_background_white"));
        this.h.setBackgroundDrawable(a.a("lab_item_shadow.9.png"));
        this.b.setTextColor(a.c("default_maintext_gray"));
        this.b.setTypeface(Typeface.defaultFromStyle(1));
        this.c.setTextColor(a.c("default_commentstext_gray"));
        this.i.getPaint().setColor(a.c("default_background_white2"));
        this.e.setBackgroundDrawable(this.i);
        this.f.setBackgroundDrawable(a.a("quark_lab_item_btn_bg.xml"));
        this.g.setTextColor(a.c("default_maintext_white"));
    }
}
