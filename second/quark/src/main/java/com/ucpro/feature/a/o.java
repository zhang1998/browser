package com.ucpro.feature.a;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import com.ucpro.base.d.b;

/* compiled from: ProGuard */
public final class o extends FrameLayout implements w {
    private b a;

    public o(@NonNull Context context) {
        super(context);
    }

    public final void setContentView(View view) {
        addView(view, -1, -1);
    }

    public final void setPresenter(b bVar) {
        this.a = (b) bVar;
    }
}
