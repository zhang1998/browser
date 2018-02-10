package com.uc.crashsdk.a;

import com.uc.crashsdk.export.LogType;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: ProGuard */
public final class b {
    public static void a(File file, File file2, byte[] bArr) {
        InputStream fileInputStream = new FileInputStream(file);
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file2.isDirectory()) {
            file2 = new File(file2, file.getName());
        }
        OutputStream fileOutputStream = new FileOutputStream(file2);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                fileInputStream.close();
                fileOutputStream.close();
            }
        }
    }

    public static boolean a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String file2 : list) {
                    if (!a(new File(file, file2))) {
                        return false;
                    }
                }
            }
        }
        return file.delete();
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        String str = "";
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[LogType.UNEXP];
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        stringBuffer.append(new String(bArr, 0, read));
                    }
                    str = stringBuffer.toString();
                    try {
                        fileInputStream.close();
                    } catch (Throwable th3) {
                        a.a(th3, false);
                    }
                } catch (Throwable th4) {
                    th3 = th4;
                    try {
                        a.a(th3, false);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th32) {
                                a.a(th32, false);
                            }
                        }
                        return str;
                    } catch (Throwable th5) {
                        th2 = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th322) {
                                a.a(th322, false);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th6) {
                th2 = th6;
                fileInputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        }
        return str;
    }

    public static String a(File file, int i, boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i];
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Throwable th2) {
                        if (!z) {
                            return str;
                        }
                        a.a(th2, false);
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    if (z) {
                        a.a(th3, false);
                    }
                }
                return null;
            } catch (Throwable th4) {
                th3 = th4;
                if (z) {
                    try {
                        a.a(th3, false);
                    } catch (Throwable th5) {
                        th3 = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th22) {
                                if (z) {
                                    a.a(th22, false);
                                }
                            }
                        }
                        throw th3;
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th32) {
                        if (z) {
                            a.a(th32, false);
                        }
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th32 = th6;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th32;
        }
    }

    public static ArrayList<String> a(File file, int i) {
        Closeable fileReader;
        Closeable bufferedReader;
        Throwable th;
        Closeable closeable = null;
        int i2 = 0;
        ArrayList<String> arrayList = new ArrayList();
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader, 512);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                        i2++;
                        if (i > 0 && i2 >= i) {
                            break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = bufferedReader;
                    }
                }
                a(fileReader);
                a(bufferedReader);
            } catch (Throwable th3) {
                th = th3;
                a(fileReader);
                a(closeable);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            fileReader = null;
            a(fileReader);
            a(closeable);
            throw th;
        }
        return arrayList;
    }

    public static boolean a(File file, byte[] bArr) {
        Closeable fileOutputStream;
        Throwable th;
        Throwable th2;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                a(fileOutputStream);
                return true;
            } catch (Throwable th3) {
                th = th3;
                try {
                    a.a(th, false);
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th4) {
                    th2 = th4;
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            th2 = th5;
            fileOutputStream = null;
            a(fileOutputStream);
            throw th2;
        }
    }

    public static boolean a(File file, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
            try {
                fileWriter.write(str, 0, str.length());
                try {
                    fileWriter.close();
                    return true;
                } catch (Throwable th2) {
                    a.a(th2, false);
                    return true;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    a.a(th, false);
                    if (fileWriter != null) {
                        return false;
                    }
                    try {
                        fileWriter.close();
                        return false;
                    } catch (Throwable th4) {
                        a.a(th4, false);
                        return false;
                    }
                } catch (Throwable th5) {
                    th4 = th5;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable th22) {
                            a.a(th22, false);
                        }
                    }
                    throw th4;
                }
            }
        } catch (Throwable th6) {
            th4 = th6;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th4;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                a.a(th, true);
            }
        }
    }
}
