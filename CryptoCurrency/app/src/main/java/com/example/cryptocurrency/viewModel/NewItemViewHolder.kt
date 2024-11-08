package com.example.cryptocurrency.viewModel
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocurrency.R
import com.example.cryptocurrency.domain.Post
// ViewHolder để quản lý các thành phần trong một item (bài viết)
class NewItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // Tìm các view từ layout (new_item.xml) và gán vào các biến
    val postLogo: ImageView = itemView.findViewById(R.id.post_logo)
    val postUsername: TextView = itemView.findViewById(R.id.post_username)
    val postTime: TextView = itemView.findViewById(R.id.post_time)
    val followButton: Button = itemView.findViewById(R.id.follow_button)
    val settingsButton: ImageButton = itemView.findViewById(R.id.settings_button)
    val postTitle: TextView = itemView.findViewById(R.id.post_title)
    val postContent: TextView = itemView.findViewById(R.id.post_content)
    val postImage: ImageView = itemView.findViewById(R.id.post_image)
    val buttonLike: ImageButton = itemView.findViewById(R.id.button_like)
    val buttonShare: ImageButton = itemView.findViewById(R.id.button_share)
    val buttonComment: ImageButton = itemView.findViewById(R.id.button_comment)

    // Phương thức này gắn dữ liệu vào các views từ một đối tượng Post
    fun bind(post: Post) {
        postUsername.text = post.username  // Gắn tên người đăng
        postContent.text = post.content  // Gắn nội dung bài viết
        postImage.setImageResource(post.imageResId)  // Gắn hình ảnh bài viết

        // Định nghĩa sự kiện click nếu cần thiết
        buttonLike.setOnClickListener {
            // Xử lý khi nhấn nút Like
        }

        buttonShare.setOnClickListener {
            // Xử lý khi nhấn nút Share
        }

        buttonComment.setOnClickListener {
            // Xử lý khi nhấn nút Comment
        }

        followButton.setOnClickListener {
            // Xử lý khi nhấn nút Theo dõi
        }

        settingsButton.setOnClickListener {
            // Xử lý khi nhấn nút Cài đặt
        }
    }
}
