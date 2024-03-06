package br.com.dv.mzcronn

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class CoachService(private val client: MainClient, private val parser: CoachParser) {

    private val log by logger()

    private var coachesCache: List<Coach> = listOf()

    fun getCoaches(): List<Coach> {
        return coachesCache
    }

    @Scheduled(fixedRate = 150000)
    fun updateCoaches() {
        val html = client.getCoachesHtml()
        coachesCache = parser.parse(html)
        log.info("Coaches updated: $coachesCache")
    }

}
