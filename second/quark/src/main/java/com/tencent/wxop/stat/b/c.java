package com.tencent.wxop.stat.b;

import android.content.Context;
import com.tencent.wxop.stat.a.s;
import com.tencent.wxop.stat.ai;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public final class c extends d {
    private String a;
    private int n;
    private int o = 100;
    private Thread p = null;

    public c(Context context, int i, Throwable th, ai aiVar) {
        super(context, i, aiVar);
        a(99, th);
    }

    public c(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        a(2, th);
        this.p = thread;
    }

    private void a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.a = stringWriter.toString();
            this.n = i;
            printWriter.close();
        }
    }

    public final boolean a(JSONObject jSONObject) {
        s.a(jSONObject, "er", this.a);
        jSONObject.put("ea", this.n);
        if (this.n == 2 || this.n == 3) {
            new com.tencent.wxop.stat.a.c(this.l).a(jSONObject, this.p);
        }
        return true;
    }

    public final e b() {
        return e.ERROR;
    }
}
