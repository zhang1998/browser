package com.ucpro.feature.p;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quark.browser.R;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;

/* compiled from: ProGuard */
public final class h extends ViewGroup implements OnClickListener {
    ViewGroup a;
    ViewGroup b;
    ImageView c;
    TextView d;
    TextView e;
    View f;
    int g = a.c((int) R.dimen.mainmenu_leftview_margin_right);
    private int h = a.c((int) R.dimen.mainmenu_content_padding);
    private int i = a.c((int) R.dimen.mainmenu_firstrow_margin_top);
    private int j = a.c((int) R.dimen.mainmenu_row_height);
    private int k = a.c((int) R.dimen.mainmenu_left_image_width);
    private int l = a.c((int) R.dimen.mainmenu_leftview_margin_top);
    private q m;

    public h(Context context) {
        super(context);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.c != null) {
            this.c.measure(MeasureSpec.makeMeasureSpec(this.k + (this.g * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.k, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.d != null) {
            this.d.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.mainmenu_left_lable_maxwidth), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.e != null) {
            this.e.measure(MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.mainmenu_left_lable_maxwidth), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (this.f != null) {
            this.f.measure(MeasureSpec.makeMeasureSpec(this.k, UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.k, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.a != null) {
            this.a.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (this.h * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.j, UCCore.VERIFY_POLICY_QUICK));
        }
        if (this.b != null) {
            this.b.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth() - (this.h * 2), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(this.j, UCCore.VERIFY_POLICY_QUICK));
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.a != null) {
            int i5 = this.h;
            int measuredWidth = this.a.getMeasuredWidth() + i5;
            int i6 = this.i;
            this.a.layout(i5, i6, measuredWidth, this.a.getMeasuredHeight() + i6);
        }
        if (this.b != null) {
            i5 = this.h;
            measuredWidth = this.b.getMeasuredWidth() + i5;
            i6 = this.a.getBottom();
            this.b.layout(i5, i6, measuredWidth, this.b.getMeasuredHeight() + i6);
        }
        if (!(this.c == null || this.a.getChildAt(0) == null)) {
            i5 = this.a.getLeft() + ((this.a.getChildAt(0).getMeasuredWidth() - this.c.getMeasuredWidth()) / 2);
            measuredWidth = this.c.getMeasuredWidth() + i5;
            i6 = this.l;
            this.c.layout(i5, i6, measuredWidth, this.c.getMeasuredHeight() + i6);
        }
        if (this.d != null) {
            i5 = this.c.getRight();
            i6 = this.c.getTop() + (((this.k - this.d.getMeasuredHeight()) - this.e.getMeasuredHeight()) / 2);
            this.d.layout(i5, i6, this.d.getMeasuredWidth() + i5, this.d.getMeasuredHeight() + i6);
        }
        if (this.e != null) {
            i5 = this.d.getLeft();
            measuredWidth = this.e.getMeasuredWidth() + i5;
            i6 = this.d.getBottom();
            this.e.layout(i5, i6, measuredWidth, this.e.getMeasuredHeight() + i6);
        }
        if (this.f != null && this.a.getChildAt(0) != null) {
            i5 = this.a.getChildAt(0).getMeasuredWidth();
            i5 = ((i5 - this.f.getMeasuredWidth()) / 2) + (this.a.getRight() - i5);
            measuredWidth = this.f.getMeasuredWidth() + i5;
            i6 = this.l;
            this.f.layout(i5, i6, measuredWidth, this.f.getMeasuredHeight() + i6);
        }
    }

    public final void a() {
        if (this.d != null) {
            this.d.setTextColor(a.c("default_maintext_gray"));
        }
        if (this.e != null) {
            this.e.setTextColor(a.c("default_assisttext_gray"));
        }
        a(this.a);
        a(this.b);
    }

    private static void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                        View childAt2 = viewGroup2.getChildAt(i2);
                        if (childAt2 instanceof c) {
                            ((c) childAt2).a();
                        }
                    }
                }
            }
        }
    }

    final ViewGroup a(b[] bVarArr) {
        ViewGroup aVar = new com.ucpro.ui.widget.a(getContext());
        aVar.setMaxItemCount(4);
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            View view;
            b bVar = bVarArr[i];
            if (bVar == null) {
                view = new View(getContext());
            } else {
                view = new c(getContext(), bVar);
                view.setId(bVar.a);
                view.setOnClickListener(this);
            }
            int i3 = i2 + 1;
            aVar.a(view, i2);
            i++;
            i2 = i3;
        }
        return aVar;
    }

    public final void onClick(View view) {
        if (this.m != null) {
            this.m.a(view.getId());
        }
    }

    public final ViewGroup getFirstRow() {
        return this.a;
    }

    public final ViewGroup getSecondRow() {
        return this.b;
    }

    public final View getLeftImage() {
        return this.c;
    }

    public final View getmRightView() {
        return this.f;
    }

    public final void a(boolean z, int i) {
        if (this.f != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, -10.0f, 0.0f});
            ofFloat.setDuration((long) i);
            ofFloat.addUpdateListener(new l(this, i, z));
            ofFloat.start();
        }
    }

    public final void setVisibility(int i) {
        this.c.setVisibility(i);
        this.d.setVisibility(i);
        this.e.setVisibility(i);
        this.a.setVisibility(i);
        this.b.setVisibility(i);
    }

    public final void setOnItemClickListener(q qVar) {
        this.m = qVar;
    }
}
