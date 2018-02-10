package com.uc.pictureviewer.interfaces;

import android.content.Context;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.webview.export.annotations.Api;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

@Api
/* compiled from: ProGuard */
public final class PictureViewerBuilder {
    private static DexClassLoader a = null;
    private static int b = 0;

    private static boolean a(Context context, String str, String str2) {
        OutputStream fileOutputStream;
        IOException e;
        Throwable th;
        boolean z = false;
        InputStream inputStream = null;
        File file = new File(str2);
        File file2 = new File(str2 + "tmp");
        if (file2.exists()) {
            file2.delete();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            InputStream open = context.getApplicationContext().getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (IOException e2) {
                e = e2;
                fileOutputStream = null;
                inputStream = open;
                try {
                    Log.e("pictureviewer", "open dex failed:" + e.toString());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                            throw th;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                inputStream = open;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[8096];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                z = file2.renameTo(file);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (IOException e6) {
                e = e6;
                inputStream = open;
                Log.e("pictureviewer", "open dex failed:" + e.toString());
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return z;
            } catch (Throwable th4) {
                th = th4;
                inputStream = open;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            fileOutputStream = null;
            Log.e("pictureviewer", "open dex failed:" + e.toString());
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return z;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        return z;
    }

    private static DexClassLoader a(Context context) {
        if (a == null) {
            synchronized (PictureViewerBuilder.class) {
                if (a == null) {
                    File cacheDir = context.getCacheDir();
                    String str = cacheDir.getAbsolutePath() + File.separator + "pictureviewer_java.jar";
                    new StringBuilder().append(cacheDir.getAbsolutePath()).append(File.separator).append("pictureviewer_packinfo");
                    if (!cacheDir.exists()) {
                        cacheDir.mkdirs();
                    }
                    a(context, "dexes/pictureviewer_java.jar", str);
                    String str2 = str + ShareConstants.ODEX_SUFFIX;
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    a = new DexClassLoader(str, str2, context.getApplicationInfo().dataDir + "/lib", context.getClassLoader());
                }
            }
        }
        return a;
    }

    public static boolean hasLoadDexClass() {
        return a != null;
    }

    public static int getLoadedNum() {
        return b;
    }

    private static boolean a(String str) {
        try {
            if (Class.forName(str) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Class<?> a(Context context, String str) {
        try {
            if (a(str)) {
                return Class.forName(str);
            }
            if (a == null) {
                a = a(context);
            }
            DexClassLoader dexClassLoader = a;
            if (dexClassLoader != null) {
                return dexClassLoader.loadClass(str);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static synchronized IPictureViewerFactory getPictureViewerFactory(Context context) {
        IPictureViewerFactory iPictureViewerFactory;
        synchronized (PictureViewerBuilder.class) {
            try {
                b++;
                Class a = a(context, "com.uc.pictureviewer.PictureViewerFactoryBuilder");
                if (a != null) {
                    Method declaredMethod = a.getDeclaredMethod("build", new Class[0]);
                    if (declaredMethod != null) {
                        iPictureViewerFactory = (IPictureViewerFactory) declaredMethod.invoke(null, new Object[0]);
                    }
                }
            } catch (Exception e) {
                Log.e("pictureviewer", "init failed:" + e.toString());
            }
            iPictureViewerFactory = null;
        }
        return iPictureViewerFactory;
    }

    public static PictureViewer build(Context context, PictureViewerSkinProvider pictureViewerSkinProvider, PictureViewerListener pictureViewerListener, PictureViewerConfig pictureViewerConfig) {
        IPictureViewerFactory pictureViewerFactory = getPictureViewerFactory(context);
        if (pictureViewerFactory == null) {
            return null;
        }
        return pictureViewerFactory.create(context, pictureViewerSkinProvider, pictureViewerListener, pictureViewerConfig);
    }
}
