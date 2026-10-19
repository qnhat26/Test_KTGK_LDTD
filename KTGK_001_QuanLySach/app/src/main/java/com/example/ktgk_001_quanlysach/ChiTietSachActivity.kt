package com.example.ktgk_001_quanlysach

import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_001_quanlysach.databinding.ActivityChiTietSachBinding

class ChiTietSachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChiTietSachBinding

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
        binding.tvTrangThai.text = "Chưa đọc"

        binding.btnQuayLai.setOnClickListener {
            finish()
        }

        binding.btnChinhSua.setOnClickListener {
            Toast.makeText(
                this,
                "Chức năng chỉnh sửa sẽ làm ở Câu 3",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}