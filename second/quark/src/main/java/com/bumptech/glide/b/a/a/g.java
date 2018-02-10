package com.bumptech.glide.b.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.b.b.a.b;
import com.bumptech.glide.b.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ProGuard */
final class g {
    private static final a a = new a();
    private final a b;
    private final f c;
    private final b d;
    private final ContentResolver e;
    private final List<com.bumptech.glide.b.g> f;

    public g(List<com.bumptech.glide.b.g> list, f fVar, b bVar, ContentResolver contentResolver) {
        this(list, a, fVar, bVar, contentResolver);
    }

    private g(List<com.bumptech.glide.b.g> list, a aVar, f fVar, b bVar, ContentResolver contentResolver) {
        this.b = aVar;
        this.c = fVar;
        this.d = bVar;
        this.e = contentResolver;
        this.f = list;
    }

    public final int a(Uri uri) {
        InputStream openInputStream;
        Throwable th;
        InputStream inputStream = null;
        try {
            openInputStream = this.e.openInputStream(uri);
            try {
                int b = h.b(this.f, openInputStream, this.d);
                if (openInputStream == null) {
                    return b;
                }
                try {
                    openInputStream.close();
                    return b;
                } catch (IOException e) {
                    return b;
                }
            } catch (IOException e2) {
                inputStream = openInputStream;
                openInputStream = inputStream;
                try {
                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                        new StringBuilder("Failed to open uri: ").append(uri);
                    }
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return -1;
                } catch (Throwable th2) {
                    th = th2;
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (NullPointerException e5) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    new StringBuilder("Failed to open uri: ").append(uri);
                }
                if (openInputStream != null) {
                    openInputStream.close();
                }
                return -1;
            }
        } catch (IOException e6) {
            openInputStream = inputStream;
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                new StringBuilder("Failed to open uri: ").append(uri);
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
            return -1;
        } catch (NullPointerException e7) {
            openInputStream = null;
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                new StringBuilder("Failed to open uri: ").append(uri);
            }
            if (openInputStream != null) {
                openInputStream.close();
            }
            return -1;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openInputStream = null;
            th = th4;
            if (openInputStream != null) {
                openInputStream.close();
            }
            throw th;
        }
    }

    public final InputStream b(Uri uri) throws FileNotFoundException {
        InputStream inputStream = null;
        Cursor a = this.c.a(uri);
        if (a != null) {
            try {
                if (a.moveToFirst()) {
                    Object string = a.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        Uri uri2;
                        File file = new File(string);
                        if (!file.exists() || file.length() <= 0) {
                            uri2 = null;
                        } else {
                            uri2 = Uri.fromFile(file);
                        }
                        if (a != null) {
                            a.close();
                        }
                        if (uri2 != null) {
                            try {
                                inputStream = this.e.openInputStream(uri2);
                            } catch (Throwable e) {
                                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri2).initCause(e));
                            }
                        }
                    } else if (a != null) {
                        a.close();
                    }
                    return inputStream;
                }
            } catch (Throwable th) {
                if (a != null) {
                    a.close();
                }
            }
        }
        if (a != null) {
            a.close();
        }
        return inputStream;
    }
}
