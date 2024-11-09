import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class PrivacyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_privacy, container, false)

        // Phần đầu (Header)
        val headerTitle: TextView = view.findViewById(R.id.headerTitle)
        val headerDescription: TextView = view.findViewById(R.id.headerDescription)
        headerTitle.text = "Chính sách bảo mật"
        headerDescription.text = "Chúng tôi cam kết bảo vệ quyền riêng tư của bạn và đảm bảo thông tin cá nhân của bạn luôn an toàn."

        // Quyền lợi của người dùng

        val deleteDataButton: Button = view.findViewById(R.id.deleteDataButton)


        deleteDataButton.setOnClickListener {
            // Xử lý yêu cầu xóa dữ liệu
            Toast.makeText(context, "Yêu cầu xóa dữ liệu đã được gửi.", Toast.LENGTH_SHORT).show()
        }

        // Nút Yêu cầu hỗ trợ
        val requestSupportButton: Button = view.findViewById(R.id.contactSupportButton)
        requestSupportButton.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf("hoanghai1003hh@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Yêu cầu hỗ trợ về quyền riêng tư")
            }
            if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(context, "Không có ứng dụng email nào khả dụng.", Toast.LENGTH_SHORT).show()
            }
        }
        val emailEditText: EditText = view.findViewById(R.id.emailEditText)
        val buttonVerify: Button = view.findViewById(R.id.buttonVerify)
        val passwordEditText: EditText = view.findViewById(R.id.passwordEditText)
        val buttonVerify1: Button = view.findViewById(R.id.buttonVerify1)

        // Set up button click listener for email verification
        buttonVerify.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isNotEmpty()) {
                // Disable the EditText to make it non-editable
                emailEditText.apply {
                    isFocusable = false
                    isFocusableInTouchMode = false
                    isClickable = false
                }
                // Show confirmation message
                Toast.makeText(requireContext(), "Email Verified: $email", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(requireContext(), "Please enter a valid email.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        // Set up button click listener for password verification
        buttonVerify1.setOnClickListener {
            val password = passwordEditText.text.toString()

            if (password.isNotEmpty()) {
                // Disable the EditText to make it non-editable
                passwordEditText.apply {
                    isFocusable = false
                    isFocusableInTouchMode = false
                    isClickable = false
                }
                // Show confirmation message
                Toast.makeText(requireContext(), "Password Verified: $password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter a valid password.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }
}
