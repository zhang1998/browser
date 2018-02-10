package com.uc.apollo.android.privy;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ProGuard */
public final class a {
    private Map<String, String> a;

    public a() {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String[] split;
        int i;
        Object obj;
        InputStreamReader inputStreamReader2 = null;
        try {
            this.a = new HashMap();
            inputStreamReader = new InputStreamReader(new FileInputStream(Environment.getRootDirectory() + "/build.prop"));
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        readLine = readLine.trim();
                        if (!(readLine.length() == 0 || readLine.startsWith("#"))) {
                            split = readLine.split("=");
                            if (split != null && split.length == 2) {
                                if (split[0] != null) {
                                    split[0] = split[0].trim();
                                }
                                if (split[1] != null) {
                                    split[1] = split[1].trim();
                                }
                                if (!(split[0] == null || split[0].length() == 0 || split[1] == null || split[1].length() == 0)) {
                                    this.a.put(split[0], split[1]);
                                }
                            }
                        }
                    } catch (Throwable th) {
                        inputStreamReader2 = inputStreamReader;
                    }
                }
            } catch (Throwable th2) {
                bufferedReader = null;
                inputStreamReader2 = inputStreamReader;
                inputStreamReader = inputStreamReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (Throwable th4) {
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th5) {
                    }
                }
                split = new String[]{"ro.build.id", "ro.build.display.id", "ro.product.name", "ro.product.device", "ro.product.board", "ro.product.manufacturer", "ro.product.brand", "ro.product.model", "ro.hardware", "ro.serialno", "ro.build.version.incremental", "ro.build.version.release", "ro.build.version.base_os", "ro.build.version.security_patch", "ro.build.version.sdk", "ro.build.version.codename", "ro.build.type", "ro.build.tags"};
                for (i = 0; i < 18; i++) {
                    obj = split[i];
                    if (this.a.containsKey(obj)) {
                        this.a.put(obj, "");
                    }
                }
            }
        } catch (Throwable th6) {
            bufferedReader = null;
            inputStreamReader = inputStreamReader2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            split = new String[]{"ro.build.id", "ro.build.display.id", "ro.product.name", "ro.product.device", "ro.product.board", "ro.product.manufacturer", "ro.product.brand", "ro.product.model", "ro.hardware", "ro.serialno", "ro.build.version.incremental", "ro.build.version.release", "ro.build.version.base_os", "ro.build.version.security_patch", "ro.build.version.sdk", "ro.build.version.codename", "ro.build.type", "ro.build.tags"};
            for (i = 0; i < 18; i++) {
                obj = split[i];
                if (this.a.containsKey(obj)) {
                    this.a.put(obj, "");
                }
            }
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (inputStreamReader != null) {
            inputStreamReader.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        split = new String[]{"ro.build.id", "ro.build.display.id", "ro.product.name", "ro.product.device", "ro.product.board", "ro.product.manufacturer", "ro.product.brand", "ro.product.model", "ro.hardware", "ro.serialno", "ro.build.version.incremental", "ro.build.version.release", "ro.build.version.base_os", "ro.build.version.security_patch", "ro.build.version.sdk", "ro.build.version.codename", "ro.build.type", "ro.build.tags"};
        for (i = 0; i < 18; i++) {
            obj = split[i];
            if (this.a.containsKey(obj)) {
                this.a.put(obj, "");
            }
        }
    }

    public final String a(String str) {
        if (this.a == null || this.a.size() == 0) {
            return null;
        }
        String str2 = (String) this.a.get(str);
        return str2 == null ? null : str2;
    }

    public final String toString() {
        if (this.a == null || this.a.size() == 0) {
            return "[null]";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Environment.getRootDirectory() + "/build.prop").append(" content:\n");
        for (Entry entry : this.a.entrySet()) {
            stringBuilder.append(" ").append((String) entry.getKey()).append(" = ").append((String) entry.getValue()).append("\n");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
