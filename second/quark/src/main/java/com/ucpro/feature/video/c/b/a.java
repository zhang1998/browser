package com.ucpro.feature.video.c.b;

import com.ucpro.feature.video.c.e.c.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;
import okhttp3.Headers;

/* compiled from: ProGuard */
final class a implements com.ucpro.feature.video.e.a.a {
    final /* synthetic */ c a;
    final /* synthetic */ com.ucpro.feature.video.c.e.b.a b;
    private boolean c = false;

    a(c cVar, com.ucpro.feature.video.c.e.b.a aVar) {
        this.a = cVar;
        this.b = aVar;
    }

    public final void a(Headers headers) {
        if (headers != null) {
            if ("gzip".equalsIgnoreCase(headers.get("Content-Encoding"))) {
                this.c = true;
            } else {
                this.c = false;
            }
        }
    }

    public final void a(byte[] bArr) {
        if (this.c) {
            bArr = b(bArr);
            if (bArr == null) {
                this.a.a(this.b, "unziped data body is null.");
                return;
            }
        } else if (bArr == null) {
            this.a.a(this.b, "data body is null.");
            return;
        }
        c a = d.b(bArr, bArr.length);
        if (a != null) {
            this.a.a(a);
        } else {
            this.a.a(this.b, "data body to pb obj failed");
        }
    }

    public final void a(int i, String str) {
        this.a.a(this.b, str);
    }

    private static byte[] b(byte[] bArr) {
        Closeable gZIPInputStream;
        Closeable closeable;
        Throwable th;
        Throwable th2;
        byte[] bArr2 = null;
        Closeable byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (Exception e) {
                closeable = null;
                gZIPInputStream = null;
                if (closeable != null) {
                    com.ucweb.common.util.o.a.a(closeable);
                }
                if (gZIPInputStream != null) {
                    com.ucweb.common.util.o.a.a(gZIPInputStream);
                }
                if (byteArrayInputStream != null) {
                    com.ucweb.common.util.o.a.a(byteArrayInputStream);
                }
                return bArr2;
            } catch (Throwable th3) {
                gZIPInputStream = null;
                th = th3;
                closeable = null;
                if (closeable != null) {
                    com.ucweb.common.util.o.a.a(closeable);
                }
                if (gZIPInputStream != null) {
                    com.ucweb.common.util.o.a.a(gZIPInputStream);
                }
                if (byteArrayInputStream != null) {
                    com.ucweb.common.util.o.a.a(byteArrayInputStream);
                }
                throw th;
            }
            try {
                byte[] bArr3 = new byte[1024];
                closeable = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = gZIPInputStream.read(bArr3, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        closeable.write(bArr3, 0, read);
                    } catch (Exception e2) {
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                bArr2 = closeable.toByteArray();
                closeable.flush();
                com.ucweb.common.util.o.a.a(closeable);
                com.ucweb.common.util.o.a.a(gZIPInputStream);
                com.ucweb.common.util.o.a.a(byteArrayInputStream);
            } catch (Exception e3) {
                closeable = null;
                if (closeable != null) {
                    com.ucweb.common.util.o.a.a(closeable);
                }
                if (gZIPInputStream != null) {
                    com.ucweb.common.util.o.a.a(gZIPInputStream);
                }
                if (byteArrayInputStream != null) {
                    com.ucweb.common.util.o.a.a(byteArrayInputStream);
                }
                return bArr2;
            } catch (Throwable th32) {
                th2 = th32;
                closeable = null;
                th = th2;
                if (closeable != null) {
                    com.ucweb.common.util.o.a.a(closeable);
                }
                if (gZIPInputStream != null) {
                    com.ucweb.common.util.o.a.a(gZIPInputStream);
                }
                if (byteArrayInputStream != null) {
                    com.ucweb.common.util.o.a.a(byteArrayInputStream);
                }
                throw th;
            }
        } catch (Exception e4) {
            closeable = null;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            if (closeable != null) {
                com.ucweb.common.util.o.a.a(closeable);
            }
            if (gZIPInputStream != null) {
                com.ucweb.common.util.o.a.a(gZIPInputStream);
            }
            if (byteArrayInputStream != null) {
                com.ucweb.common.util.o.a.a(byteArrayInputStream);
            }
            return bArr2;
        } catch (Throwable th322) {
            gZIPInputStream = null;
            byteArrayInputStream = null;
            th2 = th322;
            closeable = null;
            th = th2;
            if (closeable != null) {
                com.ucweb.common.util.o.a.a(closeable);
            }
            if (gZIPInputStream != null) {
                com.ucweb.common.util.o.a.a(gZIPInputStream);
            }
            if (byteArrayInputStream != null) {
                com.ucweb.common.util.o.a.a(byteArrayInputStream);
            }
            throw th;
        }
        return bArr2;
    }
}
