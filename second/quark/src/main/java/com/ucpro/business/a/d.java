package com.ucpro.business.a;

import android.text.TextUtils;
import com.ucpro.business.e.d.g;
import com.ucweb.common.util.j.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* compiled from: ProGuard */
final class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        if (TextUtils.isEmpty(a.b(com.ucweb.common.util.d.a(), "75766F5CC857E09B", "data", ""))) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a.b.getResources().getAssets().open("searchcode/code")));
                String str = "";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str = str + readLine;
                }
                this.a.a(str);
            } catch (Exception e) {
            }
        }
        g.a().a("ky_code", this.a);
        g.a().a("kCode_Activity_Json_Data", this.a);
    }
}
