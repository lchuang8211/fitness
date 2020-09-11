package com.hlc.fng.main.record

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hlc.fng.R
import com.hlc.fng.support.AppUtils

class RecordViewPagerAdapter(
    context: Context,
    childFragmentManager: FragmentManager,
    behaviorResumeOnlyCurrentFragment: Int
) : FragmentPagerAdapter(childFragmentManager, behaviorResumeOnlyCurrentFragment) {
    val str = AppUtils.getResources()
    val TitleList: List<String> = listOf(
        str.getString(R.string.record_eat),
        str.getString(R.string.record_train),
        str.getString(R.string.record_aerobic)
    )

    override fun getItem(position: Int): Fragment {
        var fragment = Fragment()
        when (TitleList[position]) {
            str.getString(R.string.record_eat) -> {
                fragment = PagerRecordFragment.newInstance(1)
            }
            str.getString(R.string.record_train) -> {
                fragment = PagerRecordFragment.newInstance(2)
            }
            str.getString(R.string.record_aerobic) -> {
                fragment = PagerRecordFragment.newInstance(3)
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return TitleList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return TitleList[position]
    }
}
