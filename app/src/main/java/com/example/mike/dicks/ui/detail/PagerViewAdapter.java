package com.example.mike.dicks.ui.detail;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mike.dicks.R;
import com.example.mike.dicks.utils.ImageEditor;

import java.util.List;

public class PagerViewAdapter extends PagerAdapter {

    List<String> urls;

    public PagerViewAdapter(List<String>urls){
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return true;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from( container.getContext() ).inflate( R.layout.detail_image_item, container, false );
        ImageView detailImage = v.findViewById( R.id.detailImage );
        ImageEditor ie = new ImageEditor(detailImage);
        ie.setImage( urls.get( position ) );
        return v;
    }
}
