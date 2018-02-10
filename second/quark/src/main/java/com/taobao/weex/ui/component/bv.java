package com.taobao.weex.ui.component;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.taobao.weex.ac;
import com.taobao.weex.c.ae;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ProGuard */
public abstract class bv<T extends ViewGroup> extends ab<T> {
    public ArrayList<ab> g;

    public /* synthetic */ View getRealView() {
        return g_();
    }

    @Deprecated
    public bv(ac acVar, ae aeVar, bv bvVar, String str, boolean z) {
        this(acVar, aeVar, bvVar, z);
    }

    @Deprecated
    public bv(ac acVar, ae aeVar, bv bvVar, boolean z) {
        super(acVar, aeVar, bvVar);
        this.g = new ArrayList();
    }

    public bv(ac acVar, ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
        this.g = new ArrayList();
    }

    public final void i() {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
            viewGroup.setDescendantFocusability(131072);
            viewGroup.requestFocus();
        }
    }

    public int c() {
        return 0;
    }

    @Deprecated
    public final ViewGroup f() {
        return (ViewGroup) getHostView();
    }

    public void applyLayoutAndEvent(ab abVar) {
        if (!isLazy()) {
            ab abVar2;
            if (abVar == null) {
                abVar2 = this;
            } else {
                abVar2 = abVar;
            }
            super.applyLayoutAndEvent(abVar2);
            int j = j();
            for (int i = 0; i < j; i++) {
                h(i).applyLayoutAndEvent(((bv) abVar2).h(i));
            }
        }
    }

    public LayoutParams a(ab abVar, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return new LayoutParams(i, i2);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return layoutParams;
        }
        ((MarginLayoutParams) layoutParams).setMargins(i3, i5, i4, i6);
        return layoutParams;
    }

    public p getFirstScroller() {
        if (this instanceof p) {
            return (p) this;
        }
        for (int i = 0; i < this.g.size(); i++) {
            p firstScroller = h(i).getFirstScroller();
            if (firstScroller != null) {
                return firstScroller;
            }
        }
        return null;
    }

    public void bindData(ab abVar) {
        if (!isLazy()) {
            ab abVar2;
            if (abVar == null) {
                abVar2 = this;
            } else {
                abVar2 = abVar;
            }
            super.bindData(abVar2);
            int j = j();
            for (int i = 0; i < j; i++) {
                h(i).bindData(((bv) abVar2).h(i));
            }
        }
    }

    public void refreshData(ab abVar) {
        ab abVar2;
        if (abVar == null) {
            abVar2 = this;
        } else {
            abVar2 = abVar;
        }
        super.refreshData(abVar2);
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).refreshData(((bv) abVar2).h(i));
        }
    }

    public ViewGroup g_() {
        return (ViewGroup) super.getRealView();
    }

    public void createViewImpl() {
        super.createViewImpl();
        int j = j();
        for (int i = 0; i < j; i++) {
            g(i);
        }
        if (getHostView() != null) {
            ((ViewGroup) getHostView()).setClipToPadding(false);
        }
    }

    public void destroy() {
        if (this.g != null) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ((ab) this.g.get(i)).destroy();
            }
            this.g.clear();
        }
        super.destroy();
    }

    public void recycled() {
        if (!(this.g == null || getDomObject().f() || !getDomObject().i().c())) {
            int size = this.g.size();
            for (int i = 0; i < size; i++) {
                ((ab) this.g.get(i)).recycled();
            }
        }
        super.recycled();
    }

    public View detachViewAndClearPreInfo() {
        View detachViewAndClearPreInfo = super.detachViewAndClearPreInfo();
        if (this.g != null) {
            int j = j();
            for (int i = 0; i < j; i++) {
                ((ab) this.g.get(i)).detachViewAndClearPreInfo();
            }
        }
        return detachViewAndClearPreInfo;
    }

    public final int j() {
        return this.g == null ? 0 : this.g.size();
    }

    public final ab h(int i) {
        return (ab) this.g.get(i);
    }

    public void g(ab abVar) {
        a(abVar, -1);
    }

    public void a(ab abVar, int i) {
        if (abVar != null && i >= -1) {
            if (i >= this.g.size()) {
                i = -1;
            }
            if (i == -1) {
                this.g.add(abVar);
            } else {
                this.g.add(i, abVar);
            }
        }
    }

    public void g(int i) {
        if (i < 0) {
            i = j() - 1;
            if (i < 0) {
                return;
            }
        }
        ab h = h(i);
        h.createView();
        if (!h.isVirtualComponent()) {
            a(h.getHostView(), i);
        }
    }

    public void a(View view, int i) {
        if (view != null && g_() != null) {
            if (i >= g_().getChildCount()) {
                i = -1;
            }
            if (i == -1) {
                g_().addView(view);
            } else {
                g_().addView(view, i);
            }
        }
    }

    public void a(ab abVar, boolean z) {
        if (abVar != null && this.g != null && this.g.size() != 0) {
            this.g.remove(abVar);
            if (getInstance() != null && getInstance().g.getRealView() != null && abVar.getDomObject().f()) {
                getInstance().a(abVar.getHostView());
            } else if (g_() != null) {
                if (abVar.isVirtualComponent()) {
                    abVar.removeVirtualComponent();
                } else {
                    g_().removeView(abVar.getHostView());
                }
            }
            if (z) {
                abVar.destroy();
            }
        }
    }

    public void notifyAppearStateChange(String str, String str2) {
        super.notifyAppearStateChange(str, str2);
        if (getHostView() != null && this.g != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                ab abVar = (ab) it.next();
                if (!(abVar.getHostView() == null || abVar.getHostView().getVisibility() == 0)) {
                    str = "disappear";
                }
                abVar.notifyAppearStateChange(str, str2);
            }
        }
    }

    public void onActivityCreate() {
        super.onActivityCreate();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityCreate();
        }
    }

    public void onActivityStart() {
        super.onActivityStart();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityStart();
        }
    }

    public void onActivityPause() {
        super.onActivityPause();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityPause();
        }
    }

    public void onActivityResume() {
        super.onActivityResume();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityResume();
        }
    }

    public void onActivityStop() {
        super.onActivityStop();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityStop();
        }
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityDestroy();
        }
    }

    public boolean onActivityBack() {
        super.onActivityBack();
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onActivityBack();
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int j = j();
        for (int i3 = 0; i3 < j; i3++) {
            h(i3).onActivityResult(i, i2, intent);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        int j = j();
        for (int i = 0; i < j; i++) {
            h(i).onCreateOptionsMenu(menu);
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int j = j();
        for (int i2 = 0; i2 < j; i2++) {
            h(i2).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    public /* synthetic */ View getView() {
        return (ViewGroup) getHostView();
    }
}
