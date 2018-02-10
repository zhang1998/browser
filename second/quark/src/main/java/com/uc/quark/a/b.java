package com.uc.quark.a;

import com.uc.quark.s;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: ProGuard */
public final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ s c;

    public b(String str, String str2, s sVar) {
        this.a = str;
        this.b = str2;
        this.c = sVar;
    }

    public final void run() {
        OutputStream bufferedOutputStream;
        Throwable th;
        if (this.a.indexOf("data:") == 0) {
            byte[] bArr;
            byte[] bytes = this.a.substring(this.a.indexOf(",") + 1).getBytes();
            int length = bytes.length;
            int i = (length / 4) * 3;
            if (i == 0) {
                bArr = new byte[0];
            } else {
                byte b;
                int i2;
                Object obj = new byte[i];
                i = 0;
                while (true) {
                    b = bytes[length - 1];
                    if (!(b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9)) {
                        if (b != (byte) 61) {
                            break;
                        }
                        i++;
                    }
                    length--;
                }
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i6 < length) {
                    b = bytes[i6];
                    if (b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9) {
                        i2 = i5;
                        i5 = i3;
                        i3 = i4;
                    } else {
                        if (b >= (byte) 65 && b <= (byte) 90) {
                            i2 = b - 65;
                        } else if (b >= (byte) 97 && b <= (byte) 122) {
                            i2 = b - 71;
                        } else if (b < (byte) 48 || b > (byte) 57) {
                            if (b != (byte) 43) {
                                if (b != (byte) 47) {
                                    bArr = null;
                                    break;
                                }
                                i2 = 63;
                            } else {
                                i2 = 62;
                            }
                        } else {
                            i2 = b + 4;
                        }
                        i5 = (i5 << 6) | ((byte) i2);
                        if (i4 % 4 == 3) {
                            i2 = i3 + 1;
                            obj[i3] = (byte) ((16711680 & i5) >> 16);
                            i3 = i2 + 1;
                            obj[i2] = (byte) ((65280 & i5) >> 8);
                            i2 = i3 + 1;
                            obj[i3] = (byte) (i5 & 255);
                        } else {
                            i2 = i3;
                        }
                        i3 = i4 + 1;
                        int i7 = i5;
                        i5 = i2;
                        i2 = i7;
                    }
                    i6++;
                    i4 = i3;
                    i3 = i5;
                    i5 = i2;
                }
                if (i > 0) {
                    i2 = i5 << (i * 6);
                    length = i3 + 1;
                    obj[i3] = (byte) ((16711680 & i2) >> 16);
                    if (i == 1) {
                        i3 = length + 1;
                        obj[length] = (byte) ((65280 & i2) >> 8);
                    } else {
                        i3 = length;
                    }
                }
                Object obj2 = new byte[i3];
                System.arraycopy(obj, 0, obj2, 0, i3);
                Object obj3 = obj2;
            }
            if (bArr != null) {
                OutputStream outputStream = null;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.b));
                    try {
                        bufferedOutputStream.write(bArr);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                        }
                    } catch (Exception e2) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                        m.a(2, new n(this));
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        outputStream = bufferedOutputStream;
                        th = th3;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    m.a(2, new n(this));
                } catch (Throwable th4) {
                    th = th4;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    throw th;
                }
                m.a(2, new n(this));
            }
        }
    }
}
