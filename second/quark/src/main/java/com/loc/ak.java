package com.loc;

import android.content.Context;
import com.uc.webview.browser.interfaces.IWebResources;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ProGuard */
public final class ak {
    static String a(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "pngex";
    }

    static String a(Context context, n nVar, ep epVar) {
        List a = nVar.a(aq.b(epVar.a(), IWebResources.TEXT_COPY), aq.class, false);
        if (a.size() == 0) {
            return null;
        }
        String str;
        a(a);
        int i = 0;
        while (i < a.size()) {
            aq aqVar = (aq) a.get(i);
            str = aqVar.a;
            if (a(nVar, str, a(context, str), epVar)) {
                try {
                    ap apVar = new ap(a(context, epVar.a(), epVar.b()), aqVar.b, epVar.a(), epVar.b(), aqVar.d);
                    apVar.f = "used";
                    a(context, nVar, epVar, apVar.a(), a(context, aqVar.a));
                    str = aqVar.d;
                    break;
                } catch (Throwable th) {
                    es.a(th, "DexFileManager", "loadAvailableDynamicSDKFile");
                }
            } else {
                b(context, nVar, aqVar.a);
                i++;
            }
        }
        str = null;
        return str;
    }

    static String a(Context context, String str) {
        return a(context) + File.separator + str;
    }

    static String a(Context context, String str, String str2) {
        return ek.b(str + str2 + ei.q(context)) + ".png";
    }

    static String a(String str) {
        return str + ".o";
    }

    static void a(Context context, n nVar, ep epVar, aq aqVar, String str) throws Throwable {
        InputStream fileInputStream;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        FileOutputStream fileOutputStream2;
        try {
            File file;
            String a = epVar.a();
            a(context, nVar, aqVar.a);
            fileInputStream = new FileInputStream(new File(str));
            try {
                fileInputStream.read(new byte[32]);
                file = new File(b(context, a, epVar.b()));
                fileOutputStream2 = new FileOutputStream(file, true);
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
                aqVar.b = ek.a(file.getAbsolutePath());
                nVar.a((Object) aqVar, aq.b(aqVar.a));
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                }
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    static void a(Context context, n nVar, String str) {
        b(context, nVar, str);
        b(context, nVar, a(str));
    }

    public static void a(n nVar, Context context, String str) {
        List<aq> a = aj.a(nVar, str, "used");
        if (a != null && a.size() > 0) {
            for (aq aqVar : a) {
                if (aqVar != null) {
                    a(context, nVar, aqVar.a);
                    List a2 = nVar.a(aq.a(str, aqVar.d), aq.class, false);
                    if (a2.size() > 0) {
                        Object obj = (aq) a2.get(0);
                        obj.e = "errorstatus";
                        nVar.a(obj, aq.b(obj.a));
                        File file = new File(a(context, obj.a));
                        if (file.exists()) {
                            file.delete();
                        }
                    }
                }
            }
        }
    }

    static void a(List<aq> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int i2 = i + 1; i2 < list.size(); i2++) {
                aq aqVar = (aq) list.get(i);
                aq aqVar2 = (aq) list.get(i2);
                if (av.a(aqVar2.d, aqVar.d) > 0) {
                    list.set(i, aqVar2);
                    list.set(i2, aqVar);
                }
            }
        }
    }

    static boolean a(n nVar, String str, String str2, ep epVar) {
        aq a = aj.a(nVar, str);
        return a != null && epVar.b().equals(a.c) && a(str2, a.b);
    }

    static boolean a(String str, String str2) {
        String a = ek.a(str);
        return a != null && a.equalsIgnoreCase(str2);
    }

    static String b(Context context, String str, String str2) {
        return a(context, a(context, str, str2));
    }

    static void b(Context context, n nVar, String str) {
        File file = new File(a(context, str));
        if (file.exists()) {
            file.delete();
        }
        nVar.a(aq.b(str), aq.class);
    }

    static void c(Context context, String str, String str2) {
        new ai(context, str, str2).start();
    }
}
