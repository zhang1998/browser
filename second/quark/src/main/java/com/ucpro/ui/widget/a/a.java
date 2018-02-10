package com.ucpro.ui.widget.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.ucpro.ui.widget.ListViewEx;

/* compiled from: ProGuard */
public class a extends ListViewEx {
    private static final String b = a.class.getSimpleName();
    public z a;
    private k c = new k(this);
    private y d;

    public a(Context context) {
        super(context);
        super.setOnScrollListener(this.c);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        if (onScrollListener instanceof k) {
            super.setOnScrollListener(onScrollListener);
        } else {
            setDynamicOnScrollListener(onScrollListener);
        }
    }

    public void setDynamicOnScrollListener(OnScrollListener onScrollListener) {
        this.c.a = onScrollListener;
    }

    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (this.a != null) {
            z zVar = this.a;
            if (listAdapter == null || !(listAdapter instanceof n)) {
                x.a(z.a, "--------->adapter is invalid");
                return;
            } else {
                zVar.d = listAdapter;
                return;
            }
        }
        x.a(b, "DragAndDropHandler is null and can't support drag now");
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.d != null) {
            return onTouchEvent(motionEvent);
        }
        boolean z;
        if (this.a != null) {
            this.a.a(motionEvent);
            if (this.a.f != -1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.d = this.a;
            }
        } else {
            z = false;
        }
        if (z || super.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null) {
            return super.onTouchEvent(motionEvent);
        }
        this.d.a(motionEvent);
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            this.d = null;
        }
        if (this.d != null || super.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.a != null) {
            z zVar = this.a;
            if (zVar.e != null) {
                int i;
                int i2;
                Rect bounds = zVar.e.getBounds();
                if (!(bounds == null || zVar.i == null)) {
                    i = bounds.left;
                    i2 = bounds.right;
                    int i3 = bounds.top;
                    zVar.i.setBounds(i, i3 - zVar.i.getIntrinsicHeight(), i2, i3);
                    zVar.i.draw(canvas);
                }
                zVar.e.draw(canvas);
                if (bounds != null && zVar.j != null) {
                    i = bounds.left;
                    i2 = bounds.right;
                    int i4 = bounds.bottom;
                    zVar.j.setBounds(i, i4, i2, zVar.j.getIntrinsicHeight() + i4);
                    zVar.j.draw(canvas);
                }
            }
        }
    }

    public int computeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public void setDraggableManager(j jVar) {
        if (this.a != null) {
            this.a.b = jVar;
        }
    }

    public void setDragViewBg(Drawable drawable) {
        if (this.a != null) {
            this.a.h = drawable;
        }
    }

    public void setDragViewBottomShadow(Drawable drawable) {
        if (this.a != null) {
            this.a.j = drawable;
        }
    }

    public void setDragViewTopShadow(Drawable drawable) {
        if (this.a != null) {
            this.a.i = drawable;
        }
    }

    public void setScrollSpeed(float f) {
        if (this.a != null) {
            this.a.c.a = f;
        }
    }
}
