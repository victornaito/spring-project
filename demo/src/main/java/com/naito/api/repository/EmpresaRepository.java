package com.naito.api.repository;

import com.naito.api.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository  extends JpaRepository<Empresa, Long>{

//    @Query(nativeQuery = true,
//            value = "SELECT * FROM empresa")
//    List<Empresa> buscaClientesEnviadosPeloSigVivo();
}
