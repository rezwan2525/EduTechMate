package com.rezwan2525.edutechmate.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.rezwan2525.edutechmate.R
import com.rezwan2525.edutechmate.adapters.ToolsPagerAdapter
import com.rezwan2525.edutechmate.commons.ViewPagerHelper

class CompilerActivity : AppCompatActivity() {
    private val TAG = "TAG_ToolsFragment"

    var mToolsPager: ViewPager? = null
    var toolsPagerAdapter: ToolsPagerAdapter? = null
    var toolsTabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compiler)

        supportActionBar!!.setTitle("OCR Code Compiler")

        findViews()
        getViewPagerReady()
        ViewPagerHelper.getTabOnClickAction(toolsTabLayout, mToolsPager)

    }

    private fun findViews() {
        mToolsPager = findViewById(R.id.viewpager_tools_page)
        toolsTabLayout = findViewById(R.id.tablayout_tools)
    }

    private fun getViewPagerReady() {
        toolsPagerAdapter = ToolsPagerAdapter(
            this
                .getSupportFragmentManager(),
            2
        )
        mToolsPager!!.adapter = toolsPagerAdapter
        mToolsPager!!.addOnPageChangeListener(
            TabLayoutOnPageChangeListener(toolsTabLayout)
        )
    }
}