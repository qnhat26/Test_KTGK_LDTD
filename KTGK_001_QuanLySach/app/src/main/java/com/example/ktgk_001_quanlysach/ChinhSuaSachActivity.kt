package com.example.ktgk_001_quanlysach

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_001_quanlysach.databinding.ActivityChiTietSachBinding
import com.example.ktgk_001_quanlysach.databinding.ActivityChinhSuaSachBinding

class ChinhSuaSachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChinhSuaSachBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChinhSuaSachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentTen = intent.getStringExtra("CURRENT_TEN")
        val currentGia = intent.getStringExtra("CURRENT_GIA")
        val currentGhiChu = intent.getStringExtra("CURRENT_GHI_CHU")
    }
}