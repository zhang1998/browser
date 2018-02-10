package com.uc.webview.export.cd;

import com.uc.webview.export.cd.platform.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class CDUtil {
    private static final String TAG = "CDUtil";

    public static boolean startsWithPrefexIgnoreCase(String str, String str2) {
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str2.charAt(i);
            if ('a' > charAt || charAt < 'z') {
                z = charAt == str.charAt(i);
            } else {
                boolean z2;
                if (charAt - 32 == str.charAt(i)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2;
            }
            if (!z) {
                break;
            }
        }
        if (z) {
            int i2 = length;
            while (i2 < str2.length()) {
                if (str2.charAt(i2) == ' ') {
                    i2++;
                } else if (str2.charAt(i2) == ':') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return z;
    }

    public static String getCDDataFromOrignData(String str) {
        return str.substring(str.indexOf(58) + 1).trim();
    }

    public static String trimValue(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (i <= length && (str.charAt(i) <= ' ' || str.charAt(i) == '[' || str.charAt(i) == '\"' || str.charAt(i) == '\'' || str.charAt(i) == '{')) {
            i++;
        }
        int i2 = length;
        while (i2 >= i && (str.charAt(i2) <= ' ' || str.charAt(i2) == ']' || str.charAt(i2) == '\"' || str.charAt(i2) == '\'' || str.charAt(i2) == '}')) {
            i2--;
        }
        return (i == 0 && i2 == length) ? str : str.subSequence(i, i2 + 1).toString();
    }

    public static ArrayList<String> newValueArray(String str) {
        ArrayList<String> arrayList = new ArrayList(4);
        if (str.indexOf(44) < 0) {
            arrayList.add(trimValue(str));
        } else {
            for (String trimValue : str.split(",")) {
                arrayList.add(trimValue(trimValue));
            }
        }
        return arrayList;
    }

    public static void removeFile(String str) {
        if (!isEmptyString(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static String readFile(String str) {
        BufferedReader bufferedReader;
        Throwable e;
        Object obj;
        String str2 = null;
        if (!isEmptyString(str)) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    } catch (IOException e2) {
                        e = e2;
                        obj = str2;
                        Log.printStackTraceString("CDUtil.readFile read io cd exception : ", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e3) {
                                Log.printStackTraceString("CDUtil.readFile cd exception : ", e3);
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str2;
                    }
                    try {
                        StringBuilder stringBuilder = new StringBuilder("");
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        }
                        bufferedReader.close();
                        fileInputStream.close();
                        str2 = stringBuilder.toString();
                    } catch (IOException e4) {
                        e3 = e4;
                        Log.printStackTraceString("CDUtil.readFile read io cd exception : ", e3);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return str2;
                    }
                } catch (IOException e5) {
                    e3 = e5;
                    obj = str2;
                    Object obj2 = str2;
                    Log.printStackTraceString("CDUtil.readFile read io cd exception : ", e3);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str2;
                }
            }
        }
        return str2;
    }

    public static void saveDataToFile(String str, String str2) {
        FileWriter fileWriter;
        Throwable e;
        if (!isEmptyString(str) && !isEmptyString(str2)) {
            new StringBuilder("saveDataToFile data.length :").append(str.length()).append(" path:").append(str2);
            File file = new File(str2);
            new StringBuilder("saveDataToFile saveFile:").append(file);
            try {
                fileWriter = new FileWriter(file, false);
                try {
                    fileWriter.write(str);
                    try {
                        fileWriter.close();
                    } catch (Throwable e2) {
                        Log.printStackTraceString("CDUtilsaveDataToFile file close cd exception : ", e2);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        Log.printStackTraceString("CDUtilsaveDataToFile cd exception : ", e2);
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable e22) {
                                Log.printStackTraceString("CDUtilsaveDataToFile file close cd exception : ", e22);
                            }
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Throwable e4) {
                                Log.printStackTraceString("CDUtilsaveDataToFile file close cd exception : ", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                fileWriter = null;
                Log.printStackTraceString("CDUtilsaveDataToFile cd exception : ", e22);
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Throwable th2) {
                e22 = th2;
                fileWriter = null;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw e22;
            }
        }
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }
}
