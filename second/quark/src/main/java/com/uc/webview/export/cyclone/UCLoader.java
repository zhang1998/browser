package com.uc.webview.export.cyclone;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import dalvik.system.DexClassLoader;
import java.io.File;

@Constant
/* compiled from: ProGuard */
public class UCLoader extends DexClassLoader {
    private static final boolean ENABLE_SPEEDUP_LOAD = true;
    private static final String TAG = "UCLoader";
    private static int sToken = UCLogger.createToken("v", TAG);

    private static String doCheckOdexFile(String str, String str2, boolean z) {
        if (VERSION.SDK_INT == 21) {
            for (String optimizedFileFor : str.split(":")) {
                File optimizedFileFor2 = UCCyclone.optimizedFileFor(optimizedFileFor, str2);
                if (optimizedFileFor2.exists()) {
                    File file = new File(str2, UCCyclone.getDecompressFileHash(optimizedFileFor2));
                    if (!file.exists()) {
                        if (z) {
                            try {
                                optimizedFileFor2.delete();
                                UCLogger.print(sToken, "File [" + optimizedFileFor2 + "] deleted.", new Throwable[0]);
                            } catch (Throwable th) {
                                UCLogger.print(sToken, "File [" + optimizedFileFor2 + "] delete but exception.", th);
                            }
                        } else {
                            try {
                                file.createNewFile();
                                UCLogger.print(sToken, "File [" + file + "] created.", new Throwable[0]);
                            } catch (Throwable th2) {
                                UCLogger.print(sToken, "File [" + file + "] create but exception.", th2);
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    public UCLoader(String str, String str2, String str3, ClassLoader classLoader) {
        super(doCheckOdexFile(str, str2, true), str2, str3, classLoader);
        doCheckOdexFile(str, str2, false);
    }

    @SuppressLint({"NewApi"})
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        Class<?> cls = null;
        try {
            cls = super.findClass(str);
        } catch (ClassNotFoundException e) {
        }
        if (cls == null) {
            cls = findLoadedClass(str);
        }
        if (cls == null) {
            return getParent().loadClass(str);
        }
        return cls;
    }

    protected Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("com.uc.") && !str.startsWith("org.chromium.")) {
            return super.loadClass(str, z);
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass == null) {
            return findClass(str);
        }
        return findLoadedClass;
    }
}
