package br.com.dv.mzcronn.mrequest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MRequestController(private val service: MRequestService) {

    companion object {
        const val CONFIRMATION = "Data received"
    }

    @PostMapping("/receive")
    fun receiveData(@RequestBody data: String): String {
        service.saveRequest(data)
        return CONFIRMATION
    }

}
