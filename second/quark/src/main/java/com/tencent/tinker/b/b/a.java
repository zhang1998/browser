package com.tencent.tinker.b.b;

import com.tencent.tinker.b.c.f;
import com.tencent.tinker.b.c.i;
import com.tencent.tinker.b.c.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ProGuard */
public final class a {
    public static void a(i iVar, f fVar, j jVar) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = iVar.a(fVar);
            jVar.a(new f(fVar));
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                jVar.write(bArr, 0, read);
            }
            jVar.a();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public static void a(f fVar, InputStream inputStream, j jVar) throws IOException {
        jVar.a(fVar);
        byte[] bArr = new byte[16384];
        int read = inputStream.read(bArr);
        while (read != -1) {
            jVar.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        jVar.a();
    }

    public static void a(f fVar, File file, long j, j jVar) throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        f fVar2 = new f(fVar);
        fVar2.a(0);
        fVar2.a(file.length());
        fVar2.d = file.length();
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("Bad CRC32: " + j);
        }
        fVar2.c = j;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                jVar.a(new f(fVar2));
                byte[] bArr = new byte[16384];
                for (int read = fileInputStream.read(bArr); read != -1; read = fileInputStream.read(bArr)) {
                    jVar.write(bArr, 0, read);
                }
                jVar.a();
                fileInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }
}
