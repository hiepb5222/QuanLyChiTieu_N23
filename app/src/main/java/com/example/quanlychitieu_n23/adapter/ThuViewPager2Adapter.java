package com.example.quanlychitieu_n23.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlychitieu_n23.ui.Chi.KhoanChiFragment;
import com.example.quanlychitieu_n23.ui.Thu.KhoanThuFragment;

public class ThuViewPager2Adapter extends FragmentStateAdapter {
    public ThuViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if(position==0)
        {
            fragment = KhoanThuFragment.newInstance();
        }
        else {
            fragment = KhoanChiFragment.newInstance();
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
