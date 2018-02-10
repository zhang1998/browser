package com.uc.weex.i;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import com.taobao.weex.m;
import com.uc.webview.export.extension.UCCore;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ProGuard */
public final class d {
    public static String a = "DefaultWeexSoLoader";
    private static final Set<String> n = new HashSet();
    private static final Map<String, String> o = new HashMap();
    h b;
    private volatile boolean c = false;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private volatile boolean f = false;
    private String g = null;
    private String h;
    private ClassLoader i;
    private Context j;
    private l k;
    private k l;
    private m[] m = null;

    public d(Context context, ClassLoader classLoader, List<String> list, boolean z) {
        this.j = context;
        this.i = classLoader;
        this.d = z;
        this.f = false;
        this.h = this.j.getApplicationInfo().dataDir;
        this.k = new l(context, list);
        this.l = new k(this.i);
        this.b = new h(this.d, this.f, this.h);
        b();
    }

    private synchronized void b() {
        if (!this.c) {
            if (this.m == null) {
                this.k.a(this);
                ArrayList arrayList = this.k.a;
                this.m = (m[]) arrayList.toArray(new m[arrayList.size()]);
                this.c = true;
            }
            if (this.f) {
                h hVar = this.b;
                if (hVar.b && !n.a(hVar.c)) {
                    String mapLibraryName = System.mapLibraryName("v8uc");
                    String mapLibraryName2 = System.mapLibraryName("v9uc");
                    String str = hVar.c + File.separator + "share_files";
                    File file = new File(str, mapLibraryName2);
                    if (file.exists()) {
                        try {
                            j.a(file, mapLibraryName, mapLibraryName2);
                        } catch (Throwable e) {
                            throw new RuntimeException(e);
                        }
                    }
                    throw new RuntimeException("No " + mapLibraryName2 + " found in " + str);
                }
            }
        }
    }

    public final void a(String str) {
        Object obj = null;
        a();
        k kVar = this.l;
        Object obj2 = null;
        int i = 0;
        while (obj == null && i < 3) {
            Object obj3;
            try {
                if (kVar.a == null) {
                    System.load(str);
                    return;
                }
                Runtime runtime;
                Object[] objArr;
                Method declaredMethod;
                if (kVar.a != null && VERSION.SDK_INT < 18) {
                    try {
                        runtime = Runtime.getRuntime();
                        objArr = new Object[]{str, kVar.a};
                        declaredMethod = runtime.getClass().getDeclaredMethod(UCCore.OPTION_LOAD_KERNEL_TYPE, new Class[]{String.class, ClassLoader.class});
                        declaredMethod.setAccessible(true);
                        obj2 = declaredMethod.invoke(runtime, objArr);
                    } catch (Exception e) {
                    }
                } else if (kVar.a != null) {
                    try {
                        runtime = Runtime.getRuntime();
                        objArr = new Object[]{str, kVar.a};
                        String obj4 = objArr[0].toString();
                        if (new File(obj4).isAbsolute()) {
                            declaredMethod = runtime.getClass().getDeclaredMethod("doLoad", new Class[]{String.class, ClassLoader.class});
                            declaredMethod.setAccessible(true);
                            obj2 = declaredMethod.invoke(runtime, objArr);
                        } else {
                            throw new UnsatisfiedLinkError("Expecting an absolute path of the library: " + obj4);
                        }
                    } catch (Exception e2) {
                    }
                }
                if (obj2 == null) {
                    obj = 1;
                }
                obj3 = obj2;
                obj2 = obj;
                obj = obj3;
                i++;
                obj3 = obj;
                obj = obj2;
                obj2 = obj3;
            } catch (Exception e3) {
                if (i == 2) {
                    throw e3;
                }
                obj3 = obj2;
                obj2 = obj;
                obj = obj3;
            }
        }
        if (i == 2 && obj2 != null) {
            throw new UnsatisfiedLinkError(obj2.toString());
        }
    }

    final synchronized void a(String str, int i) throws IOException, UnsatisfiedLinkError {
        int i2 = n.contains(str) ? 1 : 0;
        if (i2 != 1) {
            int i3 = 0;
            String str2 = null;
            while (i2 == 0) {
                if (i3 >= this.m.length) {
                    break;
                }
                int a;
                if (this.m[i3] instanceof e) {
                    e eVar = (e) this.m[i3];
                    if (eVar.a() != null) {
                        str2 = eVar.a().getAbsolutePath();
                        a = this.m[i3].a(str, i);
                        i3++;
                        i2 = a;
                    }
                }
                str2 = null;
                a = this.m[i3].a(str, i);
                i3++;
                i2 = a;
            }
            if (i2 == 0) {
                StringBuilder stringBuilder;
                Object b = m.b();
                if (str.contains(b)) {
                    try {
                        a();
                        k kVar = this.l;
                        if (kVar.a == null || VERSION.SDK_INT < 23 || (VERSION.SDK_INT == 23 && !"N".equalsIgnoreCase(VERSION.RELEASE))) {
                            System.loadLibrary(b);
                        } else if (kVar.a != null) {
                            try {
                                Runtime runtime = Runtime.getRuntime();
                                Object[] objArr = new Object[]{kVar.a, b};
                                Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary0", new Class[]{ClassLoader.class, String.class});
                                declaredMethod.setAccessible(true);
                                b = declaredMethod.invoke(runtime, objArr);
                            } catch (Throwable th) {
                                b = null;
                            }
                            if (b != null) {
                                throw new UnsatisfiedLinkError(b.toString());
                            }
                        }
                        b = 1;
                    } catch (Throwable th2) {
                    }
                    if (b == null) {
                        n.add(str);
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(" could not find DSO to load: " + str);
                        stringBuilder.append(" in path ");
                        stringBuilder.append(d(str));
                        if (this.k.a() && this.g != null) {
                            stringBuilder.append(" and failed to extract apk: ");
                            stringBuilder.append(this.g);
                            this.g = null;
                        }
                        throw new UnsatisfiedLinkError(stringBuilder.toString());
                    }
                }
                b = null;
                if (b == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(" could not find DSO to load: " + str);
                    stringBuilder.append(" in path ");
                    stringBuilder.append(d(str));
                    stringBuilder.append(" and failed to extract apk: ");
                    stringBuilder.append(this.g);
                    this.g = null;
                    throw new UnsatisfiedLinkError(stringBuilder.toString());
                }
                n.add(str);
            } else if (i2 == 1) {
                Log.w(a, "sLoadedLibraries add " + str);
                if (!this.e) {
                    String mapLibraryName = System.mapLibraryName(m.b());
                    if (str.equalsIgnoreCase(mapLibraryName)) {
                        long c = m.c();
                        String str3 = str2 + File.separator + mapLibraryName;
                        File file = new File(str3);
                        long j = 0;
                        if (file.exists()) {
                            j = file.length();
                        }
                        if (c != j) {
                            throw new UnsatisfiedLinkError(((str3 + " maybe corrupted!") + " expect size: " + c) + " current size: " + j);
                        }
                        this.e = true;
                    }
                }
                n.add(str);
                if (str2 != null) {
                    o.put(str, str2);
                }
            }
        }
    }

    private String d(String str) {
        boolean z = false;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < this.m.length) {
            boolean a;
            e eVar;
            boolean z2 = this.m[i] instanceof e;
            if (!z && z2) {
                try {
                    a = this.m[i].a(str);
                } catch (Throwable th) {
                }
                if (z2) {
                    eVar = (e) this.m[i];
                    if (eVar.a() != null) {
                        stringBuilder.append(eVar.a().getAbsolutePath());
                        stringBuilder.append(":");
                    }
                }
                i++;
                z = a;
            }
            a = z;
            if (z2) {
                eVar = (e) this.m[i];
                if (eVar.a() != null) {
                    stringBuilder.append(eVar.a().getAbsolutePath());
                    stringBuilder.append(":");
                }
            }
            i++;
            z = a;
        }
        if (!z) {
            stringBuilder.append(" no " + str + " found in all extra library pathes!");
        }
        return stringBuilder.toString();
    }

    final void a() {
        if (this.m == null) {
            throw new RuntimeException("DefaultWeexSoLoader.init() not yet called");
        }
    }

    public static boolean a(ArrayList<m> arrayList, String str) {
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (z) {
                break;
            }
            try {
                z = mVar.a(str);
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public static boolean b(String str) {
        return o.containsKey(str);
    }

    public static String c(String str) {
        return (String) o.get(str);
    }
}
