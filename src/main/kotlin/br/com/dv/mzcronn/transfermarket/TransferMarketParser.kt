package br.com.dv.mzcronn.transfermarket

import org.springframework.stereotype.Component
import java.util.regex.Pattern

@Component
class TransferMarketParser {

    fun parse(html: String): Int {
        val pattern = Pattern.compile("\"totalHits\":\"(\\d+)\"")
        val matcher = pattern.matcher(html)
        return if (matcher.find()) matcher.group(1).toInt() else 0
    }

}
