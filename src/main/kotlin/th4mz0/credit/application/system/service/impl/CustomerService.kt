package th4mz0.credit.application.system.service.impl

import org.springframework.stereotype.Service
import th4mz0.credit.application.system.entity.Customer
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
             throw RuntimeException("Id $id not found")

        }
    }

    override fun delete(id: Long) {
        return this.customerRepository.deleteById(id)
    }
}