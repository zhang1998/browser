package android.support.v7.widget;

import android.content.Context;
import android.support.v7.view.c;
import android.support.v7.view.menu.a;
import android.support.v7.view.menu.i;
import android.support.v7.view.menu.r;
import android.support.v7.view.menu.u;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.alibaba.wireless.security.SecExceptionCode;

/* compiled from: ProGuard */
final class eg implements r {
    u a;
    i b;
    final /* synthetic */ Toolbar c;

    private eg(Toolbar toolbar) {
        this.c = toolbar;
    }

    public final void a(Context context, u uVar) {
        if (!(this.a == null || this.b == null)) {
            this.a.b(this.b);
        }
        this.a = uVar;
    }

    public final void a(boolean z) {
        Object obj = null;
        if (this.b != null) {
            if (this.a != null) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    if (this.a.getItem(i) == this.b) {
                        obj = 1;
                        break;
                    }
                }
            }
            if (obj == null) {
                b(this.b);
            }
        }
    }

    public final boolean a(a aVar) {
        return false;
    }

    public final void a(u uVar, boolean z) {
    }

    public final boolean b() {
        return false;
    }

    public final boolean a(i iVar) {
        Toolbar.b(this.c);
        if (this.c.s.getParent() != this.c) {
            this.c.addView(this.c.s);
        }
        this.c.d = iVar.getActionView();
        this.b = iVar;
        if (this.c.d.getParent() != this.c) {
            LayoutParams e = Toolbar.e();
            e.a = 8388611 | (this.c.t & SecExceptionCode.SEC_ERROR_INIT_LOAD_INTERFACE_NOT_EXISTED);
            e.b = 2;
            this.c.d.setLayoutParams(e);
            this.c.addView(this.c.d);
        }
        Toolbar toolbar = this.c;
        for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = toolbar.getChildAt(childCount);
            if (!(((Toolbar.LayoutParams) childAt.getLayoutParams()).b == 2 || childAt == toolbar.a)) {
                toolbar.removeViewAt(childCount);
                toolbar.j.add(childAt);
            }
        }
        this.c.requestLayout();
        iVar.d(true);
        if (this.c.d instanceof c) {
            ((c) this.c.d).a();
        }
        return true;
    }

    public final boolean b(i iVar) {
        if (this.c.d instanceof c) {
            ((c) this.c.d).b();
        }
        this.c.removeView(this.c.d);
        this.c.removeView(this.c.s);
        this.c.d = null;
        Toolbar toolbar = this.c;
        for (int size = toolbar.j.size() - 1; size >= 0; size--) {
            toolbar.addView((View) toolbar.j.get(size));
        }
        toolbar.j.clear();
        this.b = null;
        this.c.requestLayout();
        iVar.d(false);
        return true;
    }
}
