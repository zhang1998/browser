package com.tencent.tinker.loader;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

@TargetApi(14)
/* compiled from: ProGuard */
class AndroidNClassLoader extends PathClassLoader {
    private static final String TAG = "Tinker.NClassLoader";
    private String applicationClassName;
    private final PathClassLoader originClassLoader;

    private AndroidNClassLoader(String str, PathClassLoader pathClassLoader, Application application) {
        super(str, pathClassLoader.getParent());
        this.originClassLoader = pathClassLoader;
        String name = application.getClass().getName();
        if (name != null && !name.equals("android.app.Application")) {
            this.applicationClassName = name;
        }
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader) throws Exception {
        Object[] objArr = (Object[]) ShareReflectUtil.findField(obj, "dexElements").get(obj);
        List<File> list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
        StringBuilder stringBuilder = new StringBuilder();
        Field findField = ShareReflectUtil.findField(objArr.getClass().getComponentType(), "dexFile");
        int i = 1;
        for (Object obj2 : objArr) {
            DexFile dexFile = (DexFile) findField.get(obj2);
            if (dexFile != null) {
                if (i != 0) {
                    i = 0;
                } else {
                    stringBuilder.append(File.pathSeparator);
                }
                stringBuilder.append(dexFile.getName());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        int i2 = 1;
        for (File file : list) {
            if (file != null) {
                if (i2 != 0) {
                    i2 = 0;
                } else {
                    stringBuilder3.append(File.pathSeparator);
                }
                stringBuilder3.append(file.getAbsolutePath());
            }
        }
        String stringBuilder4 = stringBuilder3.toString();
        return ShareReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class).newInstance(new Object[]{classLoader, stringBuilder2, stringBuilder4, null});
    }

    private static AndroidNClassLoader createAndroidNClassLoader(PathClassLoader pathClassLoader, Application application) throws Exception {
        ClassLoader androidNClassLoader = new AndroidNClassLoader("", pathClassLoader, application);
        Field findField = ShareReflectUtil.findField((Object) pathClassLoader, "pathList");
        findField.set(androidNClassLoader, recreateDexPathList(findField.get(pathClassLoader), androidNClassLoader));
        return androidNClassLoader;
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader) throws Exception {
        Object obj = (Context) ShareReflectUtil.findField((Object) application, "mBase").get(application);
        obj = ShareReflectUtil.findField(obj, "mPackageInfo").get(obj);
        Field findField = ShareReflectUtil.findField(obj, "mClassLoader");
        Thread.currentThread().setContextClassLoader(classLoader);
        findField.set(obj, classLoader);
    }

    public static AndroidNClassLoader inject(PathClassLoader pathClassLoader, Application application) throws Exception {
        ClassLoader createAndroidNClassLoader = createAndroidNClassLoader(pathClassLoader, application);
        reflectPackageInfoClassloader(application, createAndroidNClassLoader);
        return createAndroidNClassLoader;
    }

    public Class<?> findClass(String str) throws ClassNotFoundException {
        if ((str == null || ((!str.startsWith("com.tencent.tinker.loader.") && !str.startsWith("com.uc.aerie.loader.stable")) || str.equals(SystemClassLoaderAdder.CHECK_DEX_CLASS))) && (this.applicationClassName == null || !this.applicationClassName.equals(str))) {
            return super.findClass(str);
        }
        return this.originClassLoader.loadClass(str);
    }

    public String findLibrary(String str) {
        return super.findLibrary(str);
    }
}
