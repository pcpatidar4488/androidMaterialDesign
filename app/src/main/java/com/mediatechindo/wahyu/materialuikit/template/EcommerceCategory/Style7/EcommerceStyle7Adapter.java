package com.mediatechindo.wahyu.materialuikit.template.EcommerceCategory.Style7;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.mediatechindo.wahyu.materialuikit.BuildConfig;
import com.mediatechindo.wahyu.materialuikit.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wahyu on 14/11/16.
 */

public class EcommerceStyle7Adapter extends RecyclerView.Adapter<EcommerceStyle7Adapter.ItemViewHolder> implements EcommerceStyle7ItemTouchAdapter {
    private final List<String> mItems = new ArrayList<>();
    private final EcommerceStyle7OnStartDragListener mDragStartListener;
    private int count = 1;
    private Context context;

    public EcommerceStyle7Adapter(Context ctx, EcommerceStyle7OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
        context = ctx;
        mItems.add(0, "Sky Blue Dress");
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ecommerce7, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.title.setText(mItems.get(position));
        String url = BuildConfig.IMAGE_URL + "ecommerce/style-7/Ecommerce-7.jpg";
        String urlThumb = BuildConfig.IMAGE_URL + "ecommerce/style-7/Ecommerce-7-thumb.jpg";
        loadImageRequest(holder.image, url, urlThumb);

        if(count > 1) {
            animationCardIn(holder.profilContainer);
        }
    }

    private void loadImageRequest(ImageView img, String url, String urlThumb) {
        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(context)
                .load(urlThumb);

        Glide.with(context)
                .load(url)
                .thumbnail(thumbnailRequest)
                .into(img);
    }

    private void animationCardIn(View view){
        int transDistancePx = 30;
        int transDistance = ((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, transDistancePx, context.getResources().getDisplayMetrics()));
        int start = 50;
        int duration = 500;

        TranslateAnimation animTranslate1 = new TranslateAnimation( 0, 0 , 0, transDistance );
        animTranslate1.setDuration(10);
        animTranslate1.setStartOffset(0);
        animTranslate1.setFillAfter(true);

        AlphaAnimation animAlpha = new AlphaAnimation(0.5f, 1.0f);
        animAlpha.setDuration(duration);
        animAlpha.setStartOffset(start);
        animAlpha.setFillAfter(true);

        TranslateAnimation animTranslate2 = new TranslateAnimation( 0, 0 , 0, (transDistance*-1) );
        animTranslate2.setDuration(duration);
        animTranslate2.setStartOffset(start);
        animTranslate2.setFillAfter(true);

        ScaleAnimation animScale1 = new ScaleAnimation(0.93f, 1f, 0.93f, 1f, Animation.RELATIVE_TO_SELF, (float)0.5, Animation.RELATIVE_TO_SELF, (float)0.5);
        animScale1.setDuration(duration);
        animScale1.setStartOffset(start);
        animScale1.setFillAfter(true);

        AnimationSet animSet = new AnimationSet(false);
        animSet.addAnimation(animTranslate1);
        animSet.addAnimation(animAlpha);
        animSet.addAnimation(animTranslate2);
        animSet.addAnimation(animScale1);

        view.startAnimation(animSet);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {
        count++;
        mItems.remove(position);
        mItems.add(0, "Michael Angelo");
        notifyItemRemoved(position);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;
        public final ImageView image;
        public final FrameLayout profilContainer;
        public ItemViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            profilContainer = (FrameLayout) itemView.findViewById(R.id.profilContainer);
            image = (ImageView) itemView.findViewById(R.id.imageMain);
        }
    }
}
