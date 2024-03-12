package com.kadiroz.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kadiroz.todoapp.R
import com.kadiroz.todoapp.data.entity.Yapilacaklar
import com.kadiroz.todoapp.databinding.FragmentAnasayfaBinding
import com.kadiroz.todoapp.ui.adapter.YapilacaklarAdapter
import com.kadiroz.todoapp.ui.viewmodel.AnasayfaViewModel
import com.kadiroz.todoapp.ui.viewmodel.KayitViewModel
import com.kadiroz.todoapp.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private  lateinit var  binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)


        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val yapilacaklarAdapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            binding.yapilacaklarRv.adapter = yapilacaklarAdapter
        }




        binding.yapilacaklarRv.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.kayitGecis)
        }


        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return  true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }


}