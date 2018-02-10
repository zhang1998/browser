package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.aj;
import android.support.v7.c.k;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
final class fr extends LinearLayoutCompat implements OnLongClickListener {
    aj a;
    final /* synthetic */ fu b;
    private final int[] c = new int[]{16842964};
    private TextView d;
    private ImageView e;
    private View f;

    public fr(fu fuVar, Context context, aj ajVar) {
        this.b = fuVar;
        super(context, null, k.actionBarTabStyle);
        this.a = ajVar;
        dh a = dh.a(context, null, this.c, k.actionBarTabStyle);
        if (a.e(0)) {
            setBackgroundDrawable(a.a(0));
        }
        a.a.recycle();
        setGravity(8388627);
        a();
    }

    public final void setSelected(boolean z) {
        Object obj = isSelected() != z ? 1 : null;
        super.setSelected(z);
        if (obj != null && z) {
            sendAccessibilityEvent(4);
        }
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(aj.class.getName());
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(aj.class.getName());
        }
    }

    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b.b > 0 && getMeasuredWidth() > this.b.b) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(this.b.b, UCCore.VERIFY_POLICY_QUICK), i2);
        }
    }

    public final void a() {
        aj ajVar = this.a;
        View c = ajVar.c();
        if (c != null) {
            fr parent = c.getParent();
            if (parent != this) {
                if (parent != null) {
                    parent.removeView(c);
                }
                addView(c);
            }
            this.f = c;
            if (this.d != null) {
                this.d.setVisibility(8);
            }
            if (this.e != null) {
                this.e.setVisibility(8);
                this.e.setImageDrawable(null);
                return;
            }
            return;
        }
        boolean z;
        if (this.f != null) {
            removeView(this.f);
            this.f = null;
        }
        Drawable a = ajVar.a();
        CharSequence b = ajVar.b();
        if (a != null) {
            if (this.e == null) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.h = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView, 0);
                this.e = imageView;
            }
            this.e.setImageDrawable(a);
            this.e.setVisibility(0);
        } else if (this.e != null) {
            this.e.setVisibility(8);
            this.e.setImageDrawable(null);
        }
        if (TextUtils.isEmpty(b)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            if (this.d == null) {
                imageView = new AppCompatTextView(getContext(), null, k.actionBarTabTextStyle);
                imageView.setEllipsize(TruncateAt.END);
                layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
                layoutParams.h = 16;
                imageView.setLayoutParams(layoutParams);
                addView(imageView);
                this.d = imageView;
            }
            this.d.setText(b);
            this.d.setVisibility(0);
        } else if (this.d != null) {
            this.d.setVisibility(8);
            this.d.setText(null);
        }
        if (this.e != null) {
            this.e.setContentDescription(ajVar.d());
        }
        if (z || TextUtils.isEmpty(ajVar.d())) {
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
        Toast makeText = Toast.makeText(context, this.a.d(), 0);
        makeText.setGravity(49, (iArr[0] + (width / 2)) - (i / 2), height);
        makeText.show();
        return true;
    }
}
