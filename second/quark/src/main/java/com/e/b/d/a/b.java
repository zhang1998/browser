package com.e.b.d.a;

import android.content.Context;
import com.alibaba.analytics.a.af;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: ProGuard */
public class b implements c {
    public String a = null;
    public String b;
    private Object c = null;
    private Object d = null;
    private Class e = null;
    private Field f = null;
    private Field g = null;
    private Field h = null;
    private Method i = null;
    private int j = 1;
    private boolean k = false;

    public final String a() {
        return this.a;
    }

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private synchronized void b() {
        Class cls;
        Throwable th;
        Method method;
        Class cls2 = null;
        synchronized (this) {
            if (!this.k) {
                boolean booleanValue;
                try {
                    cls = Class.forName("com.alibaba.wireless.security.open.SecurityGuardManager");
                    try {
                        this.c = cls.getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{com.alibaba.analytics.core.b.a().b});
                        this.d = cls.getMethod("getSecureSignatureComp", new Class[0]).invoke(this.c, new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        af.c("UTSecurityThridRequestAuthentication", "initSecurityCheck", th);
                        if (cls != null) {
                            try {
                                this.e = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                                this.f = this.e.getDeclaredField("appKey");
                                this.g = this.e.getDeclaredField("paramMap");
                                this.h = this.e.getDeclaredField("requestType");
                                method = cls.getMethod("isOpen", new Class[0]);
                            } catch (Throwable th3) {
                                af.c("UTSecurityThridRequestAuthentication", "initSecurityCheck", th3);
                            }
                            if (method != null) {
                                booleanValue = ((Boolean) method.invoke(this.c, new Object[0])).booleanValue();
                            } else {
                                try {
                                    cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                                } catch (Throwable th32) {
                                    af.c("UTSecurityThridRequestAuthentication", "initSecurityCheck", th32);
                                }
                                if (cls2 == null) {
                                    booleanValue = true;
                                } else {
                                    booleanValue = false;
                                }
                            }
                            this.j = booleanValue ? 1 : 12;
                            this.i = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.e, String.class});
                        }
                        this.k = true;
                    }
                } catch (Throwable th4) {
                    th32 = th4;
                    cls = cls2;
                    af.c("UTSecurityThridRequestAuthentication", "initSecurityCheck", th32);
                    if (cls != null) {
                        this.e = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                        this.f = this.e.getDeclaredField("appKey");
                        this.g = this.e.getDeclaredField("paramMap");
                        this.h = this.e.getDeclaredField("requestType");
                        method = cls.getMethod("isOpen", new Class[0]);
                        if (method != null) {
                            cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                            if (cls2 == null) {
                                booleanValue = false;
                            } else {
                                booleanValue = true;
                            }
                        } else {
                            booleanValue = ((Boolean) method.invoke(this.c, new Object[0])).booleanValue();
                        }
                        if (booleanValue) {
                        }
                        this.j = booleanValue ? 1 : 12;
                        this.i = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.e, String.class});
                    }
                    this.k = true;
                }
                if (cls != null) {
                    this.e = Class.forName("com.alibaba.wireless.security.open.SecurityGuardParamContext");
                    this.f = this.e.getDeclaredField("appKey");
                    this.g = this.e.getDeclaredField("paramMap");
                    this.h = this.e.getDeclaredField("requestType");
                    method = cls.getMethod("isOpen", new Class[0]);
                    if (method != null) {
                        booleanValue = ((Boolean) method.invoke(this.c, new Object[0])).booleanValue();
                    } else {
                        cls2 = Class.forName("com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent");
                        if (cls2 == null) {
                            booleanValue = true;
                        } else {
                            booleanValue = false;
                        }
                    }
                    if (booleanValue) {
                    }
                    this.j = booleanValue ? 1 : 12;
                    this.i = Class.forName("com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent").getMethod("signRequest", new Class[]{this.e, String.class});
                }
                this.k = true;
            }
        }
    }

    public final String a(String str) {
        if (!this.k) {
            b();
        }
        if (this.a == null) {
            af.a("UTSecurityThridRequestAuthentication", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            String str2;
            if (this.c == null || this.e == null || this.f == null || this.g == null || this.h == null || this.i == null || this.d == null) {
                af.c("UTSecurityThridRequestAuthentication.getSign", "s_securityGuardManagerObj", this.c, "s_securityGuardParamContextClz", this.e, "s_securityGuardParamContext_appKey", this.f, "s_securityGuardParamContext_paramMap", this.g, "s_securityGuardParamContext_requestType", this.h, "s_signRequestMethod", this.i);
                str2 = null;
            } else {
                try {
                    Object newInstance = this.e.newInstance();
                    this.f.set(newInstance, this.a);
                    ((Map) this.g.get(newInstance)).put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
                    this.h.set(newInstance, Integer.valueOf(this.j));
                    str2 = (String) this.i.invoke(this.d, new Object[]{newInstance, this.b});
                } catch (Throwable e) {
                    af.b(null, e, new Object[0]);
                    str2 = null;
                }
            }
            return str2;
        }
    }
}
