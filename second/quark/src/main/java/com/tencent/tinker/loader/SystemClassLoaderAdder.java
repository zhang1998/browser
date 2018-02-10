package com.tencent.tinker.loader;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
public class SystemClassLoaderAdder {
    public static final String CHECK_DEX_CLASS = "com.tencent.tinker.loader.TinkerTestDexLoad";
    public static final String CHECK_DEX_FIELD = "isPatch";
    private static final String TAG = "Tinker.ClassLoaderAdder";

    /* compiled from: ProGuard */
    final class AnonymousClass1 implements Comparator<File> {
        final /* synthetic */ Map val$matchesClassNPatternMemo;

        AnonymousClass1(Map map) {
            this.val$matchesClassNPatternMemo = map;
        }

        public final int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return -1;
            }
            if (file2 == null) {
                return 1;
            }
            String name = file.getName();
            String name2 = file2.getName();
            if (name.equals(name2)) {
                return 0;
            }
            if (name.startsWith(ShareConstants.TEST_DEX_NAME)) {
                return 1;
            }
            if (name2.startsWith(ShareConstants.TEST_DEX_NAME)) {
                return -1;
            }
            boolean booleanValue = ((Boolean) this.val$matchesClassNPatternMemo.get(name)).booleanValue();
            boolean booleanValue2 = ((Boolean) this.val$matchesClassNPatternMemo.get(name2)).booleanValue();
            if (booleanValue && booleanValue2) {
                int parseInt;
                int indexOf = name.indexOf(46);
                int indexOf2 = name2.indexOf(46);
                if (indexOf > 7) {
                    parseInt = Integer.parseInt(name.substring(7, indexOf));
                } else {
                    parseInt = 1;
                }
                if (indexOf2 > 7) {
                    indexOf = Integer.parseInt(name2.substring(7, indexOf2));
                } else {
                    indexOf = 1;
                }
                if (parseInt == indexOf) {
                    return 0;
                }
                return parseInt < indexOf ? -1 : 1;
            } else if (booleanValue) {
                return -1;
            } else {
                if (booleanValue2) {
                    return 1;
                }
                return name.compareTo(name2);
            }
        }
    }

    /* compiled from: ProGuard */
    final class V14 {
        private V14() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file));
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    /* compiled from: ProGuard */
    final class V19 {
        private V19() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(SystemClassLoaderAdder.TAG, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    throw e2;
                }
            }
            return (Object[]) findMethod.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* compiled from: ProGuard */
    final class V23 {
        private V23() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            Object obj = ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            ShareReflectUtil.expandFieldArray(obj, "dexElements", makePathElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(SystemClassLoaderAdder.TAG, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] makePathElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Method findMethod;
            try {
                findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException e) {
                Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makePathElements(List,File,List) failure");
                try {
                    findMethod = ShareReflectUtil.findMethod(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
                } catch (NoSuchMethodException e2) {
                    Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                    try {
                        Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: try use v19 instead");
                        return V19.makeDexElements(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e3) {
                        Log.e(SystemClassLoaderAdder.TAG, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                        throw e3;
                    }
                }
            }
            return (Object[]) findMethod.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    /* compiled from: ProGuard */
    final class V4 {
        private V4() {
        }

        private static void install(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field findField = ShareReflectUtil.findField((Object) classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) findField.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file2 = (File) listIterator.next();
                String absolutePath = file2.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                strArr[previousIndex] = absolutePath;
                fileArr[previousIndex] = file2;
                zipFileArr[previousIndex] = new ZipFile(file2);
                dexFileArr[previousIndex] = DexFile.loadDex(absolutePath, SharePatchFileUtil.optimizedPathFor(file2, file), 0);
            }
            findField.set(classLoader, stringBuilder.toString());
            ShareReflectUtil.expandFieldArray(classLoader, "mPaths", strArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mFiles", fileArr);
            ShareReflectUtil.expandFieldArray(classLoader, "mZips", zipFileArr);
            try {
                ShareReflectUtil.expandFieldArray(classLoader, "mDexs", dexFileArr);
            } catch (Exception e) {
            }
        }
    }

    @SuppressLint({"NewApi"})
    public int installDexes(Application application, PathClassLoader pathClassLoader, File file, List<File> list) throws Throwable {
        new StringBuilder("installDexes dexOptDir: ").append(file.getAbsolutePath()).append(", dex size:").append(list.size());
        if (list.isEmpty()) {
            return 0;
        }
        List createSortedAdditionalPathEntries = createSortedAdditionalPathEntries(list);
        if (VERSION.SDK_INT >= 24) {
            pathClassLoader = AndroidNClassLoader.inject(pathClassLoader, application);
        }
        if (VERSION.SDK_INT >= 23) {
            V23.install(pathClassLoader, createSortedAdditionalPathEntries, file);
        } else if (VERSION.SDK_INT >= 19) {
            V19.install(pathClassLoader, createSortedAdditionalPathEntries, file);
        } else if (VERSION.SDK_INT >= 14) {
            V14.install(pathClassLoader, createSortedAdditionalPathEntries, file);
        } else {
            V4.install(pathClassLoader, createSortedAdditionalPathEntries, file);
        }
        new StringBuilder("after loaded classloader: ").append(pathClassLoader).append(", dex size:").append(createSortedAdditionalPathEntries.size());
        if (checkDexInstall(pathClassLoader)) {
            return createSortedAdditionalPathEntries.size();
        }
        uninstallPatchDex(pathClassLoader, createSortedAdditionalPathEntries.size());
        throw new TinkerRuntimeException(ShareConstants.CHECK_DEX_INSTALL_FAIL);
    }

    public void uninstallPatchDex(ClassLoader classLoader, int i) throws Throwable {
        if (i > 0) {
            if (VERSION.SDK_INT >= 14) {
                ShareReflectUtil.reduceFieldArray(ShareReflectUtil.findField((Object) classLoader, "pathList").get(classLoader), "dexElements", i);
                return;
            }
            ShareReflectUtil.reduceFieldArray(classLoader, "mPaths", i);
            ShareReflectUtil.reduceFieldArray(classLoader, "mFiles", i);
            ShareReflectUtil.reduceFieldArray(classLoader, "mZips", i);
            try {
                ShareReflectUtil.reduceFieldArray(classLoader, "mDexs", i);
            } catch (Exception e) {
            }
        }
    }

    private static boolean checkDexInstall(ClassLoader classLoader) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        boolean booleanValue = ((Boolean) ShareReflectUtil.findField(Class.forName(CHECK_DEX_CLASS, true, classLoader), CHECK_DEX_FIELD).get(null)).booleanValue();
        Log.w(TAG, "checkDexInstall result:" + booleanValue);
        return booleanValue;
    }

    private static List<File> createSortedAdditionalPathEntries(List<File> list) {
        List<File> arrayList = new ArrayList(list);
        Map hashMap = new HashMap();
        for (File name : arrayList) {
            CharSequence name2 = name.getName();
            hashMap.put(name2, Boolean.valueOf(ShareConstants.CLASS_N_PATTERN.matcher(name2).matches()));
        }
        Collections.sort(arrayList, new AnonymousClass1(hashMap));
        return arrayList;
    }
}
