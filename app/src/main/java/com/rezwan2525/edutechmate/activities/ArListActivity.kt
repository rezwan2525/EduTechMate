package com.rezwan2525.edutechmate.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezwan2525.edutechmate.R
import com.rezwan2525.edutechmate.adapters.ArListAdapter
import com.rezwan2525.edutechmate.databinding.ActivityArListBinding
import com.rezwan2525.edutechmate.models.ArItem

class ArListActivity : AppCompatActivity() {
    lateinit var arListAdapter: ArListAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    val aritemList = ArrayList<ArItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityArListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 1..10){
            aritemList.add(ArItem(i, "Title "+i, "http://i.imgur.com/DvpvklR.png",""))
        }

        binding.recyclerArItemList.apply {
            this.adapter = ArListAdapter(aritemList)
            this.layoutManager = LinearLayoutManager(this@ArListActivity)
        }



    }
}