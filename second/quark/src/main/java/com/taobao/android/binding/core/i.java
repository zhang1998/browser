package com.taobao.android.binding.core;

import android.mini.support.annotation.NonNull;
import android.mini.support.annotation.Nullable;
import android.text.TextUtils;
import com.alibaba.fastjson.a;
import com.taobao.weex.ac;
import com.taobao.weex.bridge.c;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: ProGuard */
final class i {
    private Map<String, Map<String, be>> a;

    i() {
    }

    final String a(@NonNull Map<String, Object> map, @NonNull c cVar, @NonNull ac acVar) {
        String a = dz.a(map, "eventType");
        String a2 = dz.a(map, "options");
        Map map2 = null;
        if (!TextUtils.isEmpty(a2)) {
            try {
                map2 = a.b(a2);
            } catch (Exception e) {
                WXLogUtils.e("ExpressionBinding", "parse external config failed.\n" + e.getMessage());
            }
        }
        return a(dz.a(map, "anchor"), a, map2, dz.b(map, "exitExpression"), dz.a((Map) map), cVar, acVar);
    }

    final void a(@Nullable String str, @Nullable String str2) {
        WXLogUtils.d("ExpressionBinding", "disable binding [" + str + "," + str2 + "]");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            WXLogUtils.d("ExpressionBinding", "disable binding failed(0x1) [" + str + "," + str2 + "]");
        } else if (this.a == null || this.a.isEmpty()) {
            WXLogUtils.d("ExpressionBinding", "disable binding failed(0x2) [" + str + "," + str2 + "]");
        } else {
            Map map = (Map) this.a.get(str);
            if (map == null || map.isEmpty()) {
                WXLogUtils.d("ExpressionBinding", "disable binding failed(0x3) [" + str + "," + str2 + "]");
                return;
            }
            be beVar = (be) map.get(str2);
            if (beVar == null) {
                WXLogUtils.d("ExpressionBinding", "disable binding failed(0x4) [" + str + "," + str2 + "]");
            } else if (beVar.b(str, str2)) {
                this.a.remove(str);
                WXLogUtils.d("ExpressionBinding", "disable binding success[" + str + "," + str2 + "]");
            } else {
                WXLogUtils.d("ExpressionBinding", "disabled failed(0x4) [" + str + "," + str2 + "]");
            }
        }
    }

    final void a() {
        if (this.a != null) {
            for (Map map : this.a.values()) {
                if (!(map == null || map.isEmpty())) {
                    for (be beVar : map.values()) {
                        if (beVar != null) {
                            beVar.b();
                        }
                    }
                }
            }
            this.a.clear();
            this.a = null;
        }
    }

    final String a(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map, @Nullable av avVar, @Nullable List<Map<String, Object>> list, @Nullable c cVar, @NonNull ac acVar) {
        if (TextUtils.isEmpty(str2) || list == null) {
            WXLogUtils.e("ExpressionBinding", "doBind failed,illegal argument.[" + str2 + "," + list + "]");
            return null;
        }
        Map map2;
        be beVar;
        CharSequence charSequence;
        be beVar2;
        be beVar3;
        CharSequence charSequence2;
        if (!(this.a == null || TextUtils.isEmpty(str))) {
            map2 = (Map) this.a.get(str);
            if (map2 != null) {
                beVar = (be) map2.get(str2);
                if (beVar != null) {
                    if (com.taobao.weex.i.c()) {
                        WXLogUtils.d("ExpressionBinding", "binding not enabled,try auto enable it.[sourceRef:" + str + ",eventType:" + str2 + "]");
                    }
                    if (TextUtils.isEmpty(str2)) {
                        WXLogUtils.e("ExpressionBinding", "[doPrepare] failed. can not found eventType");
                        charSequence = null;
                    } else if (acVar.b() != null) {
                        WXLogUtils.e("ExpressionBinding", "[doPrepare] failed. context or wxInstance is null");
                        charSequence = null;
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            Object obj = str;
                        } else {
                            charSequence = UUID.randomUUID().toString();
                        }
                        if (this.a == null) {
                            this.a = new HashMap();
                        }
                        map2 = (Map) this.a.get(charSequence);
                        if (map2 != null) {
                            beVar2 = (be) map2.get(str2);
                            if (beVar2 != null) {
                                if (com.taobao.weex.i.c()) {
                                    WXLogUtils.d("ExpressionBinding", "you have already enabled binding,[token:" + charSequence + ",type:" + str2 + "]");
                                }
                                beVar2.a(str2);
                                if (com.taobao.weex.i.c()) {
                                    WXLogUtils.d("ExpressionBinding", "enableBinding success.[token:" + charSequence + ",type:" + str2 + "]");
                                }
                            }
                        }
                        if (map2 == null) {
                            map2 = new HashMap(4);
                            this.a.put(charSequence, map2);
                        }
                        beVar2 = ("pan".equals(str2) || "flick".equals(str2)) ? new bd(acVar) : "orientation".equals(str2) ? new au(acVar) : "scroll".equals(str2) ? new bb(acVar) : "timing".equals(str2) ? new bc(acVar) : null;
                        if (beVar2 != null) {
                            WXLogUtils.e("ExpressionBinding", "unknown eventType: " + str2);
                            charSequence = null;
                        } else if (beVar2.a(charSequence, str2)) {
                            WXLogUtils.e("ExpressionBinding", "expression enabled failed. [token:" + charSequence + ",type:" + str2 + "]");
                            charSequence = null;
                        } else {
                            beVar2.a(str2);
                            map2.put(str2, beVar2);
                            if (com.taobao.weex.i.c()) {
                                WXLogUtils.d("ExpressionBinding", "enableBinding success.[token:" + charSequence + ",type:" + str2 + "]");
                            }
                        }
                    }
                    if (!(TextUtils.isEmpty(charSequence) || this.a == null)) {
                        map2 = (Map) this.a.get(charSequence);
                        if (map2 != null) {
                            beVar3 = (be) map2.get(str2);
                            charSequence2 = charSequence;
                        }
                    }
                    charSequence2 = charSequence;
                    beVar3 = beVar;
                } else {
                    Object obj2 = str;
                    beVar3 = beVar;
                }
                if (beVar3 == null) {
                    beVar3.a(str2, map, avVar, list, cVar);
                    WXLogUtils.d("ExpressionBinding", "createBinding success.[exitExp:" + avVar + ",args:" + list + "]");
                } else {
                    WXLogUtils.e("ExpressionBinding", "internal error.binding failed for ref:" + str + ",type:" + str2);
                }
                return charSequence2;
            }
        }
        Object obj3 = null;
        if (beVar != null) {
            Object obj22 = str;
            beVar3 = beVar;
        } else {
            if (com.taobao.weex.i.c()) {
                WXLogUtils.d("ExpressionBinding", "binding not enabled,try auto enable it.[sourceRef:" + str + ",eventType:" + str2 + "]");
            }
            if (TextUtils.isEmpty(str2)) {
                WXLogUtils.e("ExpressionBinding", "[doPrepare] failed. can not found eventType");
                charSequence = null;
            } else if (acVar.b() != null) {
                if (TextUtils.isEmpty(str)) {
                    Object obj4 = str;
                } else {
                    charSequence = UUID.randomUUID().toString();
                }
                if (this.a == null) {
                    this.a = new HashMap();
                }
                map2 = (Map) this.a.get(charSequence);
                if (map2 != null) {
                    beVar2 = (be) map2.get(str2);
                    if (beVar2 != null) {
                        if (com.taobao.weex.i.c()) {
                            WXLogUtils.d("ExpressionBinding", "you have already enabled binding,[token:" + charSequence + ",type:" + str2 + "]");
                        }
                        beVar2.a(str2);
                        if (com.taobao.weex.i.c()) {
                            WXLogUtils.d("ExpressionBinding", "enableBinding success.[token:" + charSequence + ",type:" + str2 + "]");
                        }
                    }
                }
                if (map2 == null) {
                    map2 = new HashMap(4);
                    this.a.put(charSequence, map2);
                }
                if (!"pan".equals(str2)) {
                }
                if (beVar2 != null) {
                    WXLogUtils.e("ExpressionBinding", "unknown eventType: " + str2);
                    charSequence = null;
                } else if (beVar2.a(charSequence, str2)) {
                    WXLogUtils.e("ExpressionBinding", "expression enabled failed. [token:" + charSequence + ",type:" + str2 + "]");
                    charSequence = null;
                } else {
                    beVar2.a(str2);
                    map2.put(str2, beVar2);
                    if (com.taobao.weex.i.c()) {
                        WXLogUtils.d("ExpressionBinding", "enableBinding success.[token:" + charSequence + ",type:" + str2 + "]");
                    }
                }
            } else {
                WXLogUtils.e("ExpressionBinding", "[doPrepare] failed. context or wxInstance is null");
                charSequence = null;
            }
            map2 = (Map) this.a.get(charSequence);
            if (map2 != null) {
                beVar3 = (be) map2.get(str2);
                charSequence2 = charSequence;
            }
            charSequence2 = charSequence;
            beVar3 = beVar;
        }
        if (beVar3 == null) {
            WXLogUtils.e("ExpressionBinding", "internal error.binding failed for ref:" + str + ",type:" + str2);
        } else {
            beVar3.a(str2, map, avVar, list, cVar);
            WXLogUtils.d("ExpressionBinding", "createBinding success.[exitExp:" + avVar + ",args:" + list + "]");
        }
        return charSequence2;
    }

    final void b() {
        if (this.a != null) {
            for (Map values : this.a.values()) {
                for (be c : values.values()) {
                    try {
                        c.c();
                    } catch (Exception e) {
                        WXLogUtils.e("ExpressionBinding", e.getMessage());
                    }
                }
            }
        }
    }

    final void c() {
        if (this.a != null) {
            for (Map values : this.a.values()) {
                for (be d : values.values()) {
                    try {
                        d.d();
                    } catch (Exception e) {
                        WXLogUtils.e("ExpressionBinding", e.getMessage());
                    }
                }
            }
        }
    }
}
