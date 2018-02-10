package com.ucpro.a.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ProGuard */
public final class c {
    public static String a(int i) {
        String str = "";
        switch (i) {
            case 0:
                return "无";
            case 1:
                return "Android ";
            case 2:
                return "PC";
            case 3:
                return "iPhone";
            default:
                return str;
        }
    }

    public static int a(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1211816315:
                if (str.equals("iPhone")) {
                    i = 3;
                    break;
                }
                break;
            case -868680783:
                if (str.equals("Android ")) {
                    i = 1;
                    break;
                }
                break;
            case 2547:
                if (str.equals("PC")) {
                    i = 2;
                    break;
                }
                break;
            case 26080:
                if (str.equals("无")) {
                    i = 0;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 1;
        }
    }

    public static List<String> a() {
        List<String> arrayList = new ArrayList();
        arrayList.add("Android ");
        arrayList.add("PC");
        arrayList.add("iPhone");
        return arrayList;
    }
}
