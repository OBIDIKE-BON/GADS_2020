package com.stackfloat.gads2020.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.stackfloat.gads2020.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentStateAdapter {


    private static final int[] TAB_TITLES = new int[]{

            R.string.skill_iq_tab_title,
            R.string.learning_tab_title};
    private Context mContext;

    /**
     * @param fragmentManager of {@link androidx.viewpager.widget.ViewPager}'s host
     * @param lifecycle       of {@link androidx.viewpager2.widget.ViewPager2}'s host
     * @param context
     * @see FragmentStateAdapter#FragmentStateAdapter(Fragment)
     * @see FragmentStateAdapter#FragmentStateAdapter(Fragment)
     */
    public SectionsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, Context context) {
        super(fragmentManager, lifecycle);
        mContext = context;
    }

    /**
     * This method may be called by the ViewPager to obtain a title string
     * to describe the specified page. This method may return null
     * indicating no title for this page. The default implementation returns
     * null.
     *
     * @param position The position of the title requested
     * @return A title for the requested page
     */
    @Nullable
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    /**
     * Provide a new Fragment associated with the specified position.
     * <p>
     * The adapter will be responsible for the Fragment lifecycle:
     * <ul>
     *     <li>The Fragment will be used to display an item.</li>
     *     <li>The Fragment will be destroyed when it gets too far from the viewport, and its state
     *     will be saved. When the item is close to the viewport again, a new Fragment will be
     *     requested, and a previously saved state will be used to initialize it.
     * </ul>
     *
     * @param position position of the fragment in the current tab
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return Learning_Fragment.newInstance();
            default:
                return Skill_IQ_Fragment.newInstance();
        }
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 2;
    }


}
