package com.celisa.ejemplomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.celisa.ejemplomvvm.databinding.ActivityMainBinding
import com.celisa.ejemplomvvm.ui.DatosLibroViewModel
import com.celisa.ejemplomvvm.ui.LibrosViewModelFactory

class MainActivity : AppCompatActivity() {

    private val libApp by lazy {
        application as LibrosApplication
    }
    val libroViewModelFctory: LibrosViewModelFactory by lazy{
        LibrosViewModelFactory(libApp.libRepository)
    }
    val datosLibroViewModel: DatosLibroViewModel by viewModels{
        libroViewModelFctory
    }

    private var _binding:  ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewmodel = datosLibroViewModel
            lifecycleOwner = this@MainActivity
        }
        datosLibroViewModel.libList.observe(this){
            datosLibroViewModel.actualizarVerTexto(it)
        }
    }
}