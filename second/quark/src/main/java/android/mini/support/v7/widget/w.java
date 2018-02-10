package android.mini.support.v7.widget;

import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
final class w {
    int a;
    int b;
    boolean c;
    boolean d;
    final /* synthetic */ LinearLayoutManager e;

    w(LinearLayoutManager linearLayoutManager) {
        this.e = linearLayoutManager;
        a();
    }

    final void a() {
        this.a = -1;
        this.b = SectionHeader.SHT_LOUSER;
        this.c = false;
        this.d = false;
    }

    final void b() {
        int a;
        if (this.c) {
            a = this.e.j.a();
        } else {
            a = this.e.j.c();
        }
        this.b = a;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.c + ", mValid=" + this.d + '}';
    }

    public final void a(View view) {
        if (this.c) {
            this.b = this.e.j.c(view) + this.e.j.h();
        } else {
            this.b = this.e.j.d(view);
        }
        this.a = LayoutManager.a(view);
    }
}
