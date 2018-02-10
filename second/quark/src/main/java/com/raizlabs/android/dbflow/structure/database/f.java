package com.raizlabs.android.dbflow.structure.database;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.raizlabs.android.dbflow.config.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class f extends g {
    private e b;
    @Nullable
    private final d c = null;

    public f(e eVar, c cVar) {
        super(cVar);
        this.b = eVar;
    }

    public final void a(@NonNull b bVar) {
        super.a(bVar);
    }

    public final void a(@NonNull b bVar, int i, int i2) {
        super.a(bVar, i, i2);
    }

    static void a(File file, InputStream inputStream) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                return;
            }
        }
    }
}
