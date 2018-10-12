package com.mediatechindo.wahyu.materialuikit.template.WalktroughCategory.Style4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;
import com.mediatechindo.wahyu.materialuikit.tools.ImageViewCircleTransform;

/**
 * Created by wahyu on 15/11/16.
 */

@SuppressLint("ValidFragment")
public class WalkthroughStyle4Fragment extends Fragment {
    int wizard_page_position;

    public WalkthroughStyle4Fragment(int position) {
        this.wizard_page_position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout_id = R.layout.walkthrough4_page1;
        switch (wizard_page_position) {
            case 0:
                layout_id = R.layout.walkthrough4_page1;
                break;

            case 1:
                layout_id = R.layout.walkthrough4_page2;
                break;

            case 2:
                layout_id = R.layout.walkthrough4_page3;
                break;

            case 3:
                layout_id = R.layout.walkthrough4_page4;
                break;
        }

        View view = inflater.inflate(layout_id, container, false);

        String url = BuildConfig.IMAGE_URL + "walkthrough/style-3/Welcome-3-circle.png";

        ImageView img = (ImageView) view.findViewById(R.id.imagePage1);
        loadImageRequest(img, url);

        return view;
    }

    private void loadImageRequest(ImageView img, String url) {
        Glide.with(getActivity())
                .load(url)
                .transform(new ImageViewCircleTransform(getActivity()))
                .thumbnail(0.01f)
                .centerCrop()
                .into(img);
    }
}
