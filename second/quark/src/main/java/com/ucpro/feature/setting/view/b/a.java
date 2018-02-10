package com.ucpro.feature.setting.view.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.g.o;

/* compiled from: ProGuard */
public final class a extends o {
    private LinearLayout A = null;
    private ImageView B = null;
    private TextView C = null;
    private ImageView D = null;
    public b a = null;
    private int b = 0;
    private TextView v = null;
    private LinearLayout w = null;
    private ImageView x = null;
    private TextView y = null;
    private ImageView z = null;

    public a(Context context) {
        super(context);
        View inflate = getLayoutInflater().inflate(R.layout.toolbar_style_dialog, null);
        this.v = (TextView) inflate.findViewById(R.id.toolbar_style_dialog_title);
        this.v.setText(com.ucpro.ui.c.a.d((int) R.string.common_toolbar_style));
        this.w = (LinearLayout) inflate.findViewById(R.id.toolbar_style_dialog_3btn_container);
        this.w.setOnClickListener(this);
        this.x = (ImageView) inflate.findViewById(R.id.toolbar_style_dialog_3btn_checkbox);
        this.y = (TextView) inflate.findViewById(R.id.toolbar_style_dialog_3btn_text);
        this.y.setText(com.ucpro.ui.c.a.d((int) R.string.common_toolbar_style_dialog_3btn_text));
        this.z = (ImageView) inflate.findViewById(R.id.toolbar_style_dialog_3btn_image);
        this.z.setOnClickListener(this);
        this.A = (LinearLayout) inflate.findViewById(R.id.toolbar_style_dialog_5btn_container);
        this.A.setOnClickListener(this);
        this.B = (ImageView) inflate.findViewById(R.id.toolbar_style_dialog_5btn_checkbox);
        this.C = (TextView) inflate.findViewById(R.id.toolbar_style_dialog_5btn_text);
        this.C.setText(com.ucpro.ui.c.a.d((int) R.string.common_toolbar_style_dialog_5btn_text));
        this.D = (ImageView) inflate.findViewById(R.id.toolbar_style_dialog_5btn_image);
        this.D.setOnClickListener(this);
        h().a(inflate);
        a();
        this.b = com.ucpro.model.a.a.a.a("setting_toolbar_style", 0);
        if (this.b == 0) {
            this.x.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_on.svg"));
            this.B.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"));
            return;
        }
        this.x.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"));
        this.B.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_on.svg"));
    }

    public final void a() {
        super.a();
        this.v.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.v.getPaint().setFakeBoldText(true);
        this.y.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.z.setImageDrawable(com.ucpro.ui.c.a.a("toolbar_style_3btn.svg"));
        this.C.setTextColor(com.ucpro.ui.c.a.c("default_maintext_gray"));
        this.D.setImageDrawable(com.ucpro.ui.c.a.a("toolbar_style_5btn.svg"));
    }

    public final void onClick(View view) {
        if (this.w == view || this.z == view) {
            if (this.b != 0) {
                this.x.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_on.svg"));
                this.B.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"));
                if (this.a != null) {
                    this.a.a();
                }
            }
        } else if ((this.A == view || this.D == view) && this.b != 1) {
            this.B.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_on.svg"));
            this.x.setImageDrawable(com.ucpro.ui.c.a.a("setting_item_checkbox_off.svg"));
            if (this.a != null) {
                this.a.b();
            }
        }
        dismiss();
    }
}
