package atulps.com.technicalassignment.utility

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * [loadImage]
 * @brief Binding extension to load normal rectangular images using Glide
 * @param view: ImageView, uri: String, placeholder: Drawable
 * @author atul.ps
 * @date 03/27/2019
 */
@BindingAdapter(value = ["uri", "placeholder"], requireAll = false)
fun loadImage(view: ImageView, imageUri: String, placeholder: Drawable) {
    Glide.with(view.context)
        .load(imageUri)
        .placeholder(placeholder)
        .into(view)
}

/**
 * [loadCircularImage]
 * @brief Binding extension to load circular images using Glide
 * @param view: ImageView, imageUri: String, error: Drawable
 * @author atul.ps
 * @date 03/27/2019
 */
@BindingAdapter(value = ["imageUri", "error"], requireAll = false)
fun loadCircularImage(view: ImageView, imageUri: String, error: Drawable) {
    Glide.with(view.context)
        .load(imageUri)
        .placeholder(error)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}
