package com.f.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.f.a.b.a.c;
import java.io.File;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a {
    private String a;
    private String b;
    private boolean c;
    private boolean d;
    private boolean e;
    private SharedPreferences f;
    private d g;
    private Editor h;
    private f i;
    private Context j;
    private b k;
    private boolean l;

    public a(Context context, String str, String str2) {
        long j;
        long a;
        long j2;
        Editor edit;
        f c;
        this.a = "";
        this.b = "";
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.c = false;
        this.l = true;
        this.a = str2;
        this.b = str;
        this.j = context;
        if (context != null) {
            this.f = context.getSharedPreferences(str2, 0);
            j = this.f.getLong("t", 0);
        } else {
            j = 0;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (!c.a(externalStorageState)) {
            if (externalStorageState.equals("mounted")) {
                this.e = true;
                this.d = true;
            } else if (externalStorageState.equals("mounted_ro")) {
                this.d = true;
                this.e = false;
            }
            if (!((!this.d && !this.e) || context == null || c.a(str))) {
                this.k = c(str);
                if (this.k != null) {
                    try {
                        this.g = this.k.a(str2);
                        a = this.g.a("t");
                        try {
                            j2 = this.f.getLong("t2", 0);
                        } catch (Exception e) {
                            long j3 = a;
                            a = j;
                            j = j3;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.l) {
                            }
                            if (this.f != null) {
                                edit = this.f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.g == null) {
                                c = this.g.c();
                                c.a("t2", a);
                                c.b();
                            }
                        }
                        try {
                            j = this.g.a("t2");
                            if (j2 >= j && j2 > 0) {
                                try {
                                    a(this.f, this.g);
                                    this.g = this.k.a(str2);
                                } catch (Exception e2) {
                                    a = j2;
                                    j2 = a;
                                    if (j2 == j) {
                                    }
                                    a = System.currentTimeMillis();
                                    if (this.l) {
                                    }
                                    if (this.f != null) {
                                        edit = this.f.edit();
                                        edit.putLong("t2", a);
                                        edit.commit();
                                    }
                                    if (this.g == null) {
                                        c = this.g.c();
                                        c.a("t2", a);
                                        c.b();
                                    }
                                }
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j2 <= j && j > 0) {
                                a(this.g, this.f);
                                this.f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j2 != 0 && j > 0) {
                                a(this.g, this.f);
                                this.f = context.getSharedPreferences(str2, 0);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            } else if (j == 0 || j2 <= 0) {
                                if (j2 == j) {
                                    a(this.f, this.g);
                                    this.g = this.k.a(str2);
                                }
                                if (j2 == j || (j2 == 0 && j == 0)) {
                                    a = System.currentTimeMillis();
                                    if (this.l || (this.l && j2 == 0 && j == 0)) {
                                        if (this.f != null) {
                                            edit = this.f.edit();
                                            edit.putLong("t2", a);
                                            edit.commit();
                                        }
                                        if (this.g == null) {
                                            c = this.g.c();
                                            c.a("t2", a);
                                            c.b();
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else {
                                a(this.f, this.g);
                                this.g = this.k.a(str2);
                                if (j2 == j) {
                                }
                                a = System.currentTimeMillis();
                                if (this.l) {
                                }
                                if (this.f != null) {
                                    edit = this.f.edit();
                                    edit.putLong("t2", a);
                                    edit.commit();
                                }
                                if (this.g == null) {
                                    c = this.g.c();
                                    c.a("t2", a);
                                    c.b();
                                }
                            }
                        } catch (Exception e3) {
                            j = a;
                            a = j2;
                            j2 = a;
                            if (j2 == j) {
                            }
                            a = System.currentTimeMillis();
                            if (this.l) {
                            }
                            if (this.f != null) {
                                edit = this.f.edit();
                                edit.putLong("t2", a);
                                edit.commit();
                            }
                            if (this.g == null) {
                                c = this.g.c();
                                c.a("t2", a);
                                c.b();
                            }
                        }
                    } catch (Exception e4) {
                        a = j;
                        j = 0;
                        j2 = a;
                        if (j2 == j) {
                        }
                        a = System.currentTimeMillis();
                        if (this.l) {
                        }
                        if (this.f != null) {
                            edit = this.f.edit();
                            edit.putLong("t2", a);
                            edit.commit();
                        }
                        if (this.g == null) {
                            c = this.g.c();
                            c.a("t2", a);
                            c.b();
                        }
                    }
                }
            }
            j2 = j;
            j = 0;
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.l) {
            }
            if (this.f != null) {
                edit = this.f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        }
        this.e = false;
        this.d = false;
        this.k = c(str);
        if (this.k != null) {
            this.g = this.k.a(str2);
            a = this.g.a("t");
            j2 = this.f.getLong("t2", 0);
            j = this.g.a("t2");
            if (j2 >= j) {
            }
            if (j2 <= j) {
            }
            if (j2 != 0) {
            }
            if (j == 0) {
            }
            if (j2 == j) {
                a(this.f, this.g);
                this.g = this.k.a(str2);
            }
            if (j2 == j) {
            }
            a = System.currentTimeMillis();
            if (this.l) {
            }
            if (this.f != null) {
                edit = this.f.edit();
                edit.putLong("t2", a);
                edit.commit();
            }
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        }
        j2 = j;
        j = 0;
        if (j2 == j) {
        }
        a = System.currentTimeMillis();
        if (this.l) {
        }
        if (this.f != null) {
            edit = this.f.edit();
            edit.putLong("t2", a);
            edit.commit();
        }
        try {
            if (this.g == null) {
                c = this.g.c();
                c.a("t2", a);
                c.b();
            }
        } catch (Exception e5) {
        }
    }

    private static void a(SharedPreferences sharedPreferences, d dVar) {
        if (sharedPreferences != null && dVar != null) {
            f c = dVar.c();
            c.a();
            for (Entry entry : sharedPreferences.getAll().entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof String) {
                    c.a(str, (String) value);
                } else if (value instanceof Integer) {
                    c.a(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    c.a(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    c.a(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    c.a(str, ((Boolean) value).booleanValue());
                }
            }
            c.b();
        }
    }

    private static void a(d dVar, SharedPreferences sharedPreferences) {
        if (dVar != null && sharedPreferences != null) {
            Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.clear();
                for (Entry entry : dVar.b().entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        edit.putString(str, (String) value);
                    } else if (value instanceof Integer) {
                        edit.putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        edit.putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        edit.putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) value).booleanValue());
                    }
                }
                edit.commit();
            }
        }
    }

    private boolean b() {
        if (this.g == null) {
            return false;
        }
        boolean a = this.g.a();
        if (a) {
            return a;
        }
        a();
        return a;
    }

    private void c() {
        if (this.h == null && this.f != null) {
            this.h = this.f.edit();
        }
        if (this.e && this.i == null && this.g != null) {
            this.i = this.g.c();
        }
        b();
    }

    public final void a(String str, String str2) {
        if (!c.a(str) && !str.equals("t")) {
            c();
            if (this.h != null) {
                this.h.putString(str, str2);
            }
            if (this.i != null) {
                this.i.a(str, str2);
            }
        }
    }

    public final void a(String str) {
        if (!c.a(str) && !str.equals("t")) {
            c();
            if (this.h != null) {
                this.h.remove(str);
            }
            if (this.i != null) {
                this.i.a(str);
            }
        }
    }

    public final boolean a() {
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.h != null) {
            if (!(this.l || this.f == null)) {
                this.h.putLong("t", currentTimeMillis);
            }
            if (!this.h.commit()) {
                z = false;
            }
        }
        if (!(this.f == null || this.j == null)) {
            this.f = this.j.getSharedPreferences(this.a, 0);
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (!c.a(externalStorageState)) {
            if (externalStorageState.equals("mounted")) {
                if (this.g == null) {
                    b c = c(this.b);
                    if (c != null) {
                        this.g = c.a(this.a);
                        if (this.l) {
                            a(this.g, this.f);
                        } else {
                            a(this.f, this.g);
                        }
                        this.i = this.g.c();
                    }
                } else if (!(this.i == null || this.i.b())) {
                    z = false;
                }
            }
            if (externalStorageState.equals("mounted") || (externalStorageState.equals("mounted_ro") && this.g != null)) {
                try {
                    if (this.k != null) {
                        this.g = this.k.a(this.a);
                    }
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    public final String b(String str) {
        b();
        if (this.f != null) {
            String string = this.f.getString(str, "");
            if (!c.a(string)) {
                return string;
            }
        }
        if (this.g != null) {
            return this.g.a(str, "");
        }
        return "";
    }

    private b c(String str) {
        File file;
        if (Environment.getExternalStorageDirectory() != null) {
            file = new File(String.format("%s%s%s", new Object[]{Environment.getExternalStorageDirectory().getAbsolutePath(), File.separator, str}));
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            file = null;
        }
        if (file == null) {
            return null;
        }
        this.k = new b(file.getAbsolutePath());
        return this.k;
    }
}
