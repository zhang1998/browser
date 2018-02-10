package com.tencent.mm.sdk.modelbiz;

import com.tencent.mm.sdk.modelbase.BaseReq;

public class OpenRankList {

    public class Req extends BaseReq {
        public boolean checkArgs() {
            return true;
        }

        public int getType() {
            return 11;
        }
    }
}
