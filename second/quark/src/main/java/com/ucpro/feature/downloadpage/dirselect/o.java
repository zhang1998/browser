package com.ucpro.feature.downloadpage.dirselect;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class o extends LinearLayout {
    private ImageView a;
    private View b = new View(getContext());

    public o(Context context) {
        super(context);
        setOrientation(1);
        setBackgroundDrawable(a.c());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        this.b.setBackgroundColor(a.c("popmenu_divider_color"));
        addView(this.b, layoutParams);
        View linearLayout = new LinearLayout(getContext());
        this.a = new ImageView(getContext());
        this.a.setImageDrawable(a.a("bookmark_add.svg"));
        linearLayout.setGravity(17);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        linearLayout.addView(this.a, layoutParams2);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a.c((int) R.dimen.common_bottom_titlebar_height)));
    }
}
