package com.taobao.weex.ui.view.listview;

import android.annotation.TargetApi;
import android.content.Context;
import android.mini.support.annotation.Nullable;
import android.mini.support.v7.widget.GridLayoutManager;
import android.mini.support.v7.widget.RecyclerView;
import android.mini.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.taobao.weex.common.w;
import com.taobao.weex.ui.view.a.b;
import com.taobao.weex.ui.view.a.c;

/* compiled from: ProGuard */
public class WXRecyclerView extends RecyclerView implements c {
    public b t;
    private boolean u = true;

    public WXRecyclerView(Context context) {
        super(context);
    }

    public WXRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setScrollable(boolean z) {
        this.u = z;
    }

    public boolean postDelayed(Runnable runnable, long j) {
        return super.postDelayed(w.a(runnable), j);
    }

    @TargetApi(16)
    public final void a(int i, int i2, int i3) {
        if (i == 2) {
            setLayoutManager(new GridLayoutManager(i2, i3));
        } else if (i == 3) {
            setLayoutManager(new StaggeredGridLayoutManager(i2, i3));
        } else if (i == 1) {
            setLayoutManager(new b(i3));
        }
    }

    public final void a(@Nullable b bVar) {
        this.t = bVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.u) {
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (this.t != null) {
            return onTouchEvent | this.t.onTouch(this, motionEvent);
        }
        return onTouchEvent;
    }
}
