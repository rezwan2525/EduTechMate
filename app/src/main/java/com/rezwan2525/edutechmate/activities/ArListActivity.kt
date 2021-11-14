package com.rezwan2525.edutechmate.activities

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.rezwan2525.edutechmate.commons.Constants
import com.rezwan2525.edutechmate.commons.RetrofitInstanceRapid
import com.rezwan2525.edutechmate.databinding.ActivityArListBinding
import com.rezwan2525.edutechmate.databinding.ActivityArListBinding.inflate
import com.rezwan2525.edutechmate.interfaces.CompilerService
import com.rezwan2525.edutechmate.interfaces.OnArListItemClicked
import com.rezwan2525.edutechmate.interfaces.RapidAPIService
import com.rezwan2525.edutechmate.models.ArItem
import com.rezwan2525.edutechmate.models.WhatsAppMessage
import com.squareup.picasso.Picasso
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArListActivity : AppCompatActivity() {
    lateinit var arListAdapter: ArListAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager
    val aritemList = ArrayList<ArItem>()
    lateinit var name:String
    lateinit var phone:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setTitle("AR Visualization Item List")


        name = getSharedPreferences(Constants.SHARED_PREF_NAME, MODE_PRIVATE)
            .getString(Constants.SHARED_NAME, "{NAME}").toString()
        phone = getSharedPreferences(Constants.SHARED_PREF_NAME, MODE_PRIVATE)
            .getString(Constants.SHARED_PHONE, "{PHONE}").toString()

        val humanbrain = Uri.parse("file:///android_asset/humanbrain.glb").toString()

        aritemList.add(ArItem(9, "Tiger", "https://preview.free3d.com/img/2017/01/2273009081591531162/gmbk8qeq-900.jpg", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", false, 50, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        aritemList.add(ArItem(1, "Eye Ball", "https://edutechmate.rkpranto.com/models/eyeball.jpg", "https://edutechmate.rkpranto.com/models/eyeball.glb", true, 100, "For More Study of 'Eye Ball' please check out : rkpranto.com"))
        aritemList.add(ArItem(2, "Skeleton", "https://edutechmate.rkpranto.com/models/skeleton.jpg", "https://edutechmate.rkpranto.com/models/skeleton.glb", true, 160, "For More Study of 'Skeleton' please check out : rkpranto.com"))
        aritemList.add(ArItem(3, "Human Brain", "https://edutechmate.rkpranto.com/models/humanbrain.jpg", "https://edutechmate.rkpranto.com/models/humanbrain.glb", true, 80, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        //aritemList.add(ArItem(3, "Human Brain", "https://edutechmate.rkpranto.com/models/humanbrain.jpg", humanbrain, false, 80, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        aritemList.add(ArItem(4, "Atom", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Stylised_atom_with_three_Bohr_model_orbits_and_stylised_nucleus.svg/220px-Stylised_atom_with_three_Bohr_model_orbits_and_stylised_nucleus.svg.png", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", true, 80, "For More Study of 'ATOM' please check out : https://en.wiktionary.org/wiki/atom"))
        aritemList.add(ArItem(5, "Heart", "https://preview.free3d.com/img/2019/04/2154878575000422342/o4zejhq3-900.jpg", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", true, 80, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        aritemList.add(ArItem(6, "Earth", "https://images.pond5.com/crystallised-low-poly-cartoon-earth-3d-070059966_iconl.jpeg", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", true, 86, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        aritemList.add(ArItem(7, "Cell", "https://fiverr-res.cloudinary.com/images/q_auto,f_auto/gigs/145919274/original/4abe8e552034784b6cecf8c491ad15df0e6e6149/create-3d-models-for-video-or-game-ready-topology.png", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", true, 82, "For More Study of 'Human Brain' please check out : rkpranto.com"))
        aritemList.add(ArItem(8, "DNA", "https://preview.free3d.com/img/2006/03/1871191458841625670/l0oh58p6-900.jpg", "https://storage.googleapis.com/ar-answers-in-search-models/static/Tiger/model.glb", true, 180, "For More Study of 'Human Brain' please check out : rkpranto.com"))

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
                        // Toast.makeText(this@ArListActivity, item.title , Toast.LENGTH_LONG).show();
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
        Picasso.get().load(item.image).into(image3D)

        val whatsAppBtn = dialog.findViewById(R.id.btn_send_whatsapp) as Button
        val smsBtn = dialog.findViewById(R.id.btn_send_sms) as Button

        whatsAppBtn.setOnClickListener {
            sendOfferOnWhatsApp(item)
            dialog.dismiss()
        }
        smsBtn.setOnClickListener {
            sendOfferOnSMS(item)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun sendOfferOnWhatsApp(item: ArItem) {
        Log.d("TAG_ARLIST", "...sending offer whatsapp")

        val message: String  = "Dear "+name+",\n"+
                "Thanks for your interested on '"+item.title+"' 3D model. Price: "+item.price+
                "$ Please contact us if you want to buy. We have some great offers as well"

        val call = RetrofitInstanceRapid.getRetrofitInstanceRapid()
            .create(RapidAPIService::class.java)
            .sendWhatsApp(WhatsAppMessage(phone, message));

        call.enqueue(object:Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.d("TAG_ARLIST", "successs: "+response.isSuccessful.toString());
                Log.d("TAG_ARLIST", "onResponse: \n"+ response.raw()+
                        "\nMessage:"+response.message()+
                        "\nHeaders: "+response.headers()+
                        "\nCode"+response.code()+
                        "\nBody: "+response.toString()+""+
                        "\nErrBody: "+ (response.errorBody()?.string() ?: "")
                );
                if(response.body()!= null && !response.body().toString().isEmpty()){

                    Toast.makeText(this@ArListActivity, "Please check your WhatsApp for more updates", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("TAG_ARLIST", "onFailure: "+t.message.toString());
            }

        })

    }

    private fun sendOfferOnSMS(item: ArItem) {
        val message: String  = "Dear "+name+",\n"+
                "Thanks for your interested on '"+item.title+"' 3D model. Price: "+item.price+
                "$ Please contact us if you want to buy. We have some great offers as well"

        val call = RetrofitInstanceRapid.getRetrofitInstanceRapidSMS()
            .create(RapidAPIService::class.java)
                .sendSMS(
                    "617bf1f9245383001100f805",
                    "617bf1f9245383001100f805",
                    0,
                    1,
                    phone,
                    "RMLPRD",
                    message)

        call.enqueue(object:Callback<ResponseBody>{
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if(response.body()!= null && !response.body().toString().isEmpty()){
                    Log.d("TAG_ARLIST", "onResponse: \n"+ response.raw()+
                        "\nMessage:"+response.message()+
                    "\nHeaders: "+response.headers()+
                            "\nCode"+response.code()+
                    "\nBody: "+response.toString()+""+
                    "\nErrBody: "+response.errorBody()
                    );
                    Toast.makeText(this@ArListActivity, "Please check your phone", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.d("TAG_ARLIST", "onFailure: "+t.message.toString());
            }

        })
        
    }

    private fun gotoARShowActivity(item: ArItem){
        var intent = Intent(this@ArListActivity, ArShowActivity::class.java)
        intent.putExtra(Constants.ARITEM_OBJECT_PASSING_KEY, item);
        startActivity(intent)
        overridePendingTransition(android.R.anim.slide_in_left,
            android.R.anim.slide_out_right);
    }
}