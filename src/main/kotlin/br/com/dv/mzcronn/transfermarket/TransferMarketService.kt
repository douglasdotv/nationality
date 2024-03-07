package br.com.dv.mzcronn.transfermarket

interface TransferMarketService {

    fun getTransferMarketData(): Map<String, Number>

    fun updateTransferMarketData()

}
