package com.uc.base.wa.d;

import com.uc.base.wa.config.b;
import com.uc.base.wa.t;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
final class e implements t {
    boolean a = false;
    boolean b = false;
    boolean c = false;
    String d = null;
    final /* synthetic */ f e;
    private boolean f = false;
    private int g = 0;
    private int h = 0;

    e(f fVar) {
        this.e = fVar;
    }

    public final boolean a(Map<String, String> map) {
        try {
            if (this.f) {
                return false;
            }
            this.a = true;
            byte[] bytes = "\n".getBytes();
            this.e.c.e.write(bytes);
            this.g = bytes.length + this.g;
            String str = b.f(this.d).f;
            StringBuilder stringBuilder = new StringBuilder("lt=");
            if (str == null) {
                str = "ev";
            }
            bytes = stringBuilder.append(str).append("`ct=").append(this.d).toString().getBytes();
            this.e.c.e.write(bytes);
            this.g = bytes.length + this.g;
            for (Entry entry : map.entrySet()) {
                bytes = ("`" + ((String) entry.getKey()) + "=" + ((String) entry.getValue())).getBytes();
                this.e.c.e.write(bytes);
                this.g = bytes.length + this.g;
            }
            if (this.h > 0 && this.g > this.h) {
                this.f = true;
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public final boolean a() {
        return this.c;
    }
}
