package br.com.dv.mzcronn.mrequest

import br.com.dv.mzcronn.util.logger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MRequestController(private val service: MRequestService) {

    private val log by logger()

    companion object {
        const val CONFIRMATION = "Data received"
    }

    @PostMapping("/receive")
    fun receiveData(@RequestBody data: String): String {
        log.info("Received data: $data")
        service.saveRequest(data)
        return CONFIRMATION
    }

}
