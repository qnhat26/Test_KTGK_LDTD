package com.example.ktgk_001_quanlysach

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ktgk_001_quanlysach.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Quản lý sách cá nhân"

        binding.btnThemSach.setOnClickListener {
            val tenSach_332 = binding.edtTenSach.text.toString().trim()
            val giaSach_332 = binding.edtGiaSach.text.toString().toDoubleOrNull()
            val ghiChu_332 = binding.edtGhiChu.text.toString().trim()

            if (tenSach_332.isEmpty()){
                binding.edtTenSach.error = "Vui lòng không để trống tên sách"
                return@setOnClickListener
            }
            if (giaSach_332 == null){
                binding.edtGiaSach.error = "Giá sách không hợp lệ"
                return@setOnClickListener
            }
            if (giaSach_332.isFinite() || giaSach_332 <= 0 ){
                binding.edtGiaSach.error = "Giá sách phải lớn hơn 0"
                return@setOnClickListener
            }
            if (ghiChu_332.isEmpty()){
                binding.edtGhiChu.error = "Vui lòng nhập ghi chú"
                return@setOnClickListener
            }
            Toast.makeText(
                this,
                "Thêm sách thành công: $tenSach_332",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}