package com.alibaba.analytics.a;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/* compiled from: ProGuard */
public final class t {
    public static String a() {
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                str = bufferedReader.readLine();
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                Log.e("SystemUtils", "Could not read from file /proc/cpuinfo :" + e.toString());
            }
        } catch (Exception e2) {
            Log.e("SystemUtils", "BaseParameter-Could not open file /proc/cpuinfo :" + e2.toString());
        }
        if (str != null) {
            return str.substring(str.indexOf(58) + 1).trim();
        }
        return "";
    }
}
