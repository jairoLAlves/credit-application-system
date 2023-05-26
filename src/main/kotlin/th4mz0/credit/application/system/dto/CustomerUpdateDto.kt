package th4mz0.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import th4mz0.credit.application.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid input")
    val firstName: String,

    @field:NotEmpty(message = "Invalid input")
    val lastName: String,

    @field:NotNull(message = "Invalid input")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid input")
    val zipCode: String,
    @field:NotEmpty(message = "Invalid input")
    val street: String

) {
    fun toEntiry(customer: Customer): Customer{
        customer.firstName = firstName
        customer.lastName = lastName
        customer.income = income
        customer.address.zipCode = zipCode
        customer.address.street = street

        return customer
    }

}
