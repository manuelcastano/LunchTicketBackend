package com.example.lunchticketbackend.service

import com.example.lunchticketbackend.entity.Employee_R
import com.example.lunchticketbackend.entity.Restaurant
import com.example.lunchticketbackend.model.BooleanResponse
import com.example.lunchticketbackend.repository.EmployeeRRepo
import org.springframework.stereotype.Service

@Service
class EmployeeRServiceImplementation(val employeeRRepo: EmployeeRRepo): EmployeeRServiceInterface {

    override fun loginEmployee(document: String, password: String): Employee_R? {
        return employeeRRepo.loginEmployee(document, password)
    }

    override fun deactivateEmployeeR(id: String): BooleanResponse {
        var employeeVerification: Employee_R? = employeeRRepo.findEmployee(id)
        if (employeeVerification == null) {
            return BooleanResponse(false, "El empleado no existe")
        } else {
            employeeRRepo.deactivateEmployee(id)
            return BooleanResponse(true, "Desactivado exitosamente")
        }
    }
}