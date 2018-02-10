package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.weex.ui.component.ab;
import java.net.URLDecoder;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class ee {
    public static int a = -1;
    public static String b = "";

    public static ec a(Context context, ep epVar, String str) {
        byte[] a;
        Object obj;
        Object obj2;
        String a2;
        dw e;
        JSONObject jSONObject;
        int i;
        dy dyVar;
        Throwable th;
        JSONObject jSONObject2;
        eb ebVar;
        Object a3;
        ea eaVar;
        String a4;
        dz dzVar;
        dz dzVar2;
        String str2 = null;
        ec ecVar = new ec();
        try {
            bi biVar = new bi();
            a = bi.a(new ed(context, epVar, str));
            try {
                obj = new byte[16];
                obj2 = new byte[(a.length - 16)];
                System.arraycopy(a, 0, obj, 0, 16);
                System.arraycopy(a, 16, obj2, 0, a.length - 16);
                Key secretKeySpec = new SecretKeySpec(obj, "AES");
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(2, secretKeySpec, new IvParameterSpec(eq.a()));
                a2 = eq.a(instance.doFinal(obj2));
            } catch (dw e2) {
                e = e2;
                ecVar.a = e.a;
                a2 = str2;
                if (a != null) {
                    if (TextUtils.isEmpty(a2)) {
                        a2 = eq.a(a);
                    }
                    try {
                        jSONObject = new JSONObject(a2);
                        if (jSONObject.has(INoCaptchaComponent.status)) {
                            i = jSONObject.getInt(INoCaptchaComponent.status);
                            if (i != 1) {
                                a = 1;
                            } else if (i == 0) {
                                a = 0;
                                if (jSONObject.has("info")) {
                                    b = jSONObject.getString("info");
                                }
                                if (a == 0) {
                                    ecVar.a = b;
                                }
                            }
                            if (jSONObject.has("ver")) {
                                ecVar.b = jSONObject.getInt("ver");
                            }
                            if (eq.a(jSONObject, "result")) {
                                dyVar = new dy();
                                dyVar.a = false;
                                dyVar.b = false;
                                ecVar.n = dyVar;
                                jSONObject = jSONObject.getJSONObject("result");
                                if (eq.a(jSONObject, "11K")) {
                                    try {
                                        dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                                    } catch (Throwable th2) {
                                        es.a(th2, "AuthConfigManager", "loadException");
                                    }
                                }
                                if (eq.a(jSONObject, "11B")) {
                                    ecVar.c = jSONObject.getJSONObject("11B");
                                }
                                if (eq.a(jSONObject, "11C")) {
                                    ecVar.e = jSONObject.getJSONObject("11C");
                                }
                                if (eq.a(jSONObject, "11I")) {
                                    ecVar.f = jSONObject.getJSONObject("11I");
                                }
                                if (eq.a(jSONObject, "11H")) {
                                    ecVar.g = jSONObject.getJSONObject("11H");
                                }
                                if (eq.a(jSONObject, "11E")) {
                                    ecVar.h = jSONObject.getJSONObject("11E");
                                }
                                if (eq.a(jSONObject, "11F")) {
                                    ecVar.i = jSONObject.getJSONObject("11F");
                                }
                                if (eq.a(jSONObject, "13A")) {
                                    ecVar.k = jSONObject.getJSONObject("13A");
                                }
                                if (eq.a(jSONObject, "11G")) {
                                    ecVar.j = jSONObject.getJSONObject("11G");
                                }
                                if (eq.a(jSONObject, "001")) {
                                    jSONObject2 = jSONObject.getJSONObject("001");
                                    ebVar = new eb();
                                    if (jSONObject2 != null) {
                                        try {
                                            obj2 = a(jSONObject2, "md5");
                                            a3 = a(jSONObject2, "url");
                                            obj = a(jSONObject2, "sdkversion");
                                            ebVar.a = a3;
                                            ebVar.b = obj2;
                                            ebVar.c = obj;
                                        } catch (Throwable th22) {
                                            es.a(th22, "ConfigManager", "parseSDKUpdate");
                                        }
                                    }
                                    ecVar.o = ebVar;
                                }
                                if (eq.a(jSONObject, "002")) {
                                    jSONObject2 = jSONObject.getJSONObject("002");
                                    eaVar = new ea();
                                    if (jSONObject2 != null) {
                                        try {
                                            a4 = a(jSONObject2, "md5");
                                            a2 = a(jSONObject2, "url");
                                            eaVar.b = a4;
                                            eaVar.a = a2;
                                        } catch (Throwable th222) {
                                            es.a(th222, "ConfigManager", "parseSDKCoordinate");
                                        }
                                    }
                                    ecVar.p = eaVar;
                                }
                                if (eq.a(jSONObject, "006")) {
                                    ecVar.l = jSONObject.getJSONObject("006");
                                }
                                if (eq.a(jSONObject, "010")) {
                                    ecVar.m = jSONObject.getJSONObject("010");
                                }
                                if (eq.a(jSONObject, "11Z")) {
                                    jSONObject2 = jSONObject.getJSONObject("11Z");
                                    dzVar = new dz();
                                    a(jSONObject2, dzVar);
                                    ecVar.q = dzVar;
                                }
                                if (eq.a(jSONObject, "135")) {
                                    ecVar.d = jSONObject.getJSONObject("135");
                                }
                                if (eq.a(jSONObject, "121")) {
                                    jSONObject2 = jSONObject.getJSONObject("121");
                                    dzVar = new dz();
                                    a(jSONObject2, dzVar);
                                    ecVar.r = dzVar;
                                }
                                if (eq.a(jSONObject, "122")) {
                                    jSONObject2 = jSONObject.getJSONObject("122");
                                    dzVar = new dz();
                                    a(jSONObject2, dzVar);
                                    ecVar.s = dzVar;
                                }
                                if (eq.a(jSONObject, "123")) {
                                    jSONObject2 = jSONObject.getJSONObject("123");
                                    dzVar2 = new dz();
                                    a(jSONObject2, dzVar2);
                                    ecVar.t = dzVar2;
                                }
                            }
                        }
                    } catch (Throwable th2222) {
                        es.a(th2222, "AuthConfigManager", "loadConfig");
                    }
                }
                return ecVar;
            } catch (IllegalBlockSizeException e3) {
                a2 = str2;
                if (a != null) {
                    if (TextUtils.isEmpty(a2)) {
                        a2 = eq.a(a);
                    }
                    jSONObject = new JSONObject(a2);
                    if (jSONObject.has(INoCaptchaComponent.status)) {
                        i = jSONObject.getInt(INoCaptchaComponent.status);
                        if (i != 1) {
                            a = 1;
                        } else if (i == 0) {
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            if (a == 0) {
                                ecVar.a = b;
                            }
                        }
                        if (jSONObject.has("ver")) {
                            ecVar.b = jSONObject.getInt("ver");
                        }
                        if (eq.a(jSONObject, "result")) {
                            dyVar = new dy();
                            dyVar.a = false;
                            dyVar.b = false;
                            ecVar.n = dyVar;
                            jSONObject = jSONObject.getJSONObject("result");
                            if (eq.a(jSONObject, "11K")) {
                                dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                            }
                            if (eq.a(jSONObject, "11B")) {
                                ecVar.c = jSONObject.getJSONObject("11B");
                            }
                            if (eq.a(jSONObject, "11C")) {
                                ecVar.e = jSONObject.getJSONObject("11C");
                            }
                            if (eq.a(jSONObject, "11I")) {
                                ecVar.f = jSONObject.getJSONObject("11I");
                            }
                            if (eq.a(jSONObject, "11H")) {
                                ecVar.g = jSONObject.getJSONObject("11H");
                            }
                            if (eq.a(jSONObject, "11E")) {
                                ecVar.h = jSONObject.getJSONObject("11E");
                            }
                            if (eq.a(jSONObject, "11F")) {
                                ecVar.i = jSONObject.getJSONObject("11F");
                            }
                            if (eq.a(jSONObject, "13A")) {
                                ecVar.k = jSONObject.getJSONObject("13A");
                            }
                            if (eq.a(jSONObject, "11G")) {
                                ecVar.j = jSONObject.getJSONObject("11G");
                            }
                            if (eq.a(jSONObject, "001")) {
                                jSONObject2 = jSONObject.getJSONObject("001");
                                ebVar = new eb();
                                if (jSONObject2 != null) {
                                    obj2 = a(jSONObject2, "md5");
                                    a3 = a(jSONObject2, "url");
                                    obj = a(jSONObject2, "sdkversion");
                                    ebVar.a = a3;
                                    ebVar.b = obj2;
                                    ebVar.c = obj;
                                }
                                ecVar.o = ebVar;
                            }
                            if (eq.a(jSONObject, "002")) {
                                jSONObject2 = jSONObject.getJSONObject("002");
                                eaVar = new ea();
                                if (jSONObject2 != null) {
                                    a4 = a(jSONObject2, "md5");
                                    a2 = a(jSONObject2, "url");
                                    eaVar.b = a4;
                                    eaVar.a = a2;
                                }
                                ecVar.p = eaVar;
                            }
                            if (eq.a(jSONObject, "006")) {
                                ecVar.l = jSONObject.getJSONObject("006");
                            }
                            if (eq.a(jSONObject, "010")) {
                                ecVar.m = jSONObject.getJSONObject("010");
                            }
                            if (eq.a(jSONObject, "11Z")) {
                                jSONObject2 = jSONObject.getJSONObject("11Z");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.q = dzVar;
                            }
                            if (eq.a(jSONObject, "135")) {
                                ecVar.d = jSONObject.getJSONObject("135");
                            }
                            if (eq.a(jSONObject, "121")) {
                                jSONObject2 = jSONObject.getJSONObject("121");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.r = dzVar;
                            }
                            if (eq.a(jSONObject, "122")) {
                                jSONObject2 = jSONObject.getJSONObject("122");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.s = dzVar;
                            }
                            if (eq.a(jSONObject, "123")) {
                                jSONObject2 = jSONObject.getJSONObject("123");
                                dzVar2 = new dz();
                                a(jSONObject2, dzVar2);
                                ecVar.t = dzVar2;
                            }
                        }
                    }
                }
                return ecVar;
            } catch (Throwable th3) {
                th2222 = th3;
                es.a(th2222, "ConfigManager", "loadConfig");
                a2 = str2;
                if (a != null) {
                    if (TextUtils.isEmpty(a2)) {
                        a2 = eq.a(a);
                    }
                    jSONObject = new JSONObject(a2);
                    if (jSONObject.has(INoCaptchaComponent.status)) {
                        i = jSONObject.getInt(INoCaptchaComponent.status);
                        if (i != 1) {
                            a = 1;
                        } else if (i == 0) {
                            a = 0;
                            if (jSONObject.has("info")) {
                                b = jSONObject.getString("info");
                            }
                            if (a == 0) {
                                ecVar.a = b;
                            }
                        }
                        if (jSONObject.has("ver")) {
                            ecVar.b = jSONObject.getInt("ver");
                        }
                        if (eq.a(jSONObject, "result")) {
                            dyVar = new dy();
                            dyVar.a = false;
                            dyVar.b = false;
                            ecVar.n = dyVar;
                            jSONObject = jSONObject.getJSONObject("result");
                            if (eq.a(jSONObject, "11K")) {
                                dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                            }
                            if (eq.a(jSONObject, "11B")) {
                                ecVar.c = jSONObject.getJSONObject("11B");
                            }
                            if (eq.a(jSONObject, "11C")) {
                                ecVar.e = jSONObject.getJSONObject("11C");
                            }
                            if (eq.a(jSONObject, "11I")) {
                                ecVar.f = jSONObject.getJSONObject("11I");
                            }
                            if (eq.a(jSONObject, "11H")) {
                                ecVar.g = jSONObject.getJSONObject("11H");
                            }
                            if (eq.a(jSONObject, "11E")) {
                                ecVar.h = jSONObject.getJSONObject("11E");
                            }
                            if (eq.a(jSONObject, "11F")) {
                                ecVar.i = jSONObject.getJSONObject("11F");
                            }
                            if (eq.a(jSONObject, "13A")) {
                                ecVar.k = jSONObject.getJSONObject("13A");
                            }
                            if (eq.a(jSONObject, "11G")) {
                                ecVar.j = jSONObject.getJSONObject("11G");
                            }
                            if (eq.a(jSONObject, "001")) {
                                jSONObject2 = jSONObject.getJSONObject("001");
                                ebVar = new eb();
                                if (jSONObject2 != null) {
                                    obj2 = a(jSONObject2, "md5");
                                    a3 = a(jSONObject2, "url");
                                    obj = a(jSONObject2, "sdkversion");
                                    ebVar.a = a3;
                                    ebVar.b = obj2;
                                    ebVar.c = obj;
                                }
                                ecVar.o = ebVar;
                            }
                            if (eq.a(jSONObject, "002")) {
                                jSONObject2 = jSONObject.getJSONObject("002");
                                eaVar = new ea();
                                if (jSONObject2 != null) {
                                    a4 = a(jSONObject2, "md5");
                                    a2 = a(jSONObject2, "url");
                                    eaVar.b = a4;
                                    eaVar.a = a2;
                                }
                                ecVar.p = eaVar;
                            }
                            if (eq.a(jSONObject, "006")) {
                                ecVar.l = jSONObject.getJSONObject("006");
                            }
                            if (eq.a(jSONObject, "010")) {
                                ecVar.m = jSONObject.getJSONObject("010");
                            }
                            if (eq.a(jSONObject, "11Z")) {
                                jSONObject2 = jSONObject.getJSONObject("11Z");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.q = dzVar;
                            }
                            if (eq.a(jSONObject, "135")) {
                                ecVar.d = jSONObject.getJSONObject("135");
                            }
                            if (eq.a(jSONObject, "121")) {
                                jSONObject2 = jSONObject.getJSONObject("121");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.r = dzVar;
                            }
                            if (eq.a(jSONObject, "122")) {
                                jSONObject2 = jSONObject.getJSONObject("122");
                                dzVar = new dz();
                                a(jSONObject2, dzVar);
                                ecVar.s = dzVar;
                            }
                            if (eq.a(jSONObject, "123")) {
                                jSONObject2 = jSONObject.getJSONObject("123");
                                dzVar2 = new dz();
                                a(jSONObject2, dzVar2);
                                ecVar.t = dzVar2;
                            }
                        }
                    }
                }
                return ecVar;
            }
        } catch (dw e4) {
            e = e4;
            a = str2;
            ecVar.a = e.a;
            a2 = str2;
            if (a != null) {
                if (TextUtils.isEmpty(a2)) {
                    a2 = eq.a(a);
                }
                jSONObject = new JSONObject(a2);
                if (jSONObject.has(INoCaptchaComponent.status)) {
                    i = jSONObject.getInt(INoCaptchaComponent.status);
                    if (i != 1) {
                        a = 1;
                    } else if (i == 0) {
                        a = 0;
                        if (jSONObject.has("info")) {
                            b = jSONObject.getString("info");
                        }
                        if (a == 0) {
                            ecVar.a = b;
                        }
                    }
                    if (jSONObject.has("ver")) {
                        ecVar.b = jSONObject.getInt("ver");
                    }
                    if (eq.a(jSONObject, "result")) {
                        dyVar = new dy();
                        dyVar.a = false;
                        dyVar.b = false;
                        ecVar.n = dyVar;
                        jSONObject = jSONObject.getJSONObject("result");
                        if (eq.a(jSONObject, "11K")) {
                            dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                        }
                        if (eq.a(jSONObject, "11B")) {
                            ecVar.c = jSONObject.getJSONObject("11B");
                        }
                        if (eq.a(jSONObject, "11C")) {
                            ecVar.e = jSONObject.getJSONObject("11C");
                        }
                        if (eq.a(jSONObject, "11I")) {
                            ecVar.f = jSONObject.getJSONObject("11I");
                        }
                        if (eq.a(jSONObject, "11H")) {
                            ecVar.g = jSONObject.getJSONObject("11H");
                        }
                        if (eq.a(jSONObject, "11E")) {
                            ecVar.h = jSONObject.getJSONObject("11E");
                        }
                        if (eq.a(jSONObject, "11F")) {
                            ecVar.i = jSONObject.getJSONObject("11F");
                        }
                        if (eq.a(jSONObject, "13A")) {
                            ecVar.k = jSONObject.getJSONObject("13A");
                        }
                        if (eq.a(jSONObject, "11G")) {
                            ecVar.j = jSONObject.getJSONObject("11G");
                        }
                        if (eq.a(jSONObject, "001")) {
                            jSONObject2 = jSONObject.getJSONObject("001");
                            ebVar = new eb();
                            if (jSONObject2 != null) {
                                obj2 = a(jSONObject2, "md5");
                                a3 = a(jSONObject2, "url");
                                obj = a(jSONObject2, "sdkversion");
                                ebVar.a = a3;
                                ebVar.b = obj2;
                                ebVar.c = obj;
                            }
                            ecVar.o = ebVar;
                        }
                        if (eq.a(jSONObject, "002")) {
                            jSONObject2 = jSONObject.getJSONObject("002");
                            eaVar = new ea();
                            if (jSONObject2 != null) {
                                a4 = a(jSONObject2, "md5");
                                a2 = a(jSONObject2, "url");
                                eaVar.b = a4;
                                eaVar.a = a2;
                            }
                            ecVar.p = eaVar;
                        }
                        if (eq.a(jSONObject, "006")) {
                            ecVar.l = jSONObject.getJSONObject("006");
                        }
                        if (eq.a(jSONObject, "010")) {
                            ecVar.m = jSONObject.getJSONObject("010");
                        }
                        if (eq.a(jSONObject, "11Z")) {
                            jSONObject2 = jSONObject.getJSONObject("11Z");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.q = dzVar;
                        }
                        if (eq.a(jSONObject, "135")) {
                            ecVar.d = jSONObject.getJSONObject("135");
                        }
                        if (eq.a(jSONObject, "121")) {
                            jSONObject2 = jSONObject.getJSONObject("121");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.r = dzVar;
                        }
                        if (eq.a(jSONObject, "122")) {
                            jSONObject2 = jSONObject.getJSONObject("122");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.s = dzVar;
                        }
                        if (eq.a(jSONObject, "123")) {
                            jSONObject2 = jSONObject.getJSONObject("123");
                            dzVar2 = new dz();
                            a(jSONObject2, dzVar2);
                            ecVar.t = dzVar2;
                        }
                    }
                }
            }
            return ecVar;
        } catch (IllegalBlockSizeException e5) {
            a = str2;
            a2 = str2;
            if (a != null) {
                if (TextUtils.isEmpty(a2)) {
                    a2 = eq.a(a);
                }
                jSONObject = new JSONObject(a2);
                if (jSONObject.has(INoCaptchaComponent.status)) {
                    i = jSONObject.getInt(INoCaptchaComponent.status);
                    if (i != 1) {
                        a = 1;
                    } else if (i == 0) {
                        a = 0;
                        if (jSONObject.has("info")) {
                            b = jSONObject.getString("info");
                        }
                        if (a == 0) {
                            ecVar.a = b;
                        }
                    }
                    if (jSONObject.has("ver")) {
                        ecVar.b = jSONObject.getInt("ver");
                    }
                    if (eq.a(jSONObject, "result")) {
                        dyVar = new dy();
                        dyVar.a = false;
                        dyVar.b = false;
                        ecVar.n = dyVar;
                        jSONObject = jSONObject.getJSONObject("result");
                        if (eq.a(jSONObject, "11K")) {
                            dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                        }
                        if (eq.a(jSONObject, "11B")) {
                            ecVar.c = jSONObject.getJSONObject("11B");
                        }
                        if (eq.a(jSONObject, "11C")) {
                            ecVar.e = jSONObject.getJSONObject("11C");
                        }
                        if (eq.a(jSONObject, "11I")) {
                            ecVar.f = jSONObject.getJSONObject("11I");
                        }
                        if (eq.a(jSONObject, "11H")) {
                            ecVar.g = jSONObject.getJSONObject("11H");
                        }
                        if (eq.a(jSONObject, "11E")) {
                            ecVar.h = jSONObject.getJSONObject("11E");
                        }
                        if (eq.a(jSONObject, "11F")) {
                            ecVar.i = jSONObject.getJSONObject("11F");
                        }
                        if (eq.a(jSONObject, "13A")) {
                            ecVar.k = jSONObject.getJSONObject("13A");
                        }
                        if (eq.a(jSONObject, "11G")) {
                            ecVar.j = jSONObject.getJSONObject("11G");
                        }
                        if (eq.a(jSONObject, "001")) {
                            jSONObject2 = jSONObject.getJSONObject("001");
                            ebVar = new eb();
                            if (jSONObject2 != null) {
                                obj2 = a(jSONObject2, "md5");
                                a3 = a(jSONObject2, "url");
                                obj = a(jSONObject2, "sdkversion");
                                ebVar.a = a3;
                                ebVar.b = obj2;
                                ebVar.c = obj;
                            }
                            ecVar.o = ebVar;
                        }
                        if (eq.a(jSONObject, "002")) {
                            jSONObject2 = jSONObject.getJSONObject("002");
                            eaVar = new ea();
                            if (jSONObject2 != null) {
                                a4 = a(jSONObject2, "md5");
                                a2 = a(jSONObject2, "url");
                                eaVar.b = a4;
                                eaVar.a = a2;
                            }
                            ecVar.p = eaVar;
                        }
                        if (eq.a(jSONObject, "006")) {
                            ecVar.l = jSONObject.getJSONObject("006");
                        }
                        if (eq.a(jSONObject, "010")) {
                            ecVar.m = jSONObject.getJSONObject("010");
                        }
                        if (eq.a(jSONObject, "11Z")) {
                            jSONObject2 = jSONObject.getJSONObject("11Z");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.q = dzVar;
                        }
                        if (eq.a(jSONObject, "135")) {
                            ecVar.d = jSONObject.getJSONObject("135");
                        }
                        if (eq.a(jSONObject, "121")) {
                            jSONObject2 = jSONObject.getJSONObject("121");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.r = dzVar;
                        }
                        if (eq.a(jSONObject, "122")) {
                            jSONObject2 = jSONObject.getJSONObject("122");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.s = dzVar;
                        }
                        if (eq.a(jSONObject, "123")) {
                            jSONObject2 = jSONObject.getJSONObject("123");
                            dzVar2 = new dz();
                            a(jSONObject2, dzVar2);
                            ecVar.t = dzVar2;
                        }
                    }
                }
            }
            return ecVar;
        } catch (Throwable th4) {
            th2222 = th4;
            a = str2;
            es.a(th2222, "ConfigManager", "loadConfig");
            a2 = str2;
            if (a != null) {
                if (TextUtils.isEmpty(a2)) {
                    a2 = eq.a(a);
                }
                jSONObject = new JSONObject(a2);
                if (jSONObject.has(INoCaptchaComponent.status)) {
                    i = jSONObject.getInt(INoCaptchaComponent.status);
                    if (i != 1) {
                        a = 1;
                    } else if (i == 0) {
                        a = 0;
                        if (jSONObject.has("info")) {
                            b = jSONObject.getString("info");
                        }
                        if (a == 0) {
                            ecVar.a = b;
                        }
                    }
                    if (jSONObject.has("ver")) {
                        ecVar.b = jSONObject.getInt("ver");
                    }
                    if (eq.a(jSONObject, "result")) {
                        dyVar = new dy();
                        dyVar.a = false;
                        dyVar.b = false;
                        ecVar.n = dyVar;
                        jSONObject = jSONObject.getJSONObject("result");
                        if (eq.a(jSONObject, "11K")) {
                            dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                        }
                        if (eq.a(jSONObject, "11B")) {
                            ecVar.c = jSONObject.getJSONObject("11B");
                        }
                        if (eq.a(jSONObject, "11C")) {
                            ecVar.e = jSONObject.getJSONObject("11C");
                        }
                        if (eq.a(jSONObject, "11I")) {
                            ecVar.f = jSONObject.getJSONObject("11I");
                        }
                        if (eq.a(jSONObject, "11H")) {
                            ecVar.g = jSONObject.getJSONObject("11H");
                        }
                        if (eq.a(jSONObject, "11E")) {
                            ecVar.h = jSONObject.getJSONObject("11E");
                        }
                        if (eq.a(jSONObject, "11F")) {
                            ecVar.i = jSONObject.getJSONObject("11F");
                        }
                        if (eq.a(jSONObject, "13A")) {
                            ecVar.k = jSONObject.getJSONObject("13A");
                        }
                        if (eq.a(jSONObject, "11G")) {
                            ecVar.j = jSONObject.getJSONObject("11G");
                        }
                        if (eq.a(jSONObject, "001")) {
                            jSONObject2 = jSONObject.getJSONObject("001");
                            ebVar = new eb();
                            if (jSONObject2 != null) {
                                obj2 = a(jSONObject2, "md5");
                                a3 = a(jSONObject2, "url");
                                obj = a(jSONObject2, "sdkversion");
                                ebVar.a = a3;
                                ebVar.b = obj2;
                                ebVar.c = obj;
                            }
                            ecVar.o = ebVar;
                        }
                        if (eq.a(jSONObject, "002")) {
                            jSONObject2 = jSONObject.getJSONObject("002");
                            eaVar = new ea();
                            if (jSONObject2 != null) {
                                a4 = a(jSONObject2, "md5");
                                a2 = a(jSONObject2, "url");
                                eaVar.b = a4;
                                eaVar.a = a2;
                            }
                            ecVar.p = eaVar;
                        }
                        if (eq.a(jSONObject, "006")) {
                            ecVar.l = jSONObject.getJSONObject("006");
                        }
                        if (eq.a(jSONObject, "010")) {
                            ecVar.m = jSONObject.getJSONObject("010");
                        }
                        if (eq.a(jSONObject, "11Z")) {
                            jSONObject2 = jSONObject.getJSONObject("11Z");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.q = dzVar;
                        }
                        if (eq.a(jSONObject, "135")) {
                            ecVar.d = jSONObject.getJSONObject("135");
                        }
                        if (eq.a(jSONObject, "121")) {
                            jSONObject2 = jSONObject.getJSONObject("121");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.r = dzVar;
                        }
                        if (eq.a(jSONObject, "122")) {
                            jSONObject2 = jSONObject.getJSONObject("122");
                            dzVar = new dz();
                            a(jSONObject2, dzVar);
                            ecVar.s = dzVar;
                        }
                        if (eq.a(jSONObject, "123")) {
                            jSONObject2 = jSONObject.getJSONObject("123");
                            dzVar2 = new dz();
                            a(jSONObject2, dzVar2);
                            ecVar.t = dzVar2;
                        }
                    }
                }
            }
            return ecVar;
        }
        if (a != null) {
            if (TextUtils.isEmpty(a2)) {
                a2 = eq.a(a);
            }
            jSONObject = new JSONObject(a2);
            if (jSONObject.has(INoCaptchaComponent.status)) {
                i = jSONObject.getInt(INoCaptchaComponent.status);
                if (i != 1) {
                    a = 1;
                } else if (i == 0) {
                    a = 0;
                    if (jSONObject.has("info")) {
                        b = jSONObject.getString("info");
                    }
                    if (a == 0) {
                        ecVar.a = b;
                    }
                }
                if (jSONObject.has("ver")) {
                    ecVar.b = jSONObject.getInt("ver");
                }
                if (eq.a(jSONObject, "result")) {
                    dyVar = new dy();
                    dyVar.a = false;
                    dyVar.b = false;
                    ecVar.n = dyVar;
                    jSONObject = jSONObject.getJSONObject("result");
                    if (eq.a(jSONObject, "11K")) {
                        dyVar.a = a(jSONObject.getJSONObject("11K").getString("able"), false);
                    }
                    if (eq.a(jSONObject, "11B")) {
                        ecVar.c = jSONObject.getJSONObject("11B");
                    }
                    if (eq.a(jSONObject, "11C")) {
                        ecVar.e = jSONObject.getJSONObject("11C");
                    }
                    if (eq.a(jSONObject, "11I")) {
                        ecVar.f = jSONObject.getJSONObject("11I");
                    }
                    if (eq.a(jSONObject, "11H")) {
                        ecVar.g = jSONObject.getJSONObject("11H");
                    }
                    if (eq.a(jSONObject, "11E")) {
                        ecVar.h = jSONObject.getJSONObject("11E");
                    }
                    if (eq.a(jSONObject, "11F")) {
                        ecVar.i = jSONObject.getJSONObject("11F");
                    }
                    if (eq.a(jSONObject, "13A")) {
                        ecVar.k = jSONObject.getJSONObject("13A");
                    }
                    if (eq.a(jSONObject, "11G")) {
                        ecVar.j = jSONObject.getJSONObject("11G");
                    }
                    if (eq.a(jSONObject, "001")) {
                        jSONObject2 = jSONObject.getJSONObject("001");
                        ebVar = new eb();
                        if (jSONObject2 != null) {
                            obj2 = a(jSONObject2, "md5");
                            a3 = a(jSONObject2, "url");
                            obj = a(jSONObject2, "sdkversion");
                            if (!(TextUtils.isEmpty(obj2) || TextUtils.isEmpty(a3) || TextUtils.isEmpty(obj))) {
                                ebVar.a = a3;
                                ebVar.b = obj2;
                                ebVar.c = obj;
                            }
                        }
                        ecVar.o = ebVar;
                    }
                    if (eq.a(jSONObject, "002")) {
                        jSONObject2 = jSONObject.getJSONObject("002");
                        eaVar = new ea();
                        if (jSONObject2 != null) {
                            a4 = a(jSONObject2, "md5");
                            a2 = a(jSONObject2, "url");
                            eaVar.b = a4;
                            eaVar.a = a2;
                        }
                        ecVar.p = eaVar;
                    }
                    if (eq.a(jSONObject, "006")) {
                        ecVar.l = jSONObject.getJSONObject("006");
                    }
                    if (eq.a(jSONObject, "010")) {
                        ecVar.m = jSONObject.getJSONObject("010");
                    }
                    if (eq.a(jSONObject, "11Z")) {
                        jSONObject2 = jSONObject.getJSONObject("11Z");
                        dzVar = new dz();
                        a(jSONObject2, dzVar);
                        ecVar.q = dzVar;
                    }
                    if (eq.a(jSONObject, "135")) {
                        ecVar.d = jSONObject.getJSONObject("135");
                    }
                    if (eq.a(jSONObject, "121")) {
                        jSONObject2 = jSONObject.getJSONObject("121");
                        dzVar = new dz();
                        a(jSONObject2, dzVar);
                        ecVar.r = dzVar;
                    }
                    if (eq.a(jSONObject, "122")) {
                        jSONObject2 = jSONObject.getJSONObject("122");
                        dzVar = new dz();
                        a(jSONObject2, dzVar);
                        ecVar.s = dzVar;
                    }
                    if (eq.a(jSONObject, "123")) {
                        jSONObject2 = jSONObject.getJSONObject("123");
                        dzVar2 = new dz();
                        a(jSONObject2, dzVar2);
                        ecVar.t = dzVar2;
                    }
                }
            }
        }
        return ecVar;
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        return (!jSONObject.has(str) || jSONObject.getString(str).equals("[]")) ? str2 : jSONObject.optString(str);
    }

    public static void a(String str) {
        dx.c(str);
    }

    private static void a(JSONObject jSONObject, dz dzVar) {
        try {
            String a = a(jSONObject, ab.PROP_FS_MATCH_PARENT);
            String a2 = a(jSONObject, "u");
            String a3 = a(jSONObject, "v");
            String a4 = a(jSONObject, "able");
            dzVar.c = a;
            dzVar.b = a2;
            dzVar.d = a3;
            dzVar.a = a(a4, false);
        } catch (Throwable th) {
            es.a(th, "ConfigManager", "parsePluginEntity");
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length + -1].charAt(4) % 2 == 1;
        } catch (Throwable th) {
            return z;
        }
    }
}
