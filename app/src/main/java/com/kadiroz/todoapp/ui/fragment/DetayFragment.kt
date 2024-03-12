package com.kadiroz.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kadiroz.todoapp.R
import com.kadiroz.todoapp.databinding.FragmentAnasayfaBinding
import com.kadiroz.todoapp.databinding.FragmentDetayBinding
import com.kadiroz.todoapp.ui.viewmodel.AnasayfaViewModel
import com.kadiroz.todoapp.ui.viewmodel.DetayViewModel
import com.kadiroz.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
   private lateinit var  binding: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle:DetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacak

        binding.editTextYapilacakBaslik.setText(gelenYapilacak.yapilacak_baslik)
        binding.editTextYapilacakAciklama.setText(gelenYapilacak.yapilacak_aciklama)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacak_baslik = binding.editTextYapilacakBaslik.text.toString()
            val yapilacak_aciklama = binding.editTextYapilacakAciklama.text.toString()
            viewModel.guncelle(gelenYapilacak.yapilacak_id,yapilacak_baslik,yapilacak_aciklama)

        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}