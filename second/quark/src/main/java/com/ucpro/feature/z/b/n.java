package com.ucpro.feature.z.b;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ProGuard */
public final class n implements TextWatcher {
    final /* synthetic */ b a;

    private n(b bVar) {
        this.a = bVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        a(charSequence);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.a.e.d()) {
            a(charSequence);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.CharSequence r5) {
        /*
        r4 = this;
        r1 = 1;
        r0 = 0;
        r2 = r5.length();
        if (r2 > 0) goto L_0x0010;
    L_0x0008:
        r1 = r4.a;
        r1 = r1.e;
        r1.setUrlState(r0);
    L_0x000f:
        return;
    L_0x0010:
        r2 = r5.toString();
        r3 = "^*([一-﨩]|[-]|\\s)+.*$";
        r3 = java.util.regex.Pattern.compile(r3);
        r2 = r3.matcher(r2);
        r2 = r2.find();
        if (r2 == 0) goto L_0x0025;
    L_0x0024:
        r0 = r1;
    L_0x0025:
        if (r0 != 0) goto L_0x0039;
    L_0x0027:
        r0 = com.ucpro.c.d.a();
        if (r0 == 0) goto L_0x0041;
    L_0x002d:
        r0 = r5.toString();
        r2 = ".*\\p{InCyrillic}.*";
        r0 = java.util.regex.Pattern.matches(r2, r0);
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r4.a;
        r0 = r0.e;
        r0.c();
        goto L_0x000f;
    L_0x0041:
        r0 = r4.a;
        r0 = r0.e;
        r0.setUrlState(r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ucpro.feature.z.b.n.a(java.lang.CharSequence):void");
    }
}
