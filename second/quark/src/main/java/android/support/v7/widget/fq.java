package android.support.v7.widget;

import android.content.ComponentName;
import java.math.BigDecimal;

/* compiled from: ProGuard */
public final class fq {
    public final ComponentName a;
    public final long b;
    public final float c;

    public fq(String str, long j, float f) {
        this(ComponentName.unflattenFromString(str), j, f);
    }

    public fq(ComponentName componentName, long j, float f) {
        this.a = componentName;
        this.b = j;
        this.c = f;
    }

    public final int hashCode() {
        return (((((this.a == null ? 0 : this.a.hashCode()) + 31) * 31) + ((int) (this.b ^ (this.b >>> 32)))) * 31) + Float.floatToIntBits(this.c);
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
        fq fqVar = (fq) obj;
        if (this.a == null) {
            if (fqVar.a != null) {
                return false;
            }
        } else if (!this.a.equals(fqVar.a)) {
            return false;
        }
        if (this.b != fqVar.b) {
            return false;
        }
        if (Float.floatToIntBits(this.c) != Float.floatToIntBits(fqVar.c)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append("; activity:").append(this.a);
        stringBuilder.append("; time:").append(this.b);
        stringBuilder.append("; weight:").append(new BigDecimal((double) this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
