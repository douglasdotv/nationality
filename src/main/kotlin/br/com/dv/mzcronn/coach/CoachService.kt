package br.com.dv.mzcronn.coach

interface CoachService {

    fun getCoachesByClass(n: Int): List<Coach>

}
