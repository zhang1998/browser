package com.bumptech.glide.f.a;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
final class j {
    final View a;
    final List<g> b = new ArrayList();
    @Nullable
    i c;

    j(View view) {
        this.a = view;
    }

    final void a(int i, int i2) {
        for (g a : this.b) {
            a.a(i, i2);
        }
    }

    final void a() {
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.c);
        }
        this.c = null;
        this.b.clear();
    }

    final boolean b(int i, int i2) {
        boolean z = (this.a.getLayoutParams() == null || this.a.getLayoutParams().width <= 0 || this.a.getLayoutParams().height <= 0) ? !this.a.isLayoutRequested() : true;
        return z && a(i) && a(i2);
    }

    final int b() {
        int paddingBottom = this.a.getPaddingBottom() + this.a.getPaddingTop();
        LayoutParams layoutParams = this.a.getLayoutParams();
        return a(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
    }

    final int c() {
        int paddingRight = this.a.getPaddingRight() + this.a.getPaddingLeft();
        LayoutParams layoutParams = this.a.getLayoutParams();
        return a(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
    }

    private static int a(int i, int i2, int i3) {
        int i4 = i - i3;
        if (a(i4)) {
            return i4;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return SectionHeader.SHT_LOUSER;
        }
        return i2 > 0 ? i2 - i3 : 0;
    }

    private static boolean a(int i) {
        return i > 0 || i == SectionHeader.SHT_LOUSER;
    }
}
