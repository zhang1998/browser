package android.support.multidex;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* compiled from: ProGuard */
final class a {
    static /* synthetic */ void a(ClassLoader classLoader, List list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
        int size = list.size();
        Field a = b.b(classLoader, "path");
        StringBuilder stringBuilder = new StringBuilder((String) a.get(classLoader));
        Object[] objArr = new String[size];
        Object[] objArr2 = new File[size];
        Object[] objArr3 = new ZipFile[size];
        Object[] objArr4 = new DexFile[size];
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            File file = (File) listIterator.next();
            String absolutePath = file.getAbsolutePath();
            stringBuilder.append(':').append(absolutePath);
            int previousIndex = listIterator.previousIndex();
            objArr[previousIndex] = absolutePath;
            objArr2[previousIndex] = file;
            objArr3[previousIndex] = new ZipFile(file);
            objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ShareConstants.DEX_SUFFIX, 0);
        }
        a.set(classLoader, stringBuilder.toString());
        b.a((Object) classLoader, "mPaths", objArr);
        b.a((Object) classLoader, "mFiles", objArr2);
        b.a((Object) classLoader, "mZips", objArr3);
        b.a((Object) classLoader, "mDexs", objArr4);
    }
}
