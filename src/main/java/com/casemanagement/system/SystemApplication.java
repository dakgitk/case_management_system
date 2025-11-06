package com.casemanagement.system;

import java.lang.reflect.Type;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.casemanagement.system.model.ClientCase;
import com.casemanagement.system.model.ClientCaseRepository;
import com.casemanagement.system.model.ClientRepository;
import com.casemanagement.system.model.CaseType;
import com.casemanagement.system.model.CaseTypeRepository;

@SpringBootApplication
public class SystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientCaseRepository clientcaseRepos, ClientRepository clientRepos,
			CaseTypeRepository CasetypeRepos) {

		return args -> {

			CaseType type1 = new CaseType("Civil");
			CaseType type2 = new CaseType("Criminal");
			CaseType type3 = new CaseType("Property");
			CasetypeRepos.save(type1);
			CasetypeRepos.save(type2);
			CasetypeRepos.save(type3);

			clientcaseRepos.save(new ClientCase("AAA5", "Tax Liability", "this is a case about unpaid taxes", type1));

			// Case 2: Legal Dispute
			clientcaseRepos.save(
					new ClientCase("BCD9", "Contract Dispute",
							"Litigation involving a breach of sales contract between two parties.", type2));

			// Case 3: Intellectual Property
			clientcaseRepos.save(
					new ClientCase("PQR3", "Patent Infringement",
							"A case filed to protect intellectual property rights against an unauthorized user.", type3));

			// Case 4: Real Estate
			clientcaseRepos.save(
					new ClientCase("XYZ1", "Property Settlement",
							"Handling the division and sale of a shared commercial property.", type1));

		

		};
	}

}
