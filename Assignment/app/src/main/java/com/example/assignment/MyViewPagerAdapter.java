package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignment.fragments.ExpensesFragment;
import com.example.assignment.fragments.FriendsFragment;
import com.example.assignment.fragments.GroupsFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {

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
                return new FriendsFragment();
            case 2:
                return new GroupsFragment();
            case 0:
            default:
//                Expense will be the default page
                return new ExpensesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
