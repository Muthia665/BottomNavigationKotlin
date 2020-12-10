package com.muzaaz.bottomnavigationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.FragmentTransitionImpl
import com.muzaaz.bottomnavigationkotlin.UI.Favorite_Fragment
import com.muzaaz.bottomnavigationkotlin.UI.Home_Fragment
import com.muzaaz.bottomnavigationkotlin.UI.Profile_Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var home_Fragment : Home_Fragment
    lateinit var favorite_Fragment : Favorite_Fragment
    lateinit var profile_Fragment : Profile_Fragment

    // buat object untuk manggil fragment2 nya yang kita buat, karena kita ngebuat bottom nav nya di main activity jadi harusdi panggil dulu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            home_Fragment = Home_Fragment()
            supportFragmentManager.beginTransaction().replace(R.id.frame_layout, home_Fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()

        // setOnNavigationItemReselectedListener = function untuk klik bottom nav
        bottom_nav.setOnNavigationItemSelectedListener { item ->
                when(item.itemId){

                R.id.home -> {
                    // ketika di pilih item home, mau pindah ke mana?, home fragment
                    home_Fragment = Home_Fragment()
                    // support fragment manager =
                    //kelas FragmentManager dan kelas FragmentTransaction memungkinkan kita untuk menambah,
                    // dan menghapusmenimpa fragment yang ada di layout saat activity sedang aktif.
                    supportFragmentManager.beginTransaction()
                        // replace = menggantikan atau menimpa frame layout menjadi fragment yang di panggil
                        .replace(R.id.frame_layout, home_Fragment)
                        // setTransaction = melakukan transisi ketika di buka dan kita buka halaman home,
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        // commit = menyetujui / menjalankan
                        .commit()
                }

                R.id.favorite -> {
                    favorite_Fragment = Favorite_Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, favorite_Fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }

                R.id.profile -> {
                    profile_Fragment = Profile_Fragment()
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout, profile_Fragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
                }
            }
            // harus mengembalikan nilai
            true
        }
    }
}
