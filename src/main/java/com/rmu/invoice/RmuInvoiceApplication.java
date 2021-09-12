package com.rmu.invoice;

import com.rmu.invoice.model.*;
import com.rmu.invoice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class RmuInvoiceApplication {

    private static UserRepository userRepository;
    private static RoleRepository roleRepository;
    private static CompanyRepository companyRepository;
    private static EmployeeRepository employeeRepository;
    private static ProductRepository productRepository;
    private static InvoiceRepository invoiceRepository;
    private static ProFormaRepository proFormaRepository;
    private static BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public RmuInvoiceApplication(UserRepository userRepository,
                                 RoleRepository roleRepository,
                                 BCryptPasswordEncoder bCryptPasswordEncoder,
                                 CompanyRepository companyRepository,
                                 EmployeeRepository employeeRepository,
                                 ProductRepository productRepository,
                                 InvoiceRepository invoiceRepository,
                                 ProFormaRepository proFormaRepository){
        RmuInvoiceApplication.userRepository = userRepository;
        RmuInvoiceApplication.roleRepository = roleRepository;
        RmuInvoiceApplication.bCryptPasswordEncoder = bCryptPasswordEncoder;
        RmuInvoiceApplication.companyRepository = companyRepository;
        RmuInvoiceApplication.employeeRepository = employeeRepository;
        RmuInvoiceApplication.productRepository = productRepository;
        RmuInvoiceApplication.invoiceRepository = invoiceRepository;
        RmuInvoiceApplication.proFormaRepository = proFormaRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(RmuInvoiceApplication.class, args);

        Date date = new Date();

//        Role role = new Role();
//        role.setId(1L);
//
//        User user = new User(
//                "Rita",
//                "Dede",
//                "dede@gmail.com",
//                bCryptPasswordEncoder.encode("RitaPass"),
//                "Comm 2, George Pub",
//                "Italian flat",
//                true,
//                date,
//                556607264);
//
//        user.setRole(role);
//        userRepository.save(user);

//        User user = new User();
//        user.setId(2L);
//
      //Role role = user.getRole();

//
//        userRepository.findById(user.getId())
//                .orElseThrow( () -> new UsernameNotFoundException("User not found"));
//             System.out.println(userRepository.findByEmail("dede@gmail.com"));
    }

    @Transactional
    public User getUser(){
        User user = new User();
        user.setId(1L);

       return userRepository.findById(user.getId())
               .orElseThrow( () -> new UsernameNotFoundException("User not found"));
    }

}
