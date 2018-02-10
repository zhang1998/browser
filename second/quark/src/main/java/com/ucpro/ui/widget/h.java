package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* compiled from: ProGuard */
public final class h extends View {
    private View a;
    private int b = 0;

    public h(Context context) {
        super(context);
    }

    public h(Context context, View view) {
        super(context);
        setSourceView(view);
    }

    public final void setSourceView(View view) {
        if (this.a != view) {
            this.a = view;
            invalidate();
        }
    }

    public final View getSourceView() {
        return this.a;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.a != null && this.a.getVisibility() != 8) {
            canvas.translate(0.0f, (float) this.b);
            this.a.draw(canvas);
        }
    }

    public final int getSourceViewHeight() {
        if (this.a != null) {
            return this.a.getMeasuredHeight();
        }
        return 0;
    }

    public final void setOffsetY(int i) {
        this.b = i;
    }
}
