package br.com.dv.mzcronn.coach

import br.com.dv.mzcronn.openfeign.MainClient
import br.com.dv.mzcronn.util.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class CoachServiceImpl(private val client: MainClient, private val parser: CoachParser) : CoachService {

    private val log by logger()

    private var coachesCache: List<Coach> = listOf()

    override fun getCoaches(): List<Coach> {
        return coachesCache
    }

    @Scheduled(fixedRate = 150000)
    fun updateCoaches() {
        val html = client.getCoachesHtml()
        coachesCache = parser.parse(html)
        log.info("Coaches updated: $coachesCache")
    }

}
