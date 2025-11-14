package es.tierno.testview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Creamos el dataset
        val data = ArrayList<ItemViewModel>()
        for (i in 1..20) {
            val image = android.R.drawable.arrow_up_float
            val descripcion = "Descripción elemento $i"
            data.add(ItemViewModel( image, descripcion))
        }

        // Creamos el adaptador
        val adapter = DataAdapter(data)

        // Obtengo la view del RecyclerView
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        // Definimos la gestión del layout
        recyclerview.layoutManager = LinearLayoutManager(this)


        // Establecemos el adaptador al recyclerView
        recyclerview.adapter = adapter

        //Aplicamos la lógica del OnClickListener
        adapter.setOnClickListener(object :
            DataAdapter.OnClickListener {
            override fun onClick(position: Int, model: ItemViewModel) {
                val msg:String = "Ha saleccionado el elemento ${model.descripcion}"
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
            }
        })
    }
}