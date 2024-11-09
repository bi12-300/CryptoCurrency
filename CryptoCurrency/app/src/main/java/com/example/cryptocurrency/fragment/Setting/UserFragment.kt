import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.cryptocurrency.R

class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        // Cài đặt Thông báo
        val transactionNotificationsSwitch: Switch = view.findViewById(R.id.transactionNotificationsSwitch)
        val securityAlertsSwitch: Switch = view.findViewById(R.id.securityAlertsSwitch)
        val marketUpdatesSwitch: Switch = view.findViewById(R.id.marketUpdatesSwitch)

        transactionNotificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Đã bật thông báo giao dịch", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Đã tắt thông báo giao dịch", Toast.LENGTH_SHORT).show()
            }
        }

        securityAlertsSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Đã bật cảnh báo bảo mật", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Đã tắt cảnh báo bảo mật", Toast.LENGTH_SHORT).show()
            }
        }

        marketUpdatesSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(requireContext(), "Đã bật cập nhật thị trường", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Đã tắt cập nhật thị trường", Toast.LENGTH_SHORT).show()
            }
        }

        // Ngôn ngữ và Cài đặt Khu vực
        val languageSpinner: Spinner = view.findViewById(R.id.languageSpinner)
        val currencySpinner: Spinner = view.findViewById(R.id.currencySpinner)

        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedLanguage = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), "Đã chọn ngôn ngữ: $selectedLanguage", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Không làm gì nếu không có mục nào được chọn
            }
        }

        currencySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCurrency = parent.getItemAtPosition(position).toString()
                Toast.makeText(requireContext(), "Đã chọn đơn vị tiền tệ: $selectedCurrency", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Không làm gì nếu không có mục nào được chọn
            }
        }

        return view
    }
}
