package br.com.dv.mzcronn.coach

import br.com.dv.mzcronn.openfeign.MainClient
import br.com.dv.mzcronn.util.logger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
class CoachServiceImpl(private val client: MainClient, private val parser: CoachParser) : CoachService {

    private val log by logger()

    private val coachesCache: MutableMap<Int, List<Coach>> = mutableMapOf()

    override fun getCoachesByClass(n: Int): List<Coach> = coachesCache[n] ?: listOf()

    @Scheduled(fixedRate = 150000)
    fun updateCoaches() {
        (1..13).forEach { n ->
            try {
                val html = client.getCoachesHtml(n)
                coachesCache[n] = parser.parse(html)

                log.info("""
                    |Updated cl_$n coaches:
                    |${coachesCache[n]}
                """.trimMargin())

                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                log.warning("Thread interrupted while updating cl_$n coaches")
            }
        }
    }

}
