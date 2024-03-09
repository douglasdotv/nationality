package br.com.dv.mzcronn.mrequest

import org.springframework.stereotype.Service

@Service
class MRequestServiceImpl(private val repository: MRequestRepository) : MRequestService {

    override fun saveRequest(content: String): MRequest {
        return repository.save(MRequest(content = content))
    }

}
