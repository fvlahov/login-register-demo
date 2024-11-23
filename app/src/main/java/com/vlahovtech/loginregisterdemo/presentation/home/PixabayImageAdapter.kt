package com.vlahovtech.loginregisterdemo.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vlahovtech.domain.model.PixabayImage
import com.vlahovtech.loginregisterdemo.databinding.ListItemImageBinding

class PixabayImageAdapter(
    private val onImageClicked: (PixabayImage) -> Unit,
) :
    PagingDataAdapter<PixabayImage, RecyclerView.ViewHolder>(DiffUtilComparator) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position) ?: return
        (holder as? PixabayImageViewHolder)?.bind(item = item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemImageBinding.inflate(
            /* inflater = */ LayoutInflater.from(parent.context),
            /* parent = */ parent,
            /* attachToParent = */ false
        )
        return PixabayImageViewHolder(binding, onImageClicked)
    }

    /**
     * view holder class
     */
    class PixabayImageViewHolder(
        private val binding: ListItemImageBinding,
        private val onClick: (item: PixabayImage) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PixabayImage) {
            binding.apply {
                Glide
                    .with(root.context)
                    .load(item.previewUrl)
                    .into(imageThumbnail)
                textUser.text = item.user
                root.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }


    companion object {
        private val DiffUtilComparator = object : DiffUtil.ItemCallback<PixabayImage>() {

            override fun areItemsTheSame(
                oldItem: PixabayImage,
                newItem: PixabayImage,
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: PixabayImage,
                newItem: PixabayImage,
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}