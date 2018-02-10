package com.uc.quark.filedownloader.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.uc.quark.filedownloader.e.e;

/* compiled from: ProGuard */
public class FileStatusContentProvider extends ContentProvider {
    private String a;
    private SQLiteDatabase b;
    private UriMatcher c;

    public boolean onCreate() {
        this.b = new b(getContext()).getWritableDatabase();
        e.c = getContext().getPackageName() + ".provider";
        e.a = "content://" + e.c + "/filestatus";
        e.b = "content://" + e.c + "/threadnum";
        this.a = "vnd.android.cursor.dir/vnd." + e.c + ".";
        this.c = new UriMatcher(-1);
        this.c.addURI(e.c, "filestatus", 0);
        this.c.addURI(e.c, "threadnum", 1);
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object a = a(uri);
        if (!TextUtils.isEmpty(a)) {
            return this.b.query(a, strArr, str, strArr2, null, null, str2, null);
        }
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    public String getType(Uri uri) {
        return this.a + a(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        Object a = a(uri);
        if (TextUtils.isEmpty(a)) {
            throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        this.b.insert(a, null, contentValues);
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        Object a = a(uri);
        if (!TextUtils.isEmpty(a)) {
            return this.b.delete(a, str, strArr);
        }
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Object a = a(uri);
        if (!TextUtils.isEmpty(a)) {
            return this.b.update(a, contentValues, str, strArr);
        }
        throw new IllegalArgumentException("Unsupported URI: " + uri);
    }

    private String a(Uri uri) {
        switch (this.c.match(uri)) {
            case 0:
                return "filestatus";
            case 1:
                return "threadnum";
            default:
                return null;
        }
    }
}
