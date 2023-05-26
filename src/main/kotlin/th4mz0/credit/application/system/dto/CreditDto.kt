package th4mz0.credit.application.system.dto

import jakarta.persistence.Column
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import th4mz0.credit.application.system.entity.Credit
import th4mz0.credit.application.system.entity.Customer
import th4mz0.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDto(

    val creditValue: BigDecimal,
    val dayFristInstallment: LocalDate,
    val numberOfInstallments: Int,
    var customerId: Long,
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFristInstallment = this.dayFristInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )

}
