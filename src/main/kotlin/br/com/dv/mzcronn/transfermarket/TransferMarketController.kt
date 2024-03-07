package br.com.dv.mzcronn.transfermarket

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class TransferMarketController(private val transferMarketService: TransferMarketService) {

    @GetMapping("/transfer-market")
    fun listTransferMarketPlayers(): ModelAndView {
        val playersPerCountry = transferMarketService.getTransferMarketData()
        return ModelAndView("transfermarket").apply {
            addObject("playersPerCountry", playersPerCountry)
        }
    }

}
