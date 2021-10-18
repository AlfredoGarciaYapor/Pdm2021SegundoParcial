package com.example.pdm12021

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode

class QrActivity : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner
    var MY_CAMERA_PERMISSION_REQUEST = 1111
    private lateinit var scannerView: CodeScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)

        scannerView = findViewById(R.id.scannerView)
        codeScanner = CodeScanner(this, scannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        // Listener que detecta cuando se leyo un codigo QR
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread{
                Toast.makeText(this,"Scan Result: ${it.text}",Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DetailQrCodeActivity::class.java)
                intent.putExtra("QrCodeValue", it.text)
                startActivity(intent)

                codeScanner.stopPreview()
            }
        }

        codeScanner.errorCallback = ErrorCallback {
            runOnUiThread{
                Toast.makeText(this,"Camera Error: ${it.message}",Toast.LENGTH_SHORT).show()
                codeScanner.stopPreview()
            }
        }

        codeScanner.startPreview()

        checkPermission()
    }

    fun checkPermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), MY_CAMERA_PERMISSION_REQUEST)
        } else {
            codeScanner.startPreview()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==MY_CAMERA_PERMISSION_REQUEST&&grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            codeScanner.startPreview()
        } else {
            Toast.makeText(this, "CAn not scan until you give the camera permission", Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume(){
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}