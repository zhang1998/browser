package com.ucpro.feature.g.b.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.feature.g.a.c;
import com.ucpro.feature.g.c.b.g;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class b extends LinearLayout implements OnClickListener {
    public ATTextView a;
    public com.ucpro.feature.g.a.b b;
    public boolean c = false;
    private ATTextView d;
    private c e;
    private String f;

    public b(Context context) {
        super(context);
        setOrientation(1);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        this.a = new ATTextView(getContext());
        this.d = new ATTextView(getContext());
        this.a.setGravity(17);
        this.a.setText(a.d((int) R.string.cloud_sync_sync));
        this.d.setTextColor(a.c("default_assisttext_gray"));
        this.a.setTextColor(a.c("default_maintext_gray"));
        this.d.setTextSize(0, a.a((int) R.dimen.clound_sync_recent_text_size));
        this.a.setTextSize(0, a.a((int) R.dimen.clound_sync_now_text_size));
        this.a.setClickable(true);
        this.a.setOnClickListener(this);
        Drawable gVar = new g();
        gVar.setColor(a.c("cloud_verfi_code_bg_normal_color"));
        gVar.setStroke(a.c((int) R.dimen.clound_sync_verif_code_stroke), a.c("default_assisttext_gray"));
        Drawable gVar2 = new g();
        gVar2.setColor(a.c("cloud_verfi_code_bg_press_color"));
        gVar2.setStroke(a.c((int) R.dimen.clound_sync_verif_code_stroke), a.c("default_assisttext_gray"));
        this.a.setBackgroundDrawable(c.a(gVar, gVar2));
        layoutParams = new LinearLayout.LayoutParams(a.c((int) R.dimen.clound_sync_sync_btn_width), a.c((int) R.dimen.clound_sync_sync_btn_height));
        layoutParams.gravity = 17;
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = a.c((int) R.dimen.clound_sync_recent_text_size);
        addView(this.a, layoutParams);
        addView(this.d, layoutParams2);
        this.b = new a(this);
    }

    public final void onClick(View view) {
        if (this.e != null) {
            this.a.setClickable(false);
            this.c = true;
            this.b.b();
            this.e.a();
        }
    }

    public final void a(String str) {
        this.c = false;
        this.b.a();
        this.d.setText(str);
        this.a.setText(a.d((int) R.string.cloud_sync_sync));
        this.a.setClickable(true);
    }

    public final void setOnSyncClick(c cVar) {
        this.e = cVar;
    }
}
