package com.uc.translate;

import java.util.Map;

/* compiled from: ProGuard */
final class o extends b<TranslateResponse> {
    String a;
    String b;
    String c;
    String d;
    String e;

    o() {
    }

    public final String c() {
        return "alibaba.intl.translationplatform.translate";
    }

    public final Map<String, String> d() {
        Map lVar = new l();
        lVar.a("field_type", this.a);
        lVar.a("source_text_format", this.b);
        lVar.a("source", this.c);
        lVar.a("source_text", this.d);
        lVar.a("target", this.e);
        return lVar;
    }
}
