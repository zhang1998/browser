package com.taobao.weex.b.a;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.mini.support.annotation.Nullable;
import android.net.Uri;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.c;
import com.taobao.weex.common.o;
import com.taobao.weex.utils.WXLogUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.android.spdy.SpdyProtocol;

/* compiled from: ProGuard */
public class a extends o {
    private final String a = "WEEX_CLIP_KEY_MAIN";

    @JSMethod
    public void setString(String str) {
        if (str != null) {
            ((ClipboardManager) this.b.b().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("WEEX_CLIP_KEY_MAIN", str));
        }
    }

    @JSMethod
    public void getString(@Nullable c cVar) {
        Context b = this.b.b();
        ClipboardManager clipboardManager = (ClipboardManager) b.getSystemService("clipboard");
        Map hashMap = new HashMap(2);
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null || primaryClip.getItemCount() <= 0) {
            hashMap.put("result", "failed");
            hashMap.put("data", "");
        } else {
            CharSequence a = a(b, primaryClip.getItemAt(0));
            hashMap.put("result", a != null ? "success" : "failed");
            hashMap.put("data", a != null ? a : "");
        }
        if (cVar != null) {
            cVar.a(hashMap);
        }
    }

    @Nullable
    private static CharSequence a(Context context, Item item) {
        FileInputStream createInputStream;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        FileInputStream fileInputStream;
        Throwable e;
        InputStreamReader inputStreamReader3 = null;
        CharSequence text = item.getText();
        if (text != null) {
            return text;
        }
        Uri uri = item.getUri();
        if (uri != null) {
            try {
                createInputStream = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null).createInputStream();
                try {
                    inputStreamReader = new InputStreamReader(createInputStream, "UTF-8");
                } catch (FileNotFoundException e2) {
                    inputStreamReader2 = null;
                    fileInputStream = createInputStream;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    return uri.toString();
                } catch (IOException e5) {
                    e = e5;
                    try {
                        WXLogUtils.w("ClippedData Failure loading text.", e);
                        if (inputStreamReader3 != null) {
                            try {
                                inputStreamReader3.close();
                            } catch (IOException e6) {
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                        return uri.toString();
                    } catch (Throwable th) {
                        e = th;
                        if (inputStreamReader3 != null) {
                            try {
                                inputStreamReader3.close();
                            } catch (IOException e8) {
                            }
                        }
                        if (createInputStream != null) {
                            try {
                                createInputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        throw e;
                    }
                }
                try {
                    StringBuilder stringBuilder = new StringBuilder(128);
                    char[] cArr = new char[SpdyProtocol.SLIGHTSSL_1_RTT_MODE];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        stringBuilder.append(cArr, 0, read);
                    }
                    text = stringBuilder.toString();
                    try {
                        inputStreamReader.close();
                    } catch (IOException e10) {
                    }
                    if (createInputStream == null) {
                        return text;
                    }
                    try {
                        createInputStream.close();
                        return text;
                    } catch (IOException e11) {
                        return text;
                    }
                } catch (FileNotFoundException e12) {
                    fileInputStream = createInputStream;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return uri.toString();
                } catch (IOException e13) {
                    e = e13;
                    inputStreamReader3 = inputStreamReader;
                    WXLogUtils.w("ClippedData Failure loading text.", e);
                    if (inputStreamReader3 != null) {
                        inputStreamReader3.close();
                    }
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    return uri.toString();
                } catch (Throwable th2) {
                    e = th2;
                    inputStreamReader3 = inputStreamReader;
                    if (inputStreamReader3 != null) {
                        inputStreamReader3.close();
                    }
                    if (createInputStream != null) {
                        createInputStream.close();
                    }
                    throw e;
                }
            } catch (FileNotFoundException e14) {
                inputStreamReader2 = null;
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return uri.toString();
            } catch (IOException e15) {
                e = e15;
                createInputStream = null;
                WXLogUtils.w("ClippedData Failure loading text.", e);
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                if (createInputStream != null) {
                    createInputStream.close();
                }
                return uri.toString();
            } catch (Throwable th3) {
                e = th3;
                createInputStream = null;
                if (inputStreamReader3 != null) {
                    inputStreamReader3.close();
                }
                if (createInputStream != null) {
                    createInputStream.close();
                }
                throw e;
            }
        }
        Intent intent = item.getIntent();
        return intent != null ? intent.toUri(1) : null;
    }
}
