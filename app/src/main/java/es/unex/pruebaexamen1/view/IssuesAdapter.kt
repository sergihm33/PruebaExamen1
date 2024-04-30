package es.unex.pruebaexamen1.view

// IssuesAdapter.kt
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.unex.pruebaexamen1.R
import es.unex.pruebaexamen1.data.api.Issue
class IssuesAdapter(
    private val issues: List<Issue>
) : RecyclerView.Adapter<IssuesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_issue, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val issue = issues[position]
        holder.bind(issue)
    }

    override fun getItemCount(): Int = issues.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)
        private val createdTextView: TextView = itemView.findViewById(R.id.createdTextView)

        fun bind(issue: Issue) {
            numberTextView.text = "Issue ${issue.number}"
            createdTextView.text = issue.created

            itemView.setOnClickListener {
                val issue = issues[adapterPosition]
                val url = "https://git.eclipse.org/r/${issue.number}/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                itemView.context.startActivity(intent)
            }
        }
    }
}
