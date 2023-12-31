package classes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	private static final String Clientes = null;
	private static EntityManager entity;
	private static List<Clientes> listaClientes = new ArrayList<>();
	private static List<Pecas> listaPecas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("PersistenceUnitJPA");
		entity = entityFactory.createEntityManager();
		int opcaocli1;
		int opcaocli2;
		
		//***********************MENU****************************
		
		while(true) {
			System.out.println("**************************");
			System.out.println("**************************");
			System.out.println("*****404SKATESHOP404******");
			System.out.println("***QUEIMANDO A RODINHA****");
			System.out.println("**************************");
			System.out.println("**************************\n\n");
			System.out.println("1 - Clientes ");
			System.out.println("2 - Peças ");
			System.out.println("3 - Fornecedores ");
			System.out.println("4 - Funcionários ");
			System.out.println("0 - Sair ");
			System.out.println("ESCOLHA PARA ONDE DESEJA IR:");
			int opcao = sc.nextInt();
			
			if (opcao==1) {
				limparConsole();
				
				System.out.println("1 - Cadastrar cliente");
				
				System.out.println("2 - Remover cliente");

				System.out.println("3 - Atualizar Dados cliente");
				
				System.out.println("4 - Tabela cliente");
				
				System.out.println("5 - Voltar");
				opcaocli1 = sc.nextInt();
				
				switch (opcaocli1) {
					case 1: 					
						cadastrarCliente(entity);
						break;
						
					case 2: 
						removerCliente(entity);
						break;
						
					case 3: 
						AtualizarDados(entity);
						break;
				}
			}
			if (opcao==2) {
				limparConsole();
				
				System.out.println("1 - Cadastrar Peças");
				
				System.out.println("2 - Remover Peças");

				System.out.println("3 - Atualizar Dados da Peça");
				
				System.out.println("4 - Tabela Peças");
				
				System.out.println("5 - Voltar");
				
				opcaocli2 = sc.nextInt();
				
				switch (opcaocli2) {
					case 1: 					
						cadastrarPeças(entity);
						break;
						
					case 2: 
						removerPecas(entity);
						break;
						
					case 3: 
						atualizarPecas(entity);
						break;
				}
			}
		}
	}
	
//*****************************************LimparConsole*************************************
	
	private static void limparConsole() {
	    for (int i = 0; i < 50; ++i) System.out.println();
	}

	//*********************Cadastro_de_CLientes********************

	private static void cadastrarCliente(EntityManager entity) {
		
		entity.getTransaction().begin();
		
		Clientes clientex = new Clientes();
		
		System.out.println("Digite o nome do cliente: ");
		String nome = sc.next();
		clientex.setNome(nome);
		System.out.println("Digite o cpf do cliente: ");
		String cpf = sc.next();
		clientex.setCpf(cpf);
		System.out.println("Digite o endereço do cliente: ");
		String endereco = sc.next();
		clientex.setEndereco(endereco);
		System.out.println("Digite o numero do Cliente: ");
		String telefone = sc.next();
		clientex.setTelefone(telefone);
		
		Clientes cliente = new Clientes (nome ,cpf , endereco, telefone);
		listaClientes.add(clientex);
		
		entity.persist(clientex);
		 
		System.out.println("Cliente cadastrado com sucesso!");
		
		entity.getTransaction().commit();
	   
	    }
	
	 //***************************Remover_Cliente********************************
	
	private static void removerCliente(EntityManager entity2) {
		
		entity.getTransaction().begin();
		
	    System.out.println("Digite o CPF do cliente que deseja remover:");
	    String cpfCliente = sc.next();
	    
	    Clientes clienteARemover = entity.find(Clientes.class, cpfCliente);
	    if (clienteARemover != null) {
	    	
	        entity.remove(clienteARemover);
	        
	        entity.getTransaction().commit();
	        
	        System.out.println("Cliente removido com sucesso!");
	    } else {
	        System.out.println("Cliente não encontrado ou CPF inválido.");
	        
	        entity.getTransaction().rollback();
	    }
	}
	//********************************Atualizando_Dados*************************************************
	
	private static void AtualizarDados(EntityManager entity3) {
		
			entity.getTransaction().begin();
		
			Clientes clientex = new Clientes();
		if (Clientes != null) {

	        System.out.println("Digite o cpf do cliente:");
	        String buscarcpf = sc.next();
	        System.out.println("Digite o novo nome do cliente:");
	        String novoNome = sc.next();
	        System.out.println("Digite o novo endereço do cliente:");
	        String novoEndereco = sc.next();
	        System.out.println("Digite o novo número do cliente:");
	        String novoTelefone = sc.next();
	        
	         Clientes clientesnovo = new Clientes(buscarcpf, novoNome, novoEndereco, novoTelefone);
	        
	        clientex.setNome(novoNome);
	        clientex.setEndereco(novoEndereco);
	        clientex.setTelefone(novoTelefone);
	        
	        entity.getTransaction().commit();
	        
	        System.out.println("Dados do cliente atualizados com sucesso!");
	    } else {
	    	
	        System.out.println("Cliente não encontrado ou CPF inválido.");
	        entity.getTransaction().rollback();
	        
	    	}
		}
	//***********************************Pecas****************************************
	
	private static void cadastrarPeças(EntityManager entity2) {
		
		entity.getTransaction().begin();
		Pecas pecasx = new Pecas ();
		
		System.out.println("Digite a identificação do produto: ");
		String Id = sc.next();
		pecasx.setId(Id);
		
		System.out.println("Qual vai ser o estilo da roda no produto: ");
		String rodas = sc.next();
		pecasx.setRodas(rodas);
		
		System.out.println("Qual vai ser o estilo do truks no produto: ");
		String truks = sc.next();
		pecasx.setTruks(truks);
		
		System.out.println("Qual vai ser o estilo do shape no produto: ");
		String shapes = sc.next();
		pecasx.setShapes(shapes);
		
		System.out.println("Digite o valor do produto: ");
		String Preco = sc.next();
		pecasx.setPreco(Preco);
		
		Pecas pecas = new Pecas (Id ,rodas , truks, shapes, Preco);
		
		entity.persist(pecasx);
		
		System.out.println("Peca cadastrada com sucesso!");
	   
		entity.getTransaction().commit();
	     }
		
	//**************************************RemoverPecas*******************************
	private static void removerPecas(EntityManager entity2) {
		
		entity.getTransaction().begin();
		
	    System.out.println("Digite a Identificação da peça que deseja remover:");
	    String IdPecas = sc.next();
	    
	    Pecas pecasARemover = entity.find(Pecas.class, IdPecas);
	    if (pecasARemover != null) {
	    	
	        entity.remove(pecasARemover);
	        
	        entity.getTransaction().commit();
	        
	        System.out.println("Peca removida com sucesso!");
	    } 
	    
	    else { System.out.println("Peca não encontrada ou ID inválido.");
	        
	        entity.getTransaction().rollback();
	      }  
	}
	//***************************************AtualizarPecas****************************
	private static void atualizarPecas(EntityManager entity2) {
		
		entity.getTransaction().begin();
		
		
		entity.getTransaction().commit();
	}
	
	}
