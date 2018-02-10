package com.ucpro.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public class ListViewEx extends ListView {
    private boolean a;

    public ListViewEx(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public ListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ListViewEx(Context context) {
        super(context);
        a();
    }

    private void a() {
        setRecyclerListener(new c(this));
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            c.a(e.toString());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            c.a(e.toString());
            return false;
        }
    }

    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (Exception e) {
            c.a(e.toString());
        }
    }

    protected void onDetachedFromWindow() {
        this.a = true;
        super.onDetachedFromWindow();
        this.a = false;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.a) {
            return false;
        }
        return super.performItemClick(view, i, j);
    }
}
