package com.tahakorkem.expandablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val groups = listOf(
            SampleGroup(
                title = "A",
                children = listOf(
                    SampleChild("Adana"),
                    SampleChild("Adıyaman"),
                    SampleChild("Afyonkarahisar"),
                    SampleChild("Ağrı"),
                    SampleChild("Amasya"),
                    SampleChild("Ankara"),
                    SampleChild("Antalya"),
                    SampleChild("Artvin"),
                    SampleChild("Aydın"),
                )
            ),
            SampleGroup(
                title = "B",
                children = listOf(
                    SampleChild("Balıkesir"),
                    SampleChild("Bilecik"),
                    SampleChild("Bingöl"),
                    SampleChild("Bitlis"),
                    SampleChild("Bolu"),
                    SampleChild("Burdur"),
                    SampleChild("Bursa"),
                )
            ),
            SampleGroup(
                title = "Ç",
                children = listOf(
                    SampleChild("Çanakkale"),
                    SampleChild("Çankırı"),
                    SampleChild("Çorum"),
                )
            ),
            SampleGroup(
                title = "D",
                children = listOf(
                    SampleChild("Denizli"),
                    SampleChild("Diyarbakır"),
                )
            ),
            SampleGroup(
                title = "E",
                children = listOf(
                    SampleChild("Edirne"),
                    SampleChild("Elazığ"),
                    SampleChild("Erzincan"),
                    SampleChild("Erzurum"),
                    SampleChild("Eskişehir"),
                )
            ),
            SampleGroup(
                title = "G",
                children = listOf(
                    SampleChild("Gaziantep"),
                    SampleChild("Giresun"),
                    SampleChild("Gümüşhane"),
                )
            ),
            SampleGroup(
                title = "H",
                children = listOf(
                    SampleChild("Hakkari"),
                    SampleChild("Hatay"),
                )
            ),
            SampleGroup(
                title = "I",
                children = listOf(
                    SampleChild("Isparta"),
                )
            ),
            SampleGroup(
                title = "İ",
                children = listOf(
                    SampleChild("İstanbul"),
                    SampleChild("İzmir"),
                )
            ),
            SampleGroup(
                title = "K",
                children = listOf(
                    SampleChild("Kars"),
                    SampleChild("Kastamonu"),
                    SampleChild("Kayseri"),
                    SampleChild("Kırklareli"),
                    SampleChild("Kırşehir"),
                    SampleChild("Kocaeli"),
                    SampleChild("Konya"),
                    SampleChild("Kütahya"),
                )
            ),
            SampleGroup(
                title = "M",
                children = listOf(
                    SampleChild("Malatya"),
                    SampleChild("Manisa"),
                    SampleChild("Mardin"),
                    SampleChild("Muğla"),
                    SampleChild("Muş"),
                )
            ),
            SampleGroup(
                title = "N",
                children = listOf(
                    SampleChild("Nevşehir"),
                    SampleChild("Niğde"),
                )
            ),
            SampleGroup(
                title = "O",
                children = listOf(
                    SampleChild("Ordu"),
                )
            ),
            SampleGroup(
                title = "R",
                children = listOf(
                    SampleChild("Rize"),
                )
            ),
            SampleGroup(
                title = "S",
                children = listOf(
                    SampleChild("Sakarya"),
                    SampleChild("Samsun"),
                    SampleChild("Siirt"),
                    SampleChild("Sinop"),
                    SampleChild("Sivas"),
                )
            ),
            SampleGroup(
                title = "Ş",
                children = listOf(
                    SampleChild("Şanlıurfa"),
                )
            ),
            SampleGroup(
                title = "T",
                children = listOf(
                    SampleChild("Tekirdağ"),
                    SampleChild("Tokat"),
                    SampleChild("Trabzon"),
                    SampleChild("Tunceli"),
                )
            ),
            SampleGroup(
                title = "U",
                children = listOf(
                    SampleChild("Uşak"),
                )
            ),
            SampleGroup(
                title = "V",
                children = listOf(
                    SampleChild("Van"),
                )
            ),
            SampleGroup(
                title = "Y",
                children = listOf(
                    SampleChild("Yozgat"),
                )
            ),
            SampleGroup(
                title = "Z",
                children = listOf(
                    SampleChild("Zonguldak"),
                )
            ),
        )
        val adapter = SampleAdapter(groups)
        recyclerView.adapter = adapter
    }
}