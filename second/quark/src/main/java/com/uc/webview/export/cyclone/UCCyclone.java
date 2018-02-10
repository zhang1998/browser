package com.uc.webview.export.cyclone;

import android.content.Context;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.crashsdk.export.LogType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.android.spdy.SpdyProtocol;

@Constant
/* compiled from: ProGuard */
public class UCCyclone {
    static final String LOG_TAG = "cyclone";
    static final boolean RELEASE_BUILD = false;
    private static final String TEMP_DEC_DIR_PREFIX = "temp_dec_";
    public static String dataFolder = LOG_TAG;
    public static boolean enableDebugLog = true;
    public static ValueCallback<String> loadLibraryCallback = null;
    public static String logExtraTag = "cyclone.";
    @Constant
    public static ConcurrentLinkedQueue<File> sInusedFiles = null;
    public static final UCClassLoaderOnCreate sUcClassLoaderOnCreate = new UCClassLoaderOnCreate();
    public static ValueCallback<Pair<String, HashMap<String, String>>> statCallback = null;

    public static File expectCreateDirFile(File file) {
        int i = 3;
        while (!file.exists() && !file.mkdirs()) {
            int i2 = i - 1;
            if (i <= 0) {
                throw new UCKnownException(1003, String.format("Directory [%s] mkdir failed.", new Object[]{file.getAbsolutePath()}));
            }
            i = i2;
        }
        return file;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    static Object invoke(Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        return invoke(null, cls, str, clsArr, objArr);
    }

    @Constant
    public static Object invoke(Object obj, Class<?> cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        Method declaredMethod;
        try {
            declaredMethod = cls.getDeclaredMethod(str, clsArr);
        } catch (Throwable th) {
            declaredMethod = cls.getMethod(str, clsArr);
        }
        return invoke(obj, (Class) cls, declaredMethod, objArr);
    }

    @Constant
    public static Object invoke(Object obj, Class<?> cls, Method method, Object[] objArr) throws Exception {
        method.setAccessible(true);
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof Exception) {
                throw ((Exception) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new RuntimeException(targetException);
            }
        }
    }

    @Constant
    public static void stat(String str, HashMap<String, String> hashMap) {
        ValueCallback valueCallback = statCallback;
        if (valueCallback != null) {
            try {
                valueCallback.onReceiveValue(new Pair(str, hashMap));
            } catch (Exception e) {
            }
        }
    }

    @Constant
    static void getFile(byte[][] bArr, File file) throws IOException {
        Closeable bufferedOutputStream;
        Throwable th;
        try {
            expectCreateDirFile(file.getParentFile());
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                for (byte[] write : bArr) {
                    bufferedOutputStream.write(write);
                }
                close(bufferedOutputStream);
            } catch (Throwable th2) {
                th = th2;
                close(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            close(bufferedOutputStream);
            throw th;
        }
    }

    public static long getFolderSize(File file) {
        return getFolderSize(file, -1);
    }

    public static long getFolderSize(File file, long j) {
        Stack stack = new Stack();
        if (file.exists()) {
            stack.push(file);
        }
        long j2 = 0;
        while (!stack.empty()) {
            File[] listFiles = ((File) stack.pop()).listFiles();
            if (listFiles != null) {
                long j3 = j2;
                for (File file2 : listFiles) {
                    try {
                        String name = file2.getName();
                        if (!(name.equals(".") || name.equals("..") || name.equals("./") || name.equals("../"))) {
                            if (file2.isDirectory() && file2.exists()) {
                                stack.push(file2);
                            } else if (file2.exists()) {
                                j3 += file2.length();
                                if (j >= 0 && j3 > j) {
                                    return j3;
                                }
                            } else {
                                continue;
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                j2 = j3;
            }
        }
        return j2;
    }

    @Constant
    public static File getDataFolder(Context context) throws UCKnownException {
        UCLogger uCLogger = null;
        try {
            if (dataFolder == null) {
                dataFolder = LOG_TAG;
            }
            File dir = context.getDir(dataFolder, 0);
            if (sInusedFiles == null) {
                synchronized (UCCyclone.class) {
                    if (sInusedFiles == null) {
                        sInusedFiles = new ConcurrentLinkedQueue();
                    }
                }
            }
            UCLogger create = !enableDebugLog ? null : UCLogger.create("i", LOG_TAG);
            if (create != null) {
                create.print("getDataFolder: ok.", new Throwable[0]);
            }
            return dir;
        } catch (Throwable th) {
            if (enableDebugLog) {
                uCLogger = UCLogger.create("e", LOG_TAG);
            }
            if (uCLogger != null) {
                uCLogger.print("getDataFolder: from dir app_* Exception:", th);
            }
            UCKnownException uCKnownException = new UCKnownException(1003, th);
        }
    }

    public static void deleteUnusedFiles(Context context) {
        Object obj = null;
        try {
            File dataFolder = getDataFolder(context);
            if (sInusedFiles != null) {
                obj = (File[]) sInusedFiles.toArray(new File[5]);
            }
            recursiveDelete(dataFolder, true, obj);
        } catch (Throwable th) {
        }
        try {
            File[] listFiles = context.getCacheDir().listFiles(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.startsWith(UCCyclone.TEMP_DEC_DIR_PREFIX);
                }
            });
            if (listFiles != null && listFiles.length > 0) {
                for (File recursiveDelete : listFiles) {
                    recursiveDelete(recursiveDelete, false, null);
                }
            }
        } catch (Throwable th2) {
        }
    }

    public static File expectFile(File file, String str) throws UCKnownException {
        return expectFile(new File(file, str));
    }

    public static File expectFile(String str) throws UCKnownException {
        return expectFile(new File(str));
    }

    public static File expectFile(File file) throws UCKnownException {
        if (!file.exists()) {
            throw new UCKnownException(1001, String.format("File [%s] not exists.", new Object[]{file.getAbsolutePath()}));
        } else if (file.canRead()) {
            return file;
        } else {
            throw new UCKnownException(1012, String.format("File [%s] cannot read.", new Object[]{file.getAbsolutePath()}));
        }
    }

    @Constant
    public static String getDecompressFileHash(File file) {
        return getDecompressSourceHash(file.getAbsolutePath(), file.length(), file.lastModified(), false);
    }

    public static String getDecompressSourceHash(String str, long j, long j2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!z) {
            str = getSourceHash(str);
        }
        return stringBuilder.append(str).append("_").append(getSourceHash(j, j2)).toString();
    }

    public static String getSourceHash(String str) {
        return String.valueOf(str.hashCode()).replace('-', '_');
    }

    public static String getSourceHash(long j, long j2) {
        return j + "_" + j2;
    }

    public static synchronized boolean decompressIfNeeded(Context context, boolean z, File file, File file2, FilenameFilter filenameFilter, boolean z2) throws UCKnownException {
        boolean decompressIfNeeded;
        synchronized (UCCyclone.class) {
            decompressIfNeeded = decompressIfNeeded(context, z, file.getAbsolutePath(), file.length(), file.lastModified(), file, file2, filenameFilter, z2);
        }
        return decompressIfNeeded;
    }

    public static boolean isDecompressFinished(File file) {
        String[] split = file.getName().split("_");
        if (split.length == 2) {
            return isDecompressFinished(file.getParentFile().getName(), Long.valueOf(split[0]).longValue(), Long.valueOf(split[1]).longValue(), file, true);
        }
        return false;
    }

    static boolean isDecompressFinished(String str, long j, long j2, File file, boolean z) {
        return getDecompressStopFlgFile(str, j, j2, file, z).exists() && !getDecompressStartFlgFile(str, j, j2, file, z).exists();
    }

    static boolean detect7zFromFileName(String str) {
        return str.endsWith(".7z") || str.contains("_7z_") || str.contains("_7z");
    }

    static void expectMakeDecompressNotFinished(String str, long j, long j2, File file) throws UCKnownException {
        try {
            File decompressStartFlgFile = getDecompressStartFlgFile(str, j, j2, file, false);
            if (!decompressStartFlgFile.exists() && !decompressStartFlgFile.createNewFile()) {
                throw new Exception("createNewFile return false");
            }
        } catch (Throwable th) {
            UCKnownException uCKnownException = new UCKnownException(1006, th);
        }
    }

    static void decompress(boolean r10, android.content.Context r11, java.lang.String r12, java.lang.String r13, java.io.FilenameFilter r14) throws com.uc.webview.export.cyclone.UCKnownException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.uc.webview.export.cyclone.UCCyclone.decompress(boolean, android.content.Context, java.lang.String, java.lang.String, java.io.FilenameFilter):void. bs: [B:2:0x0009, B:19:0x005e]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r3 = 0;
        r1 = "sdk_dec";
        stat(r1, r3);
        if (r10 == 0) goto L_0x0047;
    L_0x0009:
        r0 = com.uc.webview.export.cyclone.service.UCUnSevenZip.class;	 Catch:{ Throwable -> 0x0030 }
        r0 = com.uc.webview.export.cyclone.UCService.initImpl(r0);	 Catch:{ Throwable -> 0x0030 }
        r0 = (com.uc.webview.export.cyclone.service.UCUnSevenZip) r0;	 Catch:{ Throwable -> 0x0030 }
        if (r0 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x0030 }
    L_0x0013:
        r0 = r0.deccompress(r11, r12, r13);	 Catch:{ Throwable -> 0x0030 }
        if (r0 == 0) goto L_0x0135;	 Catch:{ Throwable -> 0x0030 }
    L_0x0019:
        r1 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ Throwable -> 0x0030 }
        r2 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;	 Catch:{ Throwable -> 0x0030 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0030 }
        r5 = "Error on 7z decoding: ";	 Catch:{ Throwable -> 0x0030 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0030 }
        r0 = r4.append(r0);	 Catch:{ Throwable -> 0x0030 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0030 }
        r1.<init>(r2, r0);	 Catch:{ Throwable -> 0x0030 }
        throw r1;	 Catch:{ Throwable -> 0x0030 }
    L_0x0030:
        r0 = move-exception;
        r1 = "sdk_dec_e";
        stat(r1, r3);
        r1 = r0 instanceof com.uc.webview.export.cyclone.UCKnownException;
        if (r1 == 0) goto L_0x013b;
    L_0x003a:
        r0 = (com.uc.webview.export.cyclone.UCKnownException) r0;
        throw r0;
    L_0x003d:
        r0 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ Throwable -> 0x0030 }
        r1 = 2015; // 0x7df float:2.824E-42 double:9.955E-321;	 Catch:{ Throwable -> 0x0030 }
        r2 = "Error on 7z decoding: no impl found.";	 Catch:{ Throwable -> 0x0030 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0030 }
        throw r0;	 Catch:{ Throwable -> 0x0030 }
    L_0x0047:
        r1 = "sdk_decz";	 Catch:{ Throwable -> 0x0030 }
        r2 = 0;	 Catch:{ Throwable -> 0x0030 }
        stat(r1, r2);	 Catch:{ Throwable -> 0x0030 }
        r4 = new java.util.zip.ZipInputStream;	 Catch:{ Throwable -> 0x0030 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0030 }
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0030 }
        r2.<init>(r12);	 Catch:{ Throwable -> 0x0030 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0030 }
        r4.<init>(r1);	 Catch:{ Throwable -> 0x0030 }
        r1 = r0;
        r2 = r3;
    L_0x005e:
        r5 = r4.getNextEntry();	 Catch:{ all -> 0x0088 }
        if (r5 == 0) goto L_0x0120;	 Catch:{ all -> 0x0088 }
    L_0x0064:
        r6 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ all -> 0x0088 }
        r6 = new byte[r6];	 Catch:{ all -> 0x0088 }
        r5 = r5.getName();	 Catch:{ all -> 0x0088 }
        r7 = "..";	 Catch:{ all -> 0x0088 }
        r7 = r5.contains(r7);	 Catch:{ all -> 0x0088 }
        if (r7 == 0) goto L_0x008d;	 Catch:{ all -> 0x0088 }
    L_0x0074:
        r0 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x0088 }
        r1 = 2012; // 0x7dc float:2.82E-42 double:9.94E-321;	 Catch:{ all -> 0x0088 }
        r2 = "Zip entry [%s] not valid.";	 Catch:{ all -> 0x0088 }
        r6 = 1;	 Catch:{ all -> 0x0088 }
        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x0088 }
        r7 = 0;	 Catch:{ all -> 0x0088 }
        r6[r7] = r5;	 Catch:{ all -> 0x0088 }
        r2 = java.lang.String.format(r2, r6);	 Catch:{ all -> 0x0088 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0088 }
        throw r0;	 Catch:{ all -> 0x0088 }
    L_0x0088:
        r0 = move-exception;
        close(r4);	 Catch:{ Throwable -> 0x0030 }
        throw r0;	 Catch:{ Throwable -> 0x0030 }
    L_0x008d:
        if (r14 == 0) goto L_0x00a2;
    L_0x008f:
        r7 = new java.io.File;	 Catch:{ all -> 0x0088 }
        r7.<init>(r5);	 Catch:{ all -> 0x0088 }
        r8 = r7.getParentFile();	 Catch:{ all -> 0x0088 }
        r7 = r7.getName();	 Catch:{ all -> 0x0088 }
        r7 = r14.accept(r8, r7);	 Catch:{ all -> 0x0088 }
        if (r7 == 0) goto L_0x005e;	 Catch:{ all -> 0x0088 }
    L_0x00a2:
        r7 = new java.io.File;	 Catch:{ all -> 0x0088 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0088 }
        r8.<init>();	 Catch:{ all -> 0x0088 }
        r8 = r8.append(r13);	 Catch:{ all -> 0x0088 }
        r9 = "/";	 Catch:{ all -> 0x0088 }
        r8 = r8.append(r9);	 Catch:{ all -> 0x0088 }
        r8 = r8.append(r5);	 Catch:{ all -> 0x0088 }
        r8 = r8.toString();	 Catch:{ all -> 0x0088 }
        r7.<init>(r8);	 Catch:{ all -> 0x0088 }
        r8 = "/";	 Catch:{ all -> 0x0088 }
        r8 = r5.endsWith(r8);	 Catch:{ all -> 0x0088 }
        if (r8 != 0) goto L_0x00ce;	 Catch:{ all -> 0x0088 }
    L_0x00c6:
        r8 = "\\";	 Catch:{ all -> 0x0088 }
        r5 = r5.endsWith(r8);	 Catch:{ all -> 0x0088 }
        if (r5 == 0) goto L_0x00d2;	 Catch:{ all -> 0x0088 }
    L_0x00ce:
        expectCreateDirFile(r7);	 Catch:{ all -> 0x0088 }
        goto L_0x005e;	 Catch:{ all -> 0x0088 }
    L_0x00d2:
        r2 = new java.io.File;	 Catch:{ all -> 0x0088 }
        r5 = r7.getParent();	 Catch:{ all -> 0x0088 }
        r2.<init>(r5);	 Catch:{ all -> 0x0088 }
        expectCreateDirFile(r2);	 Catch:{ all -> 0x0088 }
        r5 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0088 }
        r5.<init>(r7);	 Catch:{ all -> 0x0088 }
        r2 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0088 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ all -> 0x0088 }
        r2.<init>(r5, r7);	 Catch:{ all -> 0x0088 }
    L_0x00ea:
        r5 = 0;	 Catch:{ all -> 0x0088 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ all -> 0x0088 }
        r5 = r4.read(r6, r5, r7);	 Catch:{ all -> 0x0088 }
        r7 = -1;	 Catch:{ all -> 0x0088 }
        if (r5 == r7) goto L_0x0107;	 Catch:{ all -> 0x0088 }
    L_0x00f4:
        r7 = 0;	 Catch:{ all -> 0x0088 }
        r2.write(r6, r7, r5);	 Catch:{ all -> 0x0088 }
        r0 = r0 + r5;	 Catch:{ all -> 0x0088 }
        r5 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;	 Catch:{ all -> 0x0088 }
        if (r0 <= r5) goto L_0x00ea;	 Catch:{ all -> 0x0088 }
    L_0x00fd:
        r0 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x0088 }
        r1 = 2010; // 0x7da float:2.817E-42 double:9.93E-321;	 Catch:{ all -> 0x0088 }
        r2 = "Zip contents is too big.";	 Catch:{ all -> 0x0088 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0088 }
        throw r0;	 Catch:{ all -> 0x0088 }
    L_0x0107:
        r2.flush();	 Catch:{ all -> 0x0088 }
        r2.close();	 Catch:{ all -> 0x0088 }
        r4.closeEntry();	 Catch:{ all -> 0x0088 }
        r1 = r1 + 1;	 Catch:{ all -> 0x0088 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0088 }
        if (r1 <= r5) goto L_0x005e;	 Catch:{ all -> 0x0088 }
    L_0x0116:
        r0 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x0088 }
        r1 = 2011; // 0x7db float:2.818E-42 double:9.936E-321;	 Catch:{ all -> 0x0088 }
        r2 = "Too many files to unzip.";	 Catch:{ all -> 0x0088 }
        r0.<init>(r1, r2);	 Catch:{ all -> 0x0088 }
        throw r0;	 Catch:{ all -> 0x0088 }
    L_0x0120:
        close(r4);	 Catch:{ Throwable -> 0x0030 }
        if (r2 != 0) goto L_0x012f;	 Catch:{ Throwable -> 0x0030 }
    L_0x0125:
        r0 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ Throwable -> 0x0030 }
        r1 = 2002; // 0x7d2 float:2.805E-42 double:9.89E-321;	 Catch:{ Throwable -> 0x0030 }
        r2 = "No entry exists in zip file. Make sure specify a valid zip file url.";	 Catch:{ Throwable -> 0x0030 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0030 }
        throw r0;	 Catch:{ Throwable -> 0x0030 }
    L_0x012f:
        r0 = "sdk_decz_s";	 Catch:{ Throwable -> 0x0030 }
        r1 = 0;	 Catch:{ Throwable -> 0x0030 }
        stat(r0, r1);	 Catch:{ Throwable -> 0x0030 }
    L_0x0135:
        r0 = "sdk_dec_s";
        stat(r0, r3);
        return;
    L_0x013b:
        r1 = new com.uc.webview.export.cyclone.UCKnownException;
        r2 = 2005; // 0x7d5 float:2.81E-42 double:9.906E-321;
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.cyclone.UCCyclone.decompress(boolean, android.content.Context, java.lang.String, java.lang.String, java.io.FilenameFilter):void");
    }

    public static synchronized boolean decompressIfNeeded(android.content.Context r11, boolean r12, java.lang.String r13, long r14, long r16, java.io.File r18, java.io.File r19, java.io.FilenameFilter r20, boolean r21) throws com.uc.webview.export.cyclone.UCKnownException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = com.uc.webview.export.cyclone.UCCyclone.class;
        monitor-enter(r10);
        r9 = 0;
        r3 = r13;
        r4 = r14;
        r6 = r16;
        r8 = r19;
        r2 = isDecompressFinished(r3, r4, r6, r8, r9);	 Catch:{ all -> 0x0031 }
        if (r2 == 0) goto L_0x0013;
    L_0x0010:
        r2 = 0;
    L_0x0011:
        monitor-exit(r10);
        return r2;
    L_0x0013:
        r2 = r18.exists();	 Catch:{ all -> 0x0031 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ all -> 0x0031 }
    L_0x0019:
        r2 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x0031 }
        r3 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;	 Catch:{ all -> 0x0031 }
        r4 = "File [%s] not exists.";	 Catch:{ all -> 0x0031 }
        r5 = 1;	 Catch:{ all -> 0x0031 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0031 }
        r6 = 0;	 Catch:{ all -> 0x0031 }
        r7 = r18.getAbsolutePath();	 Catch:{ all -> 0x0031 }
        r5[r6] = r7;	 Catch:{ all -> 0x0031 }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x0031 }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x0031 }
        throw r2;	 Catch:{ all -> 0x0031 }
    L_0x0031:
        r2 = move-exception;
        monitor-exit(r10);
        throw r2;
    L_0x0034:
        r9 = new java.io.File;	 Catch:{ all -> 0x0031 }
        r2 = r11.getCacheDir();	 Catch:{ all -> 0x0031 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0031 }
        r4 = "temp_dec_";	 Catch:{ all -> 0x0031 }
        r3.<init>(r4);	 Catch:{ all -> 0x0031 }
        r4 = android.os.Process.myPid();	 Catch:{ all -> 0x0031 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0031 }
        r4 = "_";	 Catch:{ all -> 0x0031 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0031 }
        r4 = android.os.Process.myTid();	 Catch:{ all -> 0x0031 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0031 }
        r4 = "_";	 Catch:{ all -> 0x0031 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0031 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0031 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0031 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x0031 }
        r3 = r3.toString();	 Catch:{ all -> 0x0031 }
        r9.<init>(r2, r3);	 Catch:{ all -> 0x0031 }
        r2 = r9.exists();	 Catch:{ all -> 0x0031 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ all -> 0x0031 }
    L_0x0076:
        expectCreateDirFile(r9);	 Catch:{ all -> 0x0031 }
        java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00fc }
        if (r12 == 0) goto L_0x0103;	 Catch:{ all -> 0x00fc }
    L_0x007e:
        r2 = 1;	 Catch:{ all -> 0x00fc }
    L_0x007f:
        r3 = r18.getAbsolutePath();	 Catch:{ all -> 0x00fc }
        r4 = r9.getAbsolutePath();	 Catch:{ all -> 0x00fc }
        r0 = r20;	 Catch:{ all -> 0x00fc }
        decompress(r2, r11, r3, r4, r0);	 Catch:{ all -> 0x00fc }
        r3 = r13;	 Catch:{ all -> 0x00fc }
        r4 = r14;	 Catch:{ all -> 0x00fc }
        r6 = r16;	 Catch:{ all -> 0x00fc }
        r8 = r19;	 Catch:{ all -> 0x00fc }
        expectMakeDecompressNotFinished(r3, r4, r6, r8);	 Catch:{ all -> 0x00fc }
        r3 = r9.listFiles();	 Catch:{ all -> 0x00fc }
        if (r3 == 0) goto L_0x0141;	 Catch:{ all -> 0x00fc }
    L_0x009b:
        r4 = r3.length;	 Catch:{ all -> 0x00fc }
        r2 = 0;	 Catch:{ all -> 0x00fc }
    L_0x009d:
        if (r2 >= r4) goto L_0x012b;	 Catch:{ all -> 0x00fc }
    L_0x009f:
        r5 = r3[r2];	 Catch:{ all -> 0x00fc }
        r6 = r5.getName();	 Catch:{ all -> 0x00fc }
        r7 = ".";	 Catch:{ all -> 0x00fc }
        r8 = "";	 Catch:{ all -> 0x00fc }
        r6 = r6.replace(r7, r8);	 Catch:{ all -> 0x00fc }
        r7 = "/";	 Catch:{ all -> 0x00fc }
        r8 = "";	 Catch:{ all -> 0x00fc }
        r6 = r6.replace(r7, r8);	 Catch:{ all -> 0x00fc }
        r7 = " ";	 Catch:{ all -> 0x00fc }
        r8 = "";	 Catch:{ all -> 0x00fc }
        r6 = r6.replace(r7, r8);	 Catch:{ all -> 0x00fc }
        r6 = r6.length();	 Catch:{ all -> 0x00fc }
        if (r6 == 0) goto L_0x0127;	 Catch:{ all -> 0x00fc }
    L_0x00c3:
        r6 = new java.io.File;	 Catch:{ all -> 0x00fc }
        r7 = r5.getName();	 Catch:{ all -> 0x00fc }
        r0 = r19;	 Catch:{ all -> 0x00fc }
        r6.<init>(r0, r7);	 Catch:{ all -> 0x00fc }
        r7 = r6.exists();	 Catch:{ all -> 0x00fc }
        if (r7 == 0) goto L_0x00df;	 Catch:{ all -> 0x00fc }
    L_0x00d4:
        r7 = r6.isDirectory();	 Catch:{ all -> 0x00fc }
        if (r7 == 0) goto L_0x010d;	 Catch:{ all -> 0x00fc }
    L_0x00da:
        r7 = 0;	 Catch:{ all -> 0x00fc }
        r8 = 0;	 Catch:{ all -> 0x00fc }
        recursiveDelete(r6, r7, r8);	 Catch:{ all -> 0x00fc }
    L_0x00df:
        r7 = r5.renameTo(r6);	 Catch:{ all -> 0x00fc }
        if (r7 != 0) goto L_0x0127;	 Catch:{ all -> 0x00fc }
    L_0x00e5:
        r2 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x00fc }
        r3 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;	 Catch:{ all -> 0x00fc }
        r4 = "File [%s] renameTo [%s] failed.";	 Catch:{ all -> 0x00fc }
        r7 = 2;	 Catch:{ all -> 0x00fc }
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x00fc }
        r8 = 0;	 Catch:{ all -> 0x00fc }
        r7[r8] = r5;	 Catch:{ all -> 0x00fc }
        r5 = 1;	 Catch:{ all -> 0x00fc }
        r7[r5] = r6;	 Catch:{ all -> 0x00fc }
        r4 = java.lang.String.format(r4, r7);	 Catch:{ all -> 0x00fc }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00fc }
        throw r2;	 Catch:{ all -> 0x00fc }
    L_0x00fc:
        r2 = move-exception;
        r3 = 0;
        r4 = 0;
        recursiveDelete(r9, r3, r4);	 Catch:{ all -> 0x0031 }
        throw r2;	 Catch:{ all -> 0x0031 }
    L_0x0103:
        r2 = r18.getAbsolutePath();	 Catch:{ all -> 0x00fc }
        r2 = detect7zFromFileName(r2);	 Catch:{ all -> 0x00fc }
        goto L_0x007f;	 Catch:{ all -> 0x00fc }
    L_0x010d:
        r7 = r6.delete();	 Catch:{ all -> 0x00fc }
        if (r7 != 0) goto L_0x00df;	 Catch:{ all -> 0x00fc }
    L_0x0113:
        r2 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x00fc }
        r3 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;	 Catch:{ all -> 0x00fc }
        r4 = "File [%s] delete failed.";	 Catch:{ all -> 0x00fc }
        r5 = 1;	 Catch:{ all -> 0x00fc }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00fc }
        r7 = 0;	 Catch:{ all -> 0x00fc }
        r5[r7] = r6;	 Catch:{ all -> 0x00fc }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x00fc }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00fc }
        throw r2;	 Catch:{ all -> 0x00fc }
    L_0x0127:
        r2 = r2 + 1;	 Catch:{ all -> 0x00fc }
        goto L_0x009d;	 Catch:{ all -> 0x00fc }
    L_0x012b:
        r3 = r13;	 Catch:{ all -> 0x00fc }
        r4 = r14;	 Catch:{ all -> 0x00fc }
        r6 = r16;	 Catch:{ all -> 0x00fc }
        r8 = r19;	 Catch:{ all -> 0x00fc }
        expectMakeDecompressFinished(r3, r4, r6, r8);	 Catch:{ all -> 0x00fc }
        r2 = 0;
        r3 = 0;
        recursiveDelete(r9, r2, r3);	 Catch:{ all -> 0x0031 }
        if (r21 == 0) goto L_0x013e;	 Catch:{ all -> 0x0031 }
    L_0x013b:
        deleteFile(r18);	 Catch:{ all -> 0x0031 }
    L_0x013e:
        r2 = 1;
        goto L_0x0011;
    L_0x0141:
        r2 = new com.uc.webview.export.cyclone.UCKnownException;	 Catch:{ all -> 0x00fc }
        r3 = 2008; // 0x7d8 float:2.814E-42 double:9.92E-321;	 Catch:{ all -> 0x00fc }
        r4 = "Zip [%s] decompress success but no items found.";	 Catch:{ all -> 0x00fc }
        r5 = 1;	 Catch:{ all -> 0x00fc }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00fc }
        r6 = 0;	 Catch:{ all -> 0x00fc }
        r5[r6] = r18;	 Catch:{ all -> 0x00fc }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ all -> 0x00fc }
        r2.<init>(r3, r4);	 Catch:{ all -> 0x00fc }
        throw r2;	 Catch:{ all -> 0x00fc }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.cyclone.UCCyclone.decompressIfNeeded(android.content.Context, boolean, java.lang.String, long, long, java.io.File, java.io.File, java.io.FilenameFilter, boolean):boolean");
    }

    static File getDecompressStopFlgFile(String str, long j, long j2, File file, boolean z) {
        return new File(file, getDecompressSourceHash(str, j, j2, z));
    }

    static File getDecompressStartFlgFile(String str, long j, long j2, File file, boolean z) {
        return new File(file, getDecompressSourceHash(str, j, j2, z) + "_start");
    }

    static void expectMakeDecompressFinished(String str, long j, long j2, File file) throws UCKnownException {
        UCKnownException uCKnownException;
        try {
            File decompressStopFlgFile = getDecompressStopFlgFile(str, j, j2, file, false);
            if (decompressStopFlgFile.exists() || decompressStopFlgFile.createNewFile()) {
                try {
                    decompressStopFlgFile = getDecompressStartFlgFile(str, j, j2, file, false);
                    if (decompressStopFlgFile.exists() && !decompressStopFlgFile.delete()) {
                        throw new Exception("delete File return false");
                    }
                } catch (Throwable th) {
                    uCKnownException = new UCKnownException(1004, th);
                }
            } else {
                throw new Exception("createNewFile return false");
            }
        } catch (Throwable th2) {
            uCKnownException = new UCKnownException(1006, th2);
        }
    }

    public static void recursiveDelete(File file, boolean z, Object obj) {
        if (file.exists()) {
            ArrayList arrayList;
            if (obj != null) {
                Collection arrayList2 = new ArrayList(2);
                if (obj instanceof File) {
                    arrayList2.add((File) obj);
                    arrayList = arrayList2;
                } else if (obj instanceof File[]) {
                    Collections.addAll(arrayList2, (File[]) obj);
                    Collection collection = arrayList2;
                } else {
                    throw new UCKnownException(1010, String.format("File or File[] argument expected, but get [%s].", new Object[]{obj.getClass().getName()}));
                }
            }
            arrayList = null;
            ArrayList arrayList3 = new ArrayList(20);
            File[] listFiles = (z && file.isDirectory()) ? file.listFiles() : new File[]{file};
            File[] fileArr = listFiles;
            int i = -1;
            while (true) {
                for (File file2 : r3) {
                    if (arrayList == null || !arrayList.contains(file2)) {
                        if (!file2.isDirectory()) {
                            file2.delete();
                        } else if (file2.getName().replace(".", "").replace("/", "").replace(" ", "").length() != 0) {
                            arrayList3.add(file2);
                        }
                    }
                }
                int i2 = i + 1;
                if (i2 < arrayList3.size()) {
                    listFiles = ((File) arrayList3.get(i2)).listFiles();
                } else {
                    listFiles = null;
                }
                if (listFiles == null || i2 >= LogType.UNEXP) {
                } else {
                    int i3 = i2;
                    fileArr = listFiles;
                    i = i3;
                }
            }
            for (int size = arrayList3.size() - 1; size >= 0; size--) {
                ((File) arrayList3.get(size)).delete();
            }
        }
    }

    static void deleteFile(File file) throws UCKnownException {
        if (!file.delete()) {
            throw new UCKnownException(1004, String.format("File [%s] delete failed.", new Object[]{file.getAbsolutePath()}));
        }
    }

    public static File optimizedFileFor(String str, String str2) {
        String name = new File(str).getName();
        if (!name.endsWith(ShareConstants.DEX_SUFFIX)) {
            int lastIndexOf = name.lastIndexOf(".");
            if (lastIndexOf < 0) {
                name = name + ShareConstants.DEX_SUFFIX;
            } else {
                StringBuilder stringBuilder = new StringBuilder(lastIndexOf + 4);
                stringBuilder.append(name, 0, lastIndexOf);
                stringBuilder.append(ShareConstants.DEX_SUFFIX);
                name = stringBuilder.toString();
            }
        }
        return new File(str2, name);
    }

    public static String md5FileContents(File file) {
        Closeable bufferedInputStream;
        Throwable th;
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr, 0, ShareConstants.MD5_FILE_BUF_LENGTH);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        close(bufferedInputStream);
                        BigInteger bigInteger = new BigInteger(1, instance.digest());
                        return String.format(Locale.CHINA, "%032x", new Object[]{bigInteger});
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = null;
            th = th4;
            close(bufferedInputStream);
            throw th;
        }
    }

    public static File genFile(Context context, String str, String str2, String str3, long j, String str4, byte[][] bArr, Object... objArr) throws UCKnownException, IOException {
        File file;
        File dataFolder = getDataFolder(context);
        if (str == null || str.length() <= 0) {
            file = dataFolder;
        } else {
            file = expectCreateDirFile(new File(dataFolder, str));
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        String str5 = str2 + String.valueOf(j) + str3;
        File file2 = new File(file, str5);
        if (!file2.canRead()) {
            file2.delete();
        }
        long codeLength = (long) getCodeLength(bArr);
        if (!(file2.exists() && file2.length() == codeLength && str4.equals(md5FileContents(file2)))) {
            getFile(bArr, file2);
            UCLogger create = !enableDebugLog ? null : UCLogger.create("d", LOG_TAG);
            if (create != null) {
                create.print("genFile Extract new " + str5 + " to " + file, new Throwable[0]);
            }
        }
        if (sInusedFiles != null) {
            sInusedFiles.add(file2);
        }
        return file2;
    }

    private static int getCodeLength(byte[][] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            i2 += bArr[i].length;
            i++;
        }
        return i2;
    }

    public static void copy(File file, File file2) throws IOException {
        OutputStream fileOutputStream;
        InputStream fileInputStream = new FileInputStream(file);
        try {
            fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            fileInputStream.close();
        }
    }
}
