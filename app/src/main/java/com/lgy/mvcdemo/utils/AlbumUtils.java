package com.lgy.mvcdemo.utils;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;

import com.lgy.mvcdemo.R;
import com.lgy.mvcdemo.listener.AlbumImageListener;
import com.yanzhenjie.album.Action;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumFile;
import com.yanzhenjie.album.api.widget.Widget;

import java.util.ArrayList;

/**
 * Created by ${lgy} on 2018/2/514:24
 * 邮箱1343168198@qq.com
 * 描述： describe
 * 修改内容：
 */

public class AlbumUtils {
    /**
     * 图片选择封装器
     *
     * @param context            上下文
     * @param requestCode        请求码
     * @param maxSelectCount     最大选择数量
     * @param albumImageListener 回调监听
     */
    public static void albumImage(Context context, int requestCode, int maxSelectCount, final AlbumImageListener albumImageListener) {
        Album.image(context) // 选择图片。
                .multipleChoice()
                .requestCode(requestCode)
                .camera(true)
                .columnCount(2)
                .selectCount(maxSelectCount)
                .checkedList(null)
                .filterSize(null)
                .filterMimeType(null)
                .afterFilterVisibility(true) // 显示被过滤掉的文件，但它们是不可用的。
                .widget(Widget.newDarkBuilder(context)
                        .title("选择图片") // 标题。
                        .statusBarColor(UIUtils.getColor(R.color.white)) // 状态栏颜色。
                        .toolBarColor(UIUtils.getColor(R.color.album_color)) // Toolbar颜色。
                        .navigationBarColor(Color.WHITE) // Android5.0+的虚拟导航栏颜色。
                        .mediaItemCheckSelector(Color.WHITE, Color.BLUE) // 图片或者视频选择框的选择器。
                        .bucketItemCheckSelector(UIUtils.getColor(R.color.album_color), Color.BLUE) // 切换文件夹时文件夹选择框的选择器。
                        .buttonStyle( // 用来配置当没有发现图片/视频时的拍照按钮和录视频按钮的风格。
                                Widget.ButtonStyle.newLightBuilder(context) // 同Widget的Builder模式。
                                        .setButtonSelector(Color.WHITE, Color.WHITE) // 按钮的选择器。
                                        .build()
                        )
                        .build())
                .onResult(new Action<ArrayList<AlbumFile>>() {
                    @Override
                    public void onAction(int requestCode, @NonNull ArrayList<AlbumFile> result) {

                        ArrayList<String> parseResult = new ArrayList<>();
                        for (AlbumFile albumFile : result) {
                            parseResult.add(albumFile.getPath());
                        }
                        albumImageListener.onResult(requestCode, parseResult);
                    }
                })
                .onCancel(new Action<String>() {
                    @Override
                    public void onAction(int requestCode, @NonNull String result) {
                        albumImageListener.onCancel(requestCode, result);
                    }
                })
                .start();
    }
}
