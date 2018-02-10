package com.ucpro.feature.navigation.view;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.quark.browser.R;
import com.uc.imagecodec.export.IPictureView;
import com.ucpro.feature.navigation.b.b;
import com.ucpro.feature.navigation.b.i;
import com.ucpro.ui.c.a;
import com.ucweb.common.util.c;
import com.ucweb.common.util.i.f;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class as extends BaseAdapter {
    public List<ax> a = new ArrayList();
    ax b;
    ao c;
    boolean d;
    boolean e;
    boolean f;
    public int g = 10;
    private ax h;
    private ax i;

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int i) {
        if (i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i) {
        ax axVar = (ax) this.a.get(i);
        if (axVar != null) {
            return axVar.b;
        }
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View uVar;
        ax axVar = (ax) this.a.get(i);
        if (view == null) {
            ao aoVar = this.c;
            switch (axVar.b) {
                case 0:
                    uVar = new u(aoVar.a, aoVar.b, axVar);
                    break;
                case 1:
                    uVar = new e(aoVar.a, aoVar.b, axVar);
                    break;
                default:
                    uVar = null;
                    break;
            }
            c.a((Object) uVar, "mWidgetFactory.createWidget==null while convert View == null");
            uVar.setLayoutParams(new LayoutParams(a.c((int) R.dimen.launcher_widget_width_portrait), a.c((int) R.dimen.launcher_widget_height_portrait)));
        } else {
            uVar = view;
        }
        if (uVar.getAnimation() != null) {
            uVar.getAnimation().cancel();
        }
        uVar.setAnimation(null);
        j jVar = (j) uVar;
        jVar.a(this.d);
        jVar.setIsEditStyle(this.e);
        if (axVar.b == 0 && (jVar instanceof u)) {
            Drawable a;
            if (axVar.d == null || !axVar.d.startsWith("ext:navifunc:")) {
                a = i.a.a(jVar.getContext(), axVar.f, axVar.g, f.c(axVar.d));
            } else {
                i.a;
                a = b.c(axVar.d);
            }
            u uVar2 = (u) jVar;
            ax widgetInfo = uVar2.getWidgetInfo();
            if (widgetInfo == null || widgetInfo.a != axVar.a || widgetInfo.d == null || !widgetInfo.d.equals(axVar.d)) {
                uVar2.clearDisappearingChildren();
            } else {
                boolean z;
                Drawable icon = uVar2.getIcon();
                if (icon == null || a == null || icon == a) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    p.a(uVar2, icon);
                }
            }
            uVar2.setIcon(a);
            uVar2.setTitle(axVar.h);
            uVar2.i();
            uVar2.j();
        }
        jVar.a(axVar);
        if (axVar == this.h) {
            jVar.setVisibility(4);
        } else {
            jVar.setVisibility(0);
        }
        if (this.b == null || axVar.a == this.b.a) {
            jVar.setAlpha(IPictureView.DEFAULT_MIN_SCALE);
        } else {
            jVar.setAlpha(0.3f);
        }
        if (jVar instanceof e) {
            e eVar = (e) jVar;
            if (this.e) {
                eVar.d();
            } else {
                eVar.e();
            }
            if (this.f) {
                this.f = false;
                eVar.a(0);
            }
        }
        if ((jVar instanceof u) && this.i != null && jVar.getWidgetInfo() != null && this.i.a == jVar.getWidgetInfo().a) {
            ((u) jVar).q = true;
            this.i = null;
        }
        return jVar;
    }

    public final void a(ax axVar) {
        if (this.h != axVar) {
            this.h = axVar;
            notifyDataSetChanged();
        }
    }

    public final int a() {
        if (this.a == null) {
            return 0;
        }
        int i = 0;
        for (ax axVar : this.a) {
            int i2;
            if (axVar.b == 0) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public static void a(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof j) {
                j jVar = (j) childAt;
                if (jVar.getWidgetInfo() != null && jVar.getWidgetInfo().b == 0) {
                    jVar.h();
                }
            }
        }
    }

    public static void b(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof j) {
                j jVar = (j) childAt;
                if (!(jVar.getWidgetInfo() == null || jVar.getWidgetInfo().b != 0 || jVar.m == IPictureView.DEFAULT_MIN_SCALE)) {
                    jVar.g();
                    jVar.a(jVar.m, (float) IPictureView.DEFAULT_MIN_SCALE);
                }
            }
        }
    }

    public static void c(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof j) {
                ((j) childAt).a();
            }
        }
    }
}
