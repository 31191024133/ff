package com.example.imagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ContentFrag extends Fragment {
    GridView gridView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.getRootView().findViewById(R.id.gridview);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            String s =adapterView.getItemAtPosition(i).toString();
            Intent intent = new Intent(view.getContext(), FullImage.class);
            intent.putExtra("url", s);
            startActivity(intent);
        });
        return view;
    }

    String[] fruit = {
            "https://cdn.pixabay.com/photo/2013/07/13/11/29/cherries-158241_1280.png",
            "https://cdn.pixabay.com/photo/2014/12/21/23/39/coconut-575780_1280.png",
            "https://cdn.pixabay.com/photo/2021/09/17/15/17/fruit-6633086_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/06/07/16/38/blueberries-3460423_1280.jpg"
        };
    String[] animal = {
            "https://cdn.pixabay.com/photo/2012/06/19/10/32/owl-50267_1280.jpg",
            "https://cdn.pixabay.com/photo/2015/11/16/14/43/cat-1045782_1280.jpg",
            "https://cdn.pixabay.com/photo/2018/07/31/22/08/lion-3576045_1280.jpg",
            "https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg",
        };
    String[] food = {
            "https://cdn.pixabay.com/photo/2016/03/05/23/02/barbecue-1239434_1280.jpg",
            "https://cdn.pixabay.com/photo/2014/04/22/02/56/pizza-329523_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/09/28/18/13/bread-2796393_1280.jpg",
            "https://cdn.pixabay.com/photo/2017/01/11/11/33/cake-1971552_1280.jpg",
        };


    public void updateContent(int position){
        switch (position){
            case 0:
                gridView.setAdapter(new ImageAdapter(getContext(),fruit));
                break;
            case 1:
                gridView.setAdapter(new ImageAdapter(getContext(),animal));
                break;
            case 2:
                gridView.setAdapter(new ImageAdapter(getContext(),food));
                break;
        }
    }
    
//    public void reUpdate(String url){
//        if(checkUrl(url,fruit)){
//            gridView.setAdapter(new ImageAdapter(getContext(),fruit));
//        }else if (checkUrl(url, animal)){
//            gridView.setAdapter(new ImageAdapter(getContext(),animal));
//        }else if (checkUrl(url,food)){
//            gridView.setAdapter(new ImageAdapter(getContext(),food));
//        }else{
//            Toast.makeText(getActivity(),"Lỗi Tải Ảnh", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
//    public boolean checkUrl(String url, String[] urls){
//        for (String s : urls) {
//            if (url.equals(s)) {
//                return true;
//            }
//        }
//        return false;
//    }




}
