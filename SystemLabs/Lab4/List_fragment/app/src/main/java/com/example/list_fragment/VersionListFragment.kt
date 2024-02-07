// src/main/java/com/example/myandroidversions/VersionListFragment.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import com.example.list_fragment.AndroidVersion
import com.example.list_fragment.R
class VersionListFragment : ListFragment() {

    private val androidVersions = listOf(
        AndroidVersion("Android 1.5 Cupcake", 3, R.drawable.android_version_logo_2009_2011),
        AndroidVersion("Android 1.6 Donut", 4, R.drawable.android_version_logo_2009_2011_donut_768x483),
        AndroidVersion("Android 2.0/2.1 Eclair", 5, R.drawable.android_version_logo_2009_2011_eclair_768x483),
        AndroidVersion("Android 2.2 Froyo", 8, R.drawable.android_version_logo_2010),
        AndroidVersion("Android 2.3 Gingerbread", 9, R.drawable.android_version_logo_2010_2012_768x483),
        AndroidVersion("Android 3.0/3.1/3.2 Honeycomb", 11, R.drawable.android_version_logo_2011_768x483),
        AndroidVersion("Android 4.0 Ice Cream Sandwich", 14, R.drawable.android_version_logo_2011_2013_768x483),
        AndroidVersion("Android 4.1/4.2/4.3 Jelly Bean", 16, R.drawable.android_version_logo_2012_768x483),
        AndroidVersion("Android 4.4 KitKat", 19, R.drawable.android_version_logo_2013),
        AndroidVersion("Android 5.0/5.1 Lollipop", 21, R.drawable.android_version_logo_2014_768x483),
        AndroidVersion("Android 6.0 Marshmallow", 23, R.drawable.android_version_logo_2015),
        AndroidVersion("Android 7.0/7.1 Nougat", 24, R.drawable.android_version_logo_2016_768x483),
        AndroidVersion("Android 8.0/8.1 Oreo", 26, R.drawable.android_version_logo_2017_768x483),
        AndroidVersion("Android 9 Pie", 28, R.drawable.android_version_logo_2018_768x483),
        AndroidVersion("Android 10", 29, R.drawable.android_version_logo_2019_768x483),
        // Add more versions as needed
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = VersionAdapter(requireContext(), androidVersions)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
