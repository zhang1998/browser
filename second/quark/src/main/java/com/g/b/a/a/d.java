package com.g.b.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.g.b.a.d.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public final class d {
    private static final Uri a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");

    public static c a(Context context) {
        c b = b(context);
        if (b != null) {
            return b;
        }
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || resolveInfo.serviceInfo.applicationInfo.packageName == null || resolveInfo.serviceInfo.applicationInfo.packageName.length() == 0)) {
                b = b(context, resolveInfo.serviceInfo.applicationInfo.packageName);
                if (b != null) {
                    return b;
                }
            }
        }
        return null;
    }

    public static boolean a(Context context, String str) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            String str2 = "18da2bf10352443a00a5e046d9fca6bd";
            if (signatureArr == null) {
                return false;
            }
            for (Signature toByteArray : signatureArr) {
                if (str2.equals(com.g.b.a.d.d.a(toByteArray.toByteArray()))) {
                    a.a("check pass");
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static c b(Context context) {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            query = context.getContentResolver().query(a, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndex = query.getColumnIndex("support_api");
                int columnIndex2 = query.getColumnIndex("package");
                if (query.moveToFirst()) {
                    int i = -1;
                    try {
                        columnIndex = Integer.parseInt(query.getString(columnIndex));
                    } catch (NumberFormatException e2) {
                        columnIndex = i;
                    }
                    String string = query.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && a(context, string)) {
                        c cVar = new c();
                        cVar.a = string;
                        cVar.b = columnIndex;
                        if (query == null) {
                            return cVar;
                        }
                        query.close();
                        return cVar;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    a.a("ApiUtils", e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e4) {
            e = e4;
            query = null;
            a.a("ApiUtils", e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private static c b(Context context, String str) {
        InputStream inputStream;
        Exception e;
        Throwable th;
        if (context == null || str == null) {
            return null;
        }
        InputStream open;
        try {
            byte[] bArr = new byte[1024];
            open = context.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int read = open.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                if (TextUtils.isEmpty(stringBuilder.toString()) || !a(context, str)) {
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                        }
                    }
                    return null;
                }
                int optInt = new JSONObject(stringBuilder.toString()).optInt("support_api", -1);
                c cVar = new c();
                cVar.a = str;
                cVar.b = optInt;
                if (open == null) {
                    return cVar;
                }
                try {
                    open.close();
                    return cVar;
                } catch (IOException e3) {
                    return cVar;
                }
            } catch (NameNotFoundException e4) {
                inputStream = open;
            } catch (IOException e5) {
            } catch (JSONException e6) {
            } catch (Exception e7) {
                e = e7;
            }
        } catch (NameNotFoundException e8) {
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                }
            }
            return null;
        } catch (IOException e10) {
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e11) {
                }
            }
            return null;
        } catch (JSONException e12) {
            open = null;
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e13) {
                }
            }
            return null;
        } catch (Exception e14) {
            e = e14;
            open = null;
            try {
                a.a("ApiUtils", e.getMessage());
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e15) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e16) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            open = null;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }
}
