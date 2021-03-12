package edu.coe.richmond.textwidget
/*
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.telephony.SmsManager
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

    class MainActivity : AppCompatActivity(), View.OnClickListener {
        private val REQUEST_SEND_SMS = 123
        var SMSmgr: SmsManager? = null
        var sendText: Button? = null
        var sendTextIntent: Button? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            sendText = findViewById(R.id.btnSend) as Button
            sendText!!.setOnClickListener(this)
            sendTextIntent = findViewById(R.id.btnSendIntent) as Button
            sendTextIntent!!.setOnClickListener(this)
            if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.SEND_SMS)
                    !== PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS),
                        REQUEST_SEND_SMS)
            }
        }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            when (requestCode) {
                REQUEST_SEND_SMS -> if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this@MainActivity, "SEND Permission Granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "SEND Permission Denied", Toast.LENGTH_SHORT).show()
                }
                else -> super.onRequestPermissionsResult(requestCode, permissions!!, grantResults)
            }
        }

        @RequiresApi(Build.VERSION_CODES.KITKAT)
        override fun onClick(v: View) {
            when (v.id) {
                R.id.btnSend -> {
                    SMSmgr = SmsManager.getDefault()
                    SMSmgr!!.sendTextMessage("5554", null, "Oi", null, null)
                }
                R.id.btnSendIntent -> {
                    val defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this) // Need to change the build to API 19
                    val sendIntent = Intent(Intent.ACTION_SEND)
                    sendIntent.type = "text/plain"
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "text")
                    if (defaultSmsPackageName != null) // Can be null in case that there is no default, then the user would be able to choose
                    // any app that support this intent.
                    {
                        sendIntent.setPackage(defaultSmsPackageName)
                    }
                    startActivity(sendIntent)
                }
            }
        }
    }
}*/