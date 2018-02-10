package com.tencent.tinker.c.a.b;

import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class d {
    public static byte[] a(InputStream inputStream, int i) throws IOException {
        if (i <= 0) {
            i = WXMediaMessage.THUMB_LENGTH_LIMIT;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i);
        byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
