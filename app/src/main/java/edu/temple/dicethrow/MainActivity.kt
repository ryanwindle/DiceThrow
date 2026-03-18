package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.fragmentContainerView) == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainerView,
                    DieFragment.newInstance(6))
                .replace(R.id.fragmentContainerView2,
                    DieFragment.newInstance(10))
                .commit()
        }


        val button = findViewById<Button>(R.id.rollDiceButton)
        button.setOnClickListener {
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView)?.run{
                    (this as DieFragment).throwDie()
            }
            val dieFragment2 = supportFragmentManager.findFragmentById(
                R.id.fragmentContainerView2) as DieFragment
            dieFragment2.throwDie()
        }

    }


}