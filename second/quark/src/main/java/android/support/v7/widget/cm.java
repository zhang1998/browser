package android.support.v7.widget;

import android.content.pm.ResolveInfo;
import java.math.BigDecimal;

/* compiled from: ProGuard */
public final class cm implements Comparable<cm> {
    public final ResolveInfo a;
    public float b;
    final /* synthetic */ fs c;

    public final /* synthetic */ int compareTo(Object obj) {
        return Float.floatToIntBits(((cm) obj).b) - Float.floatToIntBits(this.b);
    }

    public cm(fs fsVar, ResolveInfo resolveInfo) {
        this.c = fsVar;
        this.a = resolveInfo;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (Float.floatToIntBits(this.b) != Float.floatToIntBits(((cm) obj).b)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("resolveInfo:").append(this.a.toString());
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.b));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
