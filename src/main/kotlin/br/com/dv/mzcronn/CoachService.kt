package br.com.dv.mzcronn

import org.springframework.stereotype.Service

@Service
class CoachService {

    fun fetchCoaches(): List<Coach> {
        return listOf(
            Coach("John Doe", "Singapore"),
            Coach("Neymar", "Denmark"),
        )
    }

}
