package br.com.dv.mzcronn

import org.springframework.stereotype.Service

@Service
class CoachService(private val client: MainClient, private val parser: CoachParser) {

    fun fetchCoaches(): List<Coach> {
        return client.getCoachesHtml().let { parser.parse(it) }
    }

}
