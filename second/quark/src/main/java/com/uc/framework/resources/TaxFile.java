package com.uc.framework.resources;

import android.content.res.AssetManager;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProGuard */
public class TaxFile {
    private static boolean b;
    protected Map<String, int[]> a = new HashMap();
    private boolean c;
    private String[] d;
    private AssetManager e;
    private String f;
    private boolean g;

    private native boolean nativeExists(String str);

    private native String[] nativeGetItems();

    private native boolean nativeInit(AssetManager assetManager, String str);

    private native byte[] nativeRead(String str);

    static {
        b = false;
        try {
            System.loadLibrary("tax");
            b = true;
        } catch (Error e) {
            b = false;
        }
    }

    public TaxFile(AssetManager assetManager, String str) throws IOException {
        this.e = assetManager;
        this.f = str;
        if (b) {
            this.g = nativeInit(assetManager, str);
        } else {
            this.g = false;
        }
        if (!this.g) {
            c(assetManager.open(str));
        }
    }

    private static int a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[2];
        inputStream.read(bArr, 0, 2);
        return (bArr[0] & 255) | (bArr[1] << 8);
    }

    private static int b(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        inputStream.read(bArr, 0, 4);
        return (bArr[0] & 255) | (((bArr[3] << 24) | ((bArr[2] & 255) << 16)) | ((bArr[1] & 255) << 8));
    }

    private static String a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        inputStream.read(bArr, 0, i);
        int i2 = 0;
        while (i2 < i && bArr[i2] != (byte) 0) {
            i2++;
        }
        return new String(bArr, 0, i2, "ISO-8859-1");
    }

    private void c(InputStream inputStream) throws IOException {
        PrintStream printStream;
        InputStream dataInputStream = new DataInputStream(inputStream);
        int readInt = dataInputStream.readInt();
        if (1431585101 != readInt) {
            PrintStream printStream2 = System.out;
            new StringBuilder("invalid file with magic[").append(readInt).append("]!");
        }
        if (dataInputStream.available() != b(dataInputStream) - 8) {
            printStream = System.out;
        }
        this.c = a(dataInputStream) != 0;
        int a = a(dataInputStream);
        int b = b(dataInputStream);
        printStream = System.out;
        new StringBuilder("tax offset:").append(b(dataInputStream));
        printStream = System.out;
        new StringBuilder("item offset:").append(b(dataInputStream));
        if (this.c && a < 2) {
            printStream = System.out;
        }
        this.d = new String[a];
        readInt = 0;
        do {
            this.d[readInt] = a(dataInputStream, 128);
            readInt++;
        } while (readInt < a);
        readInt = 0;
        do {
            Object obj = new int[3];
            obj[0] = a(dataInputStream);
            if (!this.c && obj[0] > null) {
                PrintStream printStream3 = System.out;
            }
            String a2 = a(dataInputStream, 254);
            obj[1] = b(dataInputStream);
            obj[2] = b(dataInputStream);
            this.a.put(a2, obj);
            readInt++;
        } while (readInt < b);
    }

    public final byte[] a(String str) throws IOException {
        if (this.g) {
            return nativeRead(str);
        }
        int[] iArr = (int[]) this.a.get(str);
        if (iArr == null || this.e == null) {
            return null;
        }
        InputStream open = this.e.open("theme" + File.separator + this.d[iArr[0]]);
        open.skip((long) iArr[1]);
        byte[] bArr = new byte[iArr[2]];
        int i = iArr[2];
        int i2 = 0;
        while (i > 0) {
            int read = open.read(bArr, i2, i);
            if (read <= 0) {
                break;
            }
            i2 += read;
            i -= read;
        }
        if (i != 0) {
            PrintStream printStream = System.out;
        }
        open.close();
        return bArr;
    }
}
