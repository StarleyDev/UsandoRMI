package TestRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public static void main(String[] args) {
		Ola obj = null;
		String msg = "minha mensagem";
		Pessoa retorno = null;
		try {
			// obj = (Ola)Naming.lookup("//172.62.11.90/OlaServidor");
			Registry registry = LocateRegistry.getRegistry("172.62.7.41", 2005);
			obj = (Ola) registry.lookup("OlaServidor");

			Pessoa pessoa = new Pessoa("Starlley", 20);

			retorno = obj.mudarNomePessoa(pessoa);

			System.out.println("O novo nome é " + retorno.getNome());
		} catch (Exception e) {
			System.out.println("Client exception: " + e.getMessage());
		}
	}
}
