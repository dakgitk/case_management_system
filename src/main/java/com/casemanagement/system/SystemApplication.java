package com.casemanagement.system;

import java.lang.reflect.Type;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.casemanagement.system.model.ClientCase;
import com.casemanagement.system.model.ClientCaseRepository;
import com.casemanagement.system.model.ClientRepository;
import com.casemanagement.system.model.client;
import com.casemanagement.system.model.AppUser;
import com.casemanagement.system.model.AppUserRepository;
import com.casemanagement.system.model.CaseType;
import com.casemanagement.system.model.CaseTypeRepository;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientCaseRepository clientcaseRepos, ClientRepository clientRepos,
			CaseTypeRepository CasetypeRepos,AppUserRepository appUserRepos) {

		return args -> {

			// CaseType type1 = new CaseType("Civil");
			// CaseType type2 = new CaseType("Criminal");
			// CaseType type3 = new CaseType("Property");
			// CasetypeRepos.save(type1);
			// CasetypeRepos.save(type2);
			// CasetypeRepos.save(type3);

			// // Demo Clients
			// client james = new client("James", "Hector", "jhector@gmail.com", "street 3, Westwood");
			// client sarah = new client("Sarah", "Connor", "sconnor@yahoo.com", "45 Oak Ave, Eastville");
			// client david = new client("David", "Kim", "dkim@outlook.com", "21 Elm St, Northport");
			// client maria = new client("Maria", "Rodriguez", "mrodriguez@company.net", "10 Cedar Blvd, South Heights");

			// clientRepos.save(james);
			// clientRepos.save(sarah);
			// clientRepos.save(david);
			// clientRepos.save(maria);

			// // Case 1: Tax Liability
			// ClientCase case1 = new ClientCase("AAA5", "Tax Liability", "Unpaid taxes", type1);

			// // Case 2: Legal Dispute
			// ClientCase case2 = new ClientCase("BCD9", "Contract Dispute", "Litigation over sales contract", type2);

			// // Case 3: Intellectual Property
			// ClientCase case3 = new ClientCase("PQR3", "Patent Infringement", "Intellectual property case", type3);

			// // Case 4: Real Estate
			// ClientCase case4 = new ClientCase("XYZ1", "Property Settlement", "Shared property dispute", type1);

			// // Link clients to cases
			// case1.getClients().add(james);
			// case2.getClients().add(sarah);
			// case3.getClients().add(david);
			// case4.getClients().add(maria);

			// // Save cases
			// clientcaseRepos.save(case1);
			// clientcaseRepos.save(case2);
			// clientcaseRepos.save(case3);
			// clientcaseRepos.save(case4);


			// AppUser admin = new AppUser("admin","$2a$12$DyMJVMms3JlzvjT2twvn4ukOIsC0TzwBQioIec33fEfhBS0hs5kOu","ADMIN");//admin
			// AppUser user1 = new AppUser("user1","$2a$08$aPk/9PFzHS9ymhKuO6bFhONKYVC0IGEHwmIDT83gxzYK2kKcekKpu","USER");
			// appUserRepos.save(admin);
			// appUserRepos.save(user1);
			

		};
	}

}
