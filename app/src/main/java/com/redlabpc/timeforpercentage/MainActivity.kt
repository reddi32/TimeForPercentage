package com.redlabpc.timeforpercentage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.redlabpc.timeforpercentage.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{ calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectId) {
            R.id.option_novantacinque -> 0.95
            R.id.option_novanta -> 0.90
            R.id.option_ottantacinque -> 0.85
            R.id.option_ottanta -> 0.80
            R.id.option_settantacinque -> 0.75
            R.id.option_settanta -> 0.70
            R.id.option_sessantacinque -> 0.65
            R.id.option_sessanta -> 0.60
            R.id.option_cinquantacinque -> 0.55
            R.id.option_cinquanta -> 0.50
            R.id.option_quarantacinque -> 0.45
            R.id.option_quaranta -> 0.40
            R.id.option_trentacinque -> 0.35
            R.id.option_trenta -> 0.30
            R.id.option_venticinque -> 0.25
            R.id.option_venti -> 0.20
            R.id.option_quindici -> 0.15
            R.id.option_dieci -> 0.10
            R.id.option_cinque -> 0.05
            else -> 0.05
        }

        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked
        if (roundUp) {
            tip = kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}