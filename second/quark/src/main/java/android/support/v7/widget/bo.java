package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;

/* compiled from: ProGuard */
public abstract class bo {
    protected final LayoutManager a;
    int b;

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

    public abstract int f();

    public abstract int g();

    private bo(LayoutManager layoutManager) {
        this.b = SectionHeader.SHT_LOUSER;
        this.a = layoutManager;
    }

    public final int h() {
        return SectionHeader.SHT_LOUSER == this.b ? 0 : d() - this.b;
    }

    public static bo a(LayoutManager layoutManager, int i) {
        switch (i) {
            case 0:
                return new ah(layoutManager);
            case 1:
                return new ay(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}
