package th4mz0.credit.application.system.dto


import jakarta.validation.constraints.*
import th4mz0.credit.application.system.entity.Credit
import th4mz0.credit.application.system.entity.Customer

import java.math.BigDecimal
import java.time.LocalDate


data class CreditDto(
    @field:NotNull(message = "Invalid input")
    val creditValue: BigDecimal,

    @field:Future (message = "Invalid input")
    // TODO - max value
    val dayFristInstallment: LocalDate,

    @field:NotNull(message = "Invalid input")
    @field:Max( value = 48)
    @field:Min( value = 1)
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
