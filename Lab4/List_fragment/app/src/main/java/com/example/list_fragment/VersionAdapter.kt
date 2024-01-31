// src/main/java/com/example/myandroidversions/VersionAdapter.kt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.list_fragment.AndroidVersion
import com.example.list_fragment.R

class VersionAdapter(context: Context, versions: List<AndroidVersion>) :
    ArrayAdapter<AndroidVersion>(context, R.layout.list_item_version, versions) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_version, parent, false)

        val version = getItem(position)

        val versionNameTextView: TextView = itemView.findViewById(R.id.versionNameTextView)
        val versionImageView: ImageView = itemView.findViewById(R.id.versionImageView)

        versionNameTextView.text = version?.name
        versionImageView.setImageResource(version?.imageResId ?: 0)

        return itemView
    }
}
