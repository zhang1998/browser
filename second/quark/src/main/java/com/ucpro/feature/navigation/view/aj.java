package com.ucpro.feature.navigation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class aj extends ViewGroup {
    ArrayList<View> a = new ArrayList();
    public boolean b;
    private boolean c;
    private ah d;

    public aj(Context context, ah ahVar) {
        super(context);
        this.d = ahVar;
        setWillNotDraw(true);
        setClipChildren(false);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.b;
    }

    public final void requestLayout() {
        if (!this.c) {
            super.requestLayout();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    protected final void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((View) it.next()).draw(canvas);
        }
    }

    public final void a(View view, Rect rect) {
        if (this.d != null) {
            this.d.a(view, rect);
        }
    }

    public final void addView(View view) {
        this.c = true;
        super.addView(view);
        this.c = false;
    }

    public final void removeView(View view) {
        this.c = true;
        super.removeView(view);
        this.c = false;
    }

    public final void a() {
        this.a.clear();
        removeAllViews();
    }
}
