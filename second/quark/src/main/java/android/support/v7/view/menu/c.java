package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: ProGuard */
public abstract class c implements r {
    public Context a;
    public Context b;
    public u c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    public m f;
    public d g;
    public int h;
    private int i;
    private int j;

    public abstract void a(i iVar, k kVar);

    public c(Context context, int i, int i2) {
        this.a = context;
        this.d = LayoutInflater.from(context);
        this.i = i;
        this.j = i2;
    }

    public void a(Context context, u uVar) {
        this.b = context;
        this.e = LayoutInflater.from(this.b);
        this.c = uVar;
    }

    public d a(ViewGroup viewGroup) {
        if (this.g == null) {
            this.g = (d) this.d.inflate(this.i, viewGroup, false);
            this.g.a(this.c);
            a(true);
        }
        return this.g;
    }

    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.g;
        if (viewGroup != null) {
            int i;
            if (this.c != null) {
                this.c.j();
                ArrayList i2 = this.c.i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    i iVar = (i) i2.get(i3);
                    if (c(iVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        i itemData = childAt instanceof k ? ((k) childAt).getItemData() : null;
                        View a = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a.setPressed(false);
                            ViewCompat.w(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.g).addView(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        k kVar;
        if (view instanceof k) {
            kVar = (k) view;
        } else {
            kVar = (k) this.d.inflate(this.j, viewGroup, false);
        }
        a(iVar, kVar);
        return (View) kVar;
    }

    public boolean c(i iVar) {
        return true;
    }

    public void a(u uVar, boolean z) {
        if (this.f != null) {
            this.f.a(uVar, z);
        }
    }

    public boolean a(a aVar) {
        if (this.f != null) {
            return this.f.a(aVar);
        }
        return false;
    }

    public boolean b() {
        return false;
    }

    public final boolean a(i iVar) {
        return false;
    }

    public final boolean b(i iVar) {
        return false;
    }
}
