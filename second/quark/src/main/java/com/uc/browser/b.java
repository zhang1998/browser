package com.uc.browser;

import com.uc.base.b.c.i;
import com.uc.base.b.d.a;
import com.uc.base.b.d.c;
import java.io.IOException;

/* compiled from: ProGuard */
public final class b {
    public static <T extends i> T a(String str, String str2, Class<T> cls) throws a {
        try {
            return c.a(str, str2, (Class) cls);
        } catch (a e) {
            throw new a("Invalid Argument Exception");
        } catch (IOException e2) {
            throw new a("IO Exception");
        } catch (com.uc.base.b.d.b e3) {
            throw new a("Parse Exception");
        }
    }

    public static boolean a(String str, String str2, i iVar) {
        try {
            if (com.uc.base.b.c.c.a.a(str) || com.uc.base.b.c.c.a.a(str2) || iVar == null) {
                throw new a("invalid arguments");
            }
            if (new c(c.a()).a(str, str2, iVar.k_(), iVar.l_(), false)) {
                return true;
            }
            throw new IOException("save fail");
        } catch (a e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    public static boolean a(String str, String str2) {
        return c.a(false, (byte) 2, (byte) 0).b.b(str, str2);
    }
}
