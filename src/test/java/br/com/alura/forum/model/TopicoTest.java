package br.com.alura.forum.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class TopicoTest {

	@Test
	public void o_estado_inicial_de_um_topico_deve_ser_nao_respondido() {
		// Dado
		Usuario autor = new Usuario("Newton", "newton@caelum.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
				
		// Então
		assertEquals(StatusTopico.NAO_RESPONDIDO, topico.getStatus());
	}
	
	@Test
	public void o_estado_deve_ser_fechado_quando_fechar_um_topico() {
		// Dado
		Usuario autor = new Usuario("Newton", "newton@caelum.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
		
		// Quando
		topico.fechar();
		
		// Então
		assertEquals(StatusTopico.FECHADO, topico.getStatus()); 
	}
	
	@Test
	public void ao_adicionar_uma_resposta_a_lista_de_respostas_deve_ter_mais_uma_resposta() {
		// Dado
		Usuario autor = new Usuario("Newton", "newton@caelum.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
				
		Resposta resposta = new Resposta("Adicione o Java no PATH", topico, autor);
		
		// Quando
		topico.addResposta(resposta);
		
		// Então
		assertEquals(2, topico.getRespostas().size());
	}
	
	@Test
	public void ao_marcar_como_solucionado_statustopicos_deve_ser_solucionado() {
		// Dado
		Usuario autor = new Usuario("Newton", "newton@caelum.com", "abc123");
		Categoria categoria = new Categoria("Programação");
		Curso curso = new Curso("Java Básico", categoria );
		Topico topico = new Topico("Me ajudem", "O Java não funciona no meu computador!", autor , curso );
				
		//Resposta resposta = new Resposta("Adicione o Java no PATH", topico, autor);
		
		// Quando
		//topico.addResposta(resposta);
		topico.marcarComoSolucionado();
		// Então
		assertEquals(StatusTopico.SOLUCIONADO, topico.getStatus());
		
	}

}