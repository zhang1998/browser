package com.UCMobile.Apollo.text;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import com.UCMobile.Apollo.annotations.Keep;
import com.UCMobile.Apollo.text.a.c;
import com.UCMobile.Apollo.text.a.e;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/* compiled from: ProGuard */
public class SubtitleHelper implements Callback {
    private HandlerThread a;
    private g b;
    private c c;
    private SubtitleLayout d;
    private boolean e;
    private Handler f;
    private Context g;
    private PlayerPositionProvider h;
    private e i;

    private void a(String str) {
        try {
            this.i = new c().b(str.getBytes(), str.length());
        } catch (Exception e) {
            e.toString();
        }
    }

    private SubtitleHelper(Context context) {
        this.g = context;
        this.d = new SubtitleLayout(context);
    }

    public boolean handleMessage(Message message) {
        new StringBuilder("handleMessage ").append(message.toString()).append(" msg.arg1 ").append(message.arg1);
        switch (message.what) {
            case 0:
            case 2:
                if ((message.what != 0 || this.e) && (message.what != 2 || message.arg1 == 1)) {
                    this.e = true;
                } else {
                    this.e = false;
                    a((int) SecExceptionCode.SEC_ERROR_DYN_STORE);
                    int i = -1;
                    if (this.d != null) {
                        if (this.h != null) {
                            i = this.h.getCurrentPosition();
                        }
                        if (!(i < 0 || this.i == null || this.d == null)) {
                            List a = this.i.a(((long) i) * 1000);
                            if (a != null) {
                                new StringBuilder("set new Cue (time ").append(i).append("), cue count ").append(a.size()).append(", cueStr ").append(a.size() > 0 ? ((b) a.get(0)).a : "none");
                                this.d.a(a);
                            }
                        }
                    }
                }
                return true;
            case 1:
                this.d = null;
                this.f = null;
                return true;
            default:
                return false;
        }
    }

    private void a(int i) {
        if (this.i != null && this.d != null) {
            this.f.sendMessageDelayed(this.f.obtainMessage(0), (long) i);
        }
    }

    private void b() {
        this.c = new c();
        this.a = new HandlerThread("subtitleParser");
        this.a.start();
        this.b = new g(this.a.getLooper(), this.c);
        this.b.b();
        this.f = new Handler(this.g.getMainLooper(), this);
        a(0);
    }

    public final void a() {
        if (this.b != null) {
            this.b.a();
        }
        if (this.a != null) {
            this.a.interrupt();
            this.a.quit();
        }
        if (this.f != null) {
            this.f.sendMessage(this.f.obtainMessage(1));
        }
        this.g = null;
        this.h = null;
        this.i = null;
        this.b = null;
        this.c = null;
    }

    @Keep
    public View getSubtitleView() {
        return this.d;
    }

    @Keep
    public static SubtitleHelper createSubtitle(Map<String, String> map, Context context, PlayerPositionProvider playerPositionProvider) {
        if (context == null || map == null || playerPositionProvider == null) {
            return null;
        }
        SubtitleHelper subtitleHelper;
        String str = (String) map.get("filepath");
        String str2 = (String) map.get("content");
        SubtitleHelper subtitleHelper2;
        if (str != null) {
            if (context == null || playerPositionProvider == null) {
                subtitleHelper2 = null;
            } else {
                SubtitleHelper subtitleHelper3 = new SubtitleHelper(context);
                subtitleHelper3.h = playerPositionProvider;
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        long length = file.length() > 512000 ? 512000 : file.length();
                        if (length > 0) {
                            byte[] bArr = new byte[((int) length)];
                            long j = 0;
                            FileInputStream fileInputStream = new FileInputStream(file);
                            while (j < length) {
                                j += (long) fileInputStream.read(bArr, (int) j, (int) (length - j));
                            }
                            fileInputStream.close();
                            subtitleHelper3.i = new c().b(bArr, (int) j);
                        }
                    }
                } catch (Exception e) {
                    e.toString();
                }
                subtitleHelper3.b();
                subtitleHelper2 = subtitleHelper3;
            }
            subtitleHelper = subtitleHelper2;
        } else if (str2 == null) {
            return null;
        } else {
            if (context == null || playerPositionProvider == null) {
                subtitleHelper2 = null;
            } else {
                subtitleHelper2 = new SubtitleHelper(context);
                subtitleHelper2.h = playerPositionProvider;
                subtitleHelper2.a(str2);
                subtitleHelper2.b();
            }
            subtitleHelper = subtitleHelper2;
        }
        if (subtitleHelper == null) {
            return null;
        }
        SubtitleLayout subtitleLayout = subtitleHelper.d;
        if (((String) map.get("preset_style")) == "awesome") {
            subtitleLayout.a(new a(-1, 0, 0, 1, -65536, Typeface.DEFAULT));
        } else {
            str2 = (String) map.get("foreground_color");
            String str3 = (String) map.get("background_color");
            String str4 = (String) map.get("window_color");
            String str5 = (String) map.get("outline_color");
            String str6 = (String) map.get("has_outline");
            try {
                int parseColor = str2 != null ? Color.parseColor(str2) : -1;
                int parseColor2 = str3 != null ? Color.parseColor(str3) : 0;
                int parseColor3 = str4 != null ? Color.parseColor(str4) : 0;
                int i = (str6 == null || !str6.equals("true")) ? 0 : 1;
                subtitleLayout.a(new a(parseColor, parseColor2, parseColor3, i, str5 != null ? Color.parseColor(str5) : 0, Typeface.DEFAULT));
            } catch (IllegalArgumentException e2) {
            }
        }
        subtitleLayout.setBackgroundColor(0);
        return subtitleHelper;
    }

    @Keep
    public void pauseSubtitle(Map<String, String> map) {
        int i = 1;
        if (map != null) {
            int i2;
            String str = (String) map.get("start");
            if (str == null || !str.equals("true")) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.f != null) {
                Message obtainMessage = this.f.obtainMessage(2);
                if (i2 == 0) {
                    i = 0;
                }
                obtainMessage.arg1 = i;
                this.f.sendMessage(obtainMessage);
            }
        }
    }

    @Keep
    public void stopSubtitle() {
        a();
    }
}
