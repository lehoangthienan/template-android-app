package com.dwarvesv.mvvm.view.main


import android.os.Bundle
import com.dwarvesv.mvvm.R
import com.dwarvesv.mvvm.base.BaseNoAppBarActivity


class MainActivity : BaseNoAppBarActivity(), MainFragment.InteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            setFragment(MainFragment.newInstance())
        }
        setToolbarTitle(getString(R.string.activity_title_home))
        setDisplayHomeAsUpEnabled(false)
    }

    private fun setFragment(mainFragment: MainFragment) {
        replaceFragment(R.id.fragmentContainer, mainFragment)
    }

    override fun setToolbarTitleName(name: String) {
        setToolbarTitle(name)
    }

}
