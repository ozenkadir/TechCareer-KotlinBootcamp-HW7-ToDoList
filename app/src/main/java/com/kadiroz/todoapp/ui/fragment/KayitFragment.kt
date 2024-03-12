package com.kadiroz.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kadiroz.todoapp.R
import com.kadiroz.todoapp.data.entity.Yapilacaklar
import com.kadiroz.todoapp.databinding.FragmentDetayBinding
import com.kadiroz.todoapp.databinding.FragmentKayitBinding
import com.kadiroz.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var  binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val yapilacak_baslik = binding.editTextYapilacakBaslik.text.toString()
            val yapilacak_aciklama = binding.editTextYapilacakAciklama.text.toString()
            viewModel.kaydet(yapilacak_baslik,yapilacak_aciklama)
        }


        return binding.root
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }




}