package com.loc;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
abstract class af extends ClassLoader {
    protected final Context a;
    protected final Map<String, Class<?>> b = new HashMap();
    protected DexFile c = null;
    volatile boolean d = true;
    protected ep e;
    protected String f;

    public af(Context context, ep epVar) {
        super(context.getClassLoader());
        this.a = context;
        this.e = epVar;
    }

    protected final void a(Context context, ep epVar) {
        String b = ak.b(context, epVar.a(), epVar.b());
        Object a = ak.a(context);
        if (!TextUtils.isEmpty(b) && !TextUtils.isEmpty(a)) {
            an.a(context, epVar);
            try {
                File file = new File(b);
                File parentFile = file.getParentFile();
                if (file.exists()) {
                    String str = a + File.separator + ak.a(file.getName());
                    DexFile loadDex = DexFile.loadDex(b, str, 0);
                    if (loadDex != null) {
                        aq a2 = aj.a(new n(context, ao.b()), file.getName());
                        if (a2 != null) {
                            this.f = a2.d;
                        }
                        loadDex.close();
                        a(new File(str), str, this.f, new n(context, ao.b()));
                    }
                } else if (parentFile != null && parentFile.exists()) {
                    ak.c(context, epVar.a(), epVar.b());
                }
            } catch (Throwable th) {
                es.a(th, "BaseClassLoader", "getInstanceByThread()");
            }
        }
    }

    abstract void a(File file, String str, String str2, n nVar);

    public final boolean a() {
        return this.c != null;
    }

    protected final void b() {
        try {
            this.b.clear();
            if (this.c != null) {
                this.c.close();
            }
        } catch (Throwable th) {
            es.a(th, "BaseClassLoader", "releaseDexFile()");
        }
    }
}
