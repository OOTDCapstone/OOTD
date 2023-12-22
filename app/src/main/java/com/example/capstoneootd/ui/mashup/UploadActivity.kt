package com.example.capstoneootd.ui.mashup

import android.Manifest
import android.app.Dialog
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.bayustoryapp.data.Utils.Utils
import com.example.capstoneootd.R

import com.example.capstoneootd.databinding.ActivityUploadBinding

class UploadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUploadBinding
    private var currentImageUri: Uri? = null
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                startGallery()
            } else {

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageViewUpload1.setOnClickListener {
            showPopup()
        }
        binding.imvMidware.setOnClickListener {
            showPopup()
        }
        binding.imvBottom.setOnClickListener {
            showPopup()
        }
    }
    private fun showPopup() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.layout_popup_add)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnGallery: Button = dialog.findViewById(R.id.btnGallery)
        val btnCamera: Button = dialog.findViewById(R.id.btnCamera)

        btnGallery.setOnClickListener {
            startGallery()
            dialog.dismiss()
        }
        btnCamera.setOnClickListener {
            startCamera()
            dialog.dismiss()
        }
        dialog.show()
    }
    private fun startGallery() {
        if (allPermissionGranted()) {
            launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        } else {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
    }

    private fun startCamera() {
        if (allPermissionGranted()) {
            currentImageUri = Utils.getImageUri(this)
            launcherIntentCamera.launch(currentImageUri)
        } else {
            requestPermissionLauncher.launch(REQUIRED_PERMISSION)
        }
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            currentImageUri = uri
            showImage()
            showImageMid()
            showImageBot()
        } else {

        }
    }

    private val launcherIntentCamera = registerForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            showImage()
            showImageMid()
            showImageBot()
        }
    }

    private fun showImage() {
        currentImageUri?.let {uri ->
            binding.imageViewUpload1.setImageURI(uri)

        }
    }

    private fun showImageMid() {
        currentImageUri?.let {uri ->
            binding.imvMidware.setImageURI(uri)

        }
    }
    private fun showImageBot() {
        currentImageUri?.let {uri ->
            binding.imvBottom.setImageURI(uri)

        }
    }

    private fun allPermissionGranted() =
        ContextCompat.checkSelfPermission(
            this,
            REQUIRED_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED

    companion object {
        private const val REQUIRED_PERMISSION = Manifest.permission.CAMERA
    }
}