package com.redlabpc.timeforpercentage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redlabpc.timeforpercentage.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }

    }

    @SuppressLint("ResourceType")
    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val stringInTextField2 = binding.percentuale.text.toString()
        val cost = stringInTextField.toDouble()
        val costsecond = stringInTextField2.toDouble()


        var calcolopercentuale = cost*costsecond/100
        var result = cost - calcolopercentuale

        val formattedTip = NumberFormat.getCurrencyInstance().format(calcolopercentuale)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
        val resultTip = NumberFormat.getCurrencyInstance().format(result)
        binding.tipFinal.text = getString(R.string.tip_final, resultTip)
    }
}

