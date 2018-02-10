package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.bo;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.support.v7.c.k;
import android.support.v7.c.l;
import android.support.v7.view.menu.u;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class ActionBarContextView extends fo {
    public View a;
    public boolean b;
    private CharSequence i;
    private CharSequence j;
    private View k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private int o;
    private int p;
    private int q;

    public final /* bridge */ /* synthetic */ bo a(int i, long j) {
        return super.a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dh a = dh.a(context, attributeSet, h.ActionMode, i);
        setBackgroundDrawable(a.a(h.ActionMode_background));
        this.o = a.e(h.ActionMode_titleTextStyle, 0);
        this.p = a.e(h.ActionMode_subtitleTextStyle, 0);
        this.g = a.d(h.ActionMode_height, 0);
        this.q = a.e(h.ActionMode_closeItemLayout, l.abc_action_mode_close_item_material);
        a.a.recycle();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f != null) {
            this.f.d();
            this.f.f();
        }
    }

    public void setContentHeight(int i) {
        this.g = i;
    }

    public void setCustomView(View view) {
        if (this.k != null) {
            removeView(this.k);
        }
        this.k = view;
        if (!(view == null || this.l == null)) {
            removeView(this.l);
            this.l = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.i = charSequence;
        c();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        c();
    }

    public CharSequence getTitle() {
        return this.i;
    }

    public CharSequence getSubtitle() {
        return this.j;
    }

    private void c() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.l == null) {
            LayoutInflater.from(getContext()).inflate(l.abc_action_bar_title_item, this);
            this.l = (LinearLayout) getChildAt(getChildCount() - 1);
            this.m = (TextView) this.l.findViewById(j.action_bar_title);
            this.n = (TextView) this.l.findViewById(j.action_bar_subtitle);
            if (this.o != 0) {
                this.m.setTextAppearance(getContext(), this.o);
            }
            if (this.p != 0) {
                this.n.setTextAppearance(getContext(), this.p);
            }
        }
        this.m.setText(this.i);
        this.n.setText(this.j);
        Object obj2 = !TextUtils.isEmpty(this.i) ? 1 : null;
        if (TextUtils.isEmpty(this.j)) {
            obj = null;
        }
        TextView textView = this.n;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.l;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.l.getParent() == null) {
            addView(this.l);
        }
    }

    public final void a(android.support.v7.view.h hVar) {
        if (this.a == null) {
            this.a = LayoutInflater.from(getContext()).inflate(this.q, this, false);
            addView(this.a);
        } else if (this.a.getParent() == null) {
            addView(this.a);
        }
        this.a.findViewById(j.action_mode_close_button).setOnClickListener(new er(this, hVar));
        u uVar = (u) hVar.d();
        if (this.f != null) {
            this.f.e();
        }
        this.f = new ActionMenuPresenter(getContext());
        this.f.a();
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        uVar.a(this.f, this.d);
        this.e = (ActionMenuView) this.f.a((ViewGroup) this);
        this.e.setBackgroundDrawable(null);
        addView(this.e, layoutParams);
    }

    public final void a() {
        removeAllViews();
        this.k = null;
        this.e = null;
    }

    public final boolean b() {
        if (this.f != null) {
            return this.f.c();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = UCCore.VERIFY_POLICY_QUICK;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != UCCore.VERIFY_POLICY_QUICK) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.g > 0 ? this.g : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, SectionHeader.SHT_LOUSER);
            if (this.a != null) {
                a = fo.a(this.a, paddingLeft, makeMeasureSpec);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.e != null && this.e.getParent() == this) {
                paddingLeft = fo.a(this.e, paddingLeft, makeMeasureSpec);
            }
            if (this.l != null && this.k == null) {
                if (this.b) {
                    this.l.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.l.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.l.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = fo.a(this.l, paddingLeft, makeMeasureSpec);
                }
            }
            if (this.k != null) {
                int min;
                LayoutParams layoutParams = this.k.getLayoutParams();
                makeMeasureSpec = layoutParams.width != -2 ? UCCore.VERIFY_POLICY_QUICK : SectionHeader.SHT_LOUSER;
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = SectionHeader.SHT_LOUSER;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.k.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.g <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = co.a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.a == null || this.a.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = fo.a(paddingRight, i6, a);
            paddingRight = fo.a(paddingRight + fo.a(this.a, paddingRight, paddingTop, paddingTop2, a), i5, a);
        }
        if (!(this.l == null || this.k != null || this.l.getVisibility() == 8)) {
            paddingRight += fo.a(this.l, paddingRight, paddingTop, paddingTop2, a);
        }
        if (this.k != null) {
            fo.a(this.k, paddingRight, paddingTop, paddingTop2, a);
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.e != null) {
            fo.a(this.e, i5, paddingTop, paddingTop2, !a);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.i);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.b) {
            requestLayout();
        }
        this.b = z;
    }
}
