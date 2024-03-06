package br.com.dv.mzcronn.coach

import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class CoachParser {

    fun parse(html: String): List<Coach> {
        val doc = Jsoup.parse(html)
        val coaches = mutableListOf<Coach>()

        doc.select("table#coaches_list tbody tr").forEach { row ->
            val name = row.select("td").first()?.text() ?: ""
            val countryImg = row.select("td img").first()
            val country = countryImg?.attr("title") ?: ""

            if (name.isNotBlank() && country.isNotBlank()) {
                coaches.add(Coach(name, country))
            }
        }

        return coaches
    }

}
