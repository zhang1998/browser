package com.ucpro.feature.webwindow.l.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.ucpro.ui.c.a;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class g extends FrameLayout implements f {
    private RecyclerView a;
    private int b;
    private i c;
    private int d;
    private int e;
    private int f;
    private int g;
    private b h;

    public g(@NonNull Context context) {
        this(context, h.a);
    }

    private g(@NonNull Context context, int i) {
        super(context);
        this.b = h.a;
        if (i == 0) {
            i = h.a;
        }
        this.b = i;
        this.a = new RecyclerView(getContext());
        LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.g(this.b == h.a ? 0 : 1);
        this.a.setLayoutManager(linearLayoutManager);
        this.h = new b(getContext());
        this.a.a(this.h);
        this.a.setOverScrollMode(2);
        addView(this.a);
        this.c = new i(getContext());
        this.a.setAdapter(this.c);
        d();
    }

    public final void a(Point point, Point point2, int i, int i2, int i3) {
        Object obj;
        Object obj2 = 1;
        int i4 = point.y < point2.y ? point.y : point2.y;
        int i5 = point.y > point2.y ? point.y : point2.y;
        if (i4 < 0 || i4 > i) {
            obj = null;
        } else {
            obj = 1;
        }
        if (i5 < 0 || i5 > i) {
            obj2 = null;
        }
        int i6 = (i4 + 0) - i2;
        int i7 = (i - i5) - i3;
        if (obj == null || r1 == null) {
            if (obj == null || r1 != null) {
                if (obj != null || r1 == null) {
                    this.e = ((i + 0) / 2) - this.f;
                } else if (i7 > this.f) {
                    this.e = i5 + i3;
                } else {
                    this.e = (((i5 + 0) - this.f) / 2) + 0;
                }
            } else if (i6 > this.f) {
                this.e = (i4 - i2) - this.f;
            } else {
                this.e = i4 + (((i - i4) - this.f) / 2);
            }
        } else if (i6 > this.f) {
            this.e = (i4 - (i2 / 6)) - this.f;
        } else if (i7 > this.f) {
            this.e = i5 + i3;
        } else {
            this.e = i4 + (((i5 - i4) - this.f) / 2);
        }
        int i8 = this.e;
        i6 = this.d;
        LayoutParams layoutParams = (LayoutParams) getLayoutParams();
        layoutParams.topMargin = i8;
        layoutParams.leftMargin = i6;
        setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void setItems(ArrayList<a> arrayList) {
        if (arrayList != null) {
            i.a(this.c, (ArrayList) arrayList);
            this.c.a.a();
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        measure(makeMeasureSpec, makeMeasureSpec);
        this.f = getMeasuredHeight();
        this.g = getMeasuredWidth();
    }

    public final void setWebMenuListener(e eVar) {
        this.c.c = eVar;
    }

    public final View getContentView() {
        return this;
    }

    public final void b() {
        setVisibility(4);
    }

    public final void c() {
        setVisibility(0);
    }

    public final boolean a() {
        return getVisibility() == 0;
    }

    public final void d() {
        setBackgroundDrawable(a.a("context_menu_bg.9.png"));
        this.h.a = new ColorDrawable(a.c("popmenu_divider_color"));
        this.c.b();
    }
}
