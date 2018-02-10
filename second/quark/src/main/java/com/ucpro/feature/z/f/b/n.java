package com.ucpro.feature.z.f.b;

/* compiled from: ProGuard */
public abstract class n {
    public abstract String a();

    public abstract int b();

    public abstract String c();

    public abstract g d();

    public abstract int e();

    public abstract long f();

    public final int l() {
        switch (c.a[d().ordinal()]) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("url: ").append(a()).append("\n");
        stringBuilder.append("title: ").append(c()).append("\n");
        stringBuilder.append("type: ").append(d()).append("\n");
        stringBuilder.append("weight: ").append(l()).append("\n");
        return stringBuilder.toString();
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        if (hashCode() == ((n) obj).hashCode()) {
            return true;
        }
        return false;
    }
}
