package th4mz0.credit.application.system.dto

import jakarta.persistence.*
import th4mz0.credit.application.system.entity.Credit
import th4mz0.credit.application.system.entity.Customer
import th4mz0.credit.application.system.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments: Int,

) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments

    )

}
