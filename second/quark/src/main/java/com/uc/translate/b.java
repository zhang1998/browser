package com.uc.translate;

import java.util.Map;

/* compiled from: ProGuard */
abstract class b<T extends TranslateResponse> implements e<T> {
    private Map<String, String> a;
    private Long b;

    b() {
    }

    public final Map<String, String> a() {
        if (this.a == null) {
            this.a = new l();
        }
        return this.a;
    }

    public final Long b() {
        return this.b;
    }
}
