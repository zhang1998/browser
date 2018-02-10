package com.ucpro.ui.widget.tablayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.bf;
import android.support.v7.app.aj;
import android.support.v7.widget.fb;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.quark.browser.R;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class q extends LinearLayout implements OnLongClickListener {
    final /* synthetic */ ProTabLayout a;
    private c b;
    private TextView c;
    private ImageView d;
    private View e;
    private TextView f;
    private ImageView g;
    private int h = 2;

    public q(ProTabLayout proTabLayout, Context context) {
        this.a = proTabLayout;
        super(context);
        if (proTabLayout.m != 0) {
            setBackgroundDrawable(fb.a().a(context, proTabLayout.m, false));
        }
        ViewCompat.b(this, proTabLayout.e, proTabLayout.f, proTabLayout.g, proTabLayout.h);
        setGravity(17);
        setOrientation(1);
        setClickable(true);
    }

    public final boolean performClick() {
        boolean performClick = super.performClick();
        if (this.b == null) {
            return performClick;
        }
        this.b.a();
        return true;
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
            if (this.c != null) {
                this.c.setSelected(z);
            }
            if (this.d != null) {
                this.d.setSelected(z);
            }
        }
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(aj.class.getName());
    }

    @TargetApi(14)
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(aj.class.getName());
    }

    public final void onMeasure(int i, int i2) {
        int i3 = 1;
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int f = this.a.getTabMaxWidth();
        if (f > 0 && (mode == 0 || size > f)) {
            i = MeasureSpec.makeMeasureSpec(this.a.n, SectionHeader.SHT_LOUSER);
        }
        super.onMeasure(i, i2);
        if (this.c != null) {
            float h = this.a.k;
            size = this.h;
            if (this.d != null && this.d.getVisibility() == 0) {
                size = 1;
            } else if (this.c != null && this.c.getLineCount() > 1) {
                h = this.a.l;
            }
            float textSize = this.c.getTextSize();
            int lineCount = this.c.getLineCount();
            int a = bf.a(this.c);
            if (h != textSize || (a >= 0 && size != a)) {
                if (this.a.t == 1 && h > textSize && lineCount == 1) {
                    Layout layout = this.c.getLayout();
                    if (layout == null || layout.getLineWidth(0) * (h / layout.getPaint().getTextSize()) > ((float) layout.getWidth())) {
                        i3 = 0;
                    }
                }
                if (i3 != 0) {
                    this.c.setTextSize(0, h);
                    this.c.setMaxLines(size);
                    super.onMeasure(i, i2);
                }
            }
        }
    }

    private void a(@Nullable c cVar) {
        if (cVar != this.b) {
            this.b = cVar;
            a();
        }
    }

    final void a() {
        View view;
        c cVar = this.b;
        if (cVar != null) {
            view = cVar.f;
        } else {
            view = null;
        }
        if (view != null) {
            q parent = view.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(view);
                }
                addView(view);
            }
            this.e = view;
            if (this.c != null) {
                this.c.setVisibility(8);
            }
            if (this.d != null) {
                this.d.setVisibility(8);
                this.d.setImageDrawable(null);
            }
            this.f = (TextView) view.findViewById(16908308);
            if (this.f != null) {
                this.h = bf.a(this.f);
            }
            this.g = (ImageView) view.findViewById(16908294);
        } else {
            if (this.e != null) {
                removeView(this.e);
                this.e = null;
            }
            this.f = null;
            this.g = null;
        }
        if (this.e == null) {
            if (this.d == null) {
                ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
                addView(imageView, 0);
                this.d = imageView;
            }
            if (this.c == null) {
                TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
                addView(textView);
                this.c = textView;
                this.h = bf.a(this.c);
            }
            this.c.setTextAppearance(getContext(), this.a.i);
            this.c.setTypeface(null, !this.a.C ? 0 : this.a.D);
            this.c.setAllCaps(this.a.E);
            if (this.a.j != null) {
                this.c.setTextColor(this.a.j);
            }
            a(this.c, this.d);
        } else if (this.f != null || this.g != null) {
            a(this.f, this.g);
        }
    }

    private void a(@Nullable TextView textView, @Nullable ImageView imageView) {
        Drawable drawable;
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z;
        if (this.b != null) {
            drawable = this.b.b;
        } else {
            drawable = null;
        }
        if (this.b != null) {
            charSequence = this.b.c;
        } else {
            charSequence = null;
        }
        if (this.b != null) {
            charSequence2 = this.b.d;
        } else {
            charSequence2 = null;
        }
        if (imageView != null) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                setVisibility(0);
            } else {
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
            }
            imageView.setContentDescription(charSequence2);
        }
        if (TextUtils.isEmpty(charSequence)) {
            z = false;
        } else {
            z = true;
        }
        if (textView != null) {
            if (z) {
                textView.setText(charSequence);
                textView.setVisibility(0);
                setVisibility(0);
            } else {
                textView.setVisibility(8);
                textView.setText(null);
            }
            textView.setContentDescription(charSequence2);
        }
        if (imageView != null) {
            int a;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
            if (z && imageView.getVisibility() == 0) {
                a = this.a.b(8);
            } else {
                a = 0;
            }
            if (a != marginLayoutParams.bottomMargin) {
                marginLayoutParams.bottomMargin = a;
                imageView.requestLayout();
            }
        }
        if (z || TextUtils.isEmpty(charSequence2)) {
            setOnLongClickListener(null);
            setLongClickable(false);
            return;
        }
        setOnLongClickListener(this);
    }

    public final boolean onLongClick(View view) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = context.getResources().getDisplayMetrics().widthPixels;
        Toast makeText = Toast.makeText(context, this.b.d, 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }

    static /* synthetic */ void a(q qVar) {
        qVar.a(null);
        qVar.setSelected(false);
    }
}
