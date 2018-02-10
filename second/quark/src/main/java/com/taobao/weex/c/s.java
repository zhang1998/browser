package com.taobao.weex.c;

/* compiled from: ProGuard */
public class s extends c {
    private int l = 2;

    protected final float c() {
        return b() * ((float) this.l);
    }

    protected final void d() {
        super.d();
        Object obj = i().get("rows");
        if (obj != null) {
            if (obj instanceof String) {
                try {
                    int parseInt = Integer.parseInt((String) obj);
                    if (parseInt > 0) {
                        this.l = parseInt;
                    }
                } catch (NumberFormatException e) {
                }
            } else if (obj instanceof Integer) {
                this.l = ((Integer) obj).intValue();
            }
        }
    }
}
