package br.com.dv.mzcronn.coach

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView

@Controller
class CoachController(private val coachService: CoachService) {

    @GetMapping("/coaches")
    fun listCoaches(@RequestParam(defaultValue = "1") n: Int): ModelAndView {
        val coaches = coachService.getCoachesByClass(n)

        return ModelAndView("coaches").apply {
            addObject("coaches", coaches)
            addObject("n", n)
        }
    }

}
