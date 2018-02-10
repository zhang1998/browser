package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.mini.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.view.View;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class bp {
    ArrayList<View> a;
    int b;
    int c;
    int d;
    final int e;
    final /* synthetic */ StaggeredGridLayoutManager f;

    private bp(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.f = staggeredGridLayoutManager;
        this.a = new ArrayList();
        this.b = SectionHeader.SHT_LOUSER;
        this.c = SectionHeader.SHT_LOUSER;
        this.d = 0;
        this.e = i;
    }

    final int a(int i) {
        if (this.b != SectionHeader.SHT_LOUSER) {
            return this.b;
        }
        if (this.a.size() == 0) {
            return i;
        }
        h();
        return this.b;
    }

    private void h() {
        View view = (View) this.a.get(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.b = this.f.c.d(view);
        if (layoutParams.b) {
            FullSpanItem d = this.f.i.d(layoutParams.c.c());
            if (d != null && d.b == -1) {
                this.b -= d.a(this.e);
            }
        }
    }

    final int a() {
        if (this.b != SectionHeader.SHT_LOUSER) {
            return this.b;
        }
        h();
        return this.b;
    }

    final int b(int i) {
        if (this.c != SectionHeader.SHT_LOUSER) {
            return this.c;
        }
        if (this.a.size() == 0) {
            return i;
        }
        i();
        return this.c;
    }

    private void i() {
        View view = (View) this.a.get(this.a.size() - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        this.c = this.f.c.c(view);
        if (layoutParams.b) {
            FullSpanItem d = this.f.i.d(layoutParams.c.c());
            if (d != null && d.b == 1) {
                this.c = d.a(this.e) + this.c;
            }
        }
    }

    final int b() {
        if (this.c != SectionHeader.SHT_LOUSER) {
            return this.c;
        }
        i();
        return this.c;
    }

    final void a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.a = this;
        this.a.add(0, view);
        this.b = SectionHeader.SHT_LOUSER;
        if (this.a.size() == 1) {
            this.c = SectionHeader.SHT_LOUSER;
        }
        if (layoutParams.c.m() || layoutParams.c.s()) {
            this.d += this.f.c.a(view);
        }
    }

    final void b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.a = this;
        this.a.add(view);
        this.c = SectionHeader.SHT_LOUSER;
        if (this.a.size() == 1) {
            this.b = SectionHeader.SHT_LOUSER;
        }
        if (layoutParams.c.m() || layoutParams.c.s()) {
            this.d += this.f.c.a(view);
        }
    }

    final void c() {
        this.a.clear();
        this.b = SectionHeader.SHT_LOUSER;
        this.c = SectionHeader.SHT_LOUSER;
        this.d = 0;
    }

    final void c(int i) {
        this.b = i;
        this.c = i;
    }

    final void d() {
        int size = this.a.size();
        View view = (View) this.a.remove(size - 1);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.a = null;
        if (layoutParams.c.m() || layoutParams.c.s()) {
            this.d -= this.f.c.a(view);
        }
        if (size == 1) {
            this.b = SectionHeader.SHT_LOUSER;
        }
        this.c = SectionHeader.SHT_LOUSER;
    }

    final void e() {
        View view = (View) this.a.remove(0);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.a = null;
        if (this.a.size() == 0) {
            this.c = SectionHeader.SHT_LOUSER;
        }
        if (layoutParams.c.m() || layoutParams.c.s()) {
            this.d -= this.f.c.a(view);
        }
        this.b = SectionHeader.SHT_LOUSER;
    }

    final void d(int i) {
        if (this.b != SectionHeader.SHT_LOUSER) {
            this.b += i;
        }
        if (this.c != SectionHeader.SHT_LOUSER) {
            this.c += i;
        }
    }

    public final int f() {
        if (this.f.m) {
            return b(this.a.size() - 1, -1);
        }
        return b(0, this.a.size());
    }

    public final int g() {
        if (this.f.m) {
            return b(0, this.a.size());
        }
        return b(this.a.size() - 1, -1);
    }

    private int b(int i, int i2) {
        int c = this.f.c.c();
        int a = this.f.c.a();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = (View) this.a.get(i);
            int d = this.f.c.d(view);
            int c2 = this.f.c.c(view);
            if (d < a && c2 > c) {
                return LayoutManager.a(view);
            }
            i += i3;
        }
        return -1;
    }

    public final View a(int i, int i2) {
        View view = null;
        int size;
        View view2;
        if (i2 == -1) {
            size = this.a.size();
            int i3 = 0;
            while (i3 < size) {
                view2 = (View) this.a.get(i3);
                if (!view2.isFocusable()) {
                    break;
                }
                boolean z;
                if (LayoutManager.a(view2) > i) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != this.f.m) {
                    break;
                }
                i3++;
                view = view2;
            }
            return view;
        }
        for (size = this.a.size() - 1; size >= 0; size--) {
            view2 = (View) this.a.get(size);
            if (!view2.isFocusable()) {
                break;
            }
            Object obj;
            if (LayoutManager.a(view2) > i) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != (!this.f.m ? 1 : null)) {
                break;
            }
            view = view2;
        }
        return view;
    }
}
