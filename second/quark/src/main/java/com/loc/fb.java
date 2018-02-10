package com.loc;

import android.content.Context;
import android.os.Looper;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ProGuard */
public final class fb extends l {
    private static boolean c = true;
    private String[] d = new String[10];
    private int e = 0;
    private boolean f = false;
    private int g = 0;

    protected fb(int i) {
        super(i);
    }

    private String b() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = this.e;
            while (i < 10 && i <= 9) {
                stringBuilder.append(this.d[i]);
                i++;
            }
            for (i = 0; i < this.e; i++) {
                stringBuilder.append(this.d[i]);
            }
        } catch (Throwable th) {
            es.a(th, "ANRWriter", "getLogInfo");
        }
        return stringBuilder.toString();
    }

    protected final String a(List<ep> list) {
        InputStream fileInputStream;
        Throwable th;
        bf bfVar;
        InputStream inputStream;
        String str;
        String str2;
        InputStream inputStream2 = null;
        bf bfVar2 = null;
        try {
            File file = new File("/data/anr/traces.txt");
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bfVar2 = new bf(fileInputStream, bg.a);
                    Object obj = null;
                    while (true) {
                        try {
                            String str3;
                            Object obj2;
                            String a = bfVar2.a();
                            if (a.contains("pid")) {
                                while (!a.contains("\"main\"")) {
                                    a = bfVar2.a();
                                }
                                str3 = a;
                                obj2 = 1;
                            } else {
                                str3 = a;
                                obj2 = obj;
                            }
                            obj = str3.equals("") ? null : obj2;
                            if (obj != null) {
                                try {
                                    if (this.e > 9) {
                                        this.e = 0;
                                    }
                                    this.d[this.e] = str3;
                                    this.e++;
                                } catch (Throwable th2) {
                                    es.a(th2, "ANRWriter", "addData");
                                }
                                if (this.g == 5) {
                                    break;
                                } else if (this.f) {
                                    this.g++;
                                } else {
                                    for (ep epVar : list) {
                                        this.f = l.a(epVar.d(), str3);
                                        if (this.f) {
                                            this.a = epVar;
                                        }
                                    }
                                }
                            }
                        } catch (EOFException e) {
                        } catch (FileNotFoundException e2) {
                            bfVar = bfVar2;
                            inputStream = fileInputStream;
                        } catch (IOException e3) {
                            th2 = e3;
                        }
                    }
                    if (bfVar2 != null) {
                        try {
                            bfVar2.close();
                        } catch (Throwable th22) {
                            es.a(th22, "ANRWriter", "initLog1");
                        } catch (Throwable th222) {
                            es.a(th222, "ANRWriter", "initLog2");
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            th222 = e4;
                            str = "ANRWriter";
                            str2 = "initLog3";
                            es.a(th222, str, str2);
                            return this.f ? null : b();
                        } catch (Throwable th3) {
                            th222 = th3;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            es.a(th222, str, str2);
                            if (this.f) {
                            }
                        }
                    }
                } catch (FileNotFoundException e5) {
                    bfVar = null;
                    inputStream = fileInputStream;
                    if (bfVar != null) {
                        try {
                            bfVar.close();
                        } catch (Throwable th2222) {
                            es.a(th2222, "ANRWriter", "initLog1");
                        } catch (Throwable th22222) {
                            es.a(th22222, "ANRWriter", "initLog2");
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            th22222 = e6;
                            str = "ANRWriter";
                            str2 = "initLog3";
                            es.a(th22222, str, str2);
                            if (this.f) {
                            }
                        } catch (Throwable th4) {
                            th22222 = th4;
                            str = "ANRWriter";
                            str2 = "initLog4";
                            es.a(th22222, str, str2);
                            if (this.f) {
                            }
                        }
                    }
                    if (this.f) {
                    }
                } catch (IOException e7) {
                    th22222 = e7;
                    bfVar2 = null;
                    try {
                        es.a(th22222, "ANRWriter", "initLog");
                        if (bfVar2 != null) {
                            try {
                                bfVar2.close();
                            } catch (Throwable th222222) {
                                es.a(th222222, "ANRWriter", "initLog1");
                            } catch (Throwable th2222222) {
                                es.a(th2222222, "ANRWriter", "initLog2");
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e8) {
                                th2222222 = e8;
                                str = "ANRWriter";
                                str2 = "initLog3";
                                es.a(th2222222, str, str2);
                                if (this.f) {
                                }
                            } catch (Throwable th5) {
                                th2222222 = th5;
                                str = "ANRWriter";
                                str2 = "initLog4";
                                es.a(th2222222, str, str2);
                                if (this.f) {
                                }
                            }
                        }
                        if (this.f) {
                        }
                    } catch (Throwable th6) {
                        th2222222 = th6;
                        if (bfVar2 != null) {
                            try {
                                bfVar2.close();
                            } catch (Throwable e9) {
                                es.a(e9, "ANRWriter", "initLog1");
                            } catch (Throwable e92) {
                                es.a(e92, "ANRWriter", "initLog2");
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e922) {
                                es.a(e922, "ANRWriter", "initLog3");
                            } catch (Throwable e9222) {
                                es.a(e9222, "ANRWriter", "initLog4");
                            }
                        }
                        throw th2222222;
                    }
                } catch (Throwable th7) {
                    th2222222 = th7;
                    bfVar2 = null;
                    if (bfVar2 != null) {
                        bfVar2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th2222222;
                }
                if (this.f) {
                }
            }
            if (null != null) {
                try {
                    bfVar2.close();
                } catch (Throwable e10) {
                    es.a(e10, "ANRWriter", "initLog1");
                } catch (Throwable e102) {
                    es.a(e102, "ANRWriter", "initLog2");
                }
            }
            if (null != null) {
                try {
                    inputStream2.close();
                } catch (Throwable th22222222) {
                    es.a(th22222222, "ANRWriter", "initLog3");
                } catch (Throwable th222222222) {
                    es.a(th222222222, "ANRWriter", "initLog4");
                }
            }
            return null;
        } catch (FileNotFoundException e11) {
            bfVar = null;
            inputStream = null;
            if (bfVar != null) {
                bfVar.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (this.f) {
            }
        } catch (IOException e12) {
            th222222222 = e12;
            bfVar2 = null;
            fileInputStream = null;
            es.a(th222222222, "ANRWriter", "initLog");
            if (bfVar2 != null) {
                bfVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (this.f) {
            }
        } catch (Throwable th8) {
            th222222222 = th8;
            bfVar2 = null;
            fileInputStream = null;
            if (bfVar2 != null) {
                bfVar2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th222222222;
        }
    }

    protected final boolean c(Context context) {
        if (ei.m(context) != 1 || !c) {
            return false;
        }
        c = false;
        synchronized (Looper.getMainLooper()) {
            x xVar = new x(context);
            y a = xVar.a();
            if (a == null) {
                return true;
            }
            if (a.c == 1) {
                a.c(false);
                xVar.a(a);
                return true;
            }
            return false;
        }
    }
}
