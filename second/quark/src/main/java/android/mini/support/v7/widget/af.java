package android.mini.support.v7.widget;

import android.graphics.Rect;
import android.mini.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public abstract class af {
    protected final LayoutManager a;
    int b;
    final Rect c;

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    private af(LayoutManager layoutManager) {
        this.b = SectionHeader.SHT_LOUSER;
        this.c = new Rect();
        this.a = layoutManager;
    }

    public final int h() {
        return SectionHeader.SHT_LOUSER == this.b ? 0 : d() - this.b;
    }

    public static af a(LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return new ad(layoutManager);
            case 1:
                return new ae(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}
