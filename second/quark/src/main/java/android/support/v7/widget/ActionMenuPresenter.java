package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.bl;
import android.support.v4.view.ce;
import android.support.v4.view.eh;
import android.support.v7.c.l;
import android.support.v7.view.g;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.ae;
import android.support.v7.view.menu.c;
import android.support.v7.view.menu.d;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.k;
import android.support.v7.view.menu.u;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

/* compiled from: ProGuard */
final class ActionMenuPresenter extends c implements ce {
    private final SparseBooleanArray A = new SparseBooleanArray();
    private View B;
    private cc C;
    fg i;
    Drawable j;
    boolean k;
    int l;
    boolean m;
    boolean n;
    ef o;
    ev p;
    fd q;
    final ei r = new ei();
    int s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private int z;

    /* compiled from: ProGuard */
    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new fp();
        public int a;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, l.abc_action_menu_layout, l.abc_action_menu_item_layout);
    }

    public final void a(Context context, u uVar) {
        boolean z = true;
        super.a(context, uVar);
        Resources resources = context.getResources();
        g a = g.a(context);
        if (!this.u) {
            if (VERSION.SDK_INT < 19 && eh.b(ViewConfiguration.get(a.a))) {
                z = false;
            }
            this.t = z;
        }
        if (!this.y) {
            this.v = a.a.getResources().getDisplayMetrics().widthPixels / 2;
        }
        if (!this.m) {
            this.l = a.a.getResources().getInteger(android.support.v7.c.c.abc_max_action_buttons);
        }
        int i = this.v;
        if (this.t) {
            if (this.i == null) {
                this.i = new fg(this, this.a);
                if (this.k) {
                    this.i.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.w = i;
        this.z = (int) (56.0f * resources.getDisplayMetrics().density);
        this.B = null;
    }

    public final void a() {
        this.t = true;
        this.u = true;
    }

    public final d a(ViewGroup viewGroup) {
        d a = super.a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public final View a(i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.i()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(ActionMenuView.a(layoutParams));
        }
        return actionView;
    }

    public final void a(i iVar, k kVar) {
        kVar.a(iVar);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) kVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.g);
        if (this.C == null) {
            this.C = new cc();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public final boolean c(i iVar) {
        return iVar.f();
    }

    public final void a(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ((View) this.g).getParent();
        super.a(z);
        ((View) this.g).requestLayout();
        if (this.c != null) {
            u uVar = this.c;
            uVar.j();
            ArrayList arrayList = uVar.e;
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                bl blVar = ((i) arrayList.get(i)).d;
                if (blVar != null) {
                    blVar.e = this;
                }
            }
        }
        ArrayList k = this.c != null ? this.c.k() : null;
        if (this.t && k != null) {
            i = k.size();
            if (i == 1) {
                int i4;
                if (((i) k.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.i == null) {
                this.i = new fg(this, this.a);
            }
            ViewGroup viewGroup = (ViewGroup) this.i.getParent();
            if (viewGroup != this.g) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                ((ActionMenuView) this.g).addView(this.i, ActionMenuView.a());
            }
        } else if (this.i != null && this.i.getParent() == this.g) {
            ((ViewGroup) this.g).removeView(this.i);
        }
        ((ActionMenuView) this.g).setOverflowReserved(this.t);
    }

    public final boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.i) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    public final boolean a(a aVar) {
        if (!aVar.hasVisibleItems()) {
            return false;
        }
        View view;
        a aVar2 = aVar;
        while (aVar2.a != this.c) {
            aVar2 = (a) aVar2.a;
        }
        i item = aVar2.getItem();
        ViewGroup viewGroup = (ViewGroup) this.g;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof k) && ((k) childAt).getItemData() == item) {
                    view = childAt;
                    break;
                }
            }
        }
        view = null;
        if (view == null) {
            if (this.i == null) {
                return false;
            }
            view = this.i;
        }
        this.s = aVar.getItem().getItemId();
        this.p = new ev(this, this.b, aVar);
        this.p.b = view;
        if (this.p.a()) {
            super.a(aVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public final boolean c() {
        if (!this.t || g() || this.c == null || this.g == null || this.q != null || this.c.k().isEmpty()) {
            return false;
        }
        this.q = new fd(this, new ef(this, this.b, this.c, this.i));
        ((View) this.g).post(this.q);
        super.a(null);
        return true;
    }

    public final boolean d() {
        if (this.q == null || this.g == null) {
            ae aeVar = this.o;
            if (aeVar == null) {
                return false;
            }
            aeVar.c();
            return true;
        }
        ((View) this.g).removeCallbacks(this.q);
        this.q = null;
        return true;
    }

    public final boolean e() {
        return d() | f();
    }

    public final boolean f() {
        if (this.p == null) {
            return false;
        }
        this.p.c();
        return true;
    }

    public final boolean g() {
        return this.o != null && this.o.d();
    }

    public final boolean b() {
        int i;
        ArrayList i2 = this.c.i();
        int size = i2.size();
        int i3 = this.l;
        int i4 = this.w;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.g;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            i iVar = (i) i2.get(i7);
            if (iVar.h()) {
                i5++;
            } else if (iVar.g()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.n && iVar.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.t && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.A;
        sparseBooleanArray.clear();
        if (this.x) {
            int i8 = i4 / this.z;
            i6 = ((i4 % this.z) / i8) + this.z;
            i = i8;
        } else {
            i6 = 0;
            i = 0;
        }
        i3 = 0;
        int i9 = 0;
        i5 = i;
        while (i9 < size) {
            i iVar2 = (i) i2.get(i9);
            View a;
            int i10;
            if (iVar2.h()) {
                a = a(iVar2, this.B, viewGroup);
                if (this.B == null) {
                    this.B = a;
                }
                if (this.x) {
                    i = i5 - ActionMenuView.a(a, i6, i5, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                    i = i5;
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = iVar2.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                iVar2.c(true);
                i8 = i10;
                i3 = i7;
            } else if (iVar2.g()) {
                boolean z;
                int groupId = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.x || i5 > 0);
                if (z3) {
                    a = a(iVar2, this.B, viewGroup);
                    if (this.B == null) {
                        this.B = a;
                    }
                    if (this.x) {
                        int a2 = ActionMenuView.a(a, i6, i5, makeMeasureSpec, 0);
                        i5 -= a2;
                        if (a2 == 0) {
                            i = 0;
                        }
                    } else {
                        a.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    i10 = a.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.x) {
                        z = i & (i4 >= 0 ? 1 : 0);
                        i10 = i5;
                    } else {
                        z = i & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i5;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i9; i7++) {
                        iVar = (i) i2.get(i7);
                        if (iVar.getGroupId() == groupId) {
                            if (iVar.f()) {
                                i5++;
                            }
                            iVar.c(false);
                        }
                    }
                    i = i5;
                } else {
                    i = i7;
                }
                if (z) {
                    i--;
                }
                iVar2.c(z);
                i5 = i3;
                i8 = i4;
                i3 = i;
                i = i10;
            } else {
                iVar2.c(false);
                i = i5;
                i8 = i4;
                i5 = i3;
                i3 = i7;
            }
            i9++;
            i4 = i8;
            i7 = i3;
            i3 = i5;
            i5 = i;
        }
        return true;
    }

    public final void a(u uVar, boolean z) {
        e();
        super.a(uVar, z);
    }

    public final void b(boolean z) {
        if (z) {
            super.a(null);
        } else {
            this.c.a(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.g = actionMenuView;
        actionMenuView.a = this.c;
    }
}
