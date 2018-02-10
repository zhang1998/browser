package com.UCMobile.Apollo.protocol;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: ProGuard */
public class AndroidContent {
    public static final String TAG = "AndroidContent";
    private FileDescriptor a = null;
    private AssetFileDescriptor b;
    private Context c;
    private boolean d = false;

    public static AndroidContent createAndroidContent(Context context) {
        return new AndroidContent(context);
    }

    private AndroidContent(Context context) {
        this.c = context;
    }

    public FileDescriptor getFileDescriptor() {
        return this.a;
    }

    public boolean open(String str) {
        try {
            this.a = this.c.getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r").getFileDescriptor();
            return true;
        } catch (FileNotFoundException e) {
            new StringBuilder("FileNotFoundException ").append(e.toString());
            return false;
        }
    }

    public void close() {
        if (this.d) {
            try {
                this.d = false;
                this.b.close();
            } catch (IOException e) {
                new StringBuilder("IOException ").append(e.toString());
            }
        }
    }
}
