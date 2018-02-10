package com.uc.base.wa.d;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* compiled from: ProGuard */
final class c extends ByteArrayOutputStream {
    final /* synthetic */ byte[] a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ k c;

    c(k kVar, byte[] bArr, byte[] bArr2) {
        this.c = kVar;
        this.a = bArr;
        this.b = bArr2;
    }

    public final byte[] toByteArray() {
        GZIPInputStream gZIPInputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        byte[] bArr2 = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(this.a));
                while (true) {
                    try {
                        int read = gZIPInputStream.read(bArr2, 0, 1024);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Throwable e2) {
                                Log.e("gzm_wa_WaNet", "", e2);
                            }
                        }
                    } catch (FileNotFoundException e3) {
                        e2 = e3;
                    } catch (IOException e4) {
                        e2 = e4;
                    }
                }
                gZIPInputStream.close();
                try {
                    byteArrayOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (Throwable e22) {
                    Log.e("gzm_wa_WaNet", "", e22);
                }
            } catch (FileNotFoundException e5) {
                e22 = e5;
                gZIPInputStream = bArr;
                try {
                    Log.e("gzm_wa_WaNet", "", e22);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable e222) {
                            Log.e("gzm_wa_WaNet", "", e222);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } catch (Throwable e2222) {
                            Log.e("gzm_wa_WaNet", "", e2222);
                        }
                    }
                    return bArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable e22222) {
                            Log.e("gzm_wa_WaNet", "", e22222);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                            byteArrayOutputStream.toByteArray();
                        } catch (Throwable e222222) {
                            Log.e("gzm_wa_WaNet", "", e222222);
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e222222 = e6;
                gZIPInputStream = bArr;
                Log.e("gzm_wa_WaNet", "", e222222);
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Throwable e2222222) {
                        Log.e("gzm_wa_WaNet", "", e2222222);
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                        bArr = byteArrayOutputStream.toByteArray();
                    } catch (Throwable e22222222) {
                        Log.e("gzm_wa_WaNet", "", e22222222);
                    }
                }
                return bArr;
            } catch (Throwable e222222222) {
                gZIPInputStream = bArr;
                th = e222222222;
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                    byteArrayOutputStream.toByteArray();
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            e222222222 = e7;
            byteArrayOutputStream = bArr;
            gZIPInputStream = bArr;
            Log.e("gzm_wa_WaNet", "", e222222222);
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            }
            return bArr;
        } catch (IOException e8) {
            e222222222 = e8;
            byteArrayOutputStream = bArr;
            gZIPInputStream = bArr;
            Log.e("gzm_wa_WaNet", "", e222222222);
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
            }
            return bArr;
        } catch (Throwable e2222222222) {
            byteArrayOutputStream = bArr;
            gZIPInputStream = bArr;
            th = e2222222222;
            if (gZIPInputStream != null) {
                gZIPInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
                byteArrayOutputStream.toByteArray();
            }
            throw th;
        }
        return bArr;
    }
}
