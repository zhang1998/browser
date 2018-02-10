package android.support.v7.widget;

/* compiled from: ProGuard */
final class ai {
    int a;
    int b;
    Object c;
    int d;

    ai(int i, int i2, int i3, Object obj) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.c = obj;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
        switch (this.a) {
            case 1:
                str = "add";
                break;
            case 2:
                str = "rm";
                break;
            case 4:
                str = "up";
                break;
            case 8:
                str = "mv";
                break;
            default:
                str = "??";
                break;
        }
        return append.append(str).append(",s:").append(this.b).append("c:").append(this.d).append(",p:").append(this.c).append("]").toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ai aiVar = (ai) obj;
        if (this.a != aiVar.a) {
            return false;
        }
        if (this.a == 8 && Math.abs(this.d - this.b) == 1 && this.d == aiVar.b && this.b == aiVar.d) {
            return true;
        }
        if (this.d != aiVar.d) {
            return false;
        }
        if (this.b != aiVar.b) {
            return false;
        }
        if (this.c != null) {
            if (this.c.equals(aiVar.c)) {
                return true;
            }
            return false;
        } else if (aiVar.c != null) {
            return false;
        } else {
            return true;
        }
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.d;
    }
}
