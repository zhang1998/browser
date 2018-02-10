package com.uc.weex.i;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;

/* compiled from: ProGuard */
public final class j {
    public static String[] a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            String[] a = a(fileInputStream.getChannel());
            return a;
        } finally {
            fileInputStream.close();
        }
    }

    private static String[] a(FileChannel fileChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(fileChannel, allocate, 0) != 1179403647) {
            throw new i("file is not ELF");
        }
        long c;
        long d;
        int d2;
        long j;
        int i;
        long j2;
        long j3;
        int i2;
        Object obj = e(fileChannel, allocate, 4) == (short) 1 ? 1 : null;
        if (e(fileChannel, allocate, 5) == (short) 2) {
            allocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (obj != null) {
            c = c(fileChannel, allocate, 28);
        } else {
            c = b(fileChannel, allocate, 32);
        }
        if (obj != null) {
            d = (long) d(fileChannel, allocate, 44);
        } else {
            d = (long) d(fileChannel, allocate, 56);
        }
        if (obj != null) {
            d2 = d(fileChannel, allocate, 42);
        } else {
            d2 = d(fileChannel, allocate, 54);
        }
        if (d == 65535) {
            if (obj != null) {
                d = c(fileChannel, allocate, 32);
            } else {
                d = b(fileChannel, allocate, 40);
            }
            if (obj != null) {
                d = c(fileChannel, allocate, d + 28);
            } else {
                d = c(fileChannel, allocate, d + 44);
            }
        }
        long j4 = 0;
        long j5 = c;
        for (j = 0; j < d; j++) {
            String[] strArr;
            if (c(fileChannel, allocate, 0 + j5) == 2) {
                if (obj != null) {
                    j = c(fileChannel, allocate, 4 + j5);
                } else {
                    j = b(fileChannel, allocate, 8 + j5);
                }
                j4 = j;
                if (j4 != 0) {
                    throw new i("ELF file does not contain dynamic linking information");
                }
                i = 0;
                j = 0;
                j2 = j4;
                while (true) {
                    if (obj == null) {
                        j5 = c(fileChannel, allocate, 0 + j2);
                    } else {
                        j5 = b(fileChannel, allocate, 0 + j2);
                    }
                    if (j5 != 1) {
                        if (i != Integer.MAX_VALUE) {
                            throw new i("malformed DT_NEEDED section");
                        }
                        j3 = j;
                        i2 = i + 1;
                    } else if (j5 != 5) {
                        if (obj == null) {
                            j = c(fileChannel, allocate, 4 + j2);
                        } else {
                            j = b(fileChannel, allocate, 8 + j2);
                        }
                        j3 = j;
                        i2 = i;
                    } else {
                        j3 = j;
                        i2 = i;
                    }
                    j = (obj == null ? 8 : 16) + j2;
                    if (j5 == 0) {
                        break;
                    }
                    j2 = j;
                    i = i2;
                    j = j3;
                }
                if (j3 != 0) {
                    throw new i("Dynamic section string-table not found");
                }
                i = 0;
                j2 = c;
                while (((long) i) < d) {
                    if (c(fileChannel, allocate, 0 + j2) != 1) {
                        if (obj == null) {
                            j5 = c(fileChannel, allocate, 8 + j2);
                        } else {
                            j5 = b(fileChannel, allocate, 16 + j2);
                        }
                        if (obj == null) {
                            c = c(fileChannel, allocate, 20 + j2);
                        } else {
                            c = b(fileChannel, allocate, 40 + j2);
                        }
                        if (j5 <= j3 && j3 < r10 + j5) {
                            if (obj == null) {
                                d = c(fileChannel, allocate, 4 + j2);
                            } else {
                                d = b(fileChannel, allocate, 8 + j2);
                            }
                            c = d + (j3 - j5);
                            if (c != 0) {
                                throw new i("did not find file offset of DT_STRTAB table");
                            }
                            strArr = new String[i2];
                            i = 0;
                            while (true) {
                                if (obj == null) {
                                    j = c(fileChannel, allocate, 0 + j4);
                                } else {
                                    j = b(fileChannel, allocate, 0 + j4);
                                }
                                if (j == 1) {
                                    if (obj == null) {
                                        d = c(fileChannel, allocate, 4 + j4);
                                    } else {
                                        d = b(fileChannel, allocate, 8 + j4);
                                    }
                                    strArr[i] = a(fileChannel, allocate, d + c);
                                    if (i != Integer.MAX_VALUE) {
                                        throw new i("malformed DT_NEEDED section");
                                    }
                                    i++;
                                }
                                d = (obj == null ? 8 : 16) + j4;
                                if (j != 0) {
                                    break;
                                }
                                j4 = d;
                            }
                            if (i == strArr.length) {
                                return strArr;
                            }
                            throw new i("malformed DT_NEEDED section");
                        }
                    }
                    i++;
                    j2 = ((long) d2) + j2;
                }
                c = 0;
                if (c != 0) {
                    strArr = new String[i2];
                    i = 0;
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j4);
                        } else {
                            j = c(fileChannel, allocate, 0 + j4);
                        }
                        if (j == 1) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j4);
                            } else {
                                d = c(fileChannel, allocate, 4 + j4);
                            }
                            strArr[i] = a(fileChannel, allocate, d + c);
                            if (i != Integer.MAX_VALUE) {
                                i++;
                            } else {
                                throw new i("malformed DT_NEEDED section");
                            }
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j4;
                        if (j != 0) {
                            break;
                        }
                        j4 = d;
                    }
                    if (i == strArr.length) {
                        return strArr;
                    }
                    throw new i("malformed DT_NEEDED section");
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            j5 += (long) d2;
        }
        if (j4 != 0) {
            i = 0;
            j = 0;
            j2 = j4;
            while (true) {
                if (obj == null) {
                    j5 = b(fileChannel, allocate, 0 + j2);
                } else {
                    j5 = c(fileChannel, allocate, 0 + j2);
                }
                if (j5 != 1) {
                    if (j5 != 5) {
                        j3 = j;
                        i2 = i;
                    } else {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 8 + j2);
                        } else {
                            j = c(fileChannel, allocate, 4 + j2);
                        }
                        j3 = j;
                        i2 = i;
                    }
                } else if (i != Integer.MAX_VALUE) {
                    j3 = j;
                    i2 = i + 1;
                } else {
                    throw new i("malformed DT_NEEDED section");
                }
                if (obj == null) {
                }
                j = (obj == null ? 8 : 16) + j2;
                if (j5 == 0) {
                    break;
                }
                j2 = j;
                i = i2;
                j = j3;
            }
            if (j3 != 0) {
                i = 0;
                j2 = c;
                while (((long) i) < d) {
                    if (c(fileChannel, allocate, 0 + j2) != 1) {
                        if (obj == null) {
                            j5 = b(fileChannel, allocate, 16 + j2);
                        } else {
                            j5 = c(fileChannel, allocate, 8 + j2);
                        }
                        if (obj == null) {
                            c = b(fileChannel, allocate, 40 + j2);
                        } else {
                            c = c(fileChannel, allocate, 20 + j2);
                        }
                        if (obj == null) {
                            d = b(fileChannel, allocate, 8 + j2);
                        } else {
                            d = c(fileChannel, allocate, 4 + j2);
                        }
                        c = d + (j3 - j5);
                        if (c != 0) {
                            throw new i("did not find file offset of DT_STRTAB table");
                        }
                        strArr = new String[i2];
                        i = 0;
                        while (true) {
                            if (obj == null) {
                                j = c(fileChannel, allocate, 0 + j4);
                            } else {
                                j = b(fileChannel, allocate, 0 + j4);
                            }
                            if (j == 1) {
                                if (obj == null) {
                                    d = c(fileChannel, allocate, 4 + j4);
                                } else {
                                    d = b(fileChannel, allocate, 8 + j4);
                                }
                                strArr[i] = a(fileChannel, allocate, d + c);
                                if (i != Integer.MAX_VALUE) {
                                    throw new i("malformed DT_NEEDED section");
                                }
                                i++;
                            }
                            if (obj == null) {
                            }
                            d = (obj == null ? 8 : 16) + j4;
                            if (j != 0) {
                                break;
                            }
                            j4 = d;
                        }
                        if (i == strArr.length) {
                            return strArr;
                        }
                        throw new i("malformed DT_NEEDED section");
                    }
                    i++;
                    j2 = ((long) d2) + j2;
                }
                c = 0;
                if (c != 0) {
                    strArr = new String[i2];
                    i = 0;
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j4);
                        } else {
                            j = c(fileChannel, allocate, 0 + j4);
                        }
                        if (j == 1) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j4);
                            } else {
                                d = c(fileChannel, allocate, 4 + j4);
                            }
                            strArr[i] = a(fileChannel, allocate, d + c);
                            if (i != Integer.MAX_VALUE) {
                                i++;
                            } else {
                                throw new i("malformed DT_NEEDED section");
                            }
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j4;
                        if (j != 0) {
                            break;
                        }
                        j4 = d;
                    }
                    if (i == strArr.length) {
                        return strArr;
                    }
                    throw new i("malformed DT_NEEDED section");
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            throw new i("Dynamic section string-table not found");
        }
        throw new i("ELF file does not contain dynamic linking information");
    }

    public static void a(FileChannel fileChannel, FileChannel fileChannel2, String str, String str2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(fileChannel, allocate, 0) != 1179403647) {
            throw new i("file is not ELF");
        }
        long c;
        long d;
        int d2;
        long j;
        long j2;
        String a;
        int length;
        MappedByteBuffer map;
        byte[] bytes;
        int i;
        Object obj = e(fileChannel, allocate, 4) == (short) 1 ? 1 : null;
        if (e(fileChannel, allocate, 5) == (short) 2) {
            allocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (obj != null) {
            c = c(fileChannel, allocate, 28);
        } else {
            c = b(fileChannel, allocate, 32);
        }
        if (obj != null) {
            d = (long) d(fileChannel, allocate, 44);
        } else {
            d = (long) d(fileChannel, allocate, 56);
        }
        if (obj != null) {
            d2 = d(fileChannel, allocate, 42);
        } else {
            d2 = d(fileChannel, allocate, 54);
        }
        if (d == 65535) {
            if (obj != null) {
                d = c(fileChannel, allocate, 32);
            } else {
                d = b(fileChannel, allocate, 40);
            }
            if (obj != null) {
                d = c(fileChannel, allocate, d + 28);
            } else {
                d = c(fileChannel, allocate, d + 44);
            }
        }
        long j3 = 0;
        long j4 = c;
        for (j = 0; j < d; j++) {
            int i2;
            long j5;
            if (c(fileChannel, allocate, 0 + j4) == 2) {
                if (obj != null) {
                    j = c(fileChannel, allocate, 4 + j4);
                } else {
                    j = b(fileChannel, allocate, 8 + j4);
                }
                j3 = j;
                if (j3 != 0) {
                    throw new i("ELF file does not contain dynamic linking information");
                }
                i2 = 0;
                j = 0;
                j2 = j3;
                while (true) {
                    if (obj == null) {
                        j4 = c(fileChannel, allocate, 0 + j2);
                    } else {
                        j4 = b(fileChannel, allocate, 0 + j2);
                    }
                    if (j4 != 1) {
                        if (i2 != Integer.MAX_VALUE) {
                            throw new i("malformed DT_NEEDED section");
                        }
                        i2++;
                        j5 = j;
                    } else if (j4 != 5) {
                        if (obj == null) {
                            j = c(fileChannel, allocate, 4 + j2);
                        } else {
                            j = b(fileChannel, allocate, 8 + j2);
                        }
                        j5 = j;
                    } else {
                        j5 = j;
                    }
                    j = (obj == null ? 8 : 16) + j2;
                    if (j4 == 0) {
                        break;
                    }
                    j2 = j;
                    j = j5;
                }
                if (j5 != 0) {
                    throw new i("Dynamic section string-table not found");
                }
                i2 = 0;
                j2 = c;
                while (((long) i2) < d) {
                    if (c(fileChannel, allocate, 0 + j2) != 1) {
                        if (obj == null) {
                            j4 = c(fileChannel, allocate, 8 + j2);
                        } else {
                            j4 = b(fileChannel, allocate, 16 + j2);
                        }
                        if (obj == null) {
                            c = c(fileChannel, allocate, 20 + j2);
                        } else {
                            c = b(fileChannel, allocate, 40 + j2);
                        }
                        if (j4 <= j5 && j5 < r10 + j4) {
                            if (obj == null) {
                                d = c(fileChannel, allocate, 4 + j2);
                            } else {
                                d = b(fileChannel, allocate, 8 + j2);
                            }
                            c = d + (j5 - j4);
                            if (c != 0) {
                                throw new i("did not find file offset of DT_STRTAB table");
                            }
                            i2 = 0;
                            while (true) {
                                if (obj == null) {
                                    j = c(fileChannel, allocate, 0 + j3);
                                } else {
                                    j = b(fileChannel, allocate, 0 + j3);
                                }
                                if (j == 1) {
                                    if (obj == null) {
                                        d = c(fileChannel, allocate, 4 + j3);
                                    } else {
                                        d = b(fileChannel, allocate, 8 + j3);
                                    }
                                    a = a(fileChannel, allocate, c + d);
                                    if (a == null && a.equalsIgnoreCase(str)) {
                                        break;
                                    } else if (i2 != Integer.MAX_VALUE) {
                                        throw new i("malformed DT_NEEDED section");
                                    } else {
                                        i2++;
                                    }
                                }
                                d = (obj == null ? 8 : 16) + j3;
                                if (j != 0) {
                                    j3 = d;
                                } else {
                                    return;
                                }
                            }
                            length = a.length();
                            map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                            bytes = str2.getBytes(Charset.forName("UTF-8"));
                            for (i = 0; i < length; i++) {
                                map.get(i);
                                map.put(i, bytes[i]);
                            }
                            return;
                        }
                    }
                    i2++;
                    j2 = ((long) d2) + j2;
                }
                c = 0;
                if (c != 0) {
                    i2 = 0;
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j3);
                        } else {
                            j = c(fileChannel, allocate, 0 + j3);
                        }
                        if (j == 1) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j3);
                            } else {
                                d = c(fileChannel, allocate, 4 + j3);
                            }
                            a = a(fileChannel, allocate, c + d);
                            if (a == null) {
                            }
                            if (i2 != Integer.MAX_VALUE) {
                                i2++;
                            } else {
                                throw new i("malformed DT_NEEDED section");
                            }
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j3;
                        if (j != 0) {
                            j3 = d;
                        } else {
                            return;
                        }
                    }
                    length = a.length();
                    map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                    bytes = str2.getBytes(Charset.forName("UTF-8"));
                    for (i = 0; i < length; i++) {
                        map.get(i);
                        map.put(i, bytes[i]);
                    }
                    return;
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            j4 += (long) d2;
        }
        if (j3 != 0) {
            i2 = 0;
            j = 0;
            j2 = j3;
            while (true) {
                if (obj == null) {
                    j4 = b(fileChannel, allocate, 0 + j2);
                } else {
                    j4 = c(fileChannel, allocate, 0 + j2);
                }
                if (j4 != 1) {
                    if (j4 != 5) {
                        j5 = j;
                    } else {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 8 + j2);
                        } else {
                            j = c(fileChannel, allocate, 4 + j2);
                        }
                        j5 = j;
                    }
                } else if (i2 != Integer.MAX_VALUE) {
                    i2++;
                    j5 = j;
                } else {
                    throw new i("malformed DT_NEEDED section");
                }
                if (obj == null) {
                }
                j = (obj == null ? 8 : 16) + j2;
                if (j4 == 0) {
                    break;
                }
                j2 = j;
                j = j5;
            }
            if (j5 != 0) {
                i2 = 0;
                j2 = c;
                while (((long) i2) < d) {
                    if (c(fileChannel, allocate, 0 + j2) != 1) {
                        if (obj == null) {
                            j4 = b(fileChannel, allocate, 16 + j2);
                        } else {
                            j4 = c(fileChannel, allocate, 8 + j2);
                        }
                        if (obj == null) {
                            c = b(fileChannel, allocate, 40 + j2);
                        } else {
                            c = c(fileChannel, allocate, 20 + j2);
                        }
                        if (obj == null) {
                            d = b(fileChannel, allocate, 8 + j2);
                        } else {
                            d = c(fileChannel, allocate, 4 + j2);
                        }
                        c = d + (j5 - j4);
                        if (c != 0) {
                            throw new i("did not find file offset of DT_STRTAB table");
                        }
                        i2 = 0;
                        while (true) {
                            if (obj == null) {
                                j = c(fileChannel, allocate, 0 + j3);
                            } else {
                                j = b(fileChannel, allocate, 0 + j3);
                            }
                            if (j == 1) {
                                if (obj == null) {
                                    d = c(fileChannel, allocate, 4 + j3);
                                } else {
                                    d = b(fileChannel, allocate, 8 + j3);
                                }
                                a = a(fileChannel, allocate, c + d);
                                if (a == null) {
                                }
                                if (i2 != Integer.MAX_VALUE) {
                                    throw new i("malformed DT_NEEDED section");
                                }
                                i2++;
                            }
                            if (obj == null) {
                            }
                            d = (obj == null ? 8 : 16) + j3;
                            if (j != 0) {
                                j3 = d;
                            } else {
                                return;
                            }
                        }
                        length = a.length();
                        map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                        bytes = str2.getBytes(Charset.forName("UTF-8"));
                        for (i = 0; i < length; i++) {
                            map.get(i);
                            map.put(i, bytes[i]);
                        }
                        return;
                    }
                    i2++;
                    j2 = ((long) d2) + j2;
                }
                c = 0;
                if (c != 0) {
                    i2 = 0;
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j3);
                        } else {
                            j = c(fileChannel, allocate, 0 + j3);
                        }
                        if (j == 1) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j3);
                            } else {
                                d = c(fileChannel, allocate, 4 + j3);
                            }
                            a = a(fileChannel, allocate, c + d);
                            if (a == null) {
                            }
                            if (i2 != Integer.MAX_VALUE) {
                                i2++;
                            } else {
                                throw new i("malformed DT_NEEDED section");
                            }
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j3;
                        if (j != 0) {
                            j3 = d;
                        } else {
                            return;
                        }
                    }
                    length = a.length();
                    map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                    bytes = str2.getBytes(Charset.forName("UTF-8"));
                    for (i = 0; i < length; i++) {
                        map.get(i);
                        map.put(i, bytes[i]);
                    }
                    return;
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            throw new i("Dynamic section string-table not found");
        }
        throw new i("ELF file does not contain dynamic linking information");
    }

    public static void a(File file, String str, String str2) throws IOException {
        if (str != null && str2 != null && str.length() == str2.length()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file.getAbsoluteFile(), "rw");
            try {
                b(fileInputStream.getChannel(), randomAccessFile.getChannel(), str, str2);
            } finally {
                fileInputStream.close();
                randomAccessFile.close();
            }
        }
    }

    private static void b(FileChannel fileChannel, FileChannel fileChannel2, String str, String str2) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (c(fileChannel, allocate, 0) != 1179403647) {
            throw new i("file is not ELF");
        }
        long c;
        long d;
        int d2;
        long j;
        String a;
        int length;
        int i;
        Object obj = e(fileChannel, allocate, 4) == (short) 1 ? 1 : null;
        if (e(fileChannel, allocate, 5) == (short) 2) {
            allocate.order(ByteOrder.BIG_ENDIAN);
        }
        if (obj != null) {
            c = c(fileChannel, allocate, 28);
        } else {
            c = b(fileChannel, allocate, 32);
        }
        if (obj != null) {
            d = (long) d(fileChannel, allocate, 44);
        } else {
            d = (long) d(fileChannel, allocate, 56);
        }
        if (obj != null) {
            d2 = d(fileChannel, allocate, 42);
        } else {
            d2 = d(fileChannel, allocate, 54);
        }
        if (d == 65535) {
            if (obj != null) {
                d = c(fileChannel, allocate, 32);
            } else {
                d = b(fileChannel, allocate, 40);
            }
            if (obj != null) {
                d = c(fileChannel, allocate, d + 28);
            } else {
                d = c(fileChannel, allocate, d + 44);
            }
        }
        long j2 = 0;
        long j3 = c;
        for (j = 0; j < d; j++) {
            long j4;
            long j5;
            int i2;
            MappedByteBuffer map;
            byte[] bytes;
            if (c(fileChannel, allocate, 0 + j3) == 2) {
                if (obj != null) {
                    j = c(fileChannel, allocate, 4 + j3);
                } else {
                    j = b(fileChannel, allocate, 8 + j3);
                }
                j2 = j;
                if (j2 != 0) {
                    throw new i("ELF file does not contain dynamic linking information");
                }
                j = 0;
                j4 = j2;
                while (true) {
                    if (obj == null) {
                        j3 = c(fileChannel, allocate, 0 + j4);
                    } else {
                        j3 = b(fileChannel, allocate, 0 + j4);
                    }
                    if (j3 == 14 && j3 == 5) {
                        if (obj != null) {
                            j = c(fileChannel, allocate, 4 + j4);
                        } else {
                            j = b(fileChannel, allocate, 8 + j4);
                        }
                        j5 = j;
                    } else {
                        j5 = j;
                    }
                    j = (obj == null ? 8 : 16) + j4;
                    if (j3 == 0) {
                        break;
                    }
                    j4 = j;
                    j = j5;
                }
                if (j5 != 0) {
                    throw new i("Dynamic section string-table not found");
                }
                i2 = 0;
                j4 = c;
                while (((long) i2) < d) {
                    if (c(fileChannel, allocate, 0 + j4) != 1) {
                        if (obj == null) {
                            j3 = c(fileChannel, allocate, 8 + j4);
                        } else {
                            j3 = b(fileChannel, allocate, 16 + j4);
                        }
                        if (obj == null) {
                            c = c(fileChannel, allocate, 20 + j4);
                        } else {
                            c = b(fileChannel, allocate, 40 + j4);
                        }
                        if (j3 <= j5 && j5 < r10 + j3) {
                            if (obj == null) {
                                d = c(fileChannel, allocate, 4 + j4);
                            } else {
                                d = b(fileChannel, allocate, 8 + j4);
                            }
                            c = d + (j5 - j3);
                            if (c != 0) {
                                throw new i("did not find file offset of DT_STRTAB table");
                            }
                            while (true) {
                                if (obj == null) {
                                    j = c(fileChannel, allocate, 0 + j2);
                                } else {
                                    j = b(fileChannel, allocate, 0 + j2);
                                }
                                if (j == 14) {
                                    if (obj == null) {
                                        d = c(fileChannel, allocate, 4 + j2);
                                    } else {
                                        d = b(fileChannel, allocate, 8 + j2);
                                    }
                                    a = a(fileChannel, allocate, c + d);
                                    if (a != null && a.equalsIgnoreCase(str)) {
                                        break;
                                    }
                                }
                                d = (obj == null ? 8 : 16) + j2;
                                if (j != 0) {
                                    j2 = d;
                                } else {
                                    return;
                                }
                            }
                            length = a.length();
                            map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                            bytes = str2.getBytes(Charset.forName("UTF-8"));
                            for (i = 0; i < length; i++) {
                                map.get(i);
                                map.put(i, bytes[i]);
                            }
                            return;
                        }
                    }
                    i2++;
                    j4 = ((long) d2) + j4;
                }
                c = 0;
                if (c != 0) {
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j2);
                        } else {
                            j = c(fileChannel, allocate, 0 + j2);
                        }
                        if (j == 14) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j2);
                            } else {
                                d = c(fileChannel, allocate, 4 + j2);
                            }
                            a = a(fileChannel, allocate, c + d);
                            break;
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j2;
                        if (j != 0) {
                            j2 = d;
                        } else {
                            return;
                        }
                    }
                    length = a.length();
                    map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                    bytes = str2.getBytes(Charset.forName("UTF-8"));
                    for (i = 0; i < length; i++) {
                        map.get(i);
                        map.put(i, bytes[i]);
                    }
                    return;
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            j3 += (long) d2;
        }
        if (j2 != 0) {
            j = 0;
            j4 = j2;
            while (true) {
                if (obj == null) {
                    j3 = b(fileChannel, allocate, 0 + j4);
                } else {
                    j3 = c(fileChannel, allocate, 0 + j4);
                }
                if (j3 == 14) {
                }
                j5 = j;
                if (obj == null) {
                }
                j = (obj == null ? 8 : 16) + j4;
                if (j3 == 0) {
                    break;
                }
                j4 = j;
                j = j5;
            }
            if (j5 != 0) {
                i2 = 0;
                j4 = c;
                while (((long) i2) < d) {
                    if (c(fileChannel, allocate, 0 + j4) != 1) {
                        if (obj == null) {
                            j3 = b(fileChannel, allocate, 16 + j4);
                        } else {
                            j3 = c(fileChannel, allocate, 8 + j4);
                        }
                        if (obj == null) {
                            c = b(fileChannel, allocate, 40 + j4);
                        } else {
                            c = c(fileChannel, allocate, 20 + j4);
                        }
                        if (obj == null) {
                            d = b(fileChannel, allocate, 8 + j4);
                        } else {
                            d = c(fileChannel, allocate, 4 + j4);
                        }
                        c = d + (j5 - j3);
                        if (c != 0) {
                            throw new i("did not find file offset of DT_STRTAB table");
                        }
                        while (true) {
                            if (obj == null) {
                                j = c(fileChannel, allocate, 0 + j2);
                            } else {
                                j = b(fileChannel, allocate, 0 + j2);
                            }
                            if (j == 14) {
                                if (obj == null) {
                                    d = c(fileChannel, allocate, 4 + j2);
                                } else {
                                    d = b(fileChannel, allocate, 8 + j2);
                                }
                                a = a(fileChannel, allocate, c + d);
                                break;
                            }
                            if (obj == null) {
                            }
                            d = (obj == null ? 8 : 16) + j2;
                            if (j != 0) {
                                j2 = d;
                            } else {
                                return;
                            }
                        }
                        length = a.length();
                        map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                        bytes = str2.getBytes(Charset.forName("UTF-8"));
                        for (i = 0; i < length; i++) {
                            map.get(i);
                            map.put(i, bytes[i]);
                        }
                        return;
                    }
                    i2++;
                    j4 = ((long) d2) + j4;
                }
                c = 0;
                if (c != 0) {
                    while (true) {
                        if (obj == null) {
                            j = b(fileChannel, allocate, 0 + j2);
                        } else {
                            j = c(fileChannel, allocate, 0 + j2);
                        }
                        if (j == 14) {
                            if (obj == null) {
                                d = b(fileChannel, allocate, 8 + j2);
                            } else {
                                d = c(fileChannel, allocate, 4 + j2);
                            }
                            a = a(fileChannel, allocate, c + d);
                            break;
                        }
                        if (obj == null) {
                        }
                        d = (obj == null ? 8 : 16) + j2;
                        if (j != 0) {
                            j2 = d;
                        } else {
                            return;
                        }
                    }
                    length = a.length();
                    map = fileChannel2.map(MapMode.READ_WRITE, d + c, (long) length);
                    bytes = str2.getBytes(Charset.forName("UTF-8"));
                    for (i = 0; i < length; i++) {
                        map.get(i);
                        map.put(i, bytes[i]);
                    }
                    return;
                }
                throw new i("did not find file offset of DT_STRTAB table");
            }
            throw new i("Dynamic section string-table not found");
        }
        throw new i("ELF file does not contain dynamic linking information");
    }

    private static String a(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short e = e(fileChannel, byteBuffer, j);
            if (e == (short) 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append((char) e);
            j = j2;
        }
    }

    private static void a(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        if (fileChannel.read(byteBuffer, j) != i) {
            throw new i("ELF file truncated");
        }
        byteBuffer.position(0);
    }

    private static long b(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        a(fileChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long c(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        a(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int d(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        a(fileChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & 65535;
    }

    private static short e(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        a(fileChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }
}
