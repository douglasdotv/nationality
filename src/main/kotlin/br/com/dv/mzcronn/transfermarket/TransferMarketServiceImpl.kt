package br.com.dv.mzcronn.transfermarket

import br.com.dv.mzcronn.common.CountryDataService
import br.com.dv.mzcronn.openfeign.MainClient
import br.com.dv.mzcronn.util.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class TransferMarketServiceImpl(private val client: MainClient,
                                private val parser: TransferMarketParser,
                                countryDataService: CountryDataService) : TransferMarketService {

    private val log by logger()

    private var transferMarketCache: MutableMap<String, Int> = mutableMapOf()

    private val countriesMap = countryDataService.getCountryMap().map { it.value to it.key.toInt() }.toMap()

    override fun getTransferMarketData(): Map<String, Number> {
        return transferMarketCache
    }

    @Scheduled(fixedRate = 3600000)
    override fun updateTransferMarketData() {
        countriesMap.forEach { (countryName, countryId) ->
            val html = client.getTransferMarketHtml(countryId)
            val totalPlayers = parser.parse(html)
            transferMarketCache[countryName] = totalPlayers
            log.info("Transfer market – $countryName total players: $totalPlayers")
        }
    }

}
