package com.ucpro.feature.c.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.ucpro.feature.c.a.b;
import com.ucweb.common.util.k.a;
import java.io.File;

/* compiled from: ProGuard */
final class f implements g {
    final /* synthetic */ String a;
    final /* synthetic */ i b;
    final /* synthetic */ b c;

    f(String str, i iVar, b bVar) {
        this.a = str;
        this.b = iVar;
        this.c = bVar;
    }

    public final void a(@NonNull String str) {
        if (com.ucpro.c.b.b()) {
            Log.e("hjw-pic", "uploadFile:onResponse:fileUrl=" + str);
        }
        if (TextUtils.isEmpty(this.a)) {
            this.b.a("uploadablePictureName empty");
        } else {
            com.ucpro.c.b.b();
            String str2 = "http://pic.sogou.com/pic/ris_searchList.jsp?statref=home&v=5&ul=1&keyword=" + str;
            com.ucpro.c.b.b();
            if (com.ucpro.c.b.b()) {
                Log.e("hjw-pic", "target url is = " + str2);
            }
            this.b.a(str2, this.c.a);
        }
        a.b(new File(this.c.a));
    }

    public final void b(@NonNull String str) {
        this.b.a("http request failed, " + str);
        a.b(new File(this.c.a));
    }
}
