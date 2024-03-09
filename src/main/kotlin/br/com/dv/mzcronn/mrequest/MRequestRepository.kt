package br.com.dv.mzcronn.mrequest

import org.springframework.data.jpa.repository.JpaRepository

interface MRequestRepository : JpaRepository<MRequest, Long>