package com.example.ktgk_001_quanlysach

import android.app.Activity
import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_001_quanlysach.databinding.ActivityChiTietSachBinding

class ChiTietSachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietSachBinding

    private val chinhSuaLauncher_332 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode== Activity.RESULT_OK){
            val newTen = result.data?.getStringExtra("NEW_TEN")
            val newGia = result.data?.getStringExtra("NEW_GIA")
            val newGhiChu = result.data?.getStringExtra("NEW_GHI_CHU")

            binding.tvTenSach.text = newTen
            binding.tvGiaSach.text = newGia
            binding.tvGhiChu.text = newGhiChu
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChiTietSachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tenSach_332 = intent.getStringExtra("TEN_SACH")
        val giaSach_332 = intent.getStringExtra("GIA_SACH")
        val ghiChu_332 = intent.getStringExtra("GHI_CHU")

        binding.tvTenSach.text = tenSach_332
        binding.tvGiaSach.text = giaSach_332
        binding.tvGhiChu.text = ghiChu_332

        binding.btnQuayLai.setOnClickListener {
            finish()
        }

        binding.btnChinhSua.setOnClickListener {
            val currentTen = tenSach_332
            val currentGia = giaSach_332
            val currentGhiChu = ghiChu_332

            val intent = Intent(
                this,
                ChinhSuaSachActivity::class.java
            )

            intent.putExtra("CURRENT_TEN", currentTen)
            intent.putExtra("CURRENT_GIA", currentGia)
            intent.putExtra("CURRENT_GHI_CHU", currentGhiChu)

            chinhSuaLauncher_332.launch(intent)
        }
    }
}