package com.ucpro.feature.z.d;

import android.animation.LayoutTransition;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import com.ucpro.ui.c.a;
import com.ucpro.ui.f.b;
import com.ucpro.ui.f.e;
import com.ucpro.ui.f.f;
import com.ucweb.common.util.c;

/* compiled from: ProGuard */
public final class g extends ViewGroup implements OnClickListener, OnLongClickListener, h {
    public j a = null;
    LayoutTransition b = null;
    private b c = null;
    private b d = null;
    private Context e = null;
    private int f = 0;
    private int g = 0;
    private long h = 200;

    public g(Context context) {
        super(context);
        this.e = context;
        this.f = a.c((int) R.dimen.search_input_history_delete_all_margin_bottom);
        this.g = a.c((int) R.dimen.search_input_history_delete_all_margin_right);
        this.d = new b(this.e);
        this.d.setStackFromBottom(true);
        this.d.setPadding(0, 0, 0, a.c((int) R.dimen.search_input_history_padding_bottom));
        this.b = new LayoutTransition();
        this.b.setDuration(200);
        this.d.setLayoutTransition(this.b);
        addView(this.d);
        this.a = new j(this.e, "searchpage_input_history_delete_all.svg", "search_input_history_delete_button_bg_color", "search_input_history_delete_button_text_color", a.d((int) R.string.delete_all));
        this.a.setListener(new q(this));
        addView(this.a);
        a();
    }

    public final void a() {
        this.a.a();
        this.d.c();
    }

    public final void setPresenter(com.ucpro.base.d.b bVar) {
        c.a((Object) bVar);
        c.b(bVar instanceof b);
        this.c = (b) bVar;
    }

    protected final void onMeasure(int i, int i2) {
        this.d.measure(i, i2);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(a.c((int) R.dimen.search_input_history_keyword_text_height), UCCore.VERIFY_POLICY_QUICK);
        this.a.measure(makeMeasureSpec, makeMeasureSpec);
        setMeasuredDimension(this.d.getMeasuredWidth(), (this.d.getMeasuredHeight() + this.a.getMeasuredHeight()) + this.f);
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth() - this.g;
        this.a.layout(measuredWidth - this.a.getMeasuredWidth(), 0, measuredWidth, this.a.getMeasuredHeight() + 0);
        int bottom = this.a.getBottom() + this.f;
        this.d.layout(0, bottom, this.d.getMeasuredWidth() + 0, this.d.getMeasuredHeight() + bottom);
    }

    public final void setAdapter(e eVar) {
        this.d.setAdapter(eVar);
    }

    public final void a(boolean z, long j) {
        if (getVisibility() != 8) {
            if (z) {
                setAlpha(IPictureView.DEFAULT_MIN_SCALE);
                setPivotX((float) (getMeasuredWidth() / 2));
                setPivotY((float) getMeasuredHeight());
                animate().setDuration(j).alpha(0.0f).rotationX(5.0f);
                return;
            }
            setVisibility(8);
        }
    }

    public final void a(long j) {
        if (getVisibility() != 0 && this.c.b()) {
            setVisibility(0);
            setAlpha(IPictureView.DEFAULT_MIN_SCALE);
            setRotationX(0.0f);
            this.d.setPivotX((float) (this.d.getMeasuredWidth() / 2));
            this.d.setPivotY((float) this.d.getMeasuredHeight());
            this.d.setAlpha(0.0f);
            this.a.setScaleX(0.0f);
            this.a.setScaleY(0.0f);
            this.a.setPivotX((float) (this.a.getMeasuredWidth() - (this.a.getMeasuredHeight() / 2)));
            this.a.setPivotY((float) (this.a.getMeasuredHeight() / 2));
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, IPictureView.DEFAULT_MIN_SCALE});
            ofFloat.addUpdateListener(new f(this));
            ofFloat.setDuration(250).setStartDelay(j);
            ofFloat.start();
        }
    }

    public final void setMaxLines(int i) {
        this.d.setMaxLines(i);
    }

    public final void a(View view) {
        if (view instanceof r) {
            ((r) view).setBgColor(a.c("default_background_white"));
            ((r) view).getBorderView().setVisibility(0);
            View deleteBtn = ((r) view).getDeleteBtn();
            deleteBtn.setVisibility(0);
            deleteBtn.setScaleX(0.0f);
            deleteBtn.setScaleY(0.0f);
            deleteBtn.animate().scaleX(IPictureView.DEFAULT_MIN_SCALE).scaleY(IPictureView.DEFAULT_MIN_SCALE).setDuration(this.h).setListener(null);
        }
    }

    public final void b() {
        int childCount = this.d.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            c.b(childAt instanceof f);
            View tagView = ((f) childAt).getTagView();
            if (tagView instanceof r) {
                ((r) tagView).setBgColor(a.c("default_bubble"));
                ((r) tagView).getBorderView().setVisibility(8);
                childAt = ((r) tagView).getDeleteBtn();
                childAt.animate().scaleX(0.0f).scaleY(0.0f).setDuration(this.h).setListener(new m(this, childAt));
            }
        }
    }

    public final void a(int i) {
        for (int i2 = i + 1; i2 < this.d.getChildCount(); i2++) {
            ((r) ((f) this.d.getChildAt(i2)).getTagView()).setPosition(i2 - 1);
        }
        this.d.removeViewAt(i);
        this.d.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), UCCore.VERIFY_POLICY_QUICK), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), SectionHeader.SHT_LOUSER));
        this.d.layout(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
    }

    public final void c() {
        this.d.removeAllViews();
    }

    public final int a(int i, int i2) {
        this.d.measure(i, i2);
        return this.d.getMaxContainChildCount();
    }

    public final void onClick(View view) {
        if (this.c != null) {
        }
    }

    public final boolean onLongClick(View view) {
        if (this.c != null && view == this.d) {
            this.c.a(view);
        }
        return false;
    }
}
