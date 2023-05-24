package th4mz0.credit.application.system.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import th4mz0.credit.application.system.entity.Credit
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long>{
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId : Long): List<Credit>
}