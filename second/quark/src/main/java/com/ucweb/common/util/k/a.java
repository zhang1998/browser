package com.ucweb.common.util.k;

import android.content.Context;
import android.os.StatFs;
import com.ucweb.common.util.c;
import com.ucweb.common.util.o.b;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public final class a {
    private static final String[] a = new String[]{"/", "\\", "?", "*", ":", "<", ">", "|", "\""};
    private static int b = 0;

    public static long a(File file, long j) {
        if (file == null || !file.exists()) {
            return j;
        }
        if (!file.isDirectory()) {
            return j + file.length();
        }
        long j2;
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int i = 0;
            j2 = 0;
            while (i < listFiles.length) {
                long a = a(listFiles[i], 0) + j2;
                i++;
                j2 = a;
            }
        } else {
            j2 = 0;
        }
        return j + j2;
    }

    public static String[] a(String str) throws FileNotFoundException, IOException {
        return a(new File(str));
    }

    public static String[] a(File file) throws FileNotFoundException, IOException {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine);
            } else {
                bufferedReader.close();
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
    }

    public static void a(File file, String[] strArr, boolean z) throws IOException {
        File parentFile = file.getParentFile();
        if (!(parentFile == null || parentFile.exists())) {
            parentFile.mkdirs();
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter(file, z));
        for (String println : strArr) {
            printWriter.println(println);
        }
        printWriter.close();
    }

    public static void a(File file, Map<String, String> map) throws IOException {
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        String[] strArr = new String[toArray.length];
        for (int i = 0; i < strArr.length; i++) {
            Object obj = toArray[i];
            Object obj2 = map.get(obj);
            if (!(obj == null || obj2 == null)) {
                strArr[i] = obj.toString() + '|' + obj2.toString();
            }
        }
        a(file, strArr, false);
    }

    public static boolean b(File file) {
        boolean z = false;
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (int i = z; i < list.length; i++) {
                    if (!b(new File(file, list[i]))) {
                        break;
                    }
                }
            }
        }
        try {
            z = file.delete();
        } catch (Throwable th) {
        }
        return z;
    }

    public static List<File> c(File file) {
        List<File> arrayList = new ArrayList();
        if (!file.exists() || file.isFile()) {
            return arrayList;
        }
        File[] listFiles = file.listFiles(null);
        if (listFiles != null) {
            return Arrays.asList(listFiles);
        }
        return arrayList;
    }

    public static byte[] d(File file) throws IOException {
        Throwable th;
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byte[] bArr = new byte[SpdyProtocol.SLIGHTSSL_0_RTT_MODE];
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            bArr = byteArrayOutputStream.toByteArray();
                            fileInputStream2.close();
                            byteArrayOutputStream.close();
                            return bArr;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(String str, String str2, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        return a(str, str2, bArr, bArr.length);
    }

    public static boolean a(String str, String str2, byte[] bArr, int i) {
        try {
            if (com.ucweb.common.util.n.a.a(str) || com.ucweb.common.util.n.a.a(str2) || bArr == null) {
                return false;
            }
            File k = k(str + (System.currentTimeMillis() + str2));
            a(k, bArr, 0, i);
            String str3 = str + str2;
            if (!b(k, str3)) {
                String str4 = str3 + ".bak";
                c(str4);
                b(new File(str3), str4);
                if (!b(k, str3)) {
                    return false;
                }
                c(str4);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        }
    }

    private static boolean a(File file, byte[] bArr, int i, int i2) throws FileNotFoundException, IOException {
        Closeable fileOutputStream;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr, i, i2);
                fileOutputStream.flush();
                com.ucweb.common.util.o.a.a(fileOutputStream);
                return true;
            } catch (Throwable th2) {
                th = th2;
                com.ucweb.common.util.o.a.a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            com.ucweb.common.util.o.a.a(fileOutputStream);
            throw th;
        }
    }

    private static boolean b(File file, byte[] bArr, int i, int i2) {
        boolean z = false;
        try {
            z = a(file, bArr, 0, i2);
        } catch (FileNotFoundException e) {
        } catch (IOException e2) {
        }
        return z;
    }

    public static boolean a(File file, byte[] bArr, int i) {
        return b(file, bArr, 0, i);
    }

    public static File b(String str) {
        return k(str);
    }

    private static boolean b(File file, String str) {
        return file.renameTo(new File(str));
    }

    public static boolean c(String str) {
        return b(new File(str));
    }

    private static File k(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!(parentFile == null || parentFile.exists())) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Exception e) {
            }
        }
        return file;
    }

    public static byte[] d(String str) {
        if (com.ucweb.common.util.n.a.a(str)) {
            return null;
        }
        return e(new File(str));
    }

    public static byte[] e(File file) {
        Closeable bufferedInputStream;
        byte[] f;
        Throwable th;
        Closeable closeable = null;
        try {
            if (file.exists()) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    f = com.ucweb.common.util.o.a.f(bufferedInputStream);
                    com.ucweb.common.util.o.a.a(bufferedInputStream);
                } catch (Exception e) {
                    com.ucweb.common.util.o.a.a(bufferedInputStream);
                    return f;
                } catch (Throwable th2) {
                    th = th2;
                    com.ucweb.common.util.o.a.a(bufferedInputStream);
                    throw th;
                }
            }
            com.ucweb.common.util.o.a.a(closeable);
        } catch (Exception e2) {
            bufferedInputStream = closeable;
            com.ucweb.common.util.o.a.a(bufferedInputStream);
            return f;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            bufferedInputStream = closeable;
            th = th4;
            com.ucweb.common.util.o.a.a(bufferedInputStream);
            throw th;
        }
        return f;
    }

    public static final long e(String str) {
        boolean z;
        if (com.ucweb.common.util.n.a.a(str)) {
            z = false;
        } else {
            z = new File(str).exists();
        }
        if (!z) {
            return -1;
        }
        StatFs statFs = new StatFs(str);
        return ((long) statFs.getAvailableBlocks()) * (1 * ((long) statFs.getBlockSize()));
    }

    public static String b(File file, long j) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (j <= 0 || currentTimeMillis2 - currentTimeMillis <= j) {
                        instance.update(bArr, 0, read);
                    } else {
                        bufferedInputStream.close();
                        instance.reset();
                        return "";
                    }
                }
                bufferedInputStream.close();
                return b.b(instance.digest());
            }
        } catch (NoSuchAlgorithmException e) {
            c.a(e.toString());
            return "";
        }
    }

    public static boolean a(File file, String str, long j) {
        if (file == null || !file.exists() || !file.isFile() || com.ucweb.common.util.n.a.a(str)) {
            return false;
        }
        String str2 = "";
        try {
            str2 = b(file, j);
            if (com.ucweb.common.util.n.a.a(str2)) {
                return false;
            }
        } catch (IOException e) {
        }
        return str.trim().toLowerCase(Locale.ENGLISH).equals(str2.trim().toLowerCase(Locale.ENGLISH));
    }

    public static String f(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        int i2;
        char charAt;
        String str2 = str.toString();
        for (CharSequence replace : a) {
            str2 = str2.replace(replace, "");
        }
        if (com.ucweb.common.util.n.a.a(str2)) {
            i2 = 0;
        } else {
            int length = str2.length();
            for (i2 = 0; i2 < length; i2++) {
                charAt = str2.charAt(i2);
                if ('?' <= charAt && charAt <= '?') {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
        }
        if (i2 == 0) {
            return str2;
        }
        if (com.ucweb.common.util.n.a.a(str2)) {
            return str2;
        }
        i2 = str2.length();
        StringBuilder stringBuilder = new StringBuilder(i2);
        while (i < i2) {
            charAt = str2.charAt(i);
            if (charAt < '?' || charAt > '?') {
                stringBuilder.append(charAt);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static boolean g(String str) {
        return h(str);
    }

    public static boolean h(String str) {
        boolean z = false;
        if (!com.ucweb.common.util.n.a.a(str)) {
            try {
                z = new File(str).exists();
            } catch (Exception e) {
            }
        }
        return z;
    }

    public static c i(String str) {
        c cVar = new c();
        try {
            StatFs statFs = new StatFs(str);
            cVar.b = (((long) statFs.getBlockSize()) * 1) * ((long) statFs.getAvailableBlocks());
            cVar.a = (((long) statFs.getBlockSize()) * 1) * ((long) statFs.getBlockCount());
        } catch (Throwable th) {
        }
        return cVar;
    }

    private static String l(String str) {
        try {
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            Matcher matcher = Pattern.compile("\\((\\d+)\\)$").matcher(str);
            if (matcher.find()) {
                CharSequence group = matcher.group(1);
                return str.replace(group, String.valueOf(Integer.parseInt(group) + 1));
            }
            return com.ucweb.common.util.n.a.a(str, "(1)");
        } catch (Exception e) {
            return com.ucweb.common.util.n.a.a("", "(1)");
        }
    }

    public static String j(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            return str;
        }
        String parent = file.getParent();
        if (com.ucweb.common.util.n.a.b(parent)) {
            str = j(parent);
        }
        if (!com.ucweb.common.util.n.a.b(file.getName())) {
            return str;
        }
        if (str.length() > 1) {
            str = com.ucweb.common.util.n.a.a(str, "/");
        }
        return m(com.ucweb.common.util.n.a.a(str, r0));
    }

    private static String m(String str) {
        File file;
        while (true) {
            file = new File(str);
            if (!file.exists()) {
                break;
            } else if (file.isDirectory()) {
                return str;
            } else {
                str = l(str);
            }
        }
        file = new File(str);
        boolean mkdir = file.mkdir();
        if (mkdir) {
            return str;
        }
        file.delete();
        String l = l(str);
        File file2 = new File(l);
        if (!file2.exists()) {
            mkdir = file2.mkdir();
        }
        if (mkdir || (file2.exists() && file2.isDirectory())) {
            return l;
        }
        return str;
    }

    public static String a(String str, String str2) {
        if (com.ucweb.common.util.n.a.a(str) || com.ucweb.common.util.n.a.a(str2)) {
            return str;
        }
        if (str.endsWith(File.separator)) {
            str = str.substring(0, str.length() - 1);
        }
        if (str2.startsWith(File.separator)) {
            str2 = str2.substring(1);
        }
        return str + File.separator + str2;
    }

    public static boolean a(File file, File file2) {
        boolean z = false;
        try {
            String canonicalPath = file.getCanonicalPath();
            String canonicalPath2 = file2.getCanonicalPath();
            if (!canonicalPath2.endsWith("/")) {
                canonicalPath2 = canonicalPath2 + "/";
            }
            z = canonicalPath.startsWith(canonicalPath2);
        } catch (IOException e) {
        }
        return z;
    }

    private static String a(File file, Charset charset) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = j(file);
            String a = com.ucweb.common.util.o.a.a(inputStream, b.a(charset));
            return a;
        } finally {
            com.ucweb.common.util.o.a.a(inputStream);
        }
    }

    public static byte[] f(File file) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = j(file);
            byte[] a = com.ucweb.common.util.o.a.a(inputStream, file.length());
            return a;
        } finally {
            com.ucweb.common.util.o.a.a(inputStream);
        }
    }

    private static FileInputStream j(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static String g(File file) throws IOException {
        return a(file, Charset.defaultCharset());
    }

    private static FileOutputStream k(File file) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (!(parentFile == null || parentFile.mkdirs() || parentFile.isDirectory())) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, false);
    }

    public static boolean h(File file) {
        try {
            if (file.isDirectory()) {
                l(file);
            }
        } catch (Exception e) {
        }
        try {
            return file.delete();
        } catch (Exception e2) {
            return false;
        }
    }

    private static void l(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Failed to list contents of " + file);
            }
            IOException iOException = null;
            for (File file2 : listFiles) {
                try {
                    if (file2.isDirectory()) {
                        i(file2);
                    } else {
                        boolean exists = file2.exists();
                        if (!file2.delete()) {
                            if (exists) {
                                throw new IOException("Unable to delete file: " + file2);
                            }
                            throw new FileNotFoundException("File does not exist: " + file2);
                        }
                    }
                } catch (IOException e) {
                    iOException = e;
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static void i(File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        if (file == null) {
            throw new NullPointerException("File must not be null");
        }
        Object obj;
        if (com.ucweb.common.util.o.c.a()) {
            obj = null;
        } else {
            File file2;
            if (file.getParent() != null) {
                file2 = new File(file.getParentFile().getCanonicalFile(), file.getName());
            } else {
                file2 = file;
            }
            if (file2.getCanonicalFile().equals(file2.getAbsoluteFile())) {
                obj = null;
            } else {
                obj = 1;
            }
        }
        if (obj == null) {
            l(file);
        }
        if (!file.delete()) {
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static void a(File file, String str) throws IOException {
        Charset defaultCharset = Charset.defaultCharset();
        OutputStream outputStream = null;
        try {
            outputStream = k(file);
            com.ucweb.common.util.o.a.a(str, outputStream, defaultCharset);
            outputStream.close();
        } finally {
            com.ucweb.common.util.o.a.a(outputStream);
        }
    }

    public static String a(String str, Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().getAssets().open(str)));
            String str2 = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return str2;
                }
                str2 = str2 + readLine;
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static void a(File file, byte[] bArr) throws IOException {
        OutputStream outputStream = null;
        try {
            outputStream = k(file);
            outputStream.write(bArr);
            outputStream.close();
        } finally {
            com.ucweb.common.util.o.a.a(outputStream);
        }
    }
}
