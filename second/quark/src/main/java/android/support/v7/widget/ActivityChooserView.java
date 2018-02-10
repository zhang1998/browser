package android.support.v7.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.bl;
import android.support.v7.c.e;
import android.support.v7.c.f;
import android.support.v7.c.h;
import android.support.v7.c.j;
import android.support.v7.c.l;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.uc.webview.export.extension.UCCore;

/* compiled from: ProGuard */
public class ActivityChooserView extends ViewGroup {
    bl a;
    private final bv b;
    private final dy c;
    private final LinearLayoutCompat d;
    private final Drawable e;
    private final FrameLayout f;
    private final ImageView g;
    private final FrameLayout h;
    private final ImageView i;
    private final int j;
    private final DataSetObserver k;
    private final OnGlobalLayoutListener l;
    private ListPopupWindow m;
    private OnDismissListener n;
    private boolean o;
    private int p;
    private boolean q;
    private int r;

    /* compiled from: ProGuard */
    public class InnerLayout extends LinearLayoutCompat {
        private static final int[] a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            dh a = dh.a(context, attributeSet, a);
            setBackgroundDrawable(a.a(0));
            a.a.recycle();
        }
    }

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.b.getCount() > 0) {
            activityChooserView.f.setEnabled(true);
        } else {
            activityChooserView.f.setEnabled(false);
        }
        int a = activityChooserView.b.a.a();
        int c = activityChooserView.b.a.c();
        if (a == 1 || (a > 1 && c > 0)) {
            activityChooserView.h.setVisibility(0);
            ResolveInfo b = activityChooserView.b.a.b();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.i.setImageDrawable(b.loadIcon(packageManager));
            if (activityChooserView.r != 0) {
                CharSequence loadLabel = b.loadLabel(packageManager);
                activityChooserView.h.setContentDescription(activityChooserView.getContext().getString(activityChooserView.r, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.h.setVisibility(8);
        }
        if (activityChooserView.h.getVisibility() == 0) {
            activityChooserView.d.setBackgroundDrawable(activityChooserView.e);
        } else {
            activityChooserView.d.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = new dz(this);
        this.l = new da(this);
        this.p = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ActivityChooserView, i, 0);
        this.p = obtainStyledAttributes.getInt(h.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(h.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(l.abc_activity_chooser_view, this, true);
        this.c = new dy();
        this.d = (LinearLayoutCompat) findViewById(j.activity_chooser_view_content);
        this.e = this.d.getBackground();
        this.h = (FrameLayout) findViewById(j.default_activity_button);
        this.h.setOnClickListener(this.c);
        this.h.setOnLongClickListener(this.c);
        this.i = (ImageView) this.h.findViewById(j.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(j.expand_activities_button);
        frameLayout.setOnClickListener(this.c);
        frameLayout.setOnTouchListener(new bu(this, frameLayout));
        this.f = frameLayout;
        this.g = (ImageView) frameLayout.findViewById(j.image);
        this.g.setImageDrawable(drawable);
        this.b = new bv();
        this.b.registerDataSetObserver(new eb(this));
        Resources resources = context.getResources();
        this.j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(f.abc_config_prefDialogWidth));
    }

    public void setActivityChooserModel(fs fsVar) {
        bv bvVar = this.b;
        fs fsVar2 = bvVar.c.b.a;
        if (fsVar2 != null && bvVar.c.isShown()) {
            fsVar2.unregisterObserver(bvVar.c.k);
        }
        bvVar.a = fsVar;
        if (fsVar != null && bvVar.c.isShown()) {
            fsVar.registerObserver(bvVar.c.k);
        }
        bvVar.notifyDataSetChanged();
        if (getListPopupWindow().a.isShowing()) {
            b();
            a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.g.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.g.setContentDescription(getContext().getString(i));
    }

    public void setProvider(bl blVar) {
        this.a = blVar;
    }

    public final boolean a() {
        if (getListPopupWindow().a.isShowing() || !this.q) {
            return false;
        }
        this.o = false;
        a(this.p);
        return true;
    }

    private void a(int i) {
        if (this.b.a == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.l);
        boolean z = this.h.getVisibility() == 0;
        int a = this.b.a.a();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || a <= r3 + i) {
            this.b.a(false);
            this.b.a(i);
        } else {
            this.b.a(true);
            this.b.a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.a.isShowing()) {
            if (this.o || !z) {
                this.b.a(true, z);
            } else {
                this.b.a(false, false);
            }
            listPopupWindow.a(Math.min(this.b.a(), this.j));
            listPopupWindow.b();
            if (this.a != null) {
                this.a.a(true);
            }
            listPopupWindow.b.setContentDescription(getContext().getString(e.abc_activitychooserview_choose_application));
        }
    }

    private boolean c() {
        return getListPopupWindow().a.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        fs fsVar = this.b.a;
        if (fsVar != null) {
            fsVar.registerObserver(this.k);
        }
        this.q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fs fsVar = this.b.a;
        if (fsVar != null) {
            fsVar.unregisterObserver(this.k);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.l);
        }
        if (c()) {
            b();
        }
        this.q = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.d;
        if (this.h.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), UCCore.VERIFY_POLICY_QUICK);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.d.layout(0, 0, i3 - i, i4 - i2);
        if (!c()) {
            b();
        }
    }

    public fs getDataModel() {
        return this.b.a;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.n = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.p = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.r = i;
    }

    ListPopupWindow getListPopupWindow() {
        if (this.m == null) {
            this.m = new ListPopupWindow(getContext());
            this.m.a(this.b);
            this.m.j = this;
            this.m.a();
            this.m.k = this.c;
            this.m.a(this.c);
        }
        return this.m;
    }

    public final boolean b() {
        if (getListPopupWindow().a.isShowing()) {
            getListPopupWindow().c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.l);
            }
        }
        return true;
    }
}
