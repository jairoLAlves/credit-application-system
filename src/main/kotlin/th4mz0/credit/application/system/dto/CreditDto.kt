package th4mz0.credit.application.system.dto

import jakarta.persistence.Column
import jakarta.persistence.Enumerated
import jakarta.persistence.ManyToOne
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import th4mz0.credit.application.system.entity.Credit
import th4mz0.credit.application.system.entity.Customer
import th4mz0.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditDto(
    @field:NotNull(message = "Invalid input")
    val creditValue: BigDecimal,

    @field:Future (message = "Invalid input")
    // TODO - max value
    val dayFristInstallment: LocalDate,

    @field:NotNull(message = "Invalid input")
    // TODO - max value
    val numberOfInstallments: Int,

    @field:NotNull(message = "Invalid input")
    var customerId: Long,
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFristInstallment = this.dayFristInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )

}
