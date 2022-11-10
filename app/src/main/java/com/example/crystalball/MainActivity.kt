package com.example.crystalball

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.crystalball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //click on round button
        binding.ibPrediction.setOnClickListener{

                //animation round button
                binding.ibPrediction.animate().apply {
                    duration = 1000
                    rotationYBy(360f)
                    rotationY(360f)
                }.start()

            binding.tvPrediction.text = getPrediction()
        }

        //animation Layout
        val animationDrawable = binding.constraintLayout1.background as AnimationDrawable

        animationDrawable.apply {
            setEnterFadeDuration(1000)
            setExitFadeDuration(2000)
        }.start()

        //animation textView with prediction
        binding.tvPrediction.animate().apply {
            duration = 1000
            rotationXBy(360f)
            rotationX(360f)
        }.start()
    }

    private fun getPrediction(): String{
        return resources.getStringArray(R.array.predictions)[randomNumber()]
    }

    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.predictions).size - 1
        return(0..size).random()
    }
}