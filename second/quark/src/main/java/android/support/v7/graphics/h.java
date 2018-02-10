package android.support.v7.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class h {
    public final List<b> a;
    public final Bitmap b;
    public final List<g> c = new ArrayList();
    public int d = 16;
    public int e = 25600;
    public int f = -1;
    public final List<c> g = new ArrayList();
    public Rect h;

    public h(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            throw new IllegalArgumentException("Bitmap is not valid");
        }
        this.g.add(i.f);
        this.b = bitmap;
        this.a = null;
        this.c.add(g.a);
        this.c.add(g.b);
        this.c.add(g.c);
        this.c.add(g.d);
        this.c.add(g.e);
        this.c.add(g.f);
    }

    public final int[] a(Bitmap bitmap) {
        int i = 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Object obj = new int[(width * height)];
        bitmap.getPixels(obj, 0, width, 0, 0, width, height);
        if (this.h == null) {
            return obj;
        }
        int width2 = this.h.width();
        int height2 = this.h.height();
        Object obj2 = new int[(width2 * height2)];
        while (i < height2) {
            System.arraycopy(obj, ((this.h.top + i) * width) + this.h.left, obj2, i * width2, width2);
            i++;
        }
        return obj2;
    }
}
