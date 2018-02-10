package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;

/* compiled from: ProGuard */
public class SimulatorDetect {
    private Context context;

    public SimulatorDetect(Context context) {
        if (context != null) {
            this.context = context.getApplicationContext();
        }
    }

    public boolean isSimulator() throws JAQException {
        try {
            ISimulatorDetectComponent simulatorDetectComp = SecurityGuardManager.getInstance(this.context).getSimulatorDetectComp();
            if (simulatorDetectComp != null) {
                return simulatorDetectComp.isSimulator();
            }
            throw new SecException(SecExceptionCode.SEC_ERROR_SIMULATORDETECT_UNSUPPORTED);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
