package android.support.v7.graphics;

import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.v4.b.a;
import com.uc.imagecodec.export.IPictureView;
import java.util.Arrays;

/* compiled from: ProGuard */
public final class b {
    public final int a;
    final int b;
    private final int c;
    private final int d;
    private final int e;
    private boolean f;
    private int g;
    private int h;
    private float[] i;

    public b(@ColorInt int i, int i2) {
        this.c = Color.red(i);
        this.d = Color.green(i);
        this.e = Color.blue(i);
        this.a = i;
        this.b = i2;
    }

    public final float[] a() {
        if (this.i == null) {
            this.i = new float[3];
        }
        a.a(this.c, this.d, this.e, this.i);
        return this.i;
    }

    private void b() {
        if (!this.f) {
            int a = a.a(-1, this.a, 4.5f);
            int a2 = a.a(-1, this.a, IPictureView.DEFAULT_MAX_SCALE);
            if (a == -1 || a2 == -1) {
                int a3 = a.a(-16777216, this.a, 4.5f);
                int a4 = a.a(-16777216, this.a, IPictureView.DEFAULT_MAX_SCALE);
                if (a3 == -1 || a3 == -1) {
                    this.h = a != -1 ? a.b(-1, a) : a.b(-16777216, a3);
                    this.g = a2 != -1 ? a.b(-1, a2) : a.b(-16777216, a4);
                    this.f = true;
                    return;
                }
                this.h = a.b(-16777216, a3);
                this.g = a.b(-16777216, a4);
                this.f = true;
                return;
            }
            this.h = a.b(-1, a);
            this.g = a.b(-1, a2);
            this.f = true;
        }
    }

    public final String toString() {
        StringBuilder append = new StringBuilder(getClass().getSimpleName()).append(" [RGB: #").append(Integer.toHexString(this.a)).append(']').append(" [HSL: ").append(Arrays.toString(a())).append(']').append(" [Population: ").append(this.b).append(']').append(" [Title Text: #");
        b();
        append = append.append(Integer.toHexString(this.g)).append(']').append(" [Body Text: #");
        b();
        return append.append(Integer.toHexString(this.h)).append(']').toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.b == bVar.b && this.a == bVar.a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }
}
