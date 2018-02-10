package com.ucpro.ui.e;

import android.support.v7.widget.bh;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ProGuard */
public class b<T extends e> extends bh implements OnClickListener {
    int r;
    T s;

    public b(View view) {
        super(view);
        view.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.s != null) {
            this.s.a(this.s, this.r, this);
        }
    }
}
