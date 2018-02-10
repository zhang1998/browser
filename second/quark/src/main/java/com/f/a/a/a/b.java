package com.f.a.a.a;

import android.util.Xml;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ProGuard */
public final class b {
    private static final Object c = new Object();
    private final Object a = new Object();
    private File b;
    private HashMap<File, g> d = new HashMap();

    public b(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.b = new File(str);
    }

    private File b() {
        File file;
        synchronized (this.a) {
            file = this.b;
        }
        return file;
    }

    public final d a(String str) {
        FileInputStream fileInputStream;
        byte[] bArr;
        String str2;
        File b = b();
        String str3 = str + ".xml";
        if (str3.indexOf(File.separatorChar) < 0) {
            d dVar;
            File file = new File(b, str3);
            synchronized (c) {
                dVar = (g) this.d.get(file);
                if (dVar == null || dVar.d()) {
                    Map map;
                    File b2 = b(file);
                    if (b2.exists()) {
                        file.delete();
                        b2.renameTo(file);
                    }
                    if (file.exists()) {
                        file.canRead();
                    }
                    if (file.exists() && file.canRead()) {
                        try {
                            InputStream fileInputStream2 = new FileInputStream(file);
                            XmlPullParser newPullParser = Xml.newPullParser();
                            newPullParser.setInput(fileInputStream2, null);
                            map = (HashMap) c.a(newPullParser, new String[1]);
                            try {
                                fileInputStream2.close();
                            } catch (XmlPullParserException e) {
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    bArr = new byte[fileInputStream.available()];
                                    fileInputStream.read(bArr);
                                    str2 = new String(bArr, 0, bArr.length, "UTF-8");
                                } catch (FileNotFoundException e2) {
                                } catch (IOException e3) {
                                }
                            } catch (FileNotFoundException e4) {
                            } catch (IOException e5) {
                            } catch (Exception e6) {
                            }
                        } catch (XmlPullParserException e7) {
                            map = null;
                            fileInputStream = new FileInputStream(file);
                            bArr = new byte[fileInputStream.available()];
                            fileInputStream.read(bArr);
                            str2 = new String(bArr, 0, bArr.length, "UTF-8");
                        } catch (FileNotFoundException e8) {
                            map = null;
                        } catch (IOException e9) {
                            map = null;
                        } catch (Exception e10) {
                            map = null;
                        }
                    } else {
                        map = null;
                    }
                    synchronized (c) {
                        if (dVar == null) {
                            g gVar = (g) this.d.get(file);
                            if (gVar == null) {
                                dVar = new g(file, map);
                                this.d.put(file, dVar);
                            }
                        } else if (map != null) {
                            synchronized (dVar) {
                                dVar.a = map;
                            }
                        }
                    }
                }
            }
            return dVar;
        }
        throw new IllegalArgumentException("File " + str3 + " contains a path separator");
    }

    private static File b(File file) {
        return new File(file.getPath() + ".bak");
    }
}
