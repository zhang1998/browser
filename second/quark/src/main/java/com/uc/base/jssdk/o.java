package com.uc.base.jssdk;

import android.text.TextUtils;
import com.uc.base.jssdk.a.h;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

/* compiled from: ProGuard */
public final class o {
    public p a;
    public d b;
    private g c;
    private a d;
    private l e;
    private e f;

    public final void a(String[] strArr, h hVar) {
        l lVar = this.e;
        List<String> asList = Arrays.asList(strArr);
        if (asList != null) {
            for (String str : asList) {
                if (!TextUtils.isEmpty(str)) {
                    lVar.a().putIfAbsent(str, hVar);
                }
            }
        }
    }

    public final h a(m mVar, int i) {
        h hVar = new h(mVar, this.c, this.d, i);
        hVar.a.a(hVar.b, ShellJsInterface.SHELL_JS_NAME);
        this.f.a.put(Integer.valueOf(i), new WeakReference(hVar));
        return hVar;
    }

    private o() {
        this.f = new e();
        this.e = new l();
        this.d = new a();
        this.c = new g(this.f, this.e);
        c.a.b = this.f;
    }
}
