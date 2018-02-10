package com.ucweb.a;

import com.ucweb.a.a.c;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
final class i {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                byte[] bArr3 = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                gZIPInputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
        }
        return bArr2;
    }

    static long a() {
        long j = -1;
        File file = new File(c.c().I() + "upgrade_firstcheck");
        if (file.exists()) {
            byte[] a = c.b().a(file);
            if (a != null) {
                try {
                    j = Long.parseLong(new String(a));
                } catch (NumberFormatException e) {
                }
            }
        }
        return j;
    }

    public static HashMap<String, j> b() {
        HashMap<String, j> hashMap = null;
        String H = c.c().H();
        if (H != null) {
            File file = new File(H);
            if (file.exists()) {
                byte[] a = c.b().a(file);
                if (a != null) {
                    a = c.b().b(a);
                    if (a != null) {
                        hashMap = new HashMap();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(a)));
                        while (true) {
                            try {
                                H = bufferedReader.readLine();
                                if (H == null) {
                                    break;
                                }
                                String[] split = H.split(";");
                                if (split.length >= 4) {
                                    j jVar = new j();
                                    String str = split[0];
                                    if (str != null) {
                                        str = str.trim();
                                        if (str.length() != 0) {
                                            jVar.e = str;
                                            String str2 = split[1];
                                            if (str2 != null) {
                                                try {
                                                    jVar.a = Long.parseLong(str2.trim());
                                                } catch (NumberFormatException e) {
                                                }
                                            }
                                            str2 = split[2];
                                            if (str2 != null) {
                                                try {
                                                    jVar.b = Integer.parseInt(str2.trim());
                                                } catch (NumberFormatException e2) {
                                                }
                                            }
                                            str2 = split[3];
                                            if (str2 != null) {
                                                jVar.c = str2.trim();
                                            }
                                            if (split.length >= 5) {
                                                H = split[4];
                                                if (H != null) {
                                                    try {
                                                        jVar.d = Integer.parseInt(H.trim());
                                                    } catch (NumberFormatException e3) {
                                                    }
                                                }
                                            }
                                            hashMap.put(str, jVar);
                                            new StringBuilder("info  : ").append(jVar);
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } catch (IOException e4) {
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }
}
