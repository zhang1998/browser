package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: ProGuard */
public final class b {
    private static final String a = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> b = new HashSet();
    private static final boolean c = a(System.getProperty("java.vm.version"));

    static /* synthetic */ void a(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field b = b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        b.set(obj, objArr3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6) {
        /*
        r0 = c;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 4;
        if (r0 >= r1) goto L_0x0027;
    L_0x000a:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Multi dex installation failed. SDK ";
        r1.<init>(r2);
        r2 = android.os.Build.VERSION.SDK_INT;
        r1 = r1.append(r2);
        r2 = " is unsupported. Min SDK version is 4.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0027:
        r0 = b(r6);	 Catch:{ Exception -> 0x003f }
        if (r0 == 0) goto L_0x0004;
    L_0x002d:
        r1 = b;	 Catch:{ Exception -> 0x003f }
        monitor-enter(r1);	 Catch:{ Exception -> 0x003f }
        r2 = r0.sourceDir;	 Catch:{ all -> 0x003c }
        r3 = b;	 Catch:{ all -> 0x003c }
        r3 = r3.contains(r2);	 Catch:{ all -> 0x003c }
        if (r3 == 0) goto L_0x0066;
    L_0x003a:
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = "Multidex installation failure";
        android.util.Log.e(r1, r2, r0);
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Multi dex installation failed (";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = ").";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0066:
        r3 = b;	 Catch:{ all -> 0x003c }
        r3.add(r2);	 Catch:{ all -> 0x003c }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003c }
        r3 = 20;
        if (r2 <= r3) goto L_0x009d;
    L_0x0071:
        r2 = "MultiDex";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003c }
        r4 = "MultiDex is not guaranteed to work in SDK version ";
        r3.<init>(r4);	 Catch:{ all -> 0x003c }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003c }
        r3 = r3.append(r4);	 Catch:{ all -> 0x003c }
        r4 = ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003c }
        r4 = "java.vm.version";
        r4 = java.lang.System.getProperty(r4);	 Catch:{ all -> 0x003c }
        r3 = r3.append(r4);	 Catch:{ all -> 0x003c }
        r4 = "\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x003c }
        r3 = r3.toString();	 Catch:{ all -> 0x003c }
        android.util.Log.w(r2, r3);	 Catch:{ all -> 0x003c }
    L_0x009d:
        r2 = r6.getClassLoader();	 Catch:{ RuntimeException -> 0x00ad }
        if (r2 != 0) goto L_0x00b8;
    L_0x00a3:
        r0 = "MultiDex";
        r2 = "Context class loader is null. Must be running in test mode. Skip patching.";
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x003c }
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x00ad:
        r0 = move-exception;
        r2 = "MultiDex";
        r3 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.";
        android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x003c }
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x00b8:
        c(r6);	 Catch:{ Throwable -> 0x00d5 }
    L_0x00bb:
        r3 = new java.io.File;	 Catch:{ all -> 0x003c }
        r4 = r0.dataDir;	 Catch:{ all -> 0x003c }
        r5 = a;	 Catch:{ all -> 0x003c }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x003c }
        r4 = 0;
        r4 = android.support.multidex.d.a(r6, r0, r3, r4);	 Catch:{ all -> 0x003c }
        r5 = a(r4);	 Catch:{ all -> 0x003c }
        if (r5 == 0) goto L_0x00de;
    L_0x00cf:
        a(r2, r3, r4);	 Catch:{ all -> 0x003c }
    L_0x00d2:
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        goto L_0x0004;
    L_0x00d5:
        r3 = move-exception;
        r4 = "MultiDex";
        r5 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.";
        android.util.Log.w(r4, r5, r3);	 Catch:{ all -> 0x003c }
        goto L_0x00bb;
    L_0x00de:
        r4 = "MultiDex";
        r5 = "Files were not valid zip files.  Forcing a reload.";
        android.util.Log.w(r4, r5);	 Catch:{ all -> 0x003c }
        r4 = 1;
        r0 = android.support.multidex.d.a(r6, r0, r3, r4);	 Catch:{ all -> 0x003c }
        r4 = a(r0);	 Catch:{ all -> 0x003c }
        if (r4 == 0) goto L_0x00f4;
    L_0x00f0:
        a(r2, r3, r0);	 Catch:{ all -> 0x003c }
        goto L_0x00d2;
    L_0x00f4:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x003c }
        r2 = "Zip files were not valid.";
        r0.<init>(r2);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ all -> 0x003c }
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.b.a(android.content.Context):void");
    }

    private static ApplicationInfo b(Context context) throws NameNotFoundException {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, 128);
        } catch (Throwable e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    private static boolean a(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!list.isEmpty()) {
            Object obj;
            ArrayList arrayList;
            if (VERSION.SDK_INT >= 19) {
                obj = b(classLoader, "pathList").get(classLoader);
                ArrayList arrayList2 = new ArrayList();
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2}));
                if (arrayList2.size() > 0) {
                    Object obj2;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                    }
                    Field b = b(classLoader, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr = (IOException[]) b.get(classLoader);
                    if (iOExceptionArr == null) {
                        obj2 = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
                    } else {
                        obj = new IOException[(arrayList2.size() + iOExceptionArr.length)];
                        arrayList2.toArray(obj);
                        System.arraycopy(iOExceptionArr, 0, obj, arrayList2.size(), iOExceptionArr.length);
                        obj2 = obj;
                    }
                    b.set(classLoader, obj2);
                }
            } else if (VERSION.SDK_INT >= 14) {
                obj = b(classLoader, "pathList").get(classLoader);
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) a(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
            } else {
                a.a(classLoader, list);
            }
        }
    }

    private static boolean a(List<File> list) {
        for (File a : list) {
            if (!d.a(a)) {
                return false;
            }
        }
        return true;
    }

    private static Field b(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method a(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void c(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
