package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.UCMobile.Apollo.MediaPlayer;
import com.taobao.weex.ui.component.ab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

/* compiled from: ProGuard */
public class FileProvider extends ContentProvider {
    private static final String[] a = new String[]{"_display_name", "_size"};
    private static final File b = new File("/");
    private static HashMap<String, j> c = new HashMap();
    private j d;

    public boolean onCreate() {
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.d = a(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        File a = this.d.a(uri);
        if (strArr == null) {
            strArr = a;
        }
        Object obj2 = new String[strArr.length];
        Object obj3 = new Object[strArr.length];
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            obj = strArr[i];
            if ("_display_name".equals(obj)) {
                obj2[i2] = "_display_name";
                i3 = i2 + 1;
                obj3[i2] = a.getName();
            } else if ("_size".equals(obj)) {
                obj2[i2] = "_size";
                i3 = i2 + 1;
                obj3[i2] = Long.valueOf(a.length());
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        obj = new String[i2];
        System.arraycopy(obj2, 0, obj, 0, i2);
        Object obj4 = new Object[i2];
        System.arraycopy(obj3, 0, obj4, 0, i2);
        Cursor matrixCursor = new MatrixCursor(obj, 1);
        matrixCursor.addRow(obj4);
        return matrixCursor;
    }

    public String getType(Uri uri) {
        File a = this.d.a(uri);
        int lastIndexOf = a.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.d.a(uri).delete() ? 1 : 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int i;
        File a = this.d.a(uri);
        if ("r".equals(str)) {
            i = MediaPlayer.MEDIA_ERROR_UNKNOWN;
        } else if (ab.PROP_FS_WRAP_CONTENT.equals(str) || "wt".equals(str)) {
            i = 738197504;
        } else if ("wa".equals(str)) {
            i = 704643072;
        } else if ("rw".equals(str)) {
            i = 939524096;
        } else if ("rwt".equals(str)) {
            i = 1006632960;
        } else {
            throw new IllegalArgumentException("Invalid mode: " + str);
        }
        return ParcelFileDescriptor.open(a, i);
    }

    private static j a(Context context, String str) {
        j jVar;
        Object a;
        synchronized (c) {
            jVar = (j) c.get(str);
            if (jVar == null) {
                try {
                    jVar = new d(str);
                    XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
                    if (loadXmlMetaData == null) {
                        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
                    }
                    while (true) {
                        int next = loadXmlMetaData.next();
                        if (next == 1) {
                            break;
                        } else if (next == 2) {
                            String name = loadXmlMetaData.getName();
                            CharSequence attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                            String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                            if ("root-path".equals(name)) {
                                a = a(b, attributeValue2);
                            } else if ("files-path".equals(name)) {
                                a = a(context.getFilesDir(), attributeValue2);
                            } else if ("cache-path".equals(name)) {
                                a = a(context.getCacheDir(), attributeValue2);
                            } else if ("external-path".equals(name)) {
                                a = a(Environment.getExternalStorageDirectory(), attributeValue2);
                            } else {
                                a = null;
                            }
                            if (a == null) {
                                continue;
                            } else if (TextUtils.isEmpty(attributeValue)) {
                                throw new IllegalArgumentException("Name must not be empty");
                            } else {
                                jVar.a.put(attributeValue, a.getCanonicalFile());
                            }
                        }
                    }
                    c.put(str, jVar);
                } catch (Throwable e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + a, e);
                } catch (Throwable e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                } catch (Throwable e22) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e22);
                }
            }
        }
        return jVar;
    }

    private static File a(File file, String... strArr) {
        int i = 0;
        File file2 = file;
        while (i <= 0) {
            File file3;
            String str = strArr[0];
            if (str != null) {
                file3 = new File(file2, str);
            } else {
                file3 = file2;
            }
            i++;
            file2 = file3;
        }
        return file2;
    }
}
