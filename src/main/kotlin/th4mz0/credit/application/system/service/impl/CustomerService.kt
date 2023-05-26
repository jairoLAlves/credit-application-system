package th4mz0.credit.application.system.service.impl

import org.springframework.stereotype.Service
import th4mz0.credit.application.system.entity.Customer
import th4mz0.credit.application.system.exception.BusinessException
import th4mz0.credit.application.system.repository.CustomerRepository
import th4mz0.credit.application.system.service.ICustomerService

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer {
         return this.customerRepository.findById(id).orElseThrow{
             throw BusinessException("Id $id not found")

        }
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)

    }
}