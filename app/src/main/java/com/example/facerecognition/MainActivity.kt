package com.example.facerecognition


import android.Manifest.permission.*
import android.content.Intent.*
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val MY_CAMERA_REQUEST_CODE = 100

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContentView(R.layout.fragment_main_menu)
        if (checkSelfPermission(CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(CAMERA), MY_CAMERA_REQUEST_CODE)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_CAMERA_REQUEST_CODE  -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    Toast.makeText(this, "Camera permission granted !!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Camera permission denied !!", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }


}