package com.uc.media.interfaces.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import com.uc.webview.export.annotations.Reflection;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Reflection
/* compiled from: ProGuard */
public class MediaMetadataUtil {
    private static final String LOGTAG = "MediaMetadataUtil";

    @Reflection
    /* compiled from: ProGuard */
    class MediaPlayerMetadataRetriever {
        public static final String ApolloMediaMetadataRetrieverPackName = "com.UCMobile.Apollo.ThumbnailUtils";
        private static final String METADATA_KEY_BITRATE = "METADATA_KEY_BITRATE";
        private static final String METADATA_KEY_DURATION = "METADATA_KEY_DURATION";
        private static String MediaMetadataRetrieverPackName = SystemMediaMetadataRetrieverPackName;
        public static final String SystemMediaMetadataRetrieverPackName = "android.media.MediaMetadataRetriever";
        private static Object mVideoCaptureObject = null;

        private MediaPlayerMetadataRetriever() {
        }

        public static void setMediaMetadataRetrieverPackName(String str) {
            if (str != null) {
                MediaMetadataRetrieverPackName = str;
            }
        }

        public static Object createMediaMetadataRetriever(String str) {
            if (MediaMetadataRetrieverPackName.equals(SystemMediaMetadataRetrieverPackName)) {
                if (VERSION.SDK_INT > 9) {
                    try {
                        new StringBuilder("Build.VERSION.SDK_INT = ").append(VERSION.SDK_INT).append(" create MediaMetadataRetriever by reflection.");
                        Object newInstance = Class.forName(MediaMetadataRetrieverPackName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        mVideoCaptureObject = newInstance;
                        if (!(newInstance == null || str == null)) {
                            boolean videoURI;
                            if (isLoacalFile(str)) {
                                videoURI = setVideoURI(str);
                            } else {
                                videoURI = setVideoURI(str, new HashMap());
                            }
                            if (!videoURI) {
                                Log.e(MediaMetadataUtil.LOGTAG, "create MediaPlayerMetadataRetriever success : " + mVideoCaptureObject + ", but initialize failed.");
                                release();
                            }
                        }
                    } catch (NoSuchMethodException e) {
                    } catch (Exception e2) {
                    }
                } else {
                    mVideoCaptureObject = null;
                }
                return mVideoCaptureObject;
            }
            new StringBuilder("create system player MediaMetadataRetriever error: illegal package name ").append(MediaMetadataRetrieverPackName);
            return null;
        }

        public static Bitmap getEmbeddedPicture() {
            if (MediaMetadataRetrieverPackName.equals(SystemMediaMetadataRetrieverPackName)) {
                if (mVideoCaptureObject != null) {
                    try {
                        Method declaredMethod = Class.forName(MediaMetadataRetrieverPackName).getDeclaredMethod("getEmbeddedPicture", new Class[0]);
                        if (declaredMethod != null) {
                            byte[] bArr = (byte[]) declaredMethod.invoke(mVideoCaptureObject, null);
                            if (bArr != null) {
                                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                            }
                            Log.e(MediaMetadataUtil.LOGTAG, "getEmbeddedPicture failed ,try getFrameAtTime ");
                            return getFrameAtTime();
                        }
                    } catch (NoSuchMethodException e) {
                    } catch (Throwable th) {
                    }
                }
                return null;
            }
            new StringBuilder("getEmbeddedPicture error: illegal package name ").append(MediaMetadataRetrieverPackName);
            return null;
        }

        public static Map<String, String> getMetadata() {
            Map<String, String> hashMap = new HashMap();
            String[] strArr = new String[]{METADATA_KEY_BITRATE, METADATA_KEY_DURATION};
            if (MediaMetadataRetrieverPackName.equals(SystemMediaMetadataRetrieverPackName)) {
                if (mVideoCaptureObject != null) {
                    try {
                        Class cls = Class.forName(MediaMetadataRetrieverPackName);
                        Method declaredMethod = cls.getDeclaredMethod("extractMetadata", new Class[]{Integer.TYPE});
                        if (declaredMethod != null) {
                            for (int i = 0; i < 2; i++) {
                                int i2 = cls.getDeclaredField(strArr[i]).getInt(mVideoCaptureObject);
                                String str = (String) declaredMethod.invoke(mVideoCaptureObject, new Object[]{Integer.valueOf(i2)});
                                if (str != null) {
                                    hashMap.put(strArr[i], str);
                                    new StringBuilder("getMetadata \"").append(strArr[i]).append("\": ").append(str);
                                } else {
                                    Log.e(MediaMetadataUtil.LOGTAG, "getMetadata \"" + strArr[i] + "\"  failed.");
                                }
                            }
                            return hashMap;
                        }
                    } catch (NoSuchMethodException e) {
                    } catch (Exception e2) {
                    }
                }
                return null;
            }
            new StringBuilder("getMetadata error: illegal package name ").append(MediaMetadataRetrieverPackName);
            return null;
        }

        private static Bitmap getFrameAtTime() {
            if (MediaMetadataRetrieverPackName.equals(SystemMediaMetadataRetrieverPackName)) {
                if (mVideoCaptureObject != null) {
                    try {
                        Method declaredMethod = Class.forName(MediaMetadataRetrieverPackName).getDeclaredMethod("getFrameAtTime", new Class[0]);
                        if (declaredMethod != null) {
                            return (Bitmap) declaredMethod.invoke(mVideoCaptureObject, null);
                        }
                    } catch (NoSuchMethodException e) {
                    } catch (Exception e2) {
                    }
                }
                return null;
            }
            new StringBuilder("getFrameAtTime error: illegal package name ").append(MediaMetadataRetrieverPackName);
            return null;
        }

        public static void release() {
            if (mVideoCaptureObject != null) {
                try {
                    Method declaredMethod = Class.forName(MediaMetadataRetrieverPackName).getDeclaredMethod("release", new Class[0]);
                    if (declaredMethod != null) {
                        declaredMethod.invoke(mVideoCaptureObject, null);
                    }
                } catch (NoSuchMethodException e) {
                } catch (Exception e2) {
                }
                mVideoCaptureObject = null;
            }
        }

        private static boolean setVideoURI(String str) {
            if (mVideoCaptureObject != null) {
                try {
                    if (str.indexOf("file:///") != -1) {
                        str = str.replace("file:///", "file://");
                    }
                    Method declaredMethod = Class.forName(MediaMetadataRetrieverPackName).getDeclaredMethod("setDataSource", new Class[]{FileDescriptor.class});
                    if (declaredMethod != null) {
                        FileInputStream fileInputStream = new FileInputStream(new File(str));
                        declaredMethod.invoke(mVideoCaptureObject, new Object[]{fileInputStream.getFD()});
                        fileInputStream.close();
                        return true;
                    }
                    Log.e(MediaMetadataUtil.LOGTAG, "set datasource for MediaMetadataRetriever error : getDeclaredMethod failed.");
                } catch (NoSuchMethodException e) {
                } catch (Exception e2) {
                }
            }
            return false;
        }

        private static boolean setVideoURI(String str, Map<String, String> map) {
            if (mVideoCaptureObject != null) {
                try {
                    Method declaredMethod = Class.forName(MediaMetadataRetrieverPackName).getDeclaredMethod("setDataSource", new Class[]{String.class, Map.class});
                    if (declaredMethod != null) {
                        declaredMethod.invoke(mVideoCaptureObject, new Object[]{str, map});
                        return true;
                    }
                    Log.e(MediaMetadataUtil.LOGTAG, "set datasource for MediaMetadataRetriever error : getDeclaredMethod failed.");
                } catch (NoSuchMethodException e) {
                } catch (Exception e2) {
                }
            }
            return false;
        }

        private static boolean isLoacalFile(String str) {
            if (str.indexOf("http://") != -1) {
                return false;
            }
            if (str.indexOf("file:///") != -1) {
                str = str.replace("file:///", "file://");
            }
            new StringBuilder().append(str).append(" is local file.");
            return true;
        }
    }

    /* compiled from: ProGuard */
    class MetadataCache {
        public static String mBitrate;
        public static String mDataSource;
        public static String mDuration;

        private MetadataCache() {
        }
    }

    private static boolean getVideoThumbnailBySystemPlayer(String str, Rect rect, Bitmap bitmap) {
        if (bitmap == null || rect == null || rect.width() == 0 || rect.height() == 0) {
            Log.e(LOGTAG, "Bitmap object is null or target Rect is 0.");
            return false;
        }
        MediaPlayerMetadataRetriever.setMediaMetadataRetrieverPackName(MediaPlayerMetadataRetriever.SystemMediaMetadataRetrieverPackName);
        if (MediaPlayerMetadataRetriever.createMediaMetadataRetriever(str) == null) {
            return false;
        }
        boolean z;
        Bitmap embeddedPicture = MediaPlayerMetadataRetriever.getEmbeddedPicture();
        if (embeddedPicture != null) {
            Rect rect2 = new Rect(0, 0, embeddedPicture.getWidth(), embeddedPicture.getHeight());
            new StringBuilder("video frame source : ").append(embeddedPicture.getWidth()).append(" X ").append(embeddedPicture.getHeight());
            new Canvas(bitmap).drawBitmap(embeddedPicture, rect2, rect, null);
            z = true;
        } else {
            z = false;
        }
        Map metadata = MediaPlayerMetadataRetriever.getMetadata();
        if (metadata != null) {
            MetadataCache.mDataSource = str;
            MetadataCache.mBitrate = (String) metadata.get("METADATA_KEY_BITRATE");
            MetadataCache.mDuration = (String) metadata.get("METADATA_KEY_DURATION");
        }
        MediaPlayerMetadataRetriever.release();
        return z;
    }

    public static synchronized boolean getVideoThumbnail(Context context, String str, Rect rect, Bitmap bitmap) {
        boolean z = false;
        synchronized (MediaMetadataUtil.class) {
            if (!(bitmap == null || rect == null)) {
                if (!(rect.width() == 0 || rect.height() == 0)) {
                    try {
                        boolean z2;
                        Bitmap bitmap2 = (Bitmap) Class.forName(MediaPlayerMetadataRetriever.ApolloMediaMetadataRetrieverPackName).getDeclaredMethod("createVideoThumbnail", new Class[]{Context.class, String.class, Integer.TYPE}).invoke(null, new Object[]{context, str, Integer.valueOf(-1)});
                        if (bitmap2 != null) {
                            Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
                            new StringBuilder("video frame source : ").append(bitmap2.getWidth()).append(" X ").append(bitmap2.getHeight());
                            new Canvas(bitmap).drawBitmap(bitmap2, rect2, rect, null);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z = z2;
                    } catch (Exception e) {
                        new StringBuilder("createVideoThumbnail error : ").append(e);
                    }
                    if (!z) {
                        z = getVideoThumbnailBySystemPlayer(str, rect, bitmap);
                    }
                }
            }
            Log.e(LOGTAG, "Bitmap object is null or target Rect is 0.");
        }
        return z;
    }
}
