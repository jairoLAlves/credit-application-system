package th4mz0.credit.application.system.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import th4mz0.credit.application.system.dto.CustomerDto
import th4mz0.credit.application.system.dto.CustomerUpdateDto
import th4mz0.credit.application.system.dto.CustomerView
import th4mz0.credit.application.system.entity.Customer
import th4mz0.credit.application.system.service.impl.CustomerService

@RestController
@RequestMapping("/api/customers")
class CustomerController(
    private val customerService: CustomerService,

) {


    @PostMapping
    fun salveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer =  this.customerService.save(customer = customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Customer ${savedCustomer.email} saved!")


    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
       val customer: Customer =  this.customerService.findById(id=id)
        return  ResponseEntity.status(HttpStatus.OK).body(CustomerView(
            customer = customer
        ))



    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        this.customerService.delete(id=id)

    }


    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long,
                       @RequestBody customerUpdateDto: CustomerUpdateDto,): ResponseEntity<CustomerView> {

        val customer: Customer = this.customerService.findById(id)

        val customerToUpdate: Customer =  customerUpdateDto.toEntiry(customer)
        this.customerService.save(customerToUpdate)

        return ResponseEntity.status(HttpStatus.OK).body( CustomerView(
            customerToUpdate
        ))



    }






}