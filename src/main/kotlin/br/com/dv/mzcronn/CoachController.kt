package br.com.dv.mzcronn

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class CoachController(private val coachService: CoachService) {

    @GetMapping("/coaches")
    fun listCoaches(): ModelAndView {
        val coaches = coachService.fetchCoaches()

        return ModelAndView("coaches").apply {
            addObject("coaches", coaches)
        }
    }

}
