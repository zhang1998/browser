package com.ucpro.feature.webwindow;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.ucpro.business.stat.a.a;
import com.ucpro.business.stat.a.d;
import com.ucpro.ui.widget.ac;
import com.ucpro.ui.widget.e;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public final class x extends e implements OnClickListener, d, ac {
    ObjectAnimator c;
    ObjectAnimator d;
    int e = 0;
    private af f;
    private ArrayList<View> g;
    private boolean h = true;

    public x(Context context) {
        super(context);
        setOnClickListener(this);
    }

    final ArrayList<View> getLayerViews() {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        return this.g;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((View) it.next()).layout(0, 0, getWidth(), getHeight());
            }
        }
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.g != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ((View) it.next()).measure(i, i2);
            }
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (this.h) {
            this.f.a(motionEvent);
        }
        return dispatchTouchEvent;
    }

    public final void a(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
    }

    public final void setGestureManager(af afVar) {
        this.f = afVar;
    }

    public final void onClick(View view) {
    }

    public final void setEnableGesture(boolean z) {
        this.h = z;
    }

    public final String getSpm() {
        return a.a("8937521");
    }

    public final String getPageName() {
        return "Page_home_default";
    }

    final void a() {
        if (this.d != null && this.d.isRunning()) {
            this.d.cancel();
        }
        if (this.c != null && this.c.isRunning()) {
            this.c.cancel();
        }
    }
}
