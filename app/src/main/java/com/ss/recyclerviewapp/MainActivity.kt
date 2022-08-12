package com.ss.recyclerviewapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ss.recyclerviewapp.databinding.ActivityMainBinding
import com.ss.recyclerviewapp.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter :RecyclerClass
    lateinit var linearLayoutManager : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = RecyclerClass()
        linearLayoutManager = LinearLayoutManager(this)
        binding.rv1.adapter =adapter
        binding.rv1.layoutManager = linearLayoutManager
        binding.fabAdd.setOnClickListener {
            var dialogBinding =CustomDialogBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
           dialog.setCancelable(false)
            dialog.setContentView(dialogBinding.root)
            val layout = dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
            dialogBinding.btnAdd.setOnClickListener {
              if (dialogBinding.etId.text.toString().isNullOrEmpty()){
                  dialogBinding.etId.setError("enter Id")
                  dialogBinding.etId.requestFocus()
              }
                else if (dialogBinding.etName.text.toString().isNullOrEmpty())
              {
                    dialogBinding.etName.setError("enter name")
                  dialogBinding.etName.requestFocus()
              }
              else if (dialogBinding.etrollNo.text.toString().isNullOrEmpty())
              {
                  dialogBinding.etrollNo.setError("enter name")
                  dialogBinding.etrollNo.requestFocus()
              }
                else{
                    adapter.apply {

                    }
                    Toast.makeText(this,"done",Toast.LENGTH_LONG).show()
                  dialog.dismiss()
              }
            }
            dialog.show()
        }
    }
}