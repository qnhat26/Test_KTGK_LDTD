package com.example.ktgk_001_quanlysach

import android.app.Activity
import android.content.Intent
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

        binding.edtTenSach.setText(currentTen)
        binding.edtGiaSach.setText(currentGia)
        binding.edtGhiChu.setText(currentGhiChu)

        binding.btnLuu.setOnClickListener {
            val newTen = binding.edtTenSach.text.toString().trim()
            val newGia = binding.edtGiaSach.text.toString().toDoubleOrNull()
            val newGhiChu = binding.edtGhiChu.text.toString().trim()

            if (newTen.isEmpty()){
                binding.edtTenSach.error = "Vui lòng nhập tên sách"
                return@setOnClickListener
            }
            if (newGia == null || newGia <= 0){
                binding.edtGiaSach.error = "Giá không hợp lệ"
                return@setOnClickListener
            }
            if (newGhiChu.isEmpty()){
                binding.edtGhiChu.error = "Vui lòng nhập ghi chú"
                return@setOnClickListener
            }

            val resultIntent = Intent()
            resultIntent.putExtra("NEW_TEN", newTen)
            resultIntent.putExtra("NEW_GIA", newGia.toString())
            resultIntent.putExtra("NEW_GHI_CHU", newGhiChu)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        binding.btnHuy.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}