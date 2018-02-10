package android.support.v4.widget;

import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.view.View;
import com.uc.imagecodec.export.IPictureView;

/* compiled from: ProGuard */
final class ae extends at {
    final int a;
    bt b;
    final /* synthetic */ DrawerLayout c;
    private final Runnable d = new z(this);

    public ae(DrawerLayout drawerLayout, int i) {
        this.c = drawerLayout;
        this.a = i;
    }

    public final void a() {
        this.c.removeCallbacks(this.d);
    }

    public final boolean a(View view) {
        return DrawerLayout.d(view) && this.c.a(view, this.a) && this.c.a(view) == 0;
    }

    public final void a(int i) {
        int size;
        DrawerLayout drawerLayout = this.c;
        View view = this.b.j;
        int i2 = drawerLayout.a.a;
        int i3 = drawerLayout.b.a;
        if (i2 == 1 || i3 == 1) {
            i2 = 1;
        } else if (i2 == 2 || i3 == 2) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (view != null && i == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.b == 0.0f) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.d & 1) == 1) {
                    layoutParams.d = 0;
                    if (drawerLayout.e != null) {
                        for (size = drawerLayout.e.size() - 1; size >= 0; size--) {
                            drawerLayout.e.get(size);
                        }
                    }
                    drawerLayout.a(view, false);
                    if (drawerLayout.hasWindowFocus()) {
                        View rootView = drawerLayout.getRootView();
                        if (rootView != null) {
                            rootView.sendAccessibilityEvent(32);
                        }
                    }
                }
            } else if (layoutParams.b == IPictureView.DEFAULT_MIN_SCALE) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.d & 1) == 0) {
                    layoutParams.d = 1;
                    if (drawerLayout.e != null) {
                        for (size = drawerLayout.e.size() - 1; size >= 0; size--) {
                            drawerLayout.e.get(size);
                        }
                    }
                    drawerLayout.a(view, true);
                    if (drawerLayout.hasWindowFocus()) {
                        drawerLayout.sendAccessibilityEvent(32);
                    }
                    view.requestFocus();
                }
            }
        }
        if (i2 != drawerLayout.c) {
            drawerLayout.c = i2;
            if (drawerLayout.e != null) {
                for (size = drawerLayout.e.size() - 1; size >= 0; size--) {
                    drawerLayout.e.get(size);
                }
            }
        }
    }

    public final void a(View view, int i) {
        float f;
        int width = view.getWidth();
        if (this.c.a(view, 3)) {
            f = ((float) (width + i)) / ((float) width);
        } else {
            f = ((float) (this.c.getWidth() - i)) / ((float) width);
        }
        this.c.a(view, f);
        view.setVisibility(f == 0.0f ? 4 : 0);
        this.c.invalidate();
    }

    public final void b(View view) {
        ((LayoutParams) view.getLayoutParams()).c = false;
        b();
    }

    final void b() {
        int i = 3;
        if (this.a == 3) {
            i = 5;
        }
        View a = this.c.a(i);
        if (a != null) {
            this.c.e(a);
        }
    }

    public final void a(View view, float f) {
        int i;
        float b = DrawerLayout.b(view);
        int width = view.getWidth();
        if (this.c.a(view, 3)) {
            i = (f > 0.0f || (f == 0.0f && b > 0.5f)) ? 0 : -width;
        } else {
            i = this.c.getWidth();
            if (f < 0.0f || (f == 0.0f && b > 0.5f)) {
                i -= width;
            }
        }
        this.b.a(i, view.getTop());
        this.c.invalidate();
    }

    public final void c() {
        this.c.postDelayed(this.d, 160);
    }

    public final void a(int i, int i2) {
        View a;
        if ((i & 1) == 1) {
            a = this.c.a(3);
        } else {
            a = this.c.a(5);
        }
        if (a != null && this.c.a(a) == 0) {
            this.b.a(a, i2);
        }
    }

    public final int c(View view) {
        return DrawerLayout.d(view) ? view.getWidth() : 0;
    }

    public final int b(View view, int i) {
        if (this.c.a(view, 3)) {
            return Math.max(-view.getWidth(), Math.min(i, 0));
        }
        int width = this.c.getWidth();
        return Math.max(width - view.getWidth(), Math.min(i, width));
    }

    public final int d(View view) {
        return view.getTop();
    }
}
