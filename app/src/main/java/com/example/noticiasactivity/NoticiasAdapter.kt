import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.noticiasactivity.Noticias
import com.example.noticiasactivity.OnClickListener
import com.example.practica3.R
import com.example.practica3.databinding.ItemNoticiasBinding



 class NoticiasAdapter(private val news: List<Noticias>, private val listener: OnClickListener) : RecyclerView.Adapter<NoticiasAdapter.ViewHolder>() {
    private lateinit var context: Context
    // ViewHolder para manejar cada vista
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemNoticiasBinding.bind(view)

        fun setListener(new: Noticias, position: Int) {
            binding.root.setOnClickListener { listener.onClick(new, position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_noticias, parent, false)

        return ViewHolder(view)
    }







    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val new = news[position]
        with(holder) {
            setListener(new, position + 1)
            binding.tvTitle.text = new.titulo
            binding.tvDescription.text = new.resumen
            binding.tvDate.text = new.fecha
            Glide.with(binding.newsImageView.context)
                .load(new.imagen)
                .error(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.newsImageView)
        }


    }
}
