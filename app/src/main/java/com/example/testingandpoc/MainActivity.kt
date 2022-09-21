package com.example.testingandpoc

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.testingandpoc.databinding.ActivityMainBinding
import java.io.File
import java.io.OutputStream


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.root.setOnClickListener {
            showBottomSheet()
        }
    }

    private fun showBottomSheet() {
        BottomSheetWithStickyButton().show(supportFragmentManager, null)
    }

}
