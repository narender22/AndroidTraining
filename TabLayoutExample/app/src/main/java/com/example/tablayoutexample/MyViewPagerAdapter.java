package com.example.tablayoutexample;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tablayoutexample.fragments.CallsFragment;
import com.example.tablayoutexample.fragments.ChatsFragment;
import com.example.tablayoutexample.fragments.StatusFragment;

public class MyViewPagerAdapter  extends FragmentStateAdapter {

    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        /*
        * Set page to be shown accordingly
        * */
        switch (position) {
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            case 0:
            default:
//                chats will be the default page
                return new ChatsFragment();
        }
    }

    @Override
    public int getItemCount() {
//        there are 3 pages
        return 3;
    }
}
