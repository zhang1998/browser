package com.ucpro.feature.webwindow.j;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.ui.c.a;
import com.ucpro.ui.widget.auto.theme.ATTextView;

/* compiled from: ProGuard */
public final class h extends b implements OnClickListener {
    private static long h;
    private String a;
    private ATTextView b;
    private ATTextView c;
    private LinearLayout d = new LinearLayout(getContext());
    private c e;
    private n f;
    private boolean g;

    public h(Context context) {
        super(context);
        this.d.setOrientation(0);
        getContentLayer().addView(this.d, new LayoutParams(-1, -2));
        this.b = new ATTextView(getContext());
        this.b.setSingleLine();
        this.b.setEllipsize(TruncateAt.END);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = IPictureView.DEFAULT_MIN_SCALE;
        layoutParams.gravity = 16;
        this.b.setPadding(a.c((int) R.dimen.setting_item_view_default_padding_left), 0, 0, 0);
        this.b.setTextSize(0, getTitleTextSize());
        this.d.addView(this.b, layoutParams);
        this.c = new ATTextView(getContext());
        layoutParams = new LinearLayout.LayoutParams(getDeleteButtonWide(), -2);
        layoutParams.gravity = 16;
        this.c.setText(a.d((int) R.string.ad_block_rule_view_delete_text));
        this.c.setGravity(17);
        this.c.setTextSize(0, getTitleTextSize());
        this.c.setOnClickListener(this);
        this.d.addView(this.c, layoutParams);
    }

    public final float getTitleTextSize() {
        return a.b((int) R.dimen.ad_block_rule_view_list_text_size);
    }

    public final void setAdblockRule(n nVar) {
        this.f = nVar;
        setHostName(this.f.a);
    }

    public final void setEnableMannualAdBlock(boolean z) {
        this.g = z;
        this.c.setTextColorResName("ad_block_rule_delete_text_color");
        this.b.setTextColorResName("ad_block_rule_host_name_text_color");
        if (this.g) {
            this.c.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            this.b.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            return;
        }
        this.c.setAlpha(0.7f);
        this.b.setAlpha(0.7f);
    }

    private int getDeleteButtonWide() {
        return a.c((int) R.dimen.ad_block_rule_view_delete_button_wide);
    }

    private void setHostName(String str) {
        this.a = str;
        this.b.setText(this.a);
    }

    public final void onClick(View view) {
        if (System.currentTimeMillis() - h > getClickCoolingTime() && view == this.c && this.e != null && this.g) {
            this.e.a(this.f);
        }
        h = SystemClock.currentThreadTimeMillis();
    }

    public final void setOnRuleDeleteListener(c cVar) {
        this.e = cVar;
    }
}
