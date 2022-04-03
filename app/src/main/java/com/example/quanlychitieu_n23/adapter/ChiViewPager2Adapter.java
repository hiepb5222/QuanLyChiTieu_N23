package com.example.quanlychitieu_n23.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlychitieu_n23.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu_n23.ui.Chi.LoaiChiFragment;

public class ChiViewPager2Adapter extends FragmentStateAdapter {
    public ChiViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if(position==0)
        {
            fragment= KhoanChiFragment.newInstance();
        }
        else
        {
            fragment= LoaiChiFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
