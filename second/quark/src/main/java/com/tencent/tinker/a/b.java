package com.tencent.tinker.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class b {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                return false;
            }
            i3 += read;
        }
        return true;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        while (true) {
            int read = inputStream.read(bArr, 0, SpdyProtocol.SLIGHTSSL_1_RTT_MODE);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
