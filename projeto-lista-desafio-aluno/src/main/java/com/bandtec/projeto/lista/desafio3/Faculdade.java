package com.bandtec.projeto.lista.desafio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculdade {

    private String nome;
    private List<Aluno> alunos;

    public Faculdade(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<>();

    }

    /*
        Deve verificar se existe um aluno com o nome informado, caso não exista,
        retorne false;
    */
    public Boolean existsAlunoPorNome(String nome) {
        return alunos.stream().anyMatch(a -> a.getNome().equalsIgnoreCase(nome));
    }

    /*
        Deve matricular um aluno na faculdade (inserir na lista), se a lista já
        possuir um aluno com o nome informado, não deve matricular;
    */
    public void matricularAluno(Aluno aluno) {
        if(aluno == null){
            System.out.println("nulo");
        }else{
            Boolean temAluno = existsAlunoPorNome(aluno.getNome());
            if(!temAluno){
                alunos.add(aluno);
            }else{
                System.out.println("Já tem aluno");
            }
        }

    }

    /*
        Deve cancelar a matricula de um aluno na faculdade (ativo = false), se não existir
        um aluno com o RA informado, não faça nada.
    */
    public void cancelarMatricula(String ra) {
        boolean temRa = alunos.stream().anyMatch(a -> a.getRa().equals(ra));
        if(!temRa){
            System.out.println("não tem aluno");
        }else{
            alunos.stream().filter(a -> a.getRa().equals(ra)).forEach(a -> a.setAtivo(false));
        }


    }

    /*
        Deve retornar a quantidade de alunos contidos na lista (matriculados);
    */
    public Integer getQuantidadeAlunos() {
        return alunos.stream().toList().size();
    }

    /*
        Deve retornar a quantidade de alunos matriculados (contidos na lista)
        que estão no semestre informado;
    */
    public Integer getQuantidadeAlunosPorSemestre(Integer semestre) {
        return alunos.stream().filter(aluno -> aluno.getSemestre().equals(semestre)).toList().size();
    }

    /*
        Deve retornar a quantidade de alunos com matricula cancelada (contidos na lista);
    */
    public Integer getQuantidadeAlunosComMatriculaCancelada() {
        return alunos.stream().filter(a -> a.isAtivo().equals(false)).toList().size();
    }

    public String getNome() {
        return nome;
    }
}
