package com.kadiroz.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kadiroz.todoapp.data.entity.Yapilacaklar
import com.kadiroz.todoapp.databinding.CardTasarimBinding
import com.kadiroz.todoapp.databinding.FragmentAnasayfaBinding
import com.kadiroz.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.kadiroz.todoapp.ui.viewmodel.AnasayfaViewModel
import com.kadiroz.todoapp.utils.gecis

class YapilacaklarAdapter(var mContext: Context, var yapılacaklarListesi:List<Yapilacaklar>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimHolder>() {
    inner class  CardTasarimHolder(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimHolder(binding)
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val  yapilacak = yapılacaklarListesi.get(position)
        val t = holder.tasarim
        t.textViewYapilacakBaslik.text = yapilacak.yapilacak_baslik
        t.textViewYapilacakAciklama.text = yapilacak.yapilacak_aciklama


        t.cardViewSatir.setOnClickListener{
            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacak = yapilacak)
            Navigation.gecis(it,gecis)
        }


        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"Do you want to delete ${yapilacak.yapilacak_baslik}?",Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return yapılacaklarListesi.size
    }

    fun  sil(yapilacak_id:Int){
        Log.e("Yapılacak Sil",yapilacak_id.toString())
    }

}