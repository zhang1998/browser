package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.c.c;
import android.support.v4.widget.s;
import android.support.v7.c.h;
import android.support.v7.c.k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.uc.imagecodec.export.IPictureView;
import com.uc.webview.export.extension.UCCore;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class ListPopupWindow {
    private static Method l;
    private static Method m;
    private final dp A;
    private Runnable B;
    private final Handler C;
    private Rect D;
    private boolean E;
    private int F;
    public PopupWindow a;
    public dk b;
    int c;
    int d;
    int e;
    boolean f;
    public int g;
    int h;
    int i;
    public View j;
    public OnItemClickListener k;
    private Context n;
    private ListAdapter o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private View t;
    private DataSetObserver u;
    private Drawable v;
    private OnItemSelectedListener w;
    private final em x;
    private final eo y;
    private final fi z;

    static {
        try {
            l = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
        }
        try {
            m = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, k.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, k.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -2;
        this.c = -2;
        this.q = 1002;
        this.g = 0;
        this.r = false;
        this.s = false;
        this.h = Integer.MAX_VALUE;
        this.i = 0;
        this.x = new em();
        this.y = new eo();
        this.z = new fi();
        this.A = new dp();
        this.D = new Rect();
        this.n = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.ListPopupWindow, i, i2);
        this.d = obtainStyledAttributes.getDimensionPixelOffset(h.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.e = obtainStyledAttributes.getDimensionPixelOffset(h.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.e != 0) {
            this.f = true;
        }
        obtainStyledAttributes.recycle();
        this.a = new AppCompatPopupWindow(context, attributeSet, i);
        this.a.setInputMethodMode(1);
        this.F = c.a(this.n.getResources().getConfiguration().locale);
    }

    public void a(ListAdapter listAdapter) {
        if (this.u == null) {
            this.u = new dd();
        } else if (this.o != null) {
            this.o.unregisterDataSetObserver(this.u);
        }
        this.o = listAdapter;
        if (this.o != null) {
            listAdapter.registerDataSetObserver(this.u);
        }
        if (this.b != null) {
            this.b.setAdapter(this.o);
        }
    }

    public final void a() {
        this.E = true;
        this.a.setFocusable(true);
    }

    public final void a(Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
    }

    public final void a(int i) {
        Drawable background = this.a.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            this.c = (this.D.left + this.D.right) + i;
            return;
        }
        this.c = i;
    }

    public void b() {
        int i;
        int i2;
        boolean z;
        int makeMeasureSpec;
        boolean z2 = true;
        LayoutParams layoutParams;
        View view;
        if (this.b == null) {
            Context context = this.n;
            this.B = new dv(this);
            this.b = new dk(context, !this.E);
            if (this.v != null) {
                this.b.setSelector(this.v);
            }
            this.b.setAdapter(this.o);
            this.b.setOnItemClickListener(this.k);
            this.b.setFocusable(true);
            this.b.setFocusableInTouchMode(true);
            this.b.setOnItemSelectedListener(new ck(this));
            this.b.setOnScrollListener(this.z);
            if (this.w != null) {
                this.b.setOnItemSelectedListener(this.w);
            }
            View view2 = this.b;
            View view3 = this.t;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, IPictureView.DEFAULT_MIN_SCALE);
                switch (this.i) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.i);
                        break;
                }
                if (this.c >= 0) {
                    i = this.c;
                    i2 = SectionHeader.SHT_LOUSER;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.a.setContentView(view);
        } else {
            this.a.getContentView();
            view = this.t;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i2 = 0;
            }
        }
        Drawable background = this.a.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            i = this.D.top + this.D.bottom;
            if (!this.f) {
                this.e = -this.D.top;
            }
        } else {
            this.D.setEmpty();
            i = 0;
        }
        if (this.a.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        int a = a(this.j, this.e, z);
        if (this.r || this.p == -1) {
            i2 = a + i;
        } else {
            switch (this.c) {
                case -2:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.n.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), SectionHeader.SHT_LOUSER);
                    break;
                case -1:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.n.getResources().getDisplayMetrics().widthPixels - (this.D.left + this.D.right), UCCore.VERIFY_POLICY_QUICK);
                    break;
                default:
                    makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.c, UCCore.VERIFY_POLICY_QUICK);
                    break;
            }
            makeMeasureSpec = this.b.a(makeMeasureSpec, a - i2);
            if (makeMeasureSpec > 0) {
                i2 += i;
            }
            i2 += makeMeasureSpec;
        }
        z = f();
        s.a(this.a, this.q);
        if (this.a.isShowing()) {
            if (this.c == -1) {
                i = -1;
            } else if (this.c == -2) {
                i = this.j.getWidth();
            } else {
                i = this.c;
            }
            if (this.p == -1) {
                if (z) {
                    makeMeasureSpec = i2;
                } else {
                    makeMeasureSpec = -1;
                }
                PopupWindow popupWindow;
                if (z) {
                    popupWindow = this.a;
                    if (this.c == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.a.setHeight(0);
                    a = makeMeasureSpec;
                } else {
                    popupWindow = this.a;
                    if (this.c == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.a.setHeight(-1);
                    a = makeMeasureSpec;
                }
            } else if (this.p != -2) {
                a = this.p;
            } else {
                a = i2;
            }
            PopupWindow popupWindow2 = this.a;
            if (this.s || this.r) {
                z2 = false;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.a;
            View view4 = this.j;
            int i3 = this.d;
            makeMeasureSpec = this.e;
            if (i < 0) {
                i = -1;
            }
            if (a < 0) {
                a = -1;
            }
            popupWindow2.update(view4, i3, makeMeasureSpec, i, a);
            return;
        }
        if (this.c == -1) {
            makeMeasureSpec = -1;
        } else if (this.c == -2) {
            makeMeasureSpec = this.j.getWidth();
        } else {
            makeMeasureSpec = this.c;
        }
        if (this.p == -1) {
            i2 = -1;
        } else if (this.p != -2) {
            i2 = this.p;
        }
        this.a.setWidth(makeMeasureSpec);
        this.a.setHeight(i2);
        if (l != null) {
            try {
                l.invoke(this.a, new Object[]{Boolean.valueOf(true)});
            } catch (Exception e) {
            }
        }
        popupWindow2 = this.a;
        if (this.s || this.r) {
            z2 = false;
        }
        popupWindow2.setOutsideTouchable(z2);
        this.a.setTouchInterceptor(this.y);
        s.a(this.a, this.j, this.d, this.e, this.g);
        this.b.setSelection(-1);
        if (!this.E || this.b.isInTouchMode()) {
            e();
        }
        if (!this.E) {
            this.C.post(this.A);
        }
    }

    public final void c() {
        this.a.dismiss();
        if (this.t != null) {
            ViewParent parent = this.t.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.t);
            }
        }
        this.a.setContentView(null);
        this.b = null;
        this.C.removeCallbacks(this.x);
    }

    public final void a(OnDismissListener onDismissListener) {
        this.a.setOnDismissListener(onDismissListener);
    }

    public final void d() {
        this.a.setInputMethodMode(2);
    }

    public final void e() {
        dk dkVar = this.b;
        if (dkVar != null) {
            dkVar.h = true;
            dkVar.requestLayout();
        }
    }

    public final boolean f() {
        return this.a.getInputMethodMode() == 2;
    }

    private int a(View view, int i, boolean z) {
        if (m != null) {
            try {
                return ((Integer) m.invoke(this.a, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
            }
        }
        return this.a.getMaxAvailableHeight(view, i);
    }
}
