package com.uc.b;

import android.graphics.drawable.Drawable;
import com.uc.b.a.af;
import com.uc.b.a.o;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* compiled from: ProGuard */
public final class a {
    public static HashMap<String, ?>[] a;
    public static HashMap<String, ?>[] b;
    private static String c;

    public static Drawable a(String str, String str2, float f, float f2) {
        if (str == null) {
            return null;
        }
        HashMap[] hashMapArr;
        HashMap[] hashMapArr2;
        if ("theme/default/".equals(str)) {
            hashMapArr = a;
        } else if (str.equals(c)) {
            hashMapArr = b;
        } else {
            int i;
            if ("theme/night/".equals(str)) {
                i = 1;
            } else if ("theme/transparent/".equals(str)) {
                i = 2;
            } else if ("theme/green/".equals(str)) {
                i = 3;
            } else if ("theme/orange/".equals(str)) {
                i = 4;
            } else if ("theme/pink/".equals(str)) {
                i = 5;
            } else if ("theme/black/".equals(str)) {
                i = 6;
            } else {
                i = -1;
            }
            if (i > 0) {
                hashMapArr = a(i);
            } else {
                hashMapArr = a(str);
            }
            b = hashMapArr;
        }
        c = str;
        if (hashMapArr == null) {
            hashMapArr2 = a;
        } else {
            hashMapArr2 = hashMapArr;
        }
        return af.a(hashMapArr2[0], hashMapArr2[1], o.STRING, str, str2, f, f2);
    }

    public static HashMap<String, ?>[] a(int i) {
        try {
            Class cls = Class.forName("com.ucpro.svg.resource.SvgDex");
            Method declaredMethod = cls.getDeclaredMethod("getSlots", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            return (HashMap[]) declaredMethod.invoke(cls, new Object[]{Integer.valueOf(i)});
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            return null;
        } catch (IllegalAccessException e3) {
            return null;
        } catch (IllegalArgumentException e4) {
            return null;
        } catch (InvocationTargetException e5) {
            return null;
        }
    }

    private static HashMap<String, ?>[] a(String str) {
        int i = 0;
        HashMap<String, ?>[] hashMapArr = new HashMap[2];
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new FileInputStream(str));
        } catch (FileNotFoundException e) {
        }
        if (dataInputStream != null) {
            try {
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                hashMapArr[0] = new HashMap(readUnsignedShort);
                HashMap hashMap = hashMapArr[0];
                while (true) {
                    int i2 = i + 1;
                    if (i >= readUnsignedShort) {
                        break;
                    }
                    String readUTF = dataInputStream.readUTF();
                    Object obj = new byte[dataInputStream.readUnsignedShort()];
                    dataInputStream.read(obj);
                    hashMap.put(readUTF, obj);
                    i = i2;
                }
                dataInputStream.close();
            } catch (IOException e2) {
                dataInputStream.close();
            } catch (IOException e3) {
            } catch (Throwable th) {
                dataInputStream.close();
            }
        }
        return hashMapArr;
    }
}
