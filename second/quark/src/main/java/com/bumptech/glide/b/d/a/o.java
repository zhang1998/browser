package com.bumptech.glide.b.d.a;

import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.f;
import com.bumptech.glide.b.g;
import com.bumptech.glide.util.j;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class o implements g {
    static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    private static final int[] b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public final f a(InputStream inputStream) throws IOException {
        return a(new n((InputStream) j.a((Object) inputStream, "Argument must not be null")));
    }

    public final f a(ByteBuffer byteBuffer) throws IOException {
        return a(new k((ByteBuffer) j.a((Object) byteBuffer, "Argument must not be null")));
    }

    public final int a(InputStream inputStream, b bVar) throws IOException {
        return a(new n((InputStream) j.a((Object) inputStream, "Argument must not be null")), (b) j.a((Object) bVar, "Argument must not be null"));
    }

    private static f a(m mVar) throws IOException {
        int a = mVar.a();
        if (a == 65496) {
            return f.JPEG;
        }
        a = ((a << 16) & -65536) | (mVar.a() & 65535);
        if (a == -1991225785) {
            mVar.a(21);
            return mVar.c() >= 3 ? f.PNG_A : f.PNG;
        } else if ((a >> 8) == 4671814) {
            return f.GIF;
        } else {
            if (a != 1380533830) {
                return f.UNKNOWN;
            }
            mVar.a(4);
            if ((((mVar.a() << 16) & -65536) | (mVar.a() & 65535)) != 1464156752) {
                return f.UNKNOWN;
            }
            a = ((mVar.a() << 16) & -65536) | (mVar.a() & 65535);
            if ((a & -256) != 1448097792) {
                return f.UNKNOWN;
            }
            if ((a & 255) == 88) {
                mVar.a(4);
                return (mVar.c() & 16) != 0 ? f.WEBP_A : f.WEBP;
            } else if ((a & 255) != 76) {
                return f.WEBP;
            } else {
                mVar.a(4);
                return (mVar.c() & 8) != 0 ? f.WEBP_A : f.WEBP;
            }
        }
    }

    private static int a(m mVar, b bVar) throws IOException {
        Object obj;
        int i = -1;
        int a = mVar.a();
        if ((a & 65496) == 65496 || a == 19789 || a == 18761) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            Log.isLoggable("DfltImageHeaderParser", 3);
        } else {
            int i2;
            while (mVar.b() == (short) 255) {
                short b = mVar.b();
                if (b != (short) 218) {
                    if (b != (short) 217) {
                        a = mVar.a() - 2;
                        if (b == (short) 225) {
                            i2 = a;
                            break;
                        }
                        long a2 = mVar.a((long) a);
                        if (a2 != ((long) a)) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                new StringBuilder("Unable to skip enough data, type: ").append(b).append(", wanted to skip: ").append(a).append(", but actually skipped: ").append(a2);
                            }
                            i2 = -1;
                        }
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                        i2 = -1;
                        break;
                    }
                }
                i2 = -1;
                break;
            }
            Log.isLoggable("DfltImageHeaderParser", 3);
            i2 = -1;
            if (i2 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
            } else {
                obj = (byte[]) bVar.a(i2, byte[].class);
                try {
                    int a3 = mVar.a(obj, i2);
                    if (a3 != i2) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            new StringBuilder("Unable to read exif segment data, length: ").append(i2).append(", actually read: ").append(a3);
                        }
                    } else if (a((byte[]) obj, i2)) {
                        i = a(new l(obj, i2));
                    } else {
                        Log.isLoggable("DfltImageHeaderParser", 3);
                    }
                    bVar.a(obj, byte[].class);
                } catch (Throwable th) {
                    bVar.a(obj, byte[].class);
                }
            }
        }
        return i;
    }

    private static boolean a(byte[] bArr, int i) {
        boolean z = bArr != null && i > a.length;
        if (z) {
            for (int i2 = 0; i2 < a.length; i2++) {
                if (bArr[i2] != a[i2]) {
                    return false;
                }
            }
        }
        return z;
    }

    private static int a(l lVar) {
        ByteOrder byteOrder;
        int a;
        short b;
        int i;
        short b2;
        short b3;
        short b4 = lVar.b(6);
        if (b4 != (short) 19789) {
            if (b4 == (short) 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
                lVar.a.order(byteOrder);
                a = lVar.a(10) + 6;
                b = lVar.b(a);
                for (b4 = (short) 0; b4 < b; b4++) {
                    i = (a + 2) + (b4 * 12);
                    b2 = lVar.b(i);
                    if (b2 == (short) 274) {
                        b3 = lVar.b(i + 2);
                        if (b3 <= (short) 0 && b3 <= (short) 12) {
                            int a2 = lVar.a(i + 4);
                            if (a2 >= 0) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    new StringBuilder("Got tagIndex=").append(b4).append(" tagType=").append(b2).append(" formatCode=").append(b3).append(" componentCount=").append(a2);
                                }
                                int i2 = b[b3] + a2;
                                if (i2 <= 4) {
                                    i += 8;
                                    if (i < 0 || i > lVar.a.remaining()) {
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                            new StringBuilder("Illegal tagValueOffset=").append(i).append(" tagType=").append(b2);
                                        }
                                    } else if (i2 >= 0 && i + i2 <= lVar.a.remaining()) {
                                        return lVar.b(i);
                                    } else {
                                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        }
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        }
                    }
                }
                return -1;
            }
            Log.isLoggable("DfltImageHeaderParser", 3);
        }
        byteOrder = ByteOrder.BIG_ENDIAN;
        lVar.a.order(byteOrder);
        a = lVar.a(10) + 6;
        b = lVar.b(a);
        while (b4 < b) {
            i = (a + 2) + (b4 * 12);
            b2 = lVar.b(i);
            if (b2 == (short) 274) {
                b3 = lVar.b(i + 2);
                if (b3 <= (short) 0) {
                }
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                }
            }
        }
        return -1;
    }
}
