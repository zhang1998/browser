package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.View;

/* compiled from: ProGuard */
public abstract class h {
    public void a(Canvas canvas, RecyclerView recyclerView) {
    }

    public void a(Rect rect, View view) {
        ((LayoutParams) view.getLayoutParams()).c.c();
        rect.set(0, 0, 0, 0);
    }
}
