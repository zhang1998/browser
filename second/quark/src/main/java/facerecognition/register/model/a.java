package facerecognition.register.model;

import android.content.Context;
import com.yunos.faceunlock.FaceLockUtil;
import com.yunos.faceunlock.FaceSetupParams;
import com.yunos.faceunlock.facemanager.RegisteredFaceManager;

/* compiled from: ProGuard */
public final class a {
    public RegisteredFaceManager a = RegisteredFaceManager.getInstance(this.c);
    public String b = this.a.getNewFaceName();
    private Context c;
    private FaceSetupParams d;

    public a(Context context) {
        this.c = context;
        if (this.d == null) {
            this.d = new DefaultFaceSetupParams();
        }
        if (FaceLockUtil.isFacelockEnabled(this.c) && this.b != null && !this.b.trim().equals("")) {
            this.a.getRegisteredCount();
            FaceLockUtil.setupSetParams(this.d);
        }
    }
}
