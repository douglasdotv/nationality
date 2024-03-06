package br.com.dv.mzcronn

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "mzClient", url = "https://www.managerzone.com", configuration = [FeignConfig::class])
interface MainClient {

    @GetMapping("/ajax.php?p=coaches&sub=hire-coaches&coachClass=5&country=0&skills_conjunction=and&of=cl_4&od=2&sport=soccer&o=0")
    fun getCoachesHtml(): String

}
