package th4mz0.credit.application.system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import th4mz0.credit.application.system.entity.Customer

@Repository
interface CustomerRepository: JpaRepository<Customer, Long>