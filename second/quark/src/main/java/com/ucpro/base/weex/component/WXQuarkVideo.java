package com.ucpro.base.weex.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.quark.browser.R;
import com.taobao.weex.ac;
import com.taobao.weex.common.k;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.ab;
import com.taobao.weex.ui.component.bv;
import com.taobao.weex.utils.i;
import com.tencent.tinker.loader.shareutil.ShareElfFile.SectionHeader;
import com.ucpro.feature.video.ae;
import com.ucpro.feature.video.au;
import com.ucpro.ui.c.a;

@Keep
/* compiled from: ProGuard */
public class WXQuarkVideo extends ab<FrameLayout> implements au {
    private FrameLayout mConatiner;
    private int mControllType = 1;
    private TextView mDuration;
    private String mPageUrl = "";
    private View mPlayBtn;
    private ImageView mPoster;
    private FrameLayout mPosterContainer;
    private String mVideoTitle = "";
    private String mVideoUrl = "";
    private ae mVideoViewWrapper;

    public WXQuarkVideo(ac acVar, com.taobao.weex.c.ae aeVar, bv bvVar) {
        super(acVar, aeVar, bvVar);
    }

    protected FrameLayout initComponentHostView(@NonNull Context context) {
        this.mConatiner = new c(this, context);
        this.mPosterContainer = new FrameLayout(context);
        this.mConatiner.addView(this.mPosterContainer);
        this.mPoster = new ImageView(context);
        this.mPoster.setScaleType(ScaleType.FIT_XY);
        if (VERSION.SDK_INT >= 16) {
            this.mPoster.setCropToPadding(true);
        }
        this.mPosterContainer.addView(this.mPoster);
        int c = a.c((int) R.dimen.weex_quark_video_play_btn_margin_right);
        int c2 = a.c((int) R.dimen.weex_quark_video_play_btn_margin_bottom);
        this.mPlayBtn = new View(context);
        int c3 = a.c((int) R.dimen.weex_quark_video_play_btn_width);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(c3, c3);
        layoutParams.gravity = 85;
        layoutParams.rightMargin = c;
        layoutParams.bottomMargin = c2;
        this.mPosterContainer.addView(this.mPlayBtn, layoutParams);
        this.mDuration = new TextView(getContext());
        this.mDuration.setTextSize(0, (float) a.c((int) R.dimen.weex_quark_video_duration_textsize));
        LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        c2 = a.c((int) R.dimen.weex_quark_video_duration_margin);
        layoutParams2.setMargins(c2, 0, 0, c2);
        layoutParams2.gravity = 83;
        this.mPosterContainer.addView(this.mDuration, layoutParams2);
        this.mPosterContainer.setOnClickListener(new b(this));
        onThemeChanged();
        return this.mConatiner;
    }

    private void onThemeChanged() {
        this.mPlayBtn.setBackgroundDrawable(a.a("lightapp_video_play.svg"));
        if (a.b()) {
            this.mPoster.setColorFilter(SectionHeader.SHT_LOUSER);
        } else {
            this.mPoster.setColorFilter(null);
        }
        this.mDuration.setTextColor(a.c("default_background_white"));
    }

    @WXComponentProp(name = "posterUrl")
    public void setPosterUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri a = getInstance().a(Uri.parse(str));
            if ("local".equals(a.getScheme())) {
                setLocalSrc(a);
            } else {
                setRemoteSrc(a);
            }
        }
    }

    @WXComponentProp(name = "videoUrl")
    public void setVideoUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoUrl = str;
        }
    }

    @WXComponentProp(name = "videoTitle")
    public void setVideoTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mVideoTitle = str;
        }
    }

    @WXComponentProp(name = "pageUrl")
    public void setPageUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mPageUrl = str;
        }
    }

    @WXComponentProp(name = "videoDuration")
    public void setDuration(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDuration.setText(str);
        }
    }

    @WXComponentProp(name = "controllType")
    public void setControllType(int i) {
        this.mControllType = i;
    }

    @WXComponentProp(name = "themeType")
    public void themeType(String str) {
        onThemeChanged();
    }

    private void setLocalSrc(Uri uri) {
        Drawable a = i.a(getContext(), uri);
        if (a != null) {
            ImageView imageView = this.mPoster;
            if (imageView != null) {
                imageView.setImageDrawable(a);
            }
        }
    }

    private void setRemoteSrc(Uri uri) {
        int i = 1;
        k kVar = new k();
        kVar.a = i;
        kVar.b = getDomObject().i().b() == com.taobao.weex.common.i.b ? i : false;
        String a = getDomObject().g().a();
        if (a != null) {
            try {
                i = Integer.valueOf(a).intValue();
            } catch (Exception e) {
            }
        }
        kVar.c = Math.min(10, Math.max(0, i));
        kVar.e = new d(this);
        a = null;
        if (getDomObject().i().containsKey("placeholder")) {
            a = (String) getDomObject().i().get("placeholder");
        } else if (getDomObject().i().containsKey("placeHolder")) {
            a = (String) getDomObject().i().get("placeHolder");
        }
        if (a != null) {
            kVar.d = getInstance().a(Uri.parse(a)).toString();
        }
        getInstance();
        com.taobao.weex.a.k d = ac.d();
        if (d != null) {
            d.a(uri.toString(), this.mPoster, getDomObject().i().a(), kVar);
        }
    }

    public void onDestory() {
    }
}
