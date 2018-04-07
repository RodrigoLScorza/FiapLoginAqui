package com.example.logonrm.fiaploginaqui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.login.LoginManager
import android.content.Intent
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        FacebookSdk.sdkInitialize(getApplicationContext())

        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        // App code
                        Toast.makeText(this@LoginActivity,
                                loginResult.accessToken.token.toString(),
                                Toast.LENGTH_LONG).show()
                        
                    }

                    override fun onCancel() {
                        // App code
                    }

                    override fun onError(exception: FacebookException) {
                        // App code
                    }
                })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}

