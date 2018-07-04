package cloud.disciplina;

import java.util.Arrays;

import org.springframework.hateoas.Resources;

public class AlunoClientFallback implements AlunoClient{

	@Override
	public Resources<AlunoDTO> getAllAlunos() {
		return new Resources<AlunoDTO>(Arrays.asList(new AlunoDTO()));
	}

	@Override
	public AlunoDTO getAluno(Long id) {
		return new AlunoDTO();
	}

}
