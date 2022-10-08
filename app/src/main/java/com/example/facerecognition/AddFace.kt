package com.example.facerecognition

import android.content.Intent.*
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.camera.core.CameraSelector
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import java.io.FileDescriptor

class AddFace : Fragment() {

    private var camBtn: Button? = null
    private var addBtn: Button? = null
    private var importBtn: Button? = null
    var cameraSelector: CameraSelector? = null
    private var camFace : Int = CameraSelector.LENS_FACING_BACK
    var flip: Boolean = false
    var start: Boolean = true
    var cameraProvider: ProcessCameraProvider? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_face, container, false)
        camBtn = requireActivity().findViewById(R.id.cam_btn)
        addBtn = requireActivity().findViewById(R.id.addFace)
        importBtn = requireActivity().findViewById(R.id.importPhoto)


        //Flip Camera Button
        camBtn?.setOnClickListener(
            @Override
            fun(v: View?) {
                if(camFace== CameraSelector.LENS_FACING_BACK){
                    camFace= CameraSelector.LENS_FACING_FRONT
                    flip= true
                }
                else{
                    camFace= CameraSelector.LENS_FACING_BACK
                    flip= false
                }
                cameraProvider?.unbindAll()
                //cameraBind()
        } )

        //Add Face Button
        addBtn?.setOnClickListener((View.OnClickListener() {
              @Override
              fun onClick(v: View?) {
                //addFace()
            }
        }))

        //Import Photo Button
//        importBtn?.setOnClickListener(
//                //loadPhoto()
//        )


        return view
    }

    private fun loadPhoto() {
        start=false

    }
    private fun getBitmapFromURI(uri: Uri): Bitmap {
        val parcelFileDescriptor: ParcelFileDescriptor? = requireActivity().contentResolver.openFileDescriptor(uri, "r")
        val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
        val image: Bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        parcelFileDescriptor.close()
        return image
    }



}