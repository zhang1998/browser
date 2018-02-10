package com.ucpro.patch;

import android.util.Base64;
import android.util.Log;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public final class a {
    private final String a = "QrVerifyHandler";
    private final String b = "MDUyNSNkP2F3ISEhZQ==";

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes());
            return Base64.encodeToString(instance.digest(), 11);
        } catch (Throwable e) {
            Log.e("QrVerifyHandler", "genBaseSh1 exception", e);
            return null;
        }
    }

    public static String[] b(String str) {
        String[] split = str.split("\\?", 2)[1].split("&");
        List linkedList = new LinkedList();
        Map hashMap = new HashMap();
        for (String split2 : split) {
            String[] split3 = split2.split("=", 2);
            hashMap.put(split3[0], split3[1]);
        }
        linkedList.add(hashMap.get("y"));
        linkedList.add(hashMap.get("n"));
        return (String[]) linkedList.toArray(new String[0]);
    }
}
