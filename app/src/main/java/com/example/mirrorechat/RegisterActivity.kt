package com.example.mirrorechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mirrorechat.databinding.ActivityRegisterBinding
import com.mirrorflyuikitsdk.MirrorFlyUIKit
import com.mirrorflyuikitsdk.interfaces.InitResultHandler

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            val name = binding.registerEdit.text.toString()
            registerUser(name)
        }

    }
    private fun registerUser(name:String){

        /**
         * Use this initUser method only once in the application for registration.
         * Handle this by using shared preference or any other else.
        * */
        
        MirrorFlyUIKit.initUser(name, object : InitResultHandler {

            override fun onInitResponse(isSuccess: Boolean, e: String) {
                if (isSuccess) {
                    Log.d("TAG", "onInitResponse called with: isSuccess = $isSuccess")
                    startActivity(Intent(this@RegisterActivity,MainActivity::class.java))
                    finish()
                } else {
                    Log.e("TAG", "onInitResponse called with: Failure, e = $e")
                }
            }
        })
    }
}