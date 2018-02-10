package com.ucpro.ui.f;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.ucpro.ui.g.q;

/* compiled from: ProGuard */
public final class b extends c implements a {
    private e d;
    private MotionEvent e;
    private d f;

    public b(Context context) {
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            f fVar = (f) getChildAt(i3);
            if (fVar.getVisibility() != 8 && fVar.getTagView().getVisibility() == 8) {
                fVar.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    public final void setOnTagClickListener(d dVar) {
        this.f = dVar;
        if (dVar != null) {
            setClickable(true);
        }
    }

    public final void setAdapter(e eVar) {
        this.d = eVar;
        this.d.a = this;
        removeAllViews();
        d();
    }

    private void d() {
        e eVar = this.d;
        int i = 0;
        while (i < eVar.a()) {
            View tagView = i < getChildCount() ? ((f) getChildAt(i)).getTagView() : null;
            eVar.a(i);
            tagView = eVar.a(this, i, tagView);
            if (tagView.getParent() == null) {
                View fVar = new f(getContext());
                tagView.setDuplicateParentStateEnabled(true);
                if (tagView.getLayoutParams() != null) {
                    fVar.setLayoutParams(tagView.getLayoutParams());
                } else {
                    LayoutParams marginLayoutParams = new MarginLayoutParams(-2, -2);
                    marginLayoutParams.setMargins(a(getContext()), a(getContext()), a(getContext()), a(getContext()));
                    fVar.setLayoutParams(marginLayoutParams);
                }
                fVar.addView(tagView);
                addView(fVar);
            }
            i++;
        }
        invalidate();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.e = MotionEvent.obtain(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final boolean performClick() {
        if (this.e == null) {
            return super.performClick();
        }
        View view;
        int x = (int) this.e.getX();
        int y = (int) this.e.getY();
        this.e = null;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            view = (f) getChildAt(i);
            if (view.getVisibility() != 8) {
                Rect rect = new Rect();
                view.getHitRect(rect);
                if (rect.contains(x, y)) {
                    break;
                }
            }
        }
        view = null;
        a(view);
        if (view == null || this.f == null) {
            return true;
        }
        d dVar = this.f;
        view.getTagView();
        return dVar.a();
    }

    public final e getAdapter() {
        return this.d;
    }

    private int a(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }

    public final void a() {
        e eVar = this.d;
        int childCount = getChildCount();
        int a = eVar.a();
        if (childCount > a) {
            childCount -= a;
            for (a = 0; a < childCount; a++) {
                removeViewAt(getChildCount() - 1);
            }
        }
        d();
    }

    public final void b() {
        removeAllViews();
        d();
    }

    private static int a(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
    }

    public final void c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            f fVar = (f) getChildAt(i);
            if (fVar.getTagView() instanceof q) {
                ((q) fVar.getTagView()).a();
            }
        }
    }
}
