package com.ucpro.feature.video.player.view;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class c extends LinearLayout {
    ImageView a = null;
    TextView b = null;
    final /* synthetic */ ah c;

    public c(ah ahVar, Context context) {
        this.c = ahVar;
        super(context);
        setOrientation(1);
        setGravity(1);
        this.a = new ImageView(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = a.c((int) R.dimen.player_more_item_icon_margin_bottom);
        addView(this.a, layoutParams);
        this.b = new TextView(getContext());
        this.b.setTextSize(0, (float) a.c((int) R.dimen.player_more_item_textsize));
        this.b.setTextColor(-1);
        addView(this.b, new LinearLayout.LayoutParams(-2, -2));
        int c = a.c((int) R.dimen.player_more_item_padding_right);
        setPadding(c, 0, c, 0);
    }
}
