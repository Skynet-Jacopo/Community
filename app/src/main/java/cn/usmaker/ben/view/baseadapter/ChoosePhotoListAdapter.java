/*
 * Copyright (C) 2014 pengjianbo(pengjianbosoft@gmail.com), Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package cn.usmaker.ben.view.baseadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.List;

import cn.finalteam.toolsfinal.DeviceUtils;
import cn.usmaker.community.Photo;
import cn.usmaker.community.R;
import lib.lhh.fiv.library.FrescoZoomImageView;

/**
 * Desction:
 * Author:pengjianbo
 * Date:15/12/1 下午8:42
 */
public class ChoosePhotoListAdapter extends BaseAdapter {
    private List<Photo>    mList;
    private LayoutInflater mInflater;
    private int            mScreenWidth;

    public ChoosePhotoListAdapter(Activity activity, List<Photo> list) {
        this.mList = list;
        this.mInflater = LayoutInflater.from(activity);
        this.mScreenWidth = DeviceUtils.getScreenPix(activity).widthPixels;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FrescoZoomImageView ivPhoto = (FrescoZoomImageView) mInflater.inflate(R.layout.frescoimage, null);
        setHeight(ivPhoto);
        Photo photo = mList.get(position);
        //ImageLoader.getInstance().displayImage("file:/" + photoInfo.getPhotoPath(), ivPhoto, options);
        if (photo.type==1){
            ivPhoto.loadLocalImage("file://" + photo.getPath(),R.drawable.camera);
        }else {
            ivPhoto.loadLocalImage("",photo.getId());
        }
        return ivPhoto;
    }

    private void setHeight(final View convertView) {
        int height = mScreenWidth / 3 - 8;
        convertView.setLayoutParams(new AbsListView.LayoutParams(20, 20));
    }
}
