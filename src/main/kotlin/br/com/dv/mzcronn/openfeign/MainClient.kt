package br.com.dv.mzcronn.openfeign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "mzClient", url = "https://www.managerzone.com", configuration = [FeignConfig::class])
interface MainClient {

    @GetMapping("/ajax.php?p=coaches&sub=hire-coaches&coachClass=5&country=0&skills_conjunction=and&of=cl_{of}&od=2&sport=soccer&o=0")
    fun getCoachesHtml(@PathVariable("of") of: Int): String

    @GetMapping("/ajax.php?p=transfer&sub=transfer-search&sport=soccer&issearch=true&u=&nationality={nationality}&deadline=0&category=&valuea=&valueb=&bida=&bidb=&agea=19&ageb=37&tot_low=0&tot_high=110&s0a=0&s0b=10&s1a=0&s1b=10&s2a=0&s2b=10&s3a=0&s3b=10&s4a=0&s4b=10&s5a=0&s5b=10&s6a=0&s6b=10&s7a=0&s7b=10&s8a=0&s8b=10&s9a=0&s9b=10&s10a=0&s10b=10&s11a=0&s11b=10&s12a=0&s12b=10")
    fun getTransferMarketHtml(@PathVariable("nationality") nationality: Int): String

}
