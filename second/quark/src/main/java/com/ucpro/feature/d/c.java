package com.ucpro.feature.d;

import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.quark.browser.R;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
final class c extends bh implements OnClickListener {
    TextView l;
    int m;
    a n;

    public c(TextView textView) {
        super(textView);
        this.l = textView;
        this.l.setBackgroundDrawable(a.c());
        this.l.setGravity(17);
        this.l.setCompoundDrawablePadding(a.c((int) R.dimen.share_padding_drawable));
        this.l.setTextSize(0, a.b((int) R.dimen.share_text_size));
        this.l.setPadding(a.c((int) R.dimen.share_padding_left), a.c((int) R.dimen.share_padding_top), a.c((int) R.dimen.share_padding_right), a.c((int) R.dimen.share_padding_bottom));
        this.l.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.n != null) {
            this.n.b_(this.m);
        }
    }
}
