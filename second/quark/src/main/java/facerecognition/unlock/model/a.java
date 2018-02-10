package facerecognition.unlock.model;

import android.content.Context;
import com.yunos.faceunlock.facemanager.RegisteredFaceManager;

/* compiled from: ProGuard */
public final class a {
    public RegisteredFaceManager a = RegisteredFaceManager.getInstance(this.c);
    public FaceUnlockParams b;
    private Context c;

    public a(Context context) {
        this.c = context;
        if (this.b == null) {
            this.b = new DefaultFaceUnlockParams();
        }
    }
}
