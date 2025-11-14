package es.tierno.testview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter (private val mList: List<ItemViewModel>) : RecyclerView.Adapter<DataAdapter.ViewHolder>()  {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tarjeta_view_design,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataAdapter.ViewHolder, position: Int) {

        val itemViewModel = mList[position]

        // Cargamos la imagen y descripción de una posición
        holder.imageView.setImageResource(itemViewModel.image)
        holder.textView.text = itemViewModel.descripcion

        // Seteamos el evento para el elemento
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, itemViewModel)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Interfaz para el click listener
    interface OnClickListener {
        fun onClick(position: Int, model: ItemViewModel)
    }


    // Set para el atributo
    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}