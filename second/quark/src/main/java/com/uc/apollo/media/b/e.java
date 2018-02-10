package com.uc.apollo.media.b;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.uc.crashsdk.export.LogType;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* compiled from: ProGuard */
public final class e {
    private static a b = new f();
    private com.uc.apollo.media.b.i.a a;

    /* compiled from: ProGuard */
    interface a {
        String a();

        void a(String str);
    }

    /* compiled from: ProGuard */
    final class b implements a {
        StringBuilder a;

        private b() {
            this.a = new StringBuilder(ShareConstants.MD5_FILE_BUF_LENGTH);
        }

        public final void a(String str) {
            this.a.append(str).append('\n');
        }

        public final String a() {
            return this.a.toString();
        }
    }

    /* compiled from: ProGuard */
    public final class c {
        public final String a;
        public final b b;
        public final h c;

        public c(String str, b bVar, h hVar) {
            this.a = str;
            this.b = bVar;
            if (hVar == null) {
                hVar = new k();
            }
            this.c = hVar;
        }
    }

    public static e a(com.uc.apollo.media.b.i.a aVar) {
        return new e(aVar);
    }

    private e(com.uc.apollo.media.b.i.a aVar) {
        this.a = aVar;
    }

    private boolean a(Readable readable, c cVar) throws d {
        a bVar = cVar.c.a() ? new b() : b;
        ArrayList arrayList = new ArrayList(LogType.UNEXP);
        Scanner scanner = new Scanner(readable);
        List list = null;
        double d = -1.0d;
        a aVar = null;
        boolean z = false;
        Object obj = 1;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        String str = "";
        while (scanner.hasNextLine()) {
            String trim = scanner.nextLine().trim();
            i3++;
            if (trim.length() != 0) {
                if (obj != null) {
                    if (this.a != com.uc.apollo.media.b.i.a.M3U8 || trim.startsWith("#EXTM3U")) {
                        obj = null;
                        bVar.a(trim);
                    } else {
                        throw new d(trim, i3, "PlayList type '" + com.uc.apollo.media.b.i.a.M3U8 + "' must start with #EXTM3U");
                    }
                }
                if (str.length() != 0) {
                    String str2 = str + trim;
                    str = "";
                    trim = str2;
                }
                if (trim.endsWith("\\")) {
                    str = trim.substring(0, trim.length() - 1);
                } else if (trim.startsWith("#")) {
                    bVar.a(trim);
                    if (trim.startsWith("#EXT")) {
                        if (trim.startsWith("#EXTINF")) {
                            d = (double) ((int) l.a(trim, i3, "#EXTINF"));
                        } else if (trim.startsWith("#EXT-X-ENDLIST")) {
                            z = true;
                        } else if (trim.startsWith("#EXT-X-TARGETDURATION")) {
                            i = (int) l.a(trim, i3, "#EXT-X-TARGETDURATION");
                        } else if (trim.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                            i2 = (int) l.a(trim, i3, "#EXT-X-MEDIA-SEQUENCE");
                        } else if (trim.startsWith("#EXT-X-STREAM-INF")) {
                            cVar.b.g = true;
                            a aVar2 = new a(trim, i3);
                        } else if (trim.startsWith("#EXT-X-DISCONTINUITY")) {
                            d2 = d3;
                        }
                    }
                } else {
                    trim = m.a(cVar.a, trim);
                    bVar.a(trim);
                    if (aVar != null) {
                        i iVar = new i(aVar.a, trim);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(iVar);
                        aVar = null;
                    } else if (d < 0.0d) {
                        scanner.close();
                        throw new d("", i3, "before url, must specify at least the duration");
                    } else {
                        arrayList.add(new j((int) (1000.0d * d2), (int) (1000.0d * d3), (int) (1000.0d * d), trim));
                        d3 += d;
                        d = -1.0d;
                    }
                }
            }
        }
        scanner.close();
        if (!arrayList.isEmpty()) {
            i iVar2 = cVar.b.d;
            if (iVar2 == null) {
                iVar2 = new i(cVar.a);
            }
            iVar2.a = true;
            iVar2.c = z;
            iVar2.f = i * 1000;
            iVar2.g = i2;
            if (iVar2.h == null || iVar2.h.length != arrayList.size()) {
                iVar2.h = new j[arrayList.size()];
            }
            arrayList.toArray(iVar2.h);
            iVar2.j = bVar.a();
            iVar2.b();
            if (cVar.b.d == null) {
                cVar.b.a = new i[1];
                cVar.b.a[0] = iVar2;
            }
            cVar.b.b();
        } else if (list != null) {
            cVar.b.a = new i[list.size()];
            list.toArray(cVar.b.a);
            Arrays.sort(cVar.b.a, new g(this));
            cVar.b.b = bVar.a();
            cVar.b.b();
            if (cVar.b.d != null && cVar.b.d.a) {
                cVar.b.d.j = cVar.b.b;
            }
        } else {
            cVar.b.a = null;
        }
        return true;
    }

    public final boolean a(InputStream inputStream, c cVar) throws d {
        byte[] bArr = new byte[16];
        try {
            inputStream.mark(16);
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return false;
            }
            inputStream.reset();
            if (read < 16) {
                Object obj = new byte[read];
                System.arraycopy(bArr, 0, obj, 0, read);
                bArr = obj;
            }
            if (bArr[0] >= (byte) 32 && bArr[0] < Byte.MAX_VALUE) {
                return a(new InputStreamReader(inputStream), cVar);
            }
            throw new d(bArr);
        } catch (Throwable e) {
            throw new d(bArr, e);
        } catch (d e2) {
            e2.a(bArr);
            throw e2;
        }
    }
}
