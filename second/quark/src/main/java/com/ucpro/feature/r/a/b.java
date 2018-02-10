package com.ucpro.feature.r.a;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class b extends Dialog {
    public ATTextView a = ((ATTextView) this.e.findViewById(R.id.content));
    public ATTextView b = ((ATTextView) this.e.findViewById(R.id.content_new));
    public LinearLayout c = ((LinearLayout) this.e.findViewById(R.id.ll_upgrade));
    private Context d;
    private View e = LayoutInflater.from(this.d).inflate(R.layout.upgrade_waiting, null, false);

    public b(Context context) {
        super(context, R.style.upgrade_wait_dialog_style);
        this.d = context;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.height = a.c((int) R.dimen.upgrade_waiting_layout_height);
        addContentView(this.e, layoutParams);
        this.e.setBackgroundDrawable(a.a("upgrade_wait_bg_shape.xml"));
        this.a.setTextColor(a.c("upgrade_waiting_layout_text_color"));
        this.b.setTextColor(a.c("upgrade_waiting_layout_text_color"));
    }
}
