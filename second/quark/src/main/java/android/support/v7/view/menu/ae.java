package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.c.f;
import android.support.v7.c.k;
import android.support.v7.c.l;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* compiled from: ProGuard */
public class ae implements r, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int a = l.abc_popup_menu_item_layout;
    public View b;
    public ListPopupWindow c;
    public m d;
    public boolean e;
    public int f;
    private final Context g;
    private final LayoutInflater h;
    private final u i;
    private final ad j;
    private final boolean k;
    private final int l;
    private final int m;
    private final int n;
    private ViewTreeObserver o;
    private ViewGroup p;
    private boolean q;
    private int r;

    private ae(Context context, u uVar, View view) {
        this(context, uVar, view, false, k.popupMenuStyle);
    }

    public ae(Context context, u uVar, View view, boolean z, int i) {
        this(context, uVar, view, z, i, (byte) 0);
    }

    private ae(Context context, u uVar, View view, boolean z, int i, byte b) {
        this.f = 0;
        this.g = context;
        this.h = LayoutInflater.from(context);
        this.i = uVar;
        this.j = new ad(this, this.i);
        this.k = z;
        this.m = i;
        this.n = 0;
        Resources resources = context.getResources();
        this.l = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(f.abc_config_prefDialogWidth));
        this.b = view;
        uVar.a((r) this, context);
    }

    public final boolean a() {
        int i = 0;
        this.c = new ListPopupWindow(this.g, null, this.m, this.n);
        this.c.a((OnDismissListener) this);
        this.c.k = this;
        this.c.a(this.j);
        this.c.a();
        View view = this.b;
        if (view == null) {
            return false;
        }
        boolean z = this.o == null;
        this.o = view.getViewTreeObserver();
        if (z) {
            this.o.addOnGlobalLayoutListener(this);
        }
        this.c.j = view;
        this.c.g = this.f;
        if (!this.q) {
            ListAdapter listAdapter = this.j;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i2 = 0;
            int i3 = 0;
            View view2 = null;
            while (i2 < count) {
                View view3;
                int itemViewType = listAdapter.getItemViewType(i2);
                if (itemViewType != i3) {
                    i3 = itemViewType;
                    view3 = null;
                } else {
                    view3 = view2;
                }
                if (this.p == null) {
                    this.p = new FrameLayout(this.g);
                }
                view2 = listAdapter.getView(i2, view3, this.p);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.l) {
                    i = this.l;
                    break;
                }
                if (itemViewType <= i) {
                    itemViewType = i;
                }
                i2++;
                i = itemViewType;
            }
            this.r = i;
            this.q = true;
        }
        this.c.a(this.r);
        this.c.d();
        this.c.b();
        this.c.b.setOnKeyListener(this);
        return true;
    }

    public final void c() {
        if (d()) {
            this.c.c();
        }
    }

    public void onDismiss() {
        this.c = null;
        this.i.close();
        if (this.o != null) {
            if (!this.o.isAlive()) {
                this.o = this.b.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this);
            this.o = null;
        }
    }

    public final boolean d() {
        return this.c != null && this.c.a.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ad adVar = this.j;
        adVar.b.a(adVar.a(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        c();
        return true;
    }

    public void onGlobalLayout() {
        if (d()) {
            View view = this.b;
            if (view == null || !view.isShown()) {
                c();
            } else if (d()) {
                this.c.b();
            }
        }
    }

    public final void a(Context context, u uVar) {
    }

    public final void a(boolean z) {
        this.q = false;
        if (this.j != null) {
            this.j.notifyDataSetChanged();
        }
    }

    public final boolean a(a aVar) {
        if (aVar.hasVisibleItems()) {
            boolean z;
            ae aeVar = new ae(this.g, aVar, this.b);
            aeVar.d = this.d;
            int size = aVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = aVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            aeVar.e = z;
            if (aeVar.a()) {
                if (this.d == null) {
                    return true;
                }
                this.d.a(aVar);
                return true;
            }
        }
        return false;
    }

    public final void a(u uVar, boolean z) {
        if (uVar == this.i) {
            c();
            if (this.d != null) {
                this.d.a(uVar, z);
            }
        }
    }

    public final boolean b() {
        return false;
    }

    public final boolean a(i iVar) {
        return false;
    }

    public final boolean b(i iVar) {
        return false;
    }
}
