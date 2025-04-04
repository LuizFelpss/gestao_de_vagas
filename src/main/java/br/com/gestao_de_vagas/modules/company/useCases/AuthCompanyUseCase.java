package br.com.gestao_de_vagas.modules.company.useCases;

import br.com.gestao_de_vagas.modules.company.DTO.AuthCompanyDTO;
import br.com.gestao_de_vagas.modules.company.repository.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;


@Service
public class AuthCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretkey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("username/password incorrect");
        });

        //verifica se as senhas são iguais
        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        // se não for igual -> erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        //se for igual -> gerar token
        Algorithm algorithm = Algorithm.HMAC256(secretkey);
        var token = JWT.create().withIssuer("GestaoVagas")
                .withSubject(company.getId().toString())
                .sign(algorithm);

        return token;
    }

}
