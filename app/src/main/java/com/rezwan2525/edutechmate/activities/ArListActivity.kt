package com.rezwan2525.edutechmate.activities

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.DrawableCompat.inflate
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rezwan2525.edutechmate.R
import com.rezwan2525.edutechmate.adapters.ArListAdapter
import com.rezwan2525.edutechmate.databinding.ActivityArListBinding
import com.rezwan2525.edutechmate.databinding.ActivityArListBinding.inflate
import com.rezwan2525.edutechmate.interfaces.OnArListItemClicked
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
            aritemList.add(ArItem(i, "Title "+i, "http://i.imgur.com/DvpvklR.png",
                ""+i, true, i))
        }
        aritemList.add(ArItem(11, "Title "+11, "http://i.imgur.com/DvpvklR.png",
            ""+11, false, 10))

        binding.recyclerArItemList.apply {
            this.adapter = ArListAdapter(aritemList,
                object : OnArListItemClicked {
                    override fun onItemClicked(item: ArItem) {
                        if(!item.isLocked){
                            gotoARShowActivity(item)
                        }
                        else{
                            showLockedDialog(item)
                        }
                        Toast.makeText(this@ArListActivity, item.title , Toast.LENGTH_LONG).show();
                    }
                }
            )
            this.layoutManager = GridLayoutManager(this@ArListActivity, 2)
        }



    }

    private fun showLockedDialog(item: ArItem) {
        val dialog = Dialog(this,android.R.style.Theme_DeviceDefault_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_locked_item)

        val image3D: ImageView = dialog.findViewById(R.id.iv_image_3d)
        //TODO: image load

        val whatsAppBtn = dialog.findViewById(R.id.btn_send_whatsapp) as Button
        val smsBtn = dialog.findViewById(R.id.btn_send_sms) as Button

        whatsAppBtn.setOnClickListener {

        }
        smsBtn.setOnClickListener {

        }
        dialog.show()
    }

    private fun gotoARShowActivity(item: ArItem){
        var intent = Intent(this@ArListActivity, ArShowActivity::class.java)
        intent.putExtra("data", item);
        startActivity(intent)
        overridePendingTransition(android.R.anim.slide_in_left,
            android.R.anim.slide_out_right);
    }
}