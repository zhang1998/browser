package facerecognition.unlock;

import android.database.Cursor;
import com.ucweb.common.util.h.m;
import com.yunos.faceunlock.FaceCompareResult;
import com.yunos.faceunlock.FaceDetectResult;
import com.yunos.faceunlock.FaceLockUtil;
import com.yunos.faceunlock.facemanager.RegisteredFaceManager;
import com.yunos.faceunlock.utils.SPManager;
import com.yunos.faceunlock.utils.Util;
import facerecognition.unlock.model.a;

/* compiled from: ProGuard */
final class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        int i;
        if (this.a.l == null) {
            FaceLockUtil.initialize(this.a.c, 480, 640, this.a.i, this.a.j);
            this.a.l = new a(this.a.c);
            this.a.e = this.a.l.b;
            this.a.f = ((Boolean) SPManager.newInstance(this.a.c).get("facelockBlinkSwitch", Boolean.valueOf(false))).booleanValue();
            FaceLockUtil.reset();
            Cursor queryAll = this.a.l.a.queryAll();
            String[] strArr = new String[queryAll.getCount()];
            String[] strArr2 = new String[queryAll.getCount()];
            i = 0;
            while (queryAll.moveToNext()) {
                strArr[i] = queryAll.getString(queryAll.getColumnIndex(RegisteredFaceManager.COLUMN_FEATURE));
                strArr2[i] = queryAll.getString(queryAll.getColumnIndex(RegisteredFaceManager.COLUMN_NAME));
                i++;
            }
            FaceLockUtil.unlockSetFaceModel(strArr2, strArr, queryAll.getCount());
            queryAll.close();
        }
        if (((double) this.a.d.length) >= ((double) (this.a.m.width * this.a.m.height)) * 1.5d) {
            if (this.a.n == 3) {
                this.a.d = Util.rotateYUV420Degree180(this.a.d, this.a.m.width, this.a.m.height);
            }
            i = this.a.m.width * this.a.m.height;
            if (this.a.g == null || this.a.g.length < i) {
                this.a.g = new byte[i];
            }
            System.arraycopy(this.a.d, 0, this.a.g, 0, i);
            if (this.a.e.a == 0 || this.a.e.a == 2) {
                try {
                    if (!this.a.k) {
                        FaceLockUtil.setFace(this.a.g);
                        FaceDetectResult detectFace = FaceLockUtil.detectFace();
                        new StringBuilder("result.isLive() = ").append(detectFace.isLive()).append(" result.hasFace() = ").append(detectFace.hasFace());
                        if (detectFace.hasFace() && (!this.a.f || detectFace.isLive())) {
                            boolean z;
                            b bVar = this.a;
                            FaceCompareResult unlockCompareFace = FaceLockUtil.unlockCompareFace();
                            if (unlockCompareFace != null) {
                                new StringBuilder("ret.getScore() = ").append(unlockCompareFace.getScore());
                                if (unlockCompareFace.getError_flag() != 1) {
                                    m.a(2, new a(bVar, unlockCompareFace));
                                } else {
                                    if (bVar.p == 0) {
                                        bVar.p = System.currentTimeMillis();
                                    }
                                    new StringBuilder("firstFaceAt = ").append(bVar.p);
                                    unlockCompareFace.toString();
                                    if (unlockCompareFace.getScore() > bVar.o) {
                                        bVar.o = unlockCompareFace.getScore();
                                    }
                                    if (unlockCompareFace.getScore() > bVar.e.d) {
                                        bVar.b = true;
                                        bVar.l = null;
                                        m.a(2, new e(bVar));
                                        z = true;
                                    } else {
                                        bVar.b = false;
                                        bVar.a = false;
                                        m.a(2, new d(bVar));
                                        if (System.currentTimeMillis() - bVar.p > ((long) (bVar.e.b * 1000))) {
                                            new StringBuilder("stop = true; System.currentTimeMillis() = ").append(System.currentTimeMillis());
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            z = true;
                                        }
                                    }
                                    if (z) {
                                        return;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                return;
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                }
            }
            this.a.a = false;
        }
    }
}
